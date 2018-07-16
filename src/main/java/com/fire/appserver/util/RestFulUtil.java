package com.fire.appserver.util;

import com.fire.appserver.bean.RestFulBean;

public class RestFulUtil<T> {
    private RestFulUtil() {
    }

    public static RestFulUtil getInstance() {
        return new RestFulUtil();
    }

    public RestFulBean<T> getResuFulBean(T o, int status, String msg) {
        RestFulBean<T> objectRestFulBean = new RestFulBean<T>();
        objectRestFulBean.setStatus(status);
        objectRestFulBean.setMsg(msg);
        objectRestFulBean.setData(o);
        return objectRestFulBean;
    }

}
