package com.project.googleplayapi.Library.Repository;

import com.project.googleplayapi.Library.Model.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends CrudRepository<Type, Integer> {

    Type findByName(String name);

}
