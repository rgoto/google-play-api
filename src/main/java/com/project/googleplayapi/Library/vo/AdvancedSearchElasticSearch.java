package com.project.googleplayapi.Library.vo;

import com.project.googleplayapi.Library.Model.AndroidVersion;
import com.project.googleplayapi.Library.Model.Category;
import com.project.googleplayapi.Library.Model.Genry;
import com.project.googleplayapi.Library.Model.Type;

import java.io.Serializable;

public class AdvancedSearchElasticSearch implements Serializable {

    public AdvancedSearchElasticSearch(String search, AndroidVersion androidVersion, Category categoryId, String contentRatingName, Genry genryId, Type typeId) {
        this.search = search;
        this.androidVersion = androidVersion;
        this.category = categoryId;
        this.contentRatingName = contentRatingName;
        this.genry = genryId;
        this.type = typeId;
    }

    private String search;
    private AndroidVersion androidVersion;
    private Category category;
    private String contentRatingName;
    private Genry genry;
    private Type type;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public AndroidVersion getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(AndroidVersion androidVersion) {
        this.androidVersion = androidVersion;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getContentRatingName() {
        return contentRatingName;
    }

    public void setContentRatingName(String contentRatingName) {
        this.contentRatingName = contentRatingName;
    }

    public Genry getGenry() {
        return genry;
    }

    public void setGenry(Genry genry) {
        this.genry = genry;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
