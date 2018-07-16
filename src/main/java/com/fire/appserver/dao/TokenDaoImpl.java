package com.fire.appserver.dao;

import com.fire.appserver.bean.TokenBean;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class TokenDaoImpl extends HibernateDaoSupport implements TokenDao {

    public void saveOrUpdageToken(TokenBean tokenBean) {
        this.getHibernateTemplate().saveOrUpdate(tokenBean);
    }

    public TokenBean isTokenAvailable(String phone) {
        List<TokenBean> tokens = (List<TokenBean>) this.getHibernateTemplate().find("from TokenBean where phone=?", phone);
        if (tokens != null && tokens.size() > 0) {
            return tokens.get(0);
        }
        return null;
    }


}
