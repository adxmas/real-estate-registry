package com.example.realestateregistry.service;

import com.example.realestateregistry.dao.BuildingRepository;
import com.example.realestateregistry.entity.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BuildingService {

    private final BuildingRepository buildingRepository;

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
        Building buildingToUpdate = buildingRepository.findById(id).orElse(null);
        //buildingToUpdate.setId(building.getId());
        buildingToUpdate.setAddress(building.getAddress());
        buildingToUpdate.setMarketValue(building.getMarketValue());
        buildingToUpdate.setOwner(building.getOwner());
        buildingToUpdate.setPropertyType(building.getPropertyType());
        buildingToUpdate.setSize(building.getSize());
        return buildingRepository.save(buildingToUpdate);
    }
}
