package com.sg.training.spring.cloud.dbas;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sg.training.spring.cloud.dto.Manufacturer;


@RepositoryRestResource(path="/dbas")
public interface ManufacturerRestRepo extends MongoRepository<Manufacturer,Integer> {

}
