package ApiModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)public class Contact {

    /**
     * "phone": "7772227272",
     *                 "emailAddress": "abcxcv@gmail.com",
     *                 "premanentAddress": "123 Main st."
     */

    String phone;
    String emailAddress;
    String premanentAddress;

}
