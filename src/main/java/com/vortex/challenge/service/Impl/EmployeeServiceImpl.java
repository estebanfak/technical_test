package com.vortex.challenge.service.Impl;

import com.vortex.challenge.dto.CreateEmployeeDto;
import com.vortex.challenge.dto.EmployeeDto;
import com.vortex.challenge.model.Employee;
import com.vortex.challenge.repository.EmployeeRepository;
import com.vortex.challenge.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    //------------------------------------------------------------------------------
//    @Autowired
//    private CountryRepository countryRepository;
//    @Autowired
//    private DepartmentRepository departmentRepository;
//    @Autowired
//    private JobHistoryRepository jobHistoryRepository;
//    @Autowired
//    private JobRepository jobRepository;
//    @Autowired
//    private LocationRepository locationRepository;
//    @Autowired
//    private RegionRepository regionRepository;
//
//
//    @PostConstruct
//    public void initDB(){
//        Random rand = new Random();
//        List<Region> regions = IntStream.rangeClosed(1, 5)
//                .mapToObj(i -> new Region("Region" + i))
//                .toList();
//        regionRepository.saveAll(regions);
//
//        List<Country> countries = IntStream.rangeClosed(1, 10)
//                .mapToObj(i -> new Country("Country" + i, regionRepository.findAll().get(rand.nextInt(regionRepository.findAll().size()))))
//                .toList();
//        countryRepository.saveAll(countries);
//
//        List<Location> locations = IntStream.rangeClosed(1, 20)
//                .mapToObj(i -> new Location("StreetAdress" + i, 1000, "City"+i, "State" + i, countryRepository.findAll().get(rand.nextInt(countryRepository.findAll().size()))))
//                .toList();
//        locationRepository.saveAll(locations);
//
//        List<Job> jobs = IntStream.rangeClosed(1, 5)
//                .mapToObj(i -> new Job("Job" + i, i*500, i*550))
//                .toList();
//        jobRepository.saveAll(jobs);
//        List<Department> departments = IntStream.rangeClosed(1, 5)
//                .mapToObj(i -> new Department("Department" + i, locationRepository.findAll().get(rand.nextInt(locationRepository.findAll().size()))))
//                .toList();
//        departmentRepository.saveAll(departments);
//
//        List<JobHistory> jobHistories = IntStream.rangeClosed(1, 5)
//                .mapToObj(i -> new JobHistory(new Date(), null, jobRepository.findAll().get(rand.nextInt(jobRepository.findAll().size())), departmentRepository.findAll().get(rand.nextInt(departmentRepository.findAll().size()))))
//                .toList();
//        jobHistoryRepository.saveAll(jobHistories);
//
//
//        List<Employee> managers = IntStream.rangeClosed(1, 10)
//                .mapToObj(i -> new Employee("ManagerName" + i, "ManagerLastName" + 1, "manager" + i + "@gmail.com", "56231854+" + i, new Date(), 2200.00, 150.00, jobRepository.findAll().get(rand.nextInt(jobRepository.findAll().size())), departmentRepository.findAll().get(rand.nextInt(departmentRepository.findAll().size()))))
//                .toList();
//        employeeRepository.saveAll(managers);
//        List<Employee> managersList = employeeRepository.findAll()
//                .stream()
//                .toList();
//
//        List<Employee> employees = IntStream.rangeClosed(11, 100)
//                .mapToObj(i -> new Employee("EmployeeName" + i, "EmployeeLastName" + 1, "employee" + i + "@gmail.com", "56231854+" + i, new Date(), 1200.00, 150.00, jobRepository.findAll().get(rand.nextInt(jobRepository.findAll().size())), departmentRepository.findAll().get(rand.nextInt(departmentRepository.findAll().size()))))
//                .toList();
//        employeeRepository.saveAll(employees);
//    }
    //------------------------------------------------------------------------------
    @Override
    public EmployeeDto newEmployee(CreateEmployeeDto createEmployeeDto) {
        Employee employee = new Employee(createEmployeeDto.getFirstName(),
                createEmployeeDto.getLastName(),
                createEmployeeDto.getEmail(),
                createEmployeeDto.getPhoneNumber(),
                createEmployeeDto.getHireDate(),
                createEmployeeDto.getSalary(),
                createEmployeeDto.getCommissionPct());
        return new EmployeeDto(employeeRepository.save(employee));
    }
    @Override
    public EmployeeDto modifyEmployee(EmployeeDto employeeDto) throws Exception {
        Employee employee = employeeRepository.findByEmployeeId(employeeDto.getId()).orElseThrow(() -> new Exception("Employee not found"));
        if(employeeDto.getFirstName()!=null){
            employee.setFirstName(employeeDto.getFirstName());
        }
        if(employeeDto.getLastName()!=null){
            employee.setLastName(employeeDto.getLastName());
        }
        if(employeeDto.getEmail()!=null){
            employee.setEmail(employeeDto.getEmail());
        }
        if(employeeDto.getPhoneNumber()!=null){
            employee.setPhoneNumber(employeeDto.getPhoneNumber());
        }
        if(employeeDto.getHireDate()!=null){
            employee.setHireDate(employeeDto.getHireDate());
        }
        if(employeeDto.getSalary()!=null){
            employee.setSalary(employeeDto.getSalary());
        }
        if(employeeDto.getCommissionPct()!=null){
            employee.setCommissionPct(employeeDto.getCommissionPct());
        }
        if(employeeDto.getFirstName()!=null){
            employee.setJobId(employeeDto.getJobId());
        }
        if(employeeDto.getFirstName()!=null){
            employee.setDepartmentId(employeeDto.getDepartmentId());
        }
        return new EmployeeDto(employeeRepository.save(employee));

    }
    @Override
    public EmployeeDto deleteEmployee(int employeeId) throws Exception {
        Employee employee = employeeRepository.findByEmployeeId(employeeId).orElseThrow(() -> new Exception("Employee not found"));
        EmployeeDto employeeDto = new EmployeeDto(employee);
        employeeRepository.delete(employee);
        return employeeDto;
    }
    @Override
    public EmployeeDto getEmployeeById(int id) throws Exception {
        return new EmployeeDto(employeeRepository.findByEmployeeId(id).orElseThrow(() -> new Exception("Employee not found")));
    }
    @Override
    public Page<EmployeeDto> getAll(int offset, int pageSize) {
        return new PageImpl<>(employeeRepository.findAll(PageRequest.of(offset, pageSize)).stream().map(EmployeeDto::new).collect(Collectors.toList()));
    }
    @Override
    public Page<EmployeeDto> filterByJobIdId(int jobId, int offset, int pageSize) {
        return new PageImpl<>(employeeRepository.findByJobIdJobId(jobId, PageRequest.of(offset, pageSize)).stream().map(EmployeeDto::new).toList());
    }
    @Override
    public Page<EmployeeDto> filterByManagerId(int managerId, int offset, int pageSize) {
        return new PageImpl<>(employeeRepository.findByManagerId(employeeRepository.findByEmployeeId(managerId).orElse(null), PageRequest.of(offset, pageSize)).map(EmployeeDto::new).toList());
    }
    @Override
    public Page<EmployeeDto> filterByLastName(String lastName, int offset, int pageSize) {
        return new PageImpl<>(employeeRepository.findByLastName(lastName, PageRequest.of(offset, pageSize)).stream().map(EmployeeDto::new).toList());
    }
    @Override
    public Page<EmployeeDto> employeesSortedByHireDateAscending(int offset, int pageSize) {
        return new PageImpl<>(employeeRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.Direction.ASC, "hireDate")).stream().map(EmployeeDto::new).collect(Collectors.toList()));
    }
    @Override
    public List<Employee> getAllEmployeesList() {
        return employeeRepository.findAll();
    }


    @Override
    public void setManager(int manager, int employee) {
        Employee employee1 = employeeRepository.findByEmployeeId(employee).orElse(null);
        Employee manager1 = employeeRepository.findByEmployeeId(manager).orElse(null);
        assert employee1 != null;
        employee1.setManagerId(manager1);
        employeeRepository.save(employee1);
    }




}
