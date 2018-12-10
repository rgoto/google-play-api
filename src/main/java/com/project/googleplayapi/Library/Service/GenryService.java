package com.project.googleplayapi.Library.Service;

import com.project.googleplayapi.Library.Model.Genry;
import com.project.googleplayapi.Library.Repository.GenryRepository;
import com.project.googleplayapi.Library.vo.GenryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class GenryService implements Serializable {

    @Autowired
    private GenryRepository genryRepository;

    public Genry findByName(String name) {
        return genryRepository.findByName(name);
    }

    public Genry saveAndReturn(Genry genry) {
        return genryRepository.save(genry);
    }

    public Iterable<Genry> findAll() {
        return genryRepository.findAll();
    }

    public List<GenryVO> initiliazeFilter() {
        Iterable<Genry> genries = findAll();

        List<GenryVO> genryVOS = new ArrayList<>();
        genries.forEach(genry -> {
            genryVOS.add(new GenryVO(genry.getId(), genry.getName()));
        });
        return genryVOS;
    }

    public Genry findById(Integer id) {
        return genryRepository.findById(id).orElse(null);
    }

}
