package com.example.springtransaction;

import lombok.Builder;
import lombok.Data;

/**
 * @author monkjavaer
 * @date 2021/4/15
 */
@Data
@Builder
public class Student {
    private Long id;
    private String name;
    private Integer age;
}
