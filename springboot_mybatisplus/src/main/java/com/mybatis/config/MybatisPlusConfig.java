package com.mybatis.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.xin.mapper")
@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {
    //乐观锁组件
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){return new OptimisticLockerInterceptor();}

    //分页组件
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

    //逻辑删除组件
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

    @Bean
    @Profile({"dev","test"})// 设置 dev test 环境开启，保证我们的效率
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new
                PerformanceInterceptor();
        performanceInterceptor.setMaxTime(100000); // ms设置sql执行的最大时间，如果超过了则不执行

        performanceInterceptor.setFormat(true); // 是否格式化代码
        return performanceInterceptor;
    }

}
