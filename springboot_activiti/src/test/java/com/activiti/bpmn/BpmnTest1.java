package com.activiti.bpmn;


import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BpmnTest1 {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;


    // 启动一个流程
    @Test
    public void startProcess(){

        Map<String, Object> variables =new HashMap<>();
        variables.put("num", 1);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess_1", "11",variables);
        System.out.println(processInstance.getProcessDefinitionId());
    }

    // 根据businesskey 查询任务
    @Test
    public void queryTask(){

        TaskQuery query = taskService.createTaskQuery().processInstanceBusinessKey("11");
        List<Task> list = query.list();
        System.out.println(list);
    }

    // 根据任务id 完成任务
    @Test
    public void completeTask(){

        taskService.complete("449e2720-9dc7-11eb-8d3e-1e1bb5d41e35");
    }

    @Test
    public void test(){
        Map<String, Object> variables =new HashMap<>();
        variables.put("num", 1);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess_1", "11",variables);
        System.err.println("实例过程已经创建 ID：");
        System.out.println(processInstance.getProcessDefinitionId());

        List<Task> list = taskService.createTaskQuery().processDefinitionId(processInstance.getProcessDefinitionId()).list();
        System.err.println("当前的任务 ID：");
        System.out.println(list);

        System.err.println("完成的任务 ID：");
        list.forEach(n->{
            System.out.println(n.getId());
            //taskService.complete(n.getId());
        });
    }

}
