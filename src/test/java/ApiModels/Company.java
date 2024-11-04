package ApiModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)public class Company {

    /**
     * "companyName": "Cybertek",
     *                 "title": "SDET",
     *                 "startDate": "09/03/2020",
     */
    String companyName;
    String title;
    String startDate;
    Address address;
    String project;
}
