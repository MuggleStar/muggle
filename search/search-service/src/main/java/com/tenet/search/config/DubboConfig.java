package com.tenet.search.config;

import com.tenet.goods.api.api.GoBrandApi;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboConfig {


    @Reference(version = "1.0.0", group = "goods", check = false)
    private GoBrandApi goBrandApi;


    @Bean
    public GoBrandApi goBrandApi(){
        return this.goBrandApi;
    }


}
