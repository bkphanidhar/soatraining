package com.sg.training.spring.cloud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sg.training.spring.cloud.dto.Manufacturer;


public interface ManufacturerRepo extends MongoRepository<Manufacturer,Integer> {

}
