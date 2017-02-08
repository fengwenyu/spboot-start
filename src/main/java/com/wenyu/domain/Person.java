package com.wenyu.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/2/8.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable{
    private String id;
    private String name;
    private Integer age;
}
