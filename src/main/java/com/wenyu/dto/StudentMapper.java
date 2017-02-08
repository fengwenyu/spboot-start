package com.wenyu.dto;

import com.wenyu.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/2/8.
 */
public interface StudentMapper {
    public List<Student> findByAge(@Param("age") int age, @Param("index")int index, @Param("size")int size);
}
