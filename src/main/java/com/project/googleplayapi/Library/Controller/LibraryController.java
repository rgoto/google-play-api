package com.project.googleplayapi.Library.Controller;

import com.project.googleplayapi.Library.Service.AppService;
import com.project.googleplayapi.Library.Service.FiltersService;
import com.project.googleplayapi.Library.vo.SearchAppVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/library")
public class LibraryController {

    @Autowired
    private AppService appService;

    @Autowired
    private FiltersService filtersService;

    @GetMapping(value = "find/{search}", produces = "application/json")
    public ResponseEntity<?> search(@PathVariable("search") String search) {
        try {
            return new ResponseEntity<>(appService.transformToAppVO(appService.findByNameContaining(search)), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.PRECONDITION_FAILED);
        }
    }

    @GetMapping(value = "filter/android-version", produces = "application/json")
    public ResponseEntity<?> filterAndroidVersion() {
        try {
            return new ResponseEntity<>(filtersService.filterAndroidVersion(), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.PRECONDITION_FAILED);
        }
    }

    @GetMapping(value = "filter/category", produces = "application/json")
    public ResponseEntity<?> filtersCategory() {
        try {
            return new ResponseEntity<>(filtersService.filtersCategory(), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.PRECONDITION_FAILED);
        }
    }

    @GetMapping(value = "filter/genry", produces = "application/json")
    public ResponseEntity<?> filtersGenry() {
        try {
            return new ResponseEntity<>(filtersService.filtersGenry(), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.PRECONDITION_FAILED);
        }
    }

    @GetMapping(value = "filter/type", produces = "application/json")
    public ResponseEntity<?> filtersType() {
        try {
            return new ResponseEntity<>(filtersService.filtersType(), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.PRECONDITION_FAILED);
        }
    }

    @GetMapping(value = "filter/content-rating", produces = "application/json")
    public ResponseEntity<?> filterContentRating() {
        try {
            return new ResponseEntity<>(filtersService.filterContentRating(), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.PRECONDITION_FAILED);
        }
    }

    @PostMapping(value = "find/advanced-search", produces = "application/json")
    public ResponseEntity<?> advancedSearch(@RequestBody SearchAppVO searchAppVO) {
        try {
            return new ResponseEntity<>(appService.advancedSearch(searchAppVO), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.PRECONDITION_FAILED);
        }
    }


}
