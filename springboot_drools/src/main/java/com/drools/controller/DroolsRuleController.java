package com.drools.controller;

import com.alibaba.fastjson.JSON;
import com.drools.pojo.Student;
import com.drools.pojo.UndwrtNoCarResultDto;
import com.drools.unit.JsonUtils;
import com.drools.unit.KieUtils;
import com.drools.unit.RuleHelpUtils;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("rule")
public class DroolsRuleController {

    //Map 入参类型处理
    @RequestMapping("/rule2")
    public String ruleByResource(@RequestBody Map<String,Object> map){
        KieSession kieSession = KieUtils.getKieSession();
        kieSession.insert(JsonUtils.setMap(map));

        ArrayList<UndwrtNoCarResultDto> undwrtNoCarResultDtos = new ArrayList<>();
        kieSession.setGlobal("help",new RuleHelpUtils());
        kieSession.setGlobal("resultList",undwrtNoCarResultDtos);
        UndwrtNoCarResultDto resultDto = new UndwrtNoCarResultDto();
        kieSession.setGlobal("resultDto",resultDto);
        int count = kieSession.fireAllRules();
        System.out.println("执行了"+ count + "条规则！");
        return JSON.toJSONString(undwrtNoCarResultDtos);
    }

    @RequestMapping("/pojo")
    public String ruleByResourceP(){

        Student student = new Student();
        student.setAge(23);
        student.setName("张三");
        KieSession kieSession = KieUtils.getKieSession();
        kieSession.insert(student);
        UndwrtNoCarResultDto resultDto = new UndwrtNoCarResultDto();
        kieSession.setGlobal("resultDto",resultDto);
        kieSession.setGlobal("help",new RuleHelpUtils());
        int count = kieSession.fireAllRules();
        System.out.println("执行了"+ count + "条规则！");
        return "ok";
    }
}
