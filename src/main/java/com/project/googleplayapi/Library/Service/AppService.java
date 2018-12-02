package com.project.googleplayapi.Library.Service;

import com.project.googleplayapi.Library.Model.App;
import com.project.googleplayapi.Library.Model.Genry;
import com.project.googleplayapi.Library.Repository.AppRepository;
import com.project.googleplayapi.Library.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppService implements Serializable {

    @Autowired
    private AppRepository appRepository;

    public App save(App app) {
        return appRepository.save(app);
    }

    public List<App> findByNameContaining(String search) {
        return appRepository.findByNameContaining(search);
    }

    public List<AppVO> transformToAppVO(List<App> apps) {

        List<AppVO> appVOS = new ArrayList<>();
        apps.forEach(app -> {
            AndroidVersionVO androidVersionVO = new AndroidVersionVO(app.getAndroidVersion().getId(), app.getAndroidVersion().getName());
            CategoryVO categoryVO = new CategoryVO(app.getCategory().getId(), app.getCategory().getName());
            TypeVO typeVO = new TypeVO(app.getType().getId(), app.getType().getName());

            List<GenryVO> genryVOS = new ArrayList<>();
            app.getGenry().forEach(genry -> {
                genryVOS.add(new GenryVO(genry.getId(), genry.getName()));
            });


            appVOS.add(new AppVO(app.getId(), app.getName(), app.getRating(), categoryVO, app.getReviewsQty(), app.getSize(), app.getInstallsQty(), typeVO, app.getPrice(), app.getContentRating(), genryVOS, app.getLastUpdate(), app.getVersion(), androidVersionVO));

        });

        return appVOS;
    }


}
