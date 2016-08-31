package com.sg.training.spring.cloud.dbas;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sg.training.spring.cloud.dto.Order;


@RepositoryRestResource(path="/dbas")
public interface OrderRestRepo extends MongoRepository<Order,Integer> {

}
