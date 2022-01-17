package org.education.rest.models;

public class PetModel {
    public int id;
    public CategoryModel category;
    public String name;
    public String[] photoUrls;
    public TagModel tagModel;
    public String status;

    public PetModel(int id, CategoryModel category, String name, String[] photoUrls, TagModel tagModel, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tagModel = tagModel;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(String[] photoUrls) {
        this.photoUrls = photoUrls;
    }

    public TagModel getTagModel() {
        return tagModel;
    }

    public void setTagModel(TagModel tagModel) {
        this.tagModel = tagModel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
