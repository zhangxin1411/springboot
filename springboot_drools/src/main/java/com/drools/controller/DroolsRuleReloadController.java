package com.drools.controller;

import com.drools.service.ReloadDroolsRules;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("reload")
public class DroolsRuleReloadController {

    @Resource
    private ReloadDroolsRules rules;

    @RequestMapping("drl")
    public String DroolsRuleReloadDrl(String drlName) throws Exception {
        rules.reload(drlName);
        return "ok";
    }

    @RequestMapping("xls")
    public String DroolsRuleReloadXls(){
        return "";
    }
    @RequestMapping("db")
    public String DroolsRuleReloadDB(){
        return "";
    }

}
