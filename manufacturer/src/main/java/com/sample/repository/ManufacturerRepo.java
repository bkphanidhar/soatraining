package com.sample.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sample.dto.Manufacturer;

public interface ManufacturerRepo extends MongoRepository<Manufacturer,Integer> {

}
