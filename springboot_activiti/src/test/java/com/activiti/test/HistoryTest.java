package com.activiti.test;


import org.activiti.engine.HistoryService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HistoryTest {

    @Autowired
    private HistoryService historyService;


    /**
     * 查询流程 历史信息
     */
    @Test
    public void findProcessHistoy(){
        List<HistoricProcessInstance> list1 = historyService.createHistoricProcessInstanceQuery().processInstanceBusinessKey("businessKey").list();

        // 历史相关的Service
        String processDefinitionId = list1.get(0).getProcessDefinitionId();
        List<HistoricActivityInstance> list = historyService
                .createHistoricActivityInstanceQuery()
                .processDefinitionId(processDefinitionId)
                .orderByHistoricActivityInstanceStartTime()
                .asc()
                .list();
    }
}
