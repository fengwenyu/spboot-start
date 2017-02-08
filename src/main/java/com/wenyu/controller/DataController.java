package com.wenyu.controller;

import com.wenyu.domain.Student;
import com.wenyu.domain.Worker;
import com.wenyu.domain.WorkerRepository;
import com.wenyu.dto.StudentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2017/2/8.
 */
@RestController
public class DataController {
    protected static Logger logger= LoggerFactory.getLogger(DataController.class);

    @Autowired
    WorkerRepository workerRepository;

    @Autowired
    StudentMapper workerMapper;

    @RequestMapping("/mybatis/query")
    public List<Student> queryByAge(int age, int index, int size){
        int start = (index-1)*size;
        return workerMapper.findByAge(age,start,size);
    }

    @RequestMapping("/save")
    public Worker save(String name,String address,Integer age){
        logger.debug("save 开始");
        Worker p=workerRepository.save(new Worker(null,name,age,address));
        logger.debug("save 结束");
        return p;
    }

    @RequestMapping("/q1")
    public List<Worker> q1(String address){
        logger.debug("q1 开始");
        logger.debug("q1 接收参数address={}",address);
        List<Worker> people=workerRepository.findByAddress(address);
        return people;
    }

    @RequestMapping("/q2")
    public List<Worker> q2(String name,String address){
        logger.debug("q2 开始");
        logger.debug("q2接收参数name={},address={}",name,address);
        return workerRepository.findByNameAndAddress(name, address);
    }

    @RequestMapping("/q3")
    public List<Worker> q3(String name,String address){
        logger.debug("q3 开始");
        logger.debug("q3接收参数name={},address={}",name,address);
        return workerRepository.withNameAndAddressQuery(name, address);
    }

    @RequestMapping("/sort")
    public List<Worker> sort(){
        logger.debug("sort 开始");
        List<Worker> people=workerRepository.findAll(new Sort(Sort.Direction.ASC,"age"));
        return people;
    }

    @RequestMapping("/page")
    public Page<Worker> page(){
        logger.debug("page 开始");
        Page<Worker> people=workerRepository.findAll(new PageRequest(1,2));
        return people;
    }
}
