package com.wenyu.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/2/8.
 */

public interface WorkerRepository extends JpaRepository<Worker,Long> {
    List<Worker> findByName(String name);

    List<Worker> findByAddress(String address);

    List<Worker> findByNameAndAddress(String name,String address);
    @Query("select p from Worker p where p.name=:name and p.address=:address")
    List<Worker> withNameAndAddressQuery(@Param("name")String Name, @Param("address")String address);
}
