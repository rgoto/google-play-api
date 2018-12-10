package com.project.googleplayapi.Library.vo;

import java.io.Serializable;

public class SearchAppVO implements Serializable {

    public SearchAppVO() {
    }

    public SearchAppVO(String search, Integer androidVersionId, Integer categoryId, String contentRatingName, Integer genryId, Integer typeId) {
        this.search = search;
        this.androidVersionId = androidVersionId;
        this.categoryId = categoryId;
        this.contentRatingName = contentRatingName;
        this.genryId = genryId;
        this.typeId = typeId;
    }

    private String search;
    private Integer androidVersionId;
    private Integer categoryId;
    private String contentRatingName;
    private Integer genryId;
    private Integer typeId;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Integer getAndroidVersionId() {
        return androidVersionId;
    }

    public void setAndroidVersionId(Integer androidVersionId) {
        this.androidVersionId = androidVersionId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getContentRatingName() {
        return contentRatingName;
    }

    public void setContentRatingName(String contentRatingName) {
        this.contentRatingName = contentRatingName;
    }

    public Integer getGenryId() {
        return genryId;
    }

    public void setGenryId(Integer genryId) {
        this.genryId = genryId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}
