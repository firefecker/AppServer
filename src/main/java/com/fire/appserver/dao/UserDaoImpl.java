package com.fire.appserver.dao;

import com.fire.appserver.bean.UserBean;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    public UserBean login(String phone, String password) {
        List<UserBean> users = (List<UserBean>) this.getHibernateTemplate().find("from UserBean where phone=? and password=?", phone, password);
        if (users != null && users.size() > 0) {
            return users.get(0);
        }
        return null;
    }

    public UserBean registor(UserBean userBean) {
        this.getHibernateTemplate().save(userBean);
        return getUser(userBean.getPhone());
    }

    public UserBean getUser(String phone) {
        List<UserBean> users = (List<UserBean>) this.getHibernateTemplate().find("from UserBean where phone=?", phone);
        if (users != null && users.size() > 0) {
            return users.get(0);
        }
        return null;
    }

}
