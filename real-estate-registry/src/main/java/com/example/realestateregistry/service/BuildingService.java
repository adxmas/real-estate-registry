package com.example.realestateregistry.service;

import com.example.realestateregistry.dao.BuildingRepository;
import com.example.realestateregistry.entity.Building;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class BuildingService {

    private final BuildingRepository buildingRepository;
    private List<Building> buildingList = null;

    @Autowired
    public BuildingService(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    public List<Building> getAllBuildings() {
        return this.buildingRepository.findAll();
    }

    public Building addBuilding(Building building) {
        return buildingRepository.save(building);
    }

    public List<Building> deleteBuildingById(int id) {
        buildingRepository.deleteById(id);
        return buildingRepository.findAll();
    }

    public Building updateBuilding(int id, Building building) {
        Building toUpdate = buildingRepository.findById(id).orElse(null);
        toUpdate.setAddress(building.getAddress());
        toUpdate.setMarketValue(building.getMarketValue());
        toUpdate.setOwner(building.getOwner());
        toUpdate.setPropertyType(building.getPropertyType());
        toUpdate.setSize(building.getSize());
        return buildingRepository.save(toUpdate);
    }

    public List<Building> getBuildingsByOwner(String owner) {
        return buildingRepository.findAllByOwner(owner);
    }

    public String taxCalculation(String owner, List<Double> taxRate) {
        int index = 0;
        double sum = 0;
        buildingList = getBuildingsByOwner(owner);
        if (buildingList.size() == taxRate.size()) {
            for (Building build : buildingList) {
                sum += build.getMarketValue() * taxRate.get(index);
                index++;
            }
            return "tax for properties: " + buildingList.toString() + " " + '\n' +
                    "with tax rates: " + taxRate + " " + '\n' +
                    "total yearly tax for all properties combined: " + sum;
        }
        if (buildingList.size() > taxRate.size()) {
            return "number of buildings: " + buildingList.size() + '\n' +
                    "number of given tax rate values: " + taxRate.size() + '\n' +
                    ">>> not enough tax rate values <<<";
        }
        if (buildingList.size() < taxRate.size()) {
            return "number of buildings: " + buildingList.size() + '\n' +
                    "number of given tax rate values: " + taxRate.size() + '\n' +
                    ">>> too many tax rate values <<<";
        }
        return null;
    }
}



