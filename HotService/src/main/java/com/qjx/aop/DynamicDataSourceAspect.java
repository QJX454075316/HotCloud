package com.qjx.aop;

import com.qjx.annotation.DataSource;
import com.qjx.register.DynamicDataSourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class DynamicDataSourceAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    @Before("@annotation(ds)")
    public void changeDataSource(JoinPoint point, DataSource ds) throws Throwable{
        String dsId  = ds.value();
        if (DynamicDataSourceContextHolder.containsDataSource(dsId)){
            LOGGER.info("Use DataSource :{} >", dsId, point.getSignature());
            //DynamicDataSourceContextHolder.setDataSourceRouterKey(dsId);
        }else {
            LOGGER.error("数据源[{}]不存在，使用默认数据源 >{}", dsId, point.getSignature());
            DynamicDataSourceContextHolder.setDataSourceRouterKey(dsId);
        }
    }

    @After("@annotation(ds)")
    public void restoreDataSource(JoinPoint point,DataSource ds){
        LOGGER.debug("Revert DataSource : " + ds.value() + " > " + point.getSignature());
        DynamicDataSourceContextHolder.removeDataSourceRouterKey();
    }
}
