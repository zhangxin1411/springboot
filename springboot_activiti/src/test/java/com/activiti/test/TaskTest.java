package com.activiti.test;


import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskTest {

    @Autowired
    private TaskService taskService;

    // 根据 businesskey 查询任务
    @Test
    public void queryTaskByBusinesskey(){
        TaskQuery query = taskService.createTaskQuery().processInstanceBusinessKey("businesskey");
        List<Task> list = query.list();
        System.out.println(list);
    }

    // 根据 流程ID 查询任务 Task 方法还可以加入 管理人信息等内容 .taskAssignee(在bpmn中配置的管理人信息)
    @Test
    public void queryTaskBy(){
        TaskQuery query = taskService.createTaskQuery().processDefinitionId("processId");
        List<Task> list = query.list();
        System.out.println(list);
    }


    // 根据 TaskId 完成任务
    @Test
    public void completeTask(){

        List<Task> list= taskService.createTaskQuery().processDefinitionId("ss").list();
        // 通过 Task 的id 完成任务
        list.forEach(n->{
            taskService.complete(n.getId());
        });
        System.out.println(list);
    }

    // 根据 TaskId 给任务增加描述信息
    @Test
    public void addCommentTask(){

        /*
        参数说明：
         参数一：任务Id
         参数二：流程实例Id
         参数三：描述信息的内容
        */
        taskService.addComment("taskId","processInstanceId","内容");
    }

}
