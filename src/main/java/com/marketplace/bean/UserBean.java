package com.marketplace.bean;

import com.marketplace.util.DBUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean (name = "userBean")
@SessionScoped
public class UserBean {

    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;

    private String login;
    private String password;

    public String authorization() {
        System.out.println("auth");
        try {
            sessionBean.setUser(DBUtil.getUser(login, password));
        } catch (Exception e) {
            return "fail";
        }
        login = password = "";
        return "success";
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
