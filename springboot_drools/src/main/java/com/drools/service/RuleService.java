package com.drools.service;

import com.alibaba.fastjson.JSON;
import com.drools.pojo.MapItem;
import com.drools.unit.KieSessionUtils;
import com.drools.unit.RuleHelpUtils;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RuleService {

    @Resource
    private KieSession kieSession;

    public String ruleNoMarginCheck(Map<String, MapItem> map) throws Exception {
        List<String> listRules = new ArrayList<>();
        kieSession.getAgenda().getAgendaGroup("sign").setFocus();
        kieSession.setGlobal("listRules", listRules);
        kieSession.setGlobal("help",new RuleHelpUtils());
        kieSession.insert(map);
        kieSession.fireAllRules();

        System.out.println(listRules.toString());
        return "OK";
    }

    public String ruleNoMarginCheckByXls(Map<String, MapItem> map) throws Exception {
        KieSession kieSession = KieSessionUtils.getKieSessionFromXLS("E:\\PROJECT\\drools\\nomargin-role-one.xls");
        // KieSession session = KieSessionUtils.getKieSessionFormDrl("E:\\PROJECT\\drools\\nomargin-role-one.drl");
        kieSession.setGlobal("help",new RuleHelpUtils());
        kieSession.getAgenda().getAgendaGroup("sign").setFocus();
        kieSession.insert(map);
        List<String> listRules = new ArrayList<>();
        kieSession.setGlobal("listRules", listRules);
        kieSession.fireAllRules();

        System.out.println(listRules.toString());
        return "OK";
    }
}
