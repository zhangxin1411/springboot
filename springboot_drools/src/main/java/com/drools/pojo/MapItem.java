package com.drools.pojo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class MapItem {

    private JSONObject jsonObject;

    public JSONObject getJsonObject() {
        return jsonObject;
    }
    public JSONArray jsonArray;

    public JSONArray getArray() {
        return jsonArray;
    }

    public void setJsonArray(JSONArray jsonArray) {
        this.jsonArray = jsonArray;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }
    public Object get(String str){
        return jsonObject.get(str);
    }
}
