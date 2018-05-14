package com.marketplace.mapper;

import com.marketplace.domain.Account;
import org.apache.ibatis.annotations.*;

public interface AccountMapper {

    @Select("SELECT * FROM account WHERE " +
            "login=#{login} AND " +
            "password=#{password}")
    @Results(value = {
                @Result(property = "id", column = "ID"),
                @Result(property = "login", column = "LOGIN"),
                @Result(property = "password", column = "PASSWORD"),
                @Result(property = "name", column = "NAME")})
    Account getAccount(@Param("login") String login,
                       @Param("password") String password);

    @Insert("INSERT INTO account (" +
            "login, password, name) " +
            "VALUES (#{login}, #{password}, #{name})")
    void addAccount(@Param("login")String login,
                    @Param("password")String password,
                    @Param("name")String name);

    @Update("UPDATE account SET " +
            "login = #{login}," +
            "password=#{password}, " +
            "name=#{name} " +
            "WHERE id=#{id}")
    void updateAccount(@Param("login")String login,
                       @Param("password")String password,
                       @Param("name")String name,
                       @Param("id") int id);

    @Delete("DELETE FROM account " +
            "WHERE id=#{id}")
    void deleteAccount(@Param("id")int id);
}
