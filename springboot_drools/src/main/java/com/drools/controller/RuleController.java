package com.drools.controller;


import com.drools.service.ReloadDroolsRules;
import com.drools.service.RuleService;
import com.drools.unit.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/drools")
public class RuleController {

    @Resource
    private ReloadDroolsRules rules;

    @Autowired
    RuleService ruleService;

    @RequestMapping("/rule1")
    public String rule1(@RequestBody Map<String, Object> map) throws Exception {
        return ruleService.ruleNoMarginCheck(JsonUtils.setMap(map));
    }

    @RequestMapping("/reload")
    public String reload(String drlName) throws Exception {

        rules.reload(drlName);
        return "ok";
    }

    @RequestMapping("/updateDrlFile")
    public String updateDrlFile(MultipartFile file) throws Exception {
        //更新drl后，再调用reload方法重载。即可热部署
        return "ok";
    }
}
