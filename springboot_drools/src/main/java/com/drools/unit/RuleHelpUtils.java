package com.drools.unit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.drools.pojo.MapItem;
import com.drools.pojo.UndwrtNoCarResultDto;
import org.springframework.util.StringUtils;

public class RuleHelpUtils {

    public String executeStrByIndexOf(String str){
        System.out.println(str+":" +"该字符串已经被处理");
        // 处理逻辑..
        return "1";
    }

    public String executeMapItemArray(MapItem mapItem){
        JSONArray array = mapItem.getArray();
        for (Object obj:array) {
            JSONObject jsonObject = (JSONObject)JSON.toJSON(obj);
            System.out.println(jsonObject.toString());
            // 处理逻辑..
        }
        return "1";
    }


}
