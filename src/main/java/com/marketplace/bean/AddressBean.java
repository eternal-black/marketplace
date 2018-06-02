package com.marketplace.bean;

import com.marketplace.entity.Address;
import com.marketplace.util.DBUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "addressBean")
@SessionScoped
public class AddressBean {

    private Address address = new Address();

    public String addAddress(){
        Address address = this.address;
        try {
            DBUtil.addAddress(address);
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String addressById(){
        System.out.println(address.getId());
        try {
            this.address = DBUtil.getAddressById(address.getId());
            System.out.println(address);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
