package com.project.googleplayapi.Library.vo;

import java.util.List;

public class AppVO {

    public AppVO(Long id, String name, Double rating, CategoryVO category, Integer reviewsQty, String size, String installsQty, TypeVO type, String price, String contentRating, List<GenryVO> genry, String lastUpdate, String version, AndroidVersionVO androidVersion) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.category = category;
        this.reviewsQty = reviewsQty;
        this.size = size;
        this.installsQty = installsQty;
        this.type = type;
        this.price = price;
        this.contentRating = contentRating;
        this.genry = genry;
        this.lastUpdate = lastUpdate;
        this.version = version;
        this.androidVersion = androidVersion;
    }

    private Long id;
    private String name;
    private Double rating;
    private CategoryVO category;
    private Integer reviewsQty;
    private String size;
    private String installsQty;
    private TypeVO type;
    private String price;
    private String contentRating;
    private List<GenryVO> genry;
    private String lastUpdate;
    private String version;
    private AndroidVersionVO androidVersion;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public CategoryVO getCategory() {
        return category;
    }

    public void setCategory(CategoryVO category) {
        this.category = category;
    }

    public Integer getReviewsQty() {
        return reviewsQty;
    }

    public void setReviewsQty(Integer reviewsQty) {
        this.reviewsQty = reviewsQty;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getInstallsQty() {
        return installsQty;
    }

    public void setInstallsQty(String installsQty) {
        this.installsQty = installsQty;
    }

    public TypeVO getType() {
        return type;
    }

    public void setType(TypeVO type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getContentRating() {
        return contentRating;
    }

    public void setContentRating(String contentRating) {
        this.contentRating = contentRating;
    }

    public List<GenryVO> getGenry() {
        return genry;
    }

    public void setGenry(List<GenryVO> genry) {
        this.genry = genry;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public AndroidVersionVO getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(AndroidVersionVO androidVersion) {
        this.androidVersion = androidVersion;
    }
}
