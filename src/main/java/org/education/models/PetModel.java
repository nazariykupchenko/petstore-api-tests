package org.education.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PetModel {
    public int id;
    public CategoryModel category;
    public String name;
    public String[] photoUrls;
    public TagModel tagModel;
    public String status;
}
