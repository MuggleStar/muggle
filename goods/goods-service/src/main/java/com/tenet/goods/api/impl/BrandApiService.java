package com.tenet.goods.api.impl;

import com.tenet.goods.api.api.IBrandApi;
import com.tenet.goods.api.entity.brand.GoBrand;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author Madison
 * @since 2021/2/24
 */
@Service(version = "1.0.0", group = "brandApi")
public class BrandApiService implements IBrandApi {

    @Override
    public GoBrand getBrand() {
        GoBrand goBrand = new GoBrand();
        goBrand.setId(1L);
        return goBrand;
    }
}
