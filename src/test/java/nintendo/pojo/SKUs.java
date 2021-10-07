package nintendo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
I created pojo class for serialization and deserialization
 */

//i used lombok libraries to avoid writing getters and setters.
//this way is faster and easier to read
@Getter
@Setter
@ToString
//if in response body from API, will be values then i have in pojo class it will simply ignore it
@JsonIgnoreProperties(ignoreUnknown = true)

//if i need ignore some properties when i am sending my API request i use method bellow
//@JsonIgnoreProperties(value = "sku",allowSetters = true)
public class SKUs {
    private String sku;
    private String description;
    private String price;

}
