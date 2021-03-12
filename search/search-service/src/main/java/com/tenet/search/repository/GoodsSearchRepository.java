package com.tenet.search.repository;

import com.tenet.search.entity.GoodsSearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author Madison
 * @since 2021/3/12
 */
public interface  GoodsSearchRepository extends ElasticsearchRepository<GoodsSearch, Long> {
}
