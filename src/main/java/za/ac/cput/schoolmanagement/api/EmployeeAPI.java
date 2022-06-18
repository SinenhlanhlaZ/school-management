package za.ac.cput.schoolmanagement.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.schoolmanagement.domain.Employee;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;
import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.service.ICityService;
import za.ac.cput.schoolmanagement.service.IEmployeeAddressService;
import za.ac.cput.schoolmanagement.service.IEmployeeService;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeAPI {
    private final IEmployeeAddressService iEmployeeAddressService;
    private final ICityService iCityService;
    private final IEmployeeService iEmployeeService;


    @Autowired
    public EmployeeAPI(IEmployeeAddressService iEmployeeAddressService, ICityService iCityService, IEmployeeService iEmployeeService) {
        this.iEmployeeAddressService = iEmployeeAddressService;
        this.iCityService = iCityService;
        this.iEmployeeService = iEmployeeService;
    }

    /*Question 6
    Implement a service to retrieve all employee name(s) living in a particular city.
    The formal parameter passed is the cityId.
    */
    public List<Name> findEmployeesInCity(String cityId){
        this.iCityService.read(cityId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        List<EmployeeAddress> allEmployeeAddresses = this.iEmployeeAddressService.findAll();
        List<Employee> foundEmployees = new ArrayList<>();
        List<Name> employeeNames = new ArrayList<>();

        for (var employeeAddress : allEmployeeAddresses){
            if (employeeAddress.getAddress().getCity().getId().equalsIgnoreCase(cityId)){
                foundEmployees.add(iEmployeeService.read(employeeAddress.getStaffId()).get());
            }
        }
        foundEmployees.forEach(employee -> employeeNames.add(employee.getName()));
        return employeeNames;
    }
}
