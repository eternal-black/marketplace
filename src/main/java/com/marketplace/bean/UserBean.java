package com.marketplace.bean;

import com.marketplace.entity.User;
import com.marketplace.entity.enums.Role;
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
    private String firstName;
    private String lastName;
    private String photo;
    private int rating;
    private Role role;

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
            user.setLogin(this.login);
            user.setPassword(this.password);
            user.setFirstName(this.firstName);
            user.setLastName(this.lastName);
            user.setRole(Role.user);
            user.setRating(0);
            DBUtil.addUser(user);

            sessionBean.setUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        login = password = firstName = lastName = null;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
