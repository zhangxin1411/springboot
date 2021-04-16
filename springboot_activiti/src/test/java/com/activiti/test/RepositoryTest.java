package com.activiti.test;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;

public class RepositoryTest {


    @Autowired
    private RepositoryService repositoryService;

    /**
     * 部署流程定义
     */
    public void saveNewDeploy() {
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("resource path") // 添加bpmn资源
                .name("name")
                .deploy();
//        4、输出部署信息
        System.out.println("流程部署id：" + deployment.getId());
        System.out.println("流程部署名称：" + deployment.getName());
    }
}
