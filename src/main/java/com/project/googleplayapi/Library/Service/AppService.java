package com.project.googleplayapi.Library.Service;

import com.project.googleplayapi.Library.Model.*;
import com.project.googleplayapi.Library.Repository.AppRepository;
import com.project.googleplayapi.Library.vo.*;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Optional.of;

@Service
public class AppService implements Serializable {

    @Autowired
    private AppRepository appRepository;

    @Autowired
    private AndroidVersionService androidVersionService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private GenryService genryService;

    @Autowired
    private TypeService typeService;

    @PersistenceContext
    private EntityManager entityManager;

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

    public List<ContentRatingVO> getAllContentRating() {

        List<Object> objects = appRepository.findByContentRatingGroupByContentRating();

        List<ContentRatingVO> contentRatingVOS = new ArrayList<>();
        objects.forEach(contentRating -> contentRatingVOS.add(new ContentRatingVO(String.valueOf(contentRating))) );

        return contentRatingVOS;
    }


    /*
    public List<AppVO> searchAdvancedSearch(SearchAppVO searchAppVO) {
        TypeVO typeVO1 = null;

        Genry genry = genryService.findById(searchAppVO.getGenryId());
        Type type = typeService.findById(searchAppVO.getTypeId());
        Category category = categoryService.findById(searchAppVO.getTypeId());
        AndroidVersion androidVersion = androidVersionService.findById(searchAppVO.getAndroidVersionId());
        String contentRating = of(searchAppVO).map(SearchAppVO::getContentRatingName).orElse(null);


        List<App> apps = appRepository.findByAndroidVersion_IdAndCategory_IdAndGenryAndType_IdAndContentRating(
                searchAppVO.getAndroidVersionId(), searchAppVO.getCategoryId(), genry,
                searchAppVO.getTypeId(), searchAppVO.getContentRatingName());

        List<AppVO> appVOS = new ArrayList<>();
        apps.forEach(app -> {

            AndroidVersionVO androidVersion = new AndroidVersionVO(app.getAndroidVersion().getId(),
                    app.getAndroidVersion().getName());

            CategoryVO categoryVO = new CategoryVO(app.getCategory().getId(), app.getCategory().getName());

            TypeVO typeVO = new TypeVO(app.getType().getId(), app.getType().getName());

            List<GenryVO> genryVOS = new ArrayList<>();
            app.getGenry().forEach(value -> genryVOS.add(new GenryVO(value.getId(), value.getName())));


            appVOS.add(new AppVO(app.getId(), app.getName(), app.getRating(), categoryVO, app.getReviewsQty(),
                    app.getSize(), app.getInstallsQty(), typeVO, app.getPrice(), app.getContentRating(),
                    genryVOS, app.getLastUpdate(), app.getVersion(), androidVersion));
        });


        return appVOS;
    }
*/

    


}
