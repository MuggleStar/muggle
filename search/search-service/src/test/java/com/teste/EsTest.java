package com.teste;

import com.tenet.common.dto.OperateResult;
import com.tenet.common.dto.PageDto;
import com.tenet.goods.api.api.GoBrandApi;
import com.tenet.goods.api.api.GoSpuApi;
import com.tenet.goods.api.dto.goods.GoSpuDto;
import com.tenet.goods.api.entity.brand.GoBrand;
import com.tenet.goods.api.query.brand.GoBrandQueryVo;
import com.tenet.goods.api.query.goods.GoSpuQueryVo;
import com.tenet.search.SearchApplication;
import com.tenet.search.entity.GoodsSearch;
import com.tenet.search.repository.GoodsSearchRepository;
import com.tenet.search.service.GoodSyncService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.nested.NestedAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品全量初始化入库
 *
 * @author Madison
 * @since 2021/3/12
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SearchApplication.class)
public class EsTest {

    @Resource
    private GoodsSearchRepository goodsSearchRepository;

    @Resource
    private RestHighLevelClient restHighLevelClient;

    @Resource
    private GoodSyncService goodSyncService;

    @Test
    public void testPut() {
        GoodsSearch goodsSearch = new GoodsSearch();
        goodsSearch.setId(2L);
        goodsSearch.setAll("测试 手机");

        Map<String,String> map = new HashMap<>();
        map.put("1","1value");
        goodsSearch.setGenericSpec(map);
        GoodsSearch save = goodsSearchRepository.save(goodsSearch);

    }

    @Test
    public void testInitGoods() {
        goodSyncService.initGoods();
    }

    @Test
    public void testSearch() {

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        searchSourceBuilder
                .minScore(3)
                .query(QueryBuilders.boolQuery()
                        .filter(QueryBuilders.nestedQuery("genericSpec",
                                QueryBuilders.boolQuery().must(
                                        QueryBuilders.boolQuery()
                                                .must(QueryBuilders.termQuery("genericSpec.key","7"))
                                                .must(QueryBuilders.termQuery("genericSpec.value","Android"))),
                                ScoreMode.None))
                        .filter(QueryBuilders.nestedQuery("specialSpec",
                                QueryBuilders.boolQuery().must(
                                        QueryBuilders.boolQuery()
                                                .must(QueryBuilders.termQuery("specialSpec.key","4"))
                                                .must(QueryBuilders.termsQuery("specialSpec.value","幻夜黑", "极光蓝", "黑色"))),
                                ScoreMode.None))
                        .must(QueryBuilders.matchQuery("all","手机华为小米"))
                        .must(QueryBuilders.termQuery("goCategoryIdOne","74")))
                .aggregation(AggregationBuilders.terms("goBrandId").field("goBrandId"))
                .aggregation(AggregationBuilders.terms("goCategoryIdThree").field("goCategoryIdThree"))
                .aggregation(AggregationBuilders.nested("genericSpec", "genericSpec")
                        .subAggregation(AggregationBuilders.terms("genericSpec.key")
                                .field("genericSpec.key")
                                .subAggregation(AggregationBuilders.terms("genericSpec.value")
                                        .field("genericSpec.value"))))
                .sort(SortBuilders.fieldSort("priceList").order(SortOrder.DESC))
                .from(1).size(10);


        SearchRequest searchRequest = new SearchRequest("goods_search_alias");

        System.out.println(searchSourceBuilder.toString());

        try {
            SearchResponse search = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            System.out.println(search);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
