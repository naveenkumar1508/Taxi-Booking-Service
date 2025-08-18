package com.example.GetRide.repository;

import com.example.GetRide.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByEmailId(String email);

    List<Customer> findByName(String name);

    @Query(value = "select * from customer where gender = :gender and age >= :age", nativeQuery = true)
    List<Customer> getAllByGenderAndAgeGreaterThan(@Param("gender") String gender,
                                                   @Param("age") int age);

}
