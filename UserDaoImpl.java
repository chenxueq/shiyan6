package com.itheima.two;

import com.itheima.one.Account;
import com.itheima.one.AccountDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public int addUser(User user) {
        String sql ="insert into user(id,username,password,sex) values(?,?,?,?)";
        Object[] users=new Object[]{user.getId(),user.getUsername(),user.getPassword(),user.getSex()};
        int num=this.jdbcTemplate.update(sql,users);

        return num;
    }

    @Override
    public int deleteUser(int id) {
        String sql ="delete from user where id=?";
        int num =this.jdbcTemplate.update(sql,id);

        return num;
    }

    @Override
    public User findUserById(int id) {
        String sql ="select * from user where id=? ";


        User a=this.jdbcTemplate.queryForObject(sql,id,new UserRowMapper());
        return a;
    }

    @Override
    public List<User> findAllUser() {
        String sql ="select * from user ";

        RowMapper<User> mapper = new BeanPropertyRowMapper<>(User.class);
        List<User> a=this.jdbcTemplate.query(sql,new UserRowMapper());
        return a;
    }

    @Override
    public int updateUser(User user) {
        String sql ="update  user set username=?,password=?,sex=? where id=?";
        Object[] users=new Object[]{user.getUsername(),user.getPassword(),user.getSex(),user.getId()};
        int num =this.jdbcTemplate.update(sql,users);

        return num;
    }
}
