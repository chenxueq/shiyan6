package com.itheima.one;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class AccountDaoImpl implements AccountDao{
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addAccount(Account account) {
        String sql="insert into account(username,balance) values(?,?)";
        Object[] obj=new Object[]{account.getUsername(),account.getBalance()};
        int  add=this.jdbcTemplate.update(sql,obj);
        return  add;

    }

    @Override
    public int deleteAccount(int id) {
        String sql="delete from account where id=?";
    int delete =this.jdbcTemplate.update(sql,id);
        return  delete;
    }

    @Override
    public Account findAccountById(int id) {
        String sql ="select * from account where id=?";

        RowMapper<Account> mapper = new BeanPropertyRowMapper<>(Account.class);
        Account a=this.jdbcTemplate.queryForObject(sql,mapper,id);
        return a;
    }

    @Override
    public List<Account> findAllAccount() {
        String sql ="select * from account ";

        RowMapper<Account> mapper = new BeanPropertyRowMapper<>(Account.class);
        List<Account> a=this.jdbcTemplate.query(sql,mapper);
        return a;
    }

    @Override
    public int updateAccount(Account account) {
       String sql="update account set username=?,balance=? where id=?";
       Object[] obj =new Object[]{account.getUsername(),account.getBalance(),account.getId()};
       int update =this.jdbcTemplate.update(sql,obj);
       return update;
    }
}
