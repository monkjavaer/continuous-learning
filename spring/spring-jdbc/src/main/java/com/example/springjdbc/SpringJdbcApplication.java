package com.example.springjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;

@SpringBootApplication
public class SpringJdbcApplication implements CommandLineRunner {

    @Autowired
    private StudentDao studentDao;

    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcApplication.class, args);
    }

    @Bean
    @Autowired
    public SimpleJdbcInsert simpleJdbcInsert(JdbcTemplate jdbcTemplate) {
        return new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("student").usingGeneratedKeyColumns("id");
    }

    @Bean
    @Autowired
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void run(String... args) throws Exception {
        studentDao.insertData();
        studentDao.selectList();
    }
}
