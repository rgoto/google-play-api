package com.project.googleplayapi.Library.Service;

import com.project.googleplayapi.Library.Model.*;
import com.project.googleplayapi.Library.Repository.AppRepository;
import com.project.googleplayapi.Library.vo.*;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.io.Serializable;
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

    @Autowired
    private ElasticSearchService elasticSearchService;

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

    public ResponseVO advancedSearch(SearchAppVO searchAppVO) throws IOException {
        Genry genry = null;
        Type type = null;
        Category category = null;
        AndroidVersion androidVersion = null;
        String contentRating = null;
        if (null != searchAppVO.getGenryId()) {
            genry = genryService.findById(searchAppVO.getGenryId());
        }

        if (null != searchAppVO.getTypeId()) {
            type = typeService.findById(searchAppVO.getTypeId());
        }

        if (null != searchAppVO.getCategoryId()) {
            category = categoryService.findById(searchAppVO.getCategoryId());
        }

        if (null != searchAppVO.getAndroidVersionId()) {
            androidVersion = androidVersionService.findById(searchAppVO.getAndroidVersionId());
        }

        if (null != searchAppVO.getContentRatingName()) {
            contentRating = of(searchAppVO).map(SearchAppVO::getContentRatingName).orElse(null);
        }

        AdvancedSearchElasticSearch advancedSearchElasticSearch = new AdvancedSearchElasticSearch(searchAppVO.getSearch(), androidVersion, category, contentRating, genry, type);

        SearchHits hits = elasticSearchService.advancedSearch(advancedSearchElasticSearch);

        return elasticSearchService.tranforms(hits);
    }


}
