package com.tenet.common.utils;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Json工具
 *
 * @author MuggleStar
 * @date 2020/12/7 23:07
 */
public class JsonUtil {

    private static Gson gson = null;

    private JsonUtil() {
    }

    static {
        synchronized (JsonUtil.class) {
            if (gson == null) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss");
                gsonBuilder.disableHtmlEscaping();
                gsonBuilder.serializeSpecialFloatingPointValues();
                gson = gsonBuilder.create();
            }
        }
    }

    public static Gson getInstance() {
        return gson;
    }

    /**
     * 对象转json
     *
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        return gson.toJson(object);
    }

    /**
     * json转对象
     *
     * @param json
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T fromJson(String json, Class<T> cls) {
        T t = null;
        if (gson != null) {
            t = gson.fromJson(json, cls);
        }
        return t;
    }

    /**
     * json转List<T>
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> json2List(String json, Class<T> clazz) {
        List<T> list = null;
        if (gson != null) {

            // 旧版本 JsonArray jsonArray = new JsonParser().parse(json).getAsJsonArray();
            JsonArray jsonArray = JsonParser.parseString(json).getAsJsonArray();
            for (JsonElement jsonElement : jsonArray) {
                if (list == null) {
                    list = new ArrayList<T>();
                }
                list.add(gson.fromJson(jsonElement, clazz));
            }
        }
        return list;
    }

    /**
     * json转 List<Map<String, T>>
     *
     * @param json
     * @param <T>
     * @return
     */
    public static <T> List<Map<String, T>> json2MapList(String json, Class<T> clazz) {
        List<Map<String, T>> list = null;
        if (gson != null) {
            list = gson.fromJson(json, new TypeToken<List<Map<String, T>>>() {
            }.getType());
        }
        return list;
    }

    /**
     * json转 Map<String, T>
     *
     * @param json
     * @param <T>
     * @return
     */
    public static <T> Map<String, T> json2Map(String json, Class<T> clazz) {
        Map<String, T> map = null;
        if (gson != null) {
            map = gson.fromJson(json, new TypeToken<Map<String, T>>() {
            }.getType());
        }
        return map;
    }
}
