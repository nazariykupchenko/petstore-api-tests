package org.education.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class PetModel {
    @JsonProperty("id")
    private int id;
    @JsonProperty("category")
    private CategoryModel category;
    @JsonProperty("name")
    private String name;
    @JsonProperty("photoUrls")
    private String[] photoUrls;
    @JsonProperty("tagModel")
    private TagModel tagModel;
    @JsonProperty("status")
    private String status;
}
