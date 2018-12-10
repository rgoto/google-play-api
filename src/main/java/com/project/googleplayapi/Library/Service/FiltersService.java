package com.project.googleplayapi.Library.Service;

import com.project.googleplayapi.Library.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class FiltersService implements Serializable {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private GenryService genryService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private AndroidVersionService androidVersionService;

    @Autowired
    private AppService appService;


    public List<CategoryVO> filtersCategory() {
        return categoryService.initiliazeFilter();
    }

    public List<GenryVO> filtersGenry() {
        return genryService.initiliazeFilter();
    }

    public List<TypeVO> filtersType() {
        return typeService.initializeFilter();
    }

    public List<AndroidVersionVO> filterAndroidVersion() {
        return androidVersionService.initiliazeFilter();
    }

    public List<ContentRatingVO> filterContentRating() {
        return appService.getAllContentRating();
    }
}
