package com.marketplace.bean;

import com.marketplace.entity.User;
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

    public String registration() {
        System.out.println("registration");
        try {
            User user = new User();
            user.setLogin(this.login);
            user.setPassword(this.password);
            DBUtil.addUser(user);
            System.out.println("login - " + DBUtil.getAddingUser());
            sessionBean.setUser(DBUtil.getAddingUser());
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

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
