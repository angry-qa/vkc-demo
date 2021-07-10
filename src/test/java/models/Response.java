package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
    @JsonProperty("sid")
    private String sid;

    @JsonProperty("result")
    private String result;

    @JsonProperty("phone")
    private String phone;
}