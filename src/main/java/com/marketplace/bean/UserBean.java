package com.marketplace.bean;

import com.marketplace.entity.User;
import com.marketplace.entity.enums.Role;
import com.marketplace.entity.enums.UserStatus;
import com.marketplace.util.DBUtil;

import javax.annotation.PostConstruct;
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


    public String updateAccount(){
        try {
            DBUtil.updateUser(sessionBean.getUser());
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String deleteAccount(){
        try {
            DBUtil.delete(sessionBean.getUser());
            sessionBean.setUser(null);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String registration() {
        System.out.println("registration");
        try {
            User user = new User();
            user.setLogin(sessionBean.getUser().getLogin());
            user.setPassword(sessionBean.getUser().getPassword());
            user.setFirstName(sessionBean.getUser().getFirstName());
            user.setLastName(sessionBean.getUser().getLastName());
            user.setRole(Role.USER);
            user.setStatus(UserStatus.ACTIVE);
            user.setRating(0);
            user.setCash(0);
            DBUtil.addUser(user);

            sessionBean.setUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        login = password = null;
        return "success";
    }

    public String authorization() {
        System.out.println("auth" + login);
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
