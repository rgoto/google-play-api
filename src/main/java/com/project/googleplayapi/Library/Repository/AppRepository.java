package com.project.googleplayapi.Library.Repository;

import com.project.googleplayapi.Library.Model.App;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppRepository extends CrudRepository<App, Long> {

    App findByName(String name);

    List<App> findByNameContaining(@Param("name") String name);

}
