package com.project.googleplayapi.Library.Repository;

import com.project.googleplayapi.Library.Model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

    Category findByName(String name);

}
