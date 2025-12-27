package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetItemById {

    @JsonProperty("id")
    private String id;

    @JsonProperty("sellerId")
    private Integer sellerId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private Integer price;

    @JsonProperty("createdAt")
    private String createdAt;

    @JsonProperty("statistics")
    private Statistics statistics;
}
