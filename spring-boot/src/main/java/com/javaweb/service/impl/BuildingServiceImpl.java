package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.DTO.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	private BuildingRepository buildingRepository;

	@Override
	public List<BuildingDTO> findAll(String name, Long numberOfBasement) {
		List<BuildingEntity> buldingEntities = buildingRepository.findAll(name, numberOfBasement);
		List<BuildingDTO> buildingDTO = new ArrayList();
		
		for(BuildingEntity x : buldingEntities) {
			BuildingDTO building = new BuildingDTO();
			building.setName(x.getName());
			building.setAdress(x.getStreet() + ", " + x.getWard() + ", " + x.getDistrict());
			building.setManagerName(x.getManagerName());
			buildingDTO.add(building);
		}
		return buildingDTO;
	}

}
