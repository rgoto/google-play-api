package com.project.googleplayapi.Library.Service;

import com.project.googleplayapi.Library.Model.AndroidVersion;
import com.project.googleplayapi.Library.Repository.AndroidVersionRepository;
import com.project.googleplayapi.Library.vo.AndroidVersionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class AndroidVersionService implements Serializable {

    @Autowired
    private AndroidVersionRepository androidVersionRepository;

    public AndroidVersion findByName(String name) {
        return androidVersionRepository.findByName(name);
    }

    public AndroidVersion saveAndReturn(AndroidVersion androidVersion) {
        return androidVersionRepository.save(androidVersion);
    }

    public Iterable<AndroidVersion> findAll() {
        return androidVersionRepository.findAll();
    }

    public List<AndroidVersionVO> initiliazeFilter() {
        Iterable<AndroidVersion> androidVersions = findAll();

        List<AndroidVersionVO> androidVersionVOS = new ArrayList<>();
        androidVersions.forEach(androidVersion -> {
            androidVersionVOS.add(new AndroidVersionVO(androidVersion.getId(), androidVersion.getName()));
        });

        return androidVersionVOS;
    }
}
