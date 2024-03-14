package com.javaweb.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.DTO.BuildingDTO;
import com.javaweb.DTO.ErrorResponseDTO;
import com.javaweb.customException.FieldRequiredException;
import com.javaweb.service.BuildingService;


@RestController
public class BuildingApi {

	@Autowired
	private BuildingService buildingService;
	@GetMapping(value = "/api/BuildingApi")
	public List<BuildingDTO> findBuilding(@RequestParam(value = "name", required = false) String name,
										  @RequestParam(value = "numberOfBasement", required = false) Long numberOfBasement) {
		List<BuildingDTO> result = buildingService.findAll(name, numberOfBasement);
		return result;
	}
	//test change
//	@RequestMapping(value = "/api/BuildingApi", method = RequestMethod.GET)
//	@ResponseBody
//	public BuildingDTO getBulding(@RequestParam Map<String, Object> params,
//						@RequestParam("hobby") List<String> hobbies) {
//		//giả định đã lấy xong từ database
//		BuildingDTO building = new BuildingDTO();
//		String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
//		building.setName("Nghia Le Handsome");
//		building.setTitle("Head");
//		building.setDeparture("Information Technology");
//		building.setGirlfriend(cars);
//		return building;
//   }

//	@RequestMapping(value = "/api/BuildingApi", method = RequestMethod.POST)
//	public void addBuilding(@RequestBody Map<String, String> infor) {
//		System.out.println("POST Method");
//	}

//	@RequestMapping(value = "/api/BuildingApi", method =RequestMethod.POST)
//	public void testDTO(@RequestBody BuildingDTO building) {
//		System.out.println("TestDTO");
//	}
//	@RequestMapping(value = "/api/BuildingApi", method = RequestMethod.POST)
//	public void testPost(@RequestBody BuildingDTO building) {
//		System.out.print("ok");
//	}

//	@GetMapping(value = "/api/BuildingApi")
//	public List<BuildingDTO> testDTO(@RequestParam Map<String, String> params) {
//		List<BuildingDTO> result = new ArrayList();
//		BuildingDTO building = new BuildingDTO();
//		building.setName("NghiaLE Building");
//		building.setTitle("Director");
//		building.setDeparture("CEO");
//		BuildingDTO building2 = new BuildingDTO();
//		building2.setName("HaiTrieu Building");
//		building2.setTitle("Director");
//		building2.setDeparture("CEO");
//		result.add(building2);
//		result.add(building);
//		return result;
//	}
	@DeleteMapping(value = "/api/BuildingApi/{ids}/{name}")
	public void testPathvariable(@PathVariable Long[] ids, @PathVariable String name) {
		System.out.println("ok");
	}



//	@PostMapping(value = "/api/BuildingApi")
//	public Object createBuilding(@RequestBody BuildingDTO buildingDTO) {
//		try {
//			validateData(buildingDTO);
//		} catch (Exception ex) {
//			ErrorResponseDTO err = new ErrorResponseDTO();
//			err.setError(ex.getMessage());
//			List<String> detail = new ArrayList();
//			detail.add("name or district hasn't return yet");
//			err.setDetail(detail);
//			return err;
//		}
//		System.out.println("OK");
//		return buildingDTO;
//	}

	//
//	@GetMapping(value = "/api/BuildingApi")
//	public Object findBuilding(@RequestParam(value = "name", required = false) String name,
//			@RequestParam(value = "typeCode", required = false) List<String> typeCode) {
//		System.out.print(5 / 0);
//		List<BuildingDTO> list = new ArrayList();
//		BuildingDTO buildingDTO = new BuildingDTO();
//		buildingDTO.setName("TrieuBuilding");
//		buildingDTO.setDistrict("Distric 1");
//		buildingDTO.setStreet("Nguyen Hue");
//		buildingDTO.setWard("Dakao");
//		List<String> building = new ArrayList<String>();
//		building.add("TangTret");
//		building.add("TangHam");
//		buildingDTO.setTypeCode(building);
//		list.add(buildingDTO);
//		BuildingDTO buildingDTO1 = new BuildingDTO();
//		buildingDTO1.setName("NghiaBuilding");
//		buildingDTO1.setDistrict("Distric 1");
//		buildingDTO1.setStreet("Nguyen Du");
//		buildingDTO1.setWard("Ben Nghe");
//		List<String> building1 = new ArrayList<String>();
//		building1.add("TangTret");
//		building1.add("TangHam");
//		buildingDTO1.setTypeCode(building1);
//		list.add(buildingDTO1);
//		return list;
//	}

//	@PostMapping(value = "/api/BuildingApi")
//	public Object postMethod(@RequestBody BuildingDTO buildingDTO) throws FieldRequiredException {
//		System.out.println(5/0);
//		validateData(buildingDTO);
//		System.out.print("OK");
//		return buildingDTO;
//	}
//	
//	@GetMapping(value = "/api/BuildingApi")
//	public Object finBuilding1(@RequestBody BuildingDTO buildingDTO) throws FieldRequiredException {
//		validateData(buildingDTO);
//		System.out.println("OK");
//		return buildingDTO;
//	}
}
