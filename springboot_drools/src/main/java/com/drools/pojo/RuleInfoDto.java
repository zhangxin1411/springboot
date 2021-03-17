package com.drools.pojo;

/**
 * 违反规则信息
 */
public class RuleInfoDto {

    //规则编号
    private String ruleId;
    //规则描述
    private String description;
    //规则类型
    private String ruleStatus;
    //规则文件名称
    private String ruleSetName;

    public RuleInfoDto(String ruleId, String description, String ruleStatus, String ruleSetName) {
        this.ruleId = ruleId;
        this.description = description;
        this.ruleStatus = ruleStatus;
        this.ruleSetName = ruleSetName;
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRuleStatus() {
        return ruleStatus;
    }

    public void setRuleStatus(String ruleStatus) {
        this.ruleStatus = ruleStatus;
    }

    public String getRuleSetName() {
        return ruleSetName;
    }

    public void setRuleSetName(String ruleSetName) {
        this.ruleSetName = ruleSetName;
    }
}
