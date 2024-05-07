package com.stockapp.restfulapi.Beverage;

import org.springframework.data.repository.CrudRepository;
import com.stockapp.restfulapi.Beverage.Beverage;

public interface BeverageRepository extends CrudRepository<Beverage, Integer> {
}