package com.example.realestateregistry.dao;

import com.example.realestateregistry.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<Building, Integer> {
}
