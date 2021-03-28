


POST /_aliases
{
    "actions": [
        { "add":    { "index": "goods_search_v1", "alias": "goods_search_alias" }}
    ]
}



## 2021-03-26 查询+品牌聚合+分类聚合
GET goods_search_alias/_search
{"query":{"bool":{"filter":[{"nested":{"path":"genericSpec","query":{"bool":{"must":[{"bool":{"must":[{"term":{"genericSpec.key":"7"}},{"term":{"genericSpec.value":"Android"}}]}}]}}}},{"nested":{"path":"specialSpec","query":{"bool":{"must":[{"bool":{"must":[{"term":{"specialSpec.key":"4"}},{"terms":{"specialSpec.value":["幻夜黑","极光蓝","黑色"]}}]}}]}}}}],"must":[{"match":{"all":"手机 华为 小米"}},{"term":{"goCategoryIdOne":"74"}}]}},"aggs":{"goBrandId":{"terms":{"field":"goBrandId"}},"goCategoryIdThree":{"terms":{"field":"goCategoryIdThree"}}}}

## 2021-03-26 查询+品牌聚合+分类聚合+参数聚合
GET goods_search_alias/_search
{"query":{"bool":{"filter":[{"nested":{"path":"genericSpec","query":{"bool":{"must":[{"bool":{"must":[{"term":{"genericSpec.key":"7"}},{"term":{"genericSpec.value":"Android"}}]}}]}}}},{"nested":{"path":"specialSpec","query":{"bool":{"must":[{"bool":{"must":[{"term":{"specialSpec.key":"4"}},{"terms":{"specialSpec.value":["幻夜黑","极光蓝","黑色"]}}]}}]}}}}],"must":[{"match":{"all":"手机 华为 小米"}},{"term":{"goCategoryIdOne":"74"}}]}},"aggs":{"goBrandId":{"terms":{"field":"goBrandId"}},"goCategoryIdThree":{"terms":{"field":"goCategoryIdThree"}},"genericSpec":{"nested":{"path":"genericSpec"},"aggs":{"genericSpec.key":{"terms":{"field":"genericSpec.key"},"aggs":{"genericSpec.value":{"terms":{"field":"genericSpec.value"}}}}}},"specialSpec":{"nested":{"path":"specialSpec"},"aggs":{"specialSpec.key":{"terms":{"field":"specialSpec.key"},"aggs":{"specialSpec.value":{"terms":{"field":"specialSpec.value"}}}}}}}}

## 2021-03-26 查询+品牌聚合+分类聚合+参数聚合+排序+min_score
GET goods_search_alias/_search
{"min_score":3,"query":{"bool":{"filter":[{"nested":{"path":"genericSpec","query":{"bool":{"must":[{"bool":{"must":[{"term":{"genericSpec.key":"7"}},{"term":{"genericSpec.value":"Android"}}]}}]}}}},{"nested":{"path":"specialSpec","query":{"bool":{"must":[{"bool":{"must":[{"term":{"specialSpec.key":"4"}},{"terms":{"specialSpec.value":["幻夜黑","极光蓝","黑色"]}}]}}]}}}}],"must":[{"match":{"all":"手机华为小米"}},{"term":{"goCategoryIdOne":"74"}}]}},"aggs":{"goBrandId":{"terms":{"field":"goBrandId"}},"goCategoryIdThree":{"terms":{"field":"goCategoryIdThree"}},"genericSpec":{"nested":{"path":"genericSpec"},"aggs":{"genericSpec.key":{"terms":{"field":"genericSpec.key"},"aggs":{"genericSpec.value":{"terms":{"field":"genericSpec.value"}}}}}},"specialSpec":{"nested":{"path":"specialSpec"},"aggs":{"specialSpec.key":{"terms":{"field":"specialSpec.key"},"aggs":{"specialSpec.value":{"terms":{"field":"specialSpec.value"}}}}}}},"sort":[{"priceList":{"order":"desc"}}]}


## 2021-03-26 查询+品牌聚合+分类聚合+参数聚合+rescore (用了rescore 就不能用 sort 慎用)
GET goods_search_alias/_search
{"query":{"bool":{"filter":[{"nested":{"path":"genericSpec","query":{"bool":{"must":[{"bool":{"must":[{"term":{"genericSpec.key":"7"}},{"term":{"genericSpec.value":"Android"}}]}}]}}}},{"nested":{"path":"specialSpec","query":{"bool":{"must":[{"bool":{"must":[{"term":{"specialSpec.key":"4"}},{"terms":{"specialSpec.value":["幻夜黑","极光蓝","黑色"]}}]}}]}}}}],"must":[{"match":{"all":"手机华为小米"}},{"term":{"goCategoryIdOne":"74"}}]}},"aggs":{"goBrandId":{"terms":{"field":"goBrandId"}},"goCategoryIdThree":{"terms":{"field":"goCategoryIdThree"}},"genericSpec":{"nested":{"path":"genericSpec"},"aggs":{"genericSpec.key":{"terms":{"field":"genericSpec.key"},"aggs":{"genericSpec.value":{"terms":{"field":"genericSpec.value"}}}}}},"specialSpec":{"nested":{"path":"specialSpec"},"aggs":{"specialSpec.key":{"terms":{"field":"specialSpec.key"},"aggs":{"specialSpec.value":{"terms":{"field":"specialSpec.value"}}}}}}},"rescore":{"window_size":1000,"query":{"score_mode":"multiply","rescore_query":{"function_score":{"script_score":{"script":{"source":"1/(Math.log10(doc.priceList.value+2))"}}}}}}}


