
DELETE goods_search_v1

GET goods_search_v1


GET goods_search_v1



POST /_aliases
{
    "actions": [
        { "add":    { "index": "goods_search_v1", "alias": "goods_search_alias" }}
    ]
}



PUT goods_search_v1
{
  "settings": {
    "index": {
      "number_of_shards": "2",
      "number_of_replicas": "1"
    }
  },
  "mappings": {
    "dynamic": "false",
    "properties": {
      "id": {
        "type": "long",
        "store": true
      },
      "all": {
        "type": "text",
        "store": true,
        "analyzer": "hanlp"
      },
      "spuTitle": {
        "type": "text",
        "store": true,
        "analyzer": "hanlp"
      },
      "goBrandId": {
        "type": "long",
        "store": true
      },
      "goCategoryIdOne": {
        "type": "long",
        "store": true
      },
      "goCategoryIdTwo": {
        "type": "long",
        "store": true
      },
      "goCategoryIdThree": {
        "type": "long",
        "store": true
      },
      "createTime": {
        "type": "date",
        "format": "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis"
      },
      "priceList": {
        "type": "integer",
        "store": true
      },
      "spec": {
        "type": "nested",
        "properties": {
          "specName": {
            "type": "keyword",
            "store": true
          },
          "specValue": {
            "type": "keyword",
            "store": true
          }
        }
      }
    }
  }
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
      ]
    }
  }
}






