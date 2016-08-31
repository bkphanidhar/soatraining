package com.sample.dbas;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sample.dto.Manufacturer;


@RepositoryRestResource(path="/dbas/manufacturer")
public interface ManufacturerRestRepo extends MongoRepository<Manufacturer,Integer> {

}
