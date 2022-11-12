package com.vortex.challenge;

import com.vortex.challenge.model.*;
import com.vortex.challenge.repository.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChallengeApplicationTests {
	@Autowired
	private EmployeeRepository employeeRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private JobHistoryRepository jobHistoryRepository;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private RegionRepository regionRepository;

	@Test
	@Order(1)
	public void emptyRepositoryEmployee(){
        assertEquals(0, employeeRepository.findAll().size());
	}
    @Test
    @Order(2)
    public void emptyRepositoryCountry(){
        assertEquals(0, countryRepository.findAll().size());
    }
    @Test
    @Order(3)
    public void emptyRepositoryDepartment(){
        assertEquals(0, departmentRepository.findAll().size());
    }
    @Test
    @Order(4)
    public void emptyRepositoryJobHistory(){
        assertEquals(0, jobHistoryRepository.findAll().size());
    }
    @Test
    @Order(5)
    public void emptyRepositoryJob(){
        assertEquals(0, jobRepository.findAll().size());
    }
    @Test
    @Order(6)
    public void emptyRepositoryLocation(){
        assertEquals(0, locationRepository.findAll().size());
    }
    @Test
    @Order(7)
    public void emptyRepositoryRegion(){
        assertEquals(0, regionRepository.findAll().size());
    }
    @Test
    @Order(8)
    public void addRegion(){
        Region region = new Region("Sur");
        assertNotNull(regionRepository.save(region));
    }
    @Test
    @Order(9)
    public void addRegion1(){
        Region region = new Region("Este");
        assertNotNull(regionRepository.save(region));
    }
    @Test
    @Order(10)
    public void addRegion2(){
        Region region = new Region("Oeste");
        assertNotNull(regionRepository.save(region));
    }
    @Test
    @Order(11)
    public void addRegion3(){
        Region region = new Region("Centro");
        assertNotNull(regionRepository.save(region));
    }
    @Test
    @Order(8)
    public void addRegion4(){
        Region region = new Region("Norte");
        assertNotNull(regionRepository.save(region));
    }
    @Test
    @Order(12)
    public void addCountry(){
        Country country = new Country("AR", "Argentina", regionRepository.findByRegionName("Sur"));
        assertNotNull(countryRepository.save(country));
    }
    @Test
    @Order(13)
    public void addCountry1(){
        Country country = new Country("BR", "Brasil", regionRepository.findByRegionName("Norte"));
        assertNotNull(countryRepository.save(country));
    }
    @Test
    @Order(14)
    public void addCountry2(){
        Country country = new Country("BO", "Bolivia", regionRepository.findByRegionName("Sur"));
        assertNotNull(countryRepository.save(country));
    }
    @Test
    @Order(15)
    public void addCountry3(){
        Country country = new Country("CH", "Chile", regionRepository.findByRegionName("Este"));
        assertNotNull(countryRepository.save(country));
    }
    @Test
    @Order(16)
    public void addLocation(){
        Location location = new Location("Libertador", "500", "Santa Lucia", "San Juan", countryRepository.findByCountryId("AR"));
        assertNotNull(locationRepository.save(location));
    }
    @Test
    @Order(17)
    public void addLocation1(){
        Location location = new Location("Laprida", "2000", "Rivadavia", "Mendoza", countryRepository.findByCountryId("BR"));
        assertNotNull(locationRepository.save(location));
    }
    @Test
    @Order(18)
    public void addLocation2(){
        Location location = new Location("Ignacio de la Roza", "1250", "Zonda", "Cordoba", countryRepository.findByCountryId("CH"));
        assertNotNull(locationRepository.save(location));
    }
    @Test
    @Order(19)
    public void addDepartment(){
        Department department = new Department("Contable", locationRepository.findByStreetAdress("Libertador"));
        assertNotNull(departmentRepository.save(department));
    }
    @Test
    @Order(20)
    public void addDepartment1(){
        Department department = new Department("Finanzas", locationRepository.findByStreetAdress("Laprida"));
        assertNotNull(departmentRepository.save(department));
    }
    @Test
    @Order(21)
    public void addDepartment2(){
        Department department = new Department("Ventas", locationRepository.findByStreetAdress("Ignacio de la Roza"));
        assertNotNull(departmentRepository.save(department));
    }
    @Test
    @Order(22)
    public void addJob(){
        Job job = new Job("Vendedor", "Vendedor categoria 1", (short) 1200, (short) 3000);
        assertNotNull(jobRepository.save(job));
    }
    @Test
    @Order(23)
    public void addJob1(){
        Job job = new Job("Cajero", "Cajero categoria2",  (short) 1500, (short) 4000);
        assertNotNull(jobRepository.save(job));
    }
    @Test
    @Order(23)
    public void addJob2(){
        Job job = new Job("Limpieza", "Limpieza categoria2",  (short) 800, (short) 2500);
        assertNotNull(jobRepository.save(job));
    }
    @Test
    @Order(24)
    public void addEmployee(){
        Employee employee = new Employee("Esteban", "Casile", "esteban@gmail.com", "65456", new Date(), 2000, 12, jobRepository.findByJobId("Cajero"), departmentRepository.findByDepartmentName("Contable"));
        assertNotNull(employeeRepository.save(employee));
    }
    @Test
    @Order(25)
    public void addEmployee1(){
        Employee employee = new Employee("Carlos", "Lopez", "esteban2@gmail.com", "65456", new Date(), 2000, 12, jobRepository.findByJobId("Vendedor"), departmentRepository.findByDepartmentName("Finanzas"));
        assertNotNull(employeeRepository.save(employee));
    }
    @Test
    @Order(26)
    public void addEmployee2(){
        Employee employee = new Employee("Pepe", "Perez", "esteban3@gmail.com", "65456", new Date(), 2000, 12, jobRepository.findByJobId("Limpieza"), departmentRepository.findByDepartmentName("Ventas"));
        assertNotNull(employeeRepository.save(employee));
    }
    @Test
    @Order(27)
    public void addEmployee3(){
        Employee employee = new Employee("Jacinto", "Martin", "esteban4@gmail.com", "65456", new Date(), 2000, 12, jobRepository.findByJobId("Cajero"), departmentRepository.findByDepartmentName("Finanzas"));
        assertNotNull(employeeRepository.save(employee));
    }
    @Test
    @Order(28)
    public void addEmployee4(){
        Employee employee = new Employee("Pablo", "Gomez", "esteba5n@gmail.com", "65456", new Date(), 2000, 12, jobRepository.findByJobId("Vendedor"), departmentRepository.findByDepartmentName("Contable"));
        assertNotNull(employeeRepository.save(employee));
    }
    @Test
    @Order(29)
    public void addEmployee5(){
        Employee employee = new Employee("Roberto", "Garcia", "esteban6@gmail.com", "65456", new Date(), 2000, 12, jobRepository.findByJobId("Limpieza"), departmentRepository.findByDepartmentName("Ventas"));
        assertNotNull(employeeRepository.save(employee));
    }
    @Test
    @Order(30)
    public void setManager(){
        Employee employee = employeeRepository.findByLastName("Gomez");
        Employee manager = employeeRepository.findByLastName("Casile");
        employee.setManagerId(manager);
        employeeRepository.save(employee);
        employeeRepository.save(manager);
        assertNotNull(employee.getManagerId());
    }
    @Test
    @Order(31)
    public void setManager1(){
        Employee employee = employeeRepository.findByLastName("Garcia");
        Employee manager = employeeRepository.findByLastName("Casile");
        employee.setManagerId(manager);
        employeeRepository.save(employee);
        employeeRepository.save(manager);
        assertNotNull(employee.getManagerId());
    }
    @Test
    @Order(32)
    public void setManager2(){
        Employee employee = employeeRepository.findByLastName("Martin");
        Employee manager = employeeRepository.findByLastName("Casile");
        employee.setManagerId(manager);
        employeeRepository.save(employee);
        employeeRepository.save(manager);
        assertNotNull(employee.getManagerId());
    }
    @Test
    @Order(33)
    public void setManager3(){
        Employee employee = employeeRepository.findByLastName("Perez");
        Employee manager = employeeRepository.findByLastName("Casile");
        employee.setManagerId(manager);
        employeeRepository.save(employee);
        employeeRepository.save(manager);
        assertNotNull(employee.getManagerId());
    }
    @Test
    @Order(34)
    public void checkManager(){
        Employee manager = employeeRepository.findByLastName("Casile");
        assertEquals(4,manager.getEmployees().size());
    }
//    @Test
//    @Order(17)
//    public void addLocation1(){
//        assertNotNull(countryRepository.save(country));
//    }
//    @Test
//    @Order(18)
//    public void addLocation2(){
//        assertNotNull(countryRepository.save(country));
//    }
//    @Test
//    @Order(9)
//    public void addJob(){
//        Job job = new Job("Vendedor", (short) 3500, (short) 6000);
//        assertNotNull(jobRepository.save(job));
//    }

//    @Test
//    @Order(10)
//    public void addEmployee(){
//        Employee employee = new Employee("Esteban", "Casile", "esteban@gmail.com", "8938247238947", new Date(), 5000, 12);
//        Job job = new Job("Vendedor", (short) 3500, (short) 6000);
//
//        employeeRepository.save(employee);
//        assertNotNull(employee);
//    }



}
