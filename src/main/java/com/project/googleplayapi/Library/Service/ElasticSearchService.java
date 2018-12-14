package com.project.googleplayapi.Library.Service;

import com.project.googleplayapi.Library.Model.AndroidVersion;
import com.project.googleplayapi.Library.Model.Category;
import com.project.googleplayapi.Library.Model.Genry;
import com.project.googleplayapi.Library.Model.Type;
import com.project.googleplayapi.Library.vo.*;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.QueryBuilders.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ElasticSearchService {

    @Autowired
    private GenryService genryService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AndroidVersionService androidVersionService;

    @Autowired
    private TypeService typeService;


    public SearchHits advancedSearch(AdvancedSearchElasticSearch advancedSearchElasticSearch) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();
        if (null != advancedSearchElasticSearch.getSearch()) {
          stringBuilder.append(advancedSearchElasticSearch.getSearch());
          stringBuilder.append(" ");
        }

        if (null != advancedSearchElasticSearch.getAndroidVersion()) {
            stringBuilder.append(advancedSearchElasticSearch.getAndroidVersion().getName());
            stringBuilder.append(" ");
        }

        if (null != advancedSearchElasticSearch.getCategory()) {
            stringBuilder.append(advancedSearchElasticSearch.getCategory().getName());
            stringBuilder.append(" ");
        }

        if (null != advancedSearchElasticSearch.getContentRatingName()) {
            stringBuilder.append(advancedSearchElasticSearch.getContentRatingName());
            stringBuilder.append(" ");
        }

        if (null != advancedSearchElasticSearch.getGenry()) {
            stringBuilder.append(advancedSearchElasticSearch.getGenry().getName());
            stringBuilder.append(" ");
        }

        if (null != advancedSearchElasticSearch.getType()) {
            stringBuilder.append(advancedSearchElasticSearch.getType().getName());
        }

        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials("elastic", "pV4oQUm4vjSSJRKq4izkB2mJ"));


        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("cebe8bf96fd64d638b25078e8f67a504.us-east-1.aws.found.io", 9243,
                                "https")).setHttpClientConfigCallback(httpAsyncClientBuilder
                        -> httpAsyncClientBuilder.setDefaultCredentialsProvider(credentialsProvider)));


        SearchRequest searchRequest = new SearchRequest("application");


        QueryBuilder qb = QueryBuilders.multiMatchQuery(stringBuilder.toString(), "name", "androidVersion", "genry", "category", "contentRating", "type");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(qb);
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(11000);

        searchRequest.source(searchSourceBuilder);


        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);

        client.close();

        return response.getHits();
    }


    public ResponseVO tranforms(SearchHits searchHits){

        List<AppVO> appVOS = new ArrayList<>();
        searchHits.forEach(hit -> {

            AppVO appVO = new AppVO();
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            String value;
            Integer number;
            Double numberDouble;
            for (Map.Entry<String, Object> entry: sourceAsMap.entrySet()) {

                switch (entry.getKey()) {
                    case "name":
                        value = String.valueOf(entry.getValue());
                        appVO.setName(value);
                        break;
                    case "rating":
                        numberDouble = Double.parseDouble(String.valueOf(entry.getValue()));
                        appVO.setRating(numberDouble);
                        break;
                    case "category":
                        value = String.valueOf(entry.getValue());

                        Category category = categoryService.findByName(value);
                        appVO.setCategory(new CategoryVO(category.getId(), category.getName()));
                        break;
                    case "reviewsQty":
                        value = String.valueOf(entry.getValue());

                        appVO.setReviewsQty(Integer.parseInt(value));
                        break;
                    case "size":
                        value = String.valueOf(entry.getValue());

                        appVO.setSize(value);
                        break;
                    case "installsQty":
                        value = String.valueOf(entry.getValue());

                        appVO.setInstallsQty(value);
                        break;
                    case "type":
                        value = String.valueOf(entry.getValue());

                        Type type = typeService.findByName(value);

                        appVO.setType(new TypeVO(type.getId(), type.getName()));
                        break;
                    case "price":
                        value = String.valueOf(entry.getValue());

                        appVO.setPrice(value);
                        break;
                    case "contentRating":
                        value = String.valueOf(entry.getValue());

                        appVO.setContentRating(value);
                        break;
                    case "genry":
                        value = String.valueOf(entry.getValue());
                        List<GenryVO> genryVOS = new ArrayList<>();
                        String[] split = value.split(";");
                        for (String s : split) {
                            if (!s.trim().isEmpty()) {
                                Genry genry = genryService.findByName(s);
                                genryVOS.add(new GenryVO(genry.getId(), genry.getName()));
                            }
                        }

                        appVO.setGenry(genryVOS);
                        break;
                    case "lastUpdate":
                        value = String.valueOf(entry.getValue());

                        appVO.setLastUpdate(value);

                        break;
                    case "version":
                        value = String.valueOf(entry.getValue());

                        appVO.setVersion(value);

                        break;
                    case "androidVersion":
                        value = String.valueOf(entry.getValue());

                        AndroidVersion androidVersion = androidVersionService.findByName(value);
                        appVO.setAndroidVersion(new AndroidVersionVO(androidVersion.getId(), androidVersion.getName()));

                        break;
                }
            }
            appVOS.add(appVO);
        });


    return new ResponseVO(appVOS, searchHits.totalHits);
    }
}
