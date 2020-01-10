package com.pipichao.spring.webservlet.java8;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TestJava8Stream {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring.xml");
        DruidDataSource druidDataSource=applicationContext.getBean(DruidDataSource.class);
        JdbcTemplate jdbcTemplate=new JdbcTemplate(druidDataSource);
        List<Emp> list=jdbcTemplate.query("select * from emp", (RowMapper) (resultSet, i) -> {//lamda 的表示方式
            Emp emp=new Emp();
            emp.setId(resultSet.getInt(1));
            emp.setName(resultSet.getString(2));
            emp.setSalary(resultSet.getDouble(3));
            return emp;
        });
        ///我们这一代人，是一生下来就有巨额负债的一代人
//        list.stream().limit(0).filter(emp -> emp.getName().equals("刘冰冰")).forEach(emp -> System.out.println(emp));
//        list.stream().forEach(emp -> {emp.setName("哈哈");
//            System.out.println(emp);});
//        list.stream().allMatch(emp -> emp.getName().startsWith("张"));
//        list.stream().anyMatch(emp -> emp.getName().equals("张"));
    }
}
