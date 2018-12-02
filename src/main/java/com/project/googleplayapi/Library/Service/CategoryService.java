package com.project.googleplayapi.Library.Service;

import com.project.googleplayapi.Library.Model.Category;
import com.project.googleplayapi.Library.Repository.CategoryRepository;
import com.project.googleplayapi.Library.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements Serializable {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category findByName(String category) {
        return categoryRepository.findByName(category);
    }

    public Category saveAndReturn(Category category) {
        return categoryRepository.save(category);
    }

    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    public List<CategoryVO> initiliazeFilter() {
        Iterable<Category> categories = findAll();

        List<CategoryVO> categoryVOS = new ArrayList<>();
        categories.forEach(category -> {
            categoryVOS.add(new CategoryVO(category.getId(), category.getName()));
        });

        return categoryVOS;
    }
}
