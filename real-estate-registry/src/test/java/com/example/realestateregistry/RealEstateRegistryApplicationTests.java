package com.example.realestateregistry;

import com.example.realestateregistry.dao.BuildingRepository;
import com.example.realestateregistry.entity.Building;
import com.example.realestateregistry.service.BuildingService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class RealEstateRegistryApplicationTests {

	@Autowired
	private BuildingService service;

	@MockBean
	private BuildingRepository repository;

	@MockBean
	private List<Building> buildingList = null;


	@Test
	public void getBuildingsTest(){
		when(repository.findAll()).thenReturn(Stream
				.of(new Building(5, "Salt g. 43", "Jons", 777, 999, "house"), new Building(6, "Saltinio g. 45", "Benas", 888, 444, "house")).collect(Collectors.toList()));
		assertEquals(2, service.getAllBuildings().size());
	}

	@Test
	public void addBuildingTest(){
		Building building = new Building(7, "Lauku g. 50", "Tomas", 2000, 7676, "industrial");
		when(repository.save(building)).thenReturn((building));
		assertEquals(building, service.addBuilding(building));
	}

	@Test
	public void deleteBuildingTest(){
		Building building = new Building(7, "Lauku g. 50", "Tomas", 2000, 7676, "industrial");
		service.deleteBuildingById(building.getId());
		verify(repository,times(1)).deleteById(building.getId());
	}


}
