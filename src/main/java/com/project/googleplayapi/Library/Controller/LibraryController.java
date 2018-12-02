package com.project.googleplayapi.Library.Controller;

import com.project.googleplayapi.Library.Service.AppService;
import com.project.googleplayapi.Library.Service.FiltersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/library")
public class LibraryController {

    @Autowired
    private AppService appService;

    @Autowired
    private FiltersService filtersService;

    @GetMapping(value = "find/{search}", produces = "application/json")
    public ResponseEntity<?> search(@PathVariable("search") String search) {
        try {
            return new ResponseEntity<>(appService.transformToAppVO(appService.findByNameContaining(search)), HttpStatus.FOUND);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.PRECONDITION_FAILED);
        }
    }

    @GetMapping(value = "filter", produces = "application/json")
    public ResponseEntity<?> filtersInitialSearch() {
        try {
            return new ResponseEntity<>(filtersService.initialSearch(), HttpStatus.FOUND);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.PRECONDITION_FAILED);
        }
    }

}
