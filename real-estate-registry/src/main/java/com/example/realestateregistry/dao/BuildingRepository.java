package com.example.realestateregistry.dao;

import com.example.realestateregistry.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuildingRepository extends JpaRepository<Building, Integer> {

    public List<Building> findAllByOwner(String owner);
}
