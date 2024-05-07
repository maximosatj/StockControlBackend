package com.stockapp.restfulapi.Beverage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

@Service
public class BeverageServices {
    private final BeverageRepository beverageRepository;

    @Autowired
    public BeverageServices(BeverageRepository beverageRepository) {
        this.beverageRepository = beverageRepository;
    }

    public List<Beverage> findAllBeverages() {
        Iterable<Beverage> beverageIterable = beverageRepository.findAll();
        List<Beverage> beverageList = new ArrayList<>();
        beverageIterable.forEach(beverageList::add); // Convertir Iterable a List
        return beverageList;
    }

    public Optional<Beverage> findBeverageById(int id) {
        return beverageRepository.findById(id);
    }

    public Beverage saveBeverage(Beverage beverage) {
        return beverageRepository.save(beverage);
    }

    public Beverage updateBeverage(int id, Beverage beverageDetails) {
        Optional<Beverage> optionalBeverage = beverageRepository.findById(id);
        if (optionalBeverage.isPresent()) {
            Beverage beverageToUpdate = optionalBeverage.get();
            beverageToUpdate.setName(beverageDetails.getName());
            beverageToUpdate.setLiters(beverageDetails.getLiters());
            beverageToUpdate.setPrice(beverageDetails.getPrice());
            beverageToUpdate.setImageUrl(beverageDetails.getImageUrl());
            beverageToUpdate.setQuantityInStock(beverageDetails.getQuantityInStock());

            beverageToUpdate.setCategory(beverageDetails.getCategory());
            return beverageRepository.save(beverageToUpdate);
        }
        return null;
    }

    public void deleteBeverage(int id) {
        beverageRepository.deleteById(id);
    }
}