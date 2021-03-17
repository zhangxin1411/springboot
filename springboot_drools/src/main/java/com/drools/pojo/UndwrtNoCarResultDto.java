package com.drools.pojo;

import java.util.ArrayList;
import java.util.List;

public class UndwrtNoCarResultDto {
    // 核保级别
    private String undwrtLevel;
    // 核保通过标志
    private String undwrtFlag;
    // 规则库名称
    private String pathName;
    //规则违反信息列表
    private List<RuleInfoDto> quotationRuleList = new ArrayList<RuleInfoDto>();


    /**
     * 规则违反信息列表
     */
    public void addQuotationRule(String ruleId, String description, String ruleSetName) {
        quotationRuleList.add(new RuleInfoDto(ruleId, description, "xxx", ruleSetName));
    }


    public String getUndwrtLevel() {
        return undwrtLevel;
    }

    public void setUndwrtLevel(String undwrtLevel) {
        this.undwrtLevel = undwrtLevel;
    }

    public String getUndwrtFlag() {
        return undwrtFlag;
    }

    public void setUndwrtFlag(String undwrtFlag) {
        this.undwrtFlag = undwrtFlag;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    public List<RuleInfoDto> getQuotationRuleList() {
        return quotationRuleList;
    }

    public void setQuotationRuleList(List<RuleInfoDto> quotationRuleList) {
        this.quotationRuleList = quotationRuleList;
    }
}
