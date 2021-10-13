package com.itheima.two;

import com.itheima.one.Account;
import com.itheima.one.AccountDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcTemplateTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application2.xml");
        JdbcTemplate jdbcTemplate= (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        String sql="create table user(id int primary key auto_increment,username varchar(25),password varchar(25),sex varchar(2))";
        jdbcTemplate.execute(sql);
        System.out.println("create user finish");


    }
    @Test
    public void  addUserTest(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application2.xml");
        UserDao userDao= (UserDao) applicationContext.getBean("UserDao");
        User user=new User(1,"123","1233","男");


        int num=userDao.addUser(user);
        if(num>0){
            System.out.println("insert ok");
        }
    }
    @Test
    public void  updateAccountTest(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application2.xml");
        UserDao userDao= (UserDao) applicationContext.getBean("UserDao");
      User user=new User(1,"34","315","nv");

        int num=userDao.updateUser(user);
        if(num>0){
            System.out.println("update ok");
        }
    }
    @Test
    public void  deleteAccountTest(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application2.xml");
        UserDao userDao= (UserDao) applicationContext.getBean("UserDao");

        int num=userDao.deleteUser(1);
        if(num>0){
            System.out.println("delete ok");
        }
    }
    @Test
    public void  queryAccountTest(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application2.xml");
        UserDao userDao= (UserDao) applicationContext.getBean("UserDao");

        User user=new User();
        user =userDao.findUserById(1);
        System.out.println(user);
        List<User> users=userDao.findAllUser();

        for (User a:users)
        {
            System.out.println(a);
        }
    }
}
