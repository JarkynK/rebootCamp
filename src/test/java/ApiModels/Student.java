package ApiModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {

    /**
     * "studentId": 6842,
     *             "firstName": "Sonya",
     *             "lastName": "Demir",
     *             "batch": 2,
     *             "joinDate": "12/02/2020",
     *             "birthDate": "05/12/1995",
     *             "password": "test",
     *             "subject": "SQL",
     *             "gender": "Female",
     *             "admissionNo": "123",
     *             "major": "Master",
     *             "section": "100000",
     */
    String firstName;
    String lastName;
    int batch;
    String joinDate;
    String major;
    String birthDate;
    String password;
    String subject;
    String gender;
    String admissionNo;
    String section;
    Contact contact;
    Company company;

}
