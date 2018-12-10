package com.project.googleplayapi.Library.Service;

import com.project.googleplayapi.Library.Model.Type;
import com.project.googleplayapi.Library.Repository.TypeRepository;
import com.project.googleplayapi.Library.vo.TypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class TypeService implements Serializable {
    @Autowired
    private TypeRepository typeRepository;

    public Type findByName(String name) {
        return typeRepository.findByName(name);
    }

    public Type saveAndReturn(Type type) {
        return typeRepository.save(type);
    }

    public Iterable<Type> findAll() {
        return typeRepository.findAll();
    }

    public List<TypeVO> initializeFilter() {
        Iterable<Type> types = findAll();

        List<TypeVO> typeVOS = new ArrayList<>();
        types.forEach(type -> {
            typeVOS.add(new TypeVO(type.getId(), type.getName()));
        });

        return typeVOS;
    }

    public Type findById(Integer id) {
        return typeRepository.findById(id).orElse(null);
    }
}
