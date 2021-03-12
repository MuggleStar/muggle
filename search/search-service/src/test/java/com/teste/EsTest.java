package com.teste;

import com.tenet.search.SearchApplication;
import com.tenet.search.entity.GoodsSearch;
import com.tenet.search.repository.GoodsSearchRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author Madison
 * @since 2021/3/12
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SearchApplication.class)
public class EsTest {

    @Resource
    private GoodsSearchRepository goodsSearchRepository;

    @Test
    public void testPut() {

        GoodsSearch goodsSearch = new GoodsSearch();
        goodsSearch.setId(2L);
        goodsSearch.setAll("测试 手机");

        GoodsSearch save = goodsSearchRepository.save(goodsSearch);

    }


}
