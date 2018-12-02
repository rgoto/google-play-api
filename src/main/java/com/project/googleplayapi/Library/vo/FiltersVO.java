package com.project.googleplayapi.Library.vo;

import java.util.List;

public class FiltersVO {

    public FiltersVO() {
    }

    public FiltersVO(List<CategoryVO> categoryVOS, List<GenryVO> genryVOS, List<TypeVO> typesVOS, List<AndroidVersionVO> androidVersionVOS) {
        this.categoryVOS = categoryVOS;
        this.genryVOS = genryVOS;
        this.typesVOS = typesVOS;
        this.androidVersionVOS = androidVersionVOS;
    }

    private List<CategoryVO> categoryVOS;
    private List<GenryVO> genryVOS;
    private List<TypeVO> typesVOS;
    private List<AndroidVersionVO> androidVersionVOS;

    public List<CategoryVO> getCategoryVOS() {
        return categoryVOS;
    }

    public void setCategoryVOS(List<CategoryVO> categoryVOS) {
        this.categoryVOS = categoryVOS;
    }

    public List<GenryVO> getGenryVOS() {
        return genryVOS;
    }

    public void setGenryVOS(List<GenryVO> genryVOS) {
        this.genryVOS = genryVOS;
    }

    public List<TypeVO> getTypesVOS() {
        return typesVOS;
    }

    public void setTypesVOS(List<TypeVO> typesVOS) {
        this.typesVOS = typesVOS;
    }

    public List<AndroidVersionVO> getAndroidVersionVOS() {
        return androidVersionVOS;
    }

    public void setAndroidVersionVOS(List<AndroidVersionVO> androidVersionVOS) {
        this.androidVersionVOS = androidVersionVOS;
    }
}
