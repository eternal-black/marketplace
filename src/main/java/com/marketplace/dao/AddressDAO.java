package com.marketplace.dao;

import com.marketplace.entity.Address;

import java.sql.SQLException;
import java.util.List;

public interface AddressDAO {

    List<String> getCountry() throws SQLException;
    List<String> getCity(String country) throws SQLException;
    List<String> getStreet(String city) throws SQLException;
    List<String> getHome(String street) throws SQLException;

    void addAddress(Address address) throws SQLException;
    Address getAddress(int id) throws SQLException;
}
