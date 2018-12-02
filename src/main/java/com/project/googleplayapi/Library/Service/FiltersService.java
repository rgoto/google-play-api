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


    public FiltersVO initialSearch() {
        List<CategoryVO> categoryVOS = categoryService.initiliazeFilter();
        List<GenryVO> genryVOS = genryService.initiliazeFilter();
        List<TypeVO> typeVOS = typeService.initializeFilter();
        List<AndroidVersionVO> androidVersionVOS = androidVersionService.initiliazeFilter();

        return new FiltersVO(categoryVOS, genryVOS, typeVOS, androidVersionVOS);
    }

}
