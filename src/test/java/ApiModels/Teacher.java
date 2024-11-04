package ApiModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Teacher {

    /**
     * {
     *   "batch": 14,
     *   "birthDate": "01/01/1999",
     *   "department": "IT",
     *   "emailAddress": "testgmail.com",
     *   "firstName": "Ashley",
     *   "gender": "Male",
     *   "joinDate": "02/02/2040",
     *   "lastName": "Jobs",
     *   "password": "testPass",
     *   "phone": "123-532-1323",
     *   "premanentAddress": "Some address in California",
     *   "salary": 150,
     *   "section": "string",
     *   "subject": "Programming"
     * }
     */
    String premanentAddress;
    String section;
    String subject;
    int batch;
    String birthDate;
    String department;
    String gender;
    String password;
    String phone;
    String firstName;
    String lastName;
    String emailAddress;
    String joinDate;
    int salary;
    int teacherId;

}

