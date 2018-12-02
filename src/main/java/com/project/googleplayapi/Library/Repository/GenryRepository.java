package com.project.googleplayapi.Library.Repository;

import com.project.googleplayapi.Library.Model.Genry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenryRepository extends CrudRepository<Genry, Integer> {

    Genry findByName(String name);

}
