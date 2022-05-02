package com.monkjavaer.learn.springbootpure.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author monkjavaer
 * @date 2021/1/3
 */
@Data
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private Integer age;
    private Date createTime;
    private List<String> roles;
}
