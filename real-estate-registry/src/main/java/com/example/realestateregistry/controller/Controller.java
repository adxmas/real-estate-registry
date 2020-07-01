package com.example.realestateregistry.controller;

import com.example.realestateregistry.entity.Building;
import com.example.realestateregistry.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/rest")
@RestController
public class Controller {

    private final BuildingService buildingService;

    @Autowired
    public Controller(BuildingService buildingService){
        this.buildingService = buildingService;
    }

    @GetMapping("/buildings")
    public List<Building> getAllBuildings(){
        return buildingService.getAllBuildings();
    }

    @PostMapping("/add")
    public Building addBuilding(Building building) {
        return buildingService.addBuilding(building);
    }

    @DeleteMapping("delete/{id}")
    public List<Building> deleteBuilding(@PathVariable("id") int id){
        return buildingService.deleteBuildingById(id);
    }

    @PutMapping("/update/{id}")
    public Building updateBuilding(@PathVariable("id") int id, Building building){
        return buildingService.updateBuilding(id, building);
    }

    @GetMapping("/owner/{owner}")
    public List<Building> getBuildingsByOwner(@PathVariable("owner") String owner){
        return buildingService.getBuildingsByOwner(owner);
    }

    @GetMapping("/tax/")
    public String getCalculatedTaxes(@RequestParam String owner, @RequestParam List<Double> taxRate){
        return buildingService.taxCalculation(owner, taxRate);
    }






}
