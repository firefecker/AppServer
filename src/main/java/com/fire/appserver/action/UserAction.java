package com.fire.appserver.action;


import com.fire.appserver.bean.RestFulBean;
import com.fire.appserver.bean.UserBean;
import com.fire.appserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserAction {

    @Autowired
    private UserService userService;


    /**
     * 注册
     *
     * @param userBean
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.PUT)
    public RestFulBean<UserBean> register(@RequestBody UserBean userBean) {
        return userService.registorServer(userBean);
    }

    /**
     * 登录
     *
     * @param phone
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public RestFulBean<UserBean> login(String phone, String password) {
        return userService.login(phone, password);
    }

    /**
     * 详情
     * @param phone
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/userinfo", method = RequestMethod.GET)
    public RestFulBean<UserBean> userInfo(String phone) {
        return userService.userinfo(phone);
    }


    @ResponseBody
    @RequestMapping(value = "/loginByPwd", method = RequestMethod.GET)
    public RestFulBean<String> loginByPwd(@RequestParam String username, @RequestParam String password) {
        RestFulBean<String> restful = new RestFulBean<String>();
        restful.setMsg("hello, " + username + " welcom to my website!");
        restful.setStatus(0);
        restful.setMsg("成功");
        return restful;
    }


}
