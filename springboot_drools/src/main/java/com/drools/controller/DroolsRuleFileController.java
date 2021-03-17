package com.drools.controller;

import com.alibaba.fastjson.JSON;
import com.drools.pojo.UndwrtNoCarResultDto;
import com.drools.unit.KieUtils;
import com.drools.unit.RuleHelpUtils;
import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.Map;

@RestController
@RequestMapping("file")
public class DroolsRuleFileController {

    @RequestMapping("/xls")
    public String readRuleFileByXls(@RequestBody Map<String, Object> map) throws Exception {
        KieSession kieSession = KieUtils.getKieSessionFromXLS("E:\\PROJECT\\drools\\springboot_drools\\nocar-rule.xls");
        kieSession.setGlobal("help",new RuleHelpUtils());
        kieSession.getAgenda().getAgendaGroup("sign").setFocus();
        kieSession.insert(map);

        UndwrtNoCarResultDto resultDto = new UndwrtNoCarResultDto();
        kieSession.setGlobal("resultDto",resultDto);
        int ruleFiredCount = kieSession.fireAllRules();
        System.out.println("触发了" + ruleFiredCount + "条规则");
        System.out.println(JSON.toJSONString(resultDto));
        return JSON.toJSONString(resultDto);
    }

    @RequestMapping("/drl")
    public String readRuleFileByDrl(@RequestBody Map<String, Object> map) throws Exception {
       // KieSession kieSession = KieUtils.getKieSessionFromXLS("E:\\PROJECT\\drools\\springboot_drools\\nomargin-role-one.xls");
        KieSession kieSession = KieUtils.getKieSessionFormDrl("E:\\PROJECT\\drools\\springboot_drools\\nocar-rule.drl");
        kieSession.setGlobal("help",new RuleHelpUtils());
        kieSession.getAgenda().getAgendaGroup("sign").setFocus();
        kieSession.insert(map);

        //  List<String> listRules = new ArrayList<>();
        //kieSession.setGlobal("listRules", listRules);
        UndwrtNoCarResultDto resultDto = new UndwrtNoCarResultDto();
        kieSession.setGlobal("resultDto",resultDto);
        int ruleFiredCount = kieSession.fireAllRules();
        System.out.println("触发了" + ruleFiredCount + "条规则");
        System.out.println(JSON.toJSONString(resultDto));
        return "OK";
    }
}
