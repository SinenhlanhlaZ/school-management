package za.ac.cput.schoolmanagement.api;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.schoolmanagement.domain.Student;
import za.ac.cput.schoolmanagement.domain.StudentAddress;
import za.ac.cput.schoolmanagement.service.IStudentAddressService;
import za.ac.cput.schoolmanagement.service.IStudentService;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentAPI {

    private final IStudentService iStudentService;
    private final IStudentAddressService iStudentAddressService;

    public StudentAPI(IStudentService iStudentService, IStudentAddressService iStudentAddressService) {
        this.iStudentAddressService = iStudentAddressService;
        this.iStudentService = iStudentService;
    }

    /* Question 8
     Using your knowledge of Facade design pattern, implement a service to retrieve a list containing the last name of all the students in the same country,
     given a country id.
     Hint: Revisit Q6 to ensure that it was implemented correctly*/
    public List<String> findStudentsInCountry(String countryId) {
        try {
            //Defining all lists to filter out the students by Surname
            List<Student> studentList = new ArrayList<>();
            List<String> lastNameList = new ArrayList<>();
            List<StudentAddress> studentAddressList = iStudentAddressService.findAll();
            List<StudentAddress> finalStudentAdd = new ArrayList<>();

            for (var studentAddress : studentAddressList) {
                if (studentAddress.getAddress().getCity().getCountry().getId().equalsIgnoreCase(countryId)) {
                    finalStudentAdd.add(studentAddress);
                }
            }
            finalStudentAdd.forEach(studentAddress -> {
                studentList.add(iStudentService.read(studentAddress.getStudentId()).get());
            });

            studentList.forEach(student -> {
                lastNameList.add(student.getName().getLastName());
            });

            return lastNameList;
        } catch (Exception i) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
