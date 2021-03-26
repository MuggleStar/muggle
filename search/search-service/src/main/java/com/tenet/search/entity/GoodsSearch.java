package com.tenet.search.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Madison
 * @since 2021/3/12
 */
@Data
@Document(indexName = "goods_search_alias")
public class GoodsSearch {

    @Id
    private Long id;
    /**
     * 组合字段，用户搜索
     */
    private String all;
    /**
     * 标题
     */
    private String spuTitle;
    /**
     * 品牌id
     */
    private Long goBrandId;
    /**
     * 1级类目id
     */
    private Long goCategoryIdOne;

    /**
     * 2级类目id
     */
    private Long goCategoryIdTwo;

    /**
     * 3级类目id
     */
    private Long goCategoryIdThree;
    /**
     * 添加时间
     */
    private LocalDateTime createTime;
    /**
     * 价格
     */
    private List<Long> priceList;
    /**
     * 属性参数
     */
    private List<GenericSpec> genericSpec;
    /**
     * 特色属性参数
     */
    private List<SpecialSpec> specialSpec;

    private class GenericSpec {
        String key;
        String value;
    }

    private class SpecialSpec {
        String key;
        List<String> value;
    }

    public void setGenericSpec(Map<String, String> map) {
        if (map == null) {
            return;
        }
        List<GenericSpec> genericSpecList = new ArrayList<>();
        map.forEach((k,v)->{
            GenericSpec genericSpec = new GenericSpec();
            genericSpec.key = k;
            genericSpec.value = v;
            genericSpecList.add(genericSpec);
                });

        this.genericSpec = genericSpecList;
    }

    public void setSpecialSpec(Map<String, List<String>> map) {
        if (map == null) {
            return;
        }
        List<SpecialSpec> specialSpecList = new ArrayList<>();
        map.forEach((k,v)->{
            SpecialSpec specialSpec = new SpecialSpec();
            specialSpec.key = k;
            specialSpec.value = v;
            specialSpecList.add(specialSpec);
        });
        this.specialSpec = specialSpecList;
    }

    public Map<String, String> getGenericSpec() {
        if (this.genericSpec == null) {
            return null;
        }
        Map<String, String> map = new HashMap<>();
        for (GenericSpec spec : this.genericSpec) {
            map.put(spec.key,spec.value);
        }
        return map;
    }

    public Map<String, List<String>> getSpecialSpec() {
        if (this.specialSpec == null) {
            return null;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (SpecialSpec spec : this.specialSpec) {
            map.put(spec.key,spec.value);
        }
        return map;
    }
}
