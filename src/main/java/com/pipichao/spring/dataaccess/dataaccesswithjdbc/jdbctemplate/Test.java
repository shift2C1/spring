package com.pipichao.spring.dataaccess.dataaccesswithjdbc.jdbctemplate;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.cj.jdbc.Driver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Test {
    public DruidDataSource init(){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("2437262431");
        dataSource.setUrl("jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC");
        try {
            dataSource.setDriver(new Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataSource;
    }
    public JdbcTemplate getJdbcTemplate(){
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(this.init());
        return jdbcTemplate;
    }

    public static void main(String[] args) {
//        Test test=new Test();
//        JdbcTemplate jdbcTemplate=test.getJdbcTemplate();
        ApplicationContext ioc=new ClassPathXmlApplicationContext("ioc.xml");
        DataSource dataSource=ioc.getBean("dataSource",DataSource.class);
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

        //不带查询参数
//        int count=jdbcTemplate.queryForObject("select count(*) from bumen",Integer.class);
//        System.out.println(count);

        //带查询参数 ? 报错？
//        Object[] param={"1001"};
//        Bumen bumen=jdbcTemplate.queryForObject("select  * from bumen where id = ?",param,Bumen.class);
//        System.out.println(bumen.toString());

        //rowMapper

//        //参数
//        Object[] param={"1002","市场部"};
//        //结果集
//        RowMapper<Bumen> rowMapper=new RowMapper<Bumen>() {
//            @Override
//            public Bumen mapRow(ResultSet resultSet, int i) throws SQLException {
//                Bumen bumen=new Bumen();
//                bumen.setId(resultSet.getString("id"));
//                bumen.setName(resultSet.getString(2));
//                System.out.println("i:"+i);
//                return bumen;
//            }
//        };
//        final Bumen bumen=jdbcTemplate.queryForObject("select  id,name from bumen where id = ? and name=?", param,rowMapper);
//        System.out.println(bumen);//无查询结果报错？


        //返回list
//        RowMapper<Bumen> rowMapper=new RowMapper<Bumen>() {
//            @Override
//            public Bumen mapRow(ResultSet resultSet, int i) throws SQLException {
//                Bumen bumen1=new Bumen();
//                bumen1.setId(resultSet.getString(1));
//                bumen1.setName(resultSet.getString("name"));
//                return bumen1;
//            }
//        };
//        List<Bumen> bumenList=jdbcTemplate.query("select * from bumen where id =?",new Object[]{"1001"},rowMapper );
//        System.out.println("容量："+bumenList.size());



        ///以上是查询语句，jdbcTemplate 把语句分为两类 ，一类为不修改数据的，即：qurery,
        //另一类 修改了数据的 insert delete update 都用update方法
//        jdbcTemplate.update("update bumen set name=? where  id= ?","技术部","1001");
//        jdbcTemplate.update("delete from bumne where id=?");
//        jdbcTemplate.update("insert into bumen(id,name) values ('1111','1111')");
        //执行任何语句
//        jdbcTemplate.execute("drop database ");
//        JdbcDaoSupport jdbcDaoSupport;
    }

}
