package com.tenet.goods.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Madison
 * @since 2021/2/24
 */
@Configuration
@MapperScan("com.tenet.goods.mapper")
public class MybatisPlusConfig {
}
