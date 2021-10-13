package com.itheima.two;

import com.itheima.one.Account;

import java.util.List;

public interface UserDao {
    public  int addUser(User user);
    public int deleteUser(int id);
    public  User findUserById(int id);
    public List<User> findAllUser();
    public int updateUser(User user);
}
