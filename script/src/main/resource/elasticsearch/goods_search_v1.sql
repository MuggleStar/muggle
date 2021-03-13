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
      "genericSpec": {
        "type": "nested",
        "properties": {
          "key": {
            "type": "keyword",
            "store": true
          },
          "value": {
            "type": "keyword",
            "store": true
          }
        }
      },
      "specialSpec": {
        "type": "nested",
        "properties": {
          "key": {
            "type": "keyword",
            "store": true
          },
          "value": {
            "type": "keyword",
            "store": true
          }
        }
      }
    }
  }
}
