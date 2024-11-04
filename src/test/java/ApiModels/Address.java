package ApiModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

    /**
     * "street": "123 Main st.",
     *                     "city": "Chicago",
     *                     "state": "IL",
     *                     "zipCode": 60016
     */
    String city;
    String state;
    int zipCode;
    String street;

}
