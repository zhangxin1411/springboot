package com.drools.unit;

import com.alibaba.fastjson.JSON;
import com.drools.pojo.MapItem;

import java.util.HashMap;
import java.util.Map;

public class JsonUtils {
    public static Map<String, MapItem> setMap(Map<String, Object> map) {
        Map<String, MapItem> mapResult = new HashMap<>();
        for (String str : map.keySet()) {
            if (map.get(str).toString().contains("[")) {
                String[] split = JSON.toJSONString(map.get(str)).split(",");
                if (split!=null&&split.length!=0) {
                    MapItem item = new MapItem();
                    item.setJsonArray(JSON.parseArray(JSON.toJSONString(map.get(str))));
                    mapResult.put(str, item);
                }
            } else {
                MapItem item = new MapItem();
                item.setJsonObject(JSON.parseObject(JSON.toJSONString(map.get(str))));
                mapResult.put(str, item);
            }
        }
        return mapResult;
    }
}
