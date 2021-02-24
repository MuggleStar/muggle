package com.teste;

import com.tenet.goods.api.api.IBrandApi;
import com.tenet.goods.api.entity.brand.GoBrand;
import com.tenet.search.SearchApplication;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Madison
 * @since 2021/2/24
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SearchApplication.class)
public class DubboTest {


    @Reference(version = "1.0.0", group = "brandApi")
    private IBrandApi brandApi;


    @Test
    public void test2() {
        GoBrand brand = brandApi.getBrand();
        System.out.println(brand);
    }

}
