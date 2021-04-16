package com.activiti.test;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProcessTest {


    @Autowired
    private RuntimeService runtimeService;

    // 启动一个流程
    @Test
    public void startProcess(){

      /*
       variables 参数说明：
         1. Map<String, String> 的形式，在 bpmn 中可以直接通过 key 使用属性，例如  variables.put("num", 1); -> ${num > 1}
         2. Map<String, 对象>   的形式，在bpmn 中可以通过 key.属性使用， 例如  variables.put("user", user); -> ${user.num > 1}
      */
        Map<String, Object> variables =new HashMap<>();
        variables.put("num", 1);
        // 方法名：startProcessInstanceByKey
        // 参数一：流程ID
        // 参数二：通常为业务系统的数据，主要用于业务和流程的绑定，可以认为是任务的ID
        // 参数三：bpmn中使用的变量，用于分支条件
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess_1", "业务系统ID（自定义）",variables);
        System.out.println(processInstance.getProcessDefinitionId());
    }

    @Test
    public void startProcessNoVariables(){
        // 如果没有变量，可以不增加标量的Map 直接启动一个流程
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess_1", "业务系统ID（自定义）");
        System.out.println(processInstance.getProcessDefinitionId());
    }

}
