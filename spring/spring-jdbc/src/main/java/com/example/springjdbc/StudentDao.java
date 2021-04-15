package com.example.springjdbc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author monkjavaer
 * @date 2021/4/15
 */
@Slf4j
@Repository
public class StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private SimpleJdbcInsert simpleJdbcInsert;


    public void insertData() {
        Arrays.asList("zhangfei", "liubei").forEach(name -> {
            jdbcTemplate.update("INSERT INTO student (name) VALUES (?)", name);
        });

        HashMap<String, String> row = new HashMap<>();
        row.put("name", "liubei");
        Number id = simpleJdbcInsert.executeAndReturnKey(row);
        log.info("ID of liubei: {}", id.longValue());
    }

    public void selectList() {
         List<Student> list = jdbcTemplate.query("select * from student", new RowMapper<Student>() {
             @Override
             public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                 return Student.builder()
                         .id(resultSet.getLong(1))
                         .name(resultSet.getString(2))
                         .age(resultSet.getInt(3))
                         .build();
             }
         });
         list.forEach(student -> log.info("student = {}", student));
    }
}
