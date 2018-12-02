package com.project.googleplayapi.Library.Repository;

import com.project.googleplayapi.Library.Model.AndroidVersion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AndroidVersionRepository extends CrudRepository<AndroidVersion, Integer> {

    AndroidVersion findByName(String name);
}
