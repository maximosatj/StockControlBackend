package com.stockapp.restfulapi.Beverage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.stockapp.restfulapi.Beverage.BeverageServices;

@RestController
public class BeverageController {

    @Autowired
    private BeverageServices beverageService;

    @GetMapping("/beverages")
    public List<Beverage> getAllBeverages() {
        return beverageService.findAllBeverages();
    }

    @GetMapping("/beverages/{id}")
    public Beverage getBeverageById(@PathVariable int id) {
        return beverageService.findBeverageById(id).orElse(null);
    }

    @PostMapping("/createBeverage")
    public Beverage createBeverage(@RequestBody Beverage beverage) {
        return beverageService.saveBeverage(beverage);
    }
}