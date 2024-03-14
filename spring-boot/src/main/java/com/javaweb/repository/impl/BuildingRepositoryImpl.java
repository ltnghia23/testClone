package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.DTO.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.utils.Connect;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository{
	
	@Override
	public List<BuildingEntity> findAll(String name, Long numberOfBasement) {
		
		String query = "select * from building ";
		String where = "where 1=1";
		if(name != null && !name.equals("")) {
			where+= " and name like '%" + name + "%' ";
		}
		if(numberOfBasement != null) {
			where+= " and numberofbasement =" + numberOfBasement ;
		}
		query += where;
		List<BuildingEntity> result = new  ArrayList();
		try (Connection conn = Connect.getConection();
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(query);) {
				while(rs.next()) {
					BuildingEntity building = new BuildingEntity();
					building.setName(rs.getString("name"));
					building.setStreet(rs.getString("street"));
					building.setWard(rs.getString("ward"));
					building.setDistrict(rs.getString("districtid"));
					building.setNumberOfBasement(rs.getLong("numberofbasement"));
					building.setManagerName(rs.getString("managername"));
					building.setManagerPhoneNumber(rs.getString("managerphonenumber"));
					result.add(building);
				}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connected database failed...");
		}

		return result;
	}
	
	@Override
	public void delete(Long[] ids) {
		
	}

}
