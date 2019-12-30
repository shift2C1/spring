package com.pipichao.spring.dataaccess.dataaccesswithjdbc.namedparameterjdbctemplate;

import com.pipichao.spring.dataaccess.dataaccesswithjdbc.jdbctemplate.Bumen;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Test {
    public static void main(String[] args) {
        ApplicationContext ioc= new ClassPathXmlApplicationContext("ioc.xml");
        DruidDataSource dataSource=ioc.getBean("dataSource",DruidDataSource.class);
        NamedParameterJdbcTemplate jdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
        RowMapper<Bumen> rowMapper=new RowMapper<Bumen>() {
            @Override
            public Bumen mapRow(ResultSet resultSet, int i) throws SQLException {
                Bumen result=new Bumen();
                result.setBumenId(resultSet.getString("id"));
                result.setBumenName(resultSet.getString(2));
                return result;
            }
        };
//        String sql="select * from bumen where id= :param";
//        SqlParameterSource sqlParameterSource=new MapSqlParameterSource("param","1001");
//        ((MapSqlParameterSource) sqlParameterSource).addValue("name","技术部");//添加查询参数，动态sql？
//        Bumen bumen=jdbcTemplate.queryForObject(sql, sqlParameterSource, rowMapper);
//        System.out.println(bumen);

        //参数名对应 为类的字段名
        String sql="select * from bumen where id=:bumenId and name = :bumenName";
        Bumen paramvo=new Bumen();
        paramvo.setBumenId("1001");
        paramvo.setBumenName("技术部");
        BeanPropertySqlParameterSource sqlParameterSource1 =new BeanPropertySqlParameterSource(paramvo);
        Bumen bumen=jdbcTemplate.queryForObject(sql,sqlParameterSource1,rowMapper);
        System.out.println(bumen.toString());
    }
}
