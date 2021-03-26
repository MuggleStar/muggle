


POST /_aliases
{
    "actions": [
        { "add":    { "index": "goods_search_v1", "alias": "goods_search_alias" }}
    ]
}


GET goods_search/_search
{
  "query": {
    "bool": {
      "filter": [
        {
          "nested": {
            "path": "genericSpec",
            "query": {
              "bool": {
                "must": [
                  {
                    "bool": {
                      "must": [
                        {
                          "term": {
                            "genericSpec.key": "1"
                          }
                        },
                        {
                          "term": {
                            "genericSpec.value": "华为（HUAWEI）"
                          }
                        }
                      ]
                    }
                  }
                ]
              }
            }
          }
        },
        {
          "nested": {
            "path": "specialSpec",
            "query": {
              "bool": {
                "must": [
                  {
                    "bool": {
                      "must": [
                        {
                          "term": {
                            "specialSpec.key": "4"
                          }
                        }
                      ],
                      "should": [
                        {
                          "term": {
                            "specialSpec.value": "幻夜黑"
                          }
                        },
                        {
                          "term": {
                            "specialSpec.value": "极光蓝"
                          }
                        }
                      ],"minimum_should_match": 1
                    }
                  }
                ]
              }
            }
          }
        }
      ],
      "should": [
        {"term": {
          "all": "手机"
          }
        },{
          "term": {
            "goCategoryIdThree":"76"
          }
        }
      ],"minimum_should_match": 1
    }
  },
  "rescore": {
    "query": {},
    "window_size": 50
  }
}


## 2021-03-26 查询+品牌聚合+分类聚合
GET goods_search_alias/_search
{"query":{"bool":{"filter":[{"nested":{"path":"genericSpec","query":{"bool":{"must":[{"bool":{"must":[{"term":{"genericSpec.key":"7"}},{"term":{"genericSpec.value":"Android"}}]}}]}}}},{"nested":{"path":"specialSpec","query":{"bool":{"must":[{"bool":{"must":[{"term":{"specialSpec.key":"4"}},{"terms":{"specialSpec.value":["幻夜黑","极光蓝","黑色"]}}]}}]}}}}],"must":[{"match":{"all":"手机 华为 小米"}},{"term":{"goCategoryIdOne":"74"}}]}},"aggs":{"goBrandId":{"terms":{"field":"goBrandId"}},"goCategoryIdThree":{"terms":{"field":"goCategoryIdThree"}}}}

## 2021-03-26 查询+品牌聚合+分类聚合+参数聚合
GET goods_search_alias/_search
{"query":{"bool":{"filter":[{"nested":{"path":"genericSpec","query":{"bool":{"must":[{"bool":{"must":[{"term":{"genericSpec.key":"7"}},{"term":{"genericSpec.value":"Android"}}]}}]}}}},{"nested":{"path":"specialSpec","query":{"bool":{"must":[{"bool":{"must":[{"term":{"specialSpec.key":"4"}},{"terms":{"specialSpec.value":["幻夜黑","极光蓝","黑色"]}}]}}]}}}}],"must":[{"match":{"all":"手机 华为 小米"}},{"term":{"goCategoryIdOne":"74"}}]}},"aggs":{"goBrandId":{"terms":{"field":"goBrandId"}},"goCategoryIdThree":{"terms":{"field":"goCategoryIdThree"}},"genericSpec":{"nested":{"path":"genericSpec"},"aggs":{"genericSpec.key":{"terms":{"field":"genericSpec.key"},"aggs":{"genericSpec.value":{"terms":{"field":"genericSpec.value"}}}}}},"specialSpec":{"nested":{"path":"specialSpec"},"aggs":{"specialSpec.key":{"terms":{"field":"specialSpec.key"},"aggs":{"specialSpec.value":{"terms":{"field":"specialSpec.value"}}}}}}}}



