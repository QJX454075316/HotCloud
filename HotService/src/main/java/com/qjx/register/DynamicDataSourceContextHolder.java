package com.qjx.register;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.ArrayList;

/**
 * @author qjx
 */
public class DynamicDataSourceContextHolder {


    private static Logger logger = LoggerFactory.getLogger(DynamicDataSourceContextHolder.class);


    public static List<String> dataSourceIds = new ArrayList<>();

    private static final ThreadLocal<String> HOLDER = new ThreadLocal<>();

    public static String getDataSourceRouterKey(){
        return HOLDER.get();
    }

    public static void setDataSourceRouterKey(String dataSourceRouterKey){
        logger.info("切换至{}数据源", dataSourceRouterKey);
        HOLDER.set(dataSourceRouterKey);
    }


    /**
     * 移除数据源
     */
    public static void removeDataSourceRouterKey(){
        HOLDER.remove();
    }


    /**
     * 判断DataSource 是否存在
     * @param datasourceId
     * @return
     */
    public static boolean containsDataSource(String datasourceId){
        return dataSourceIds.contains(datasourceId);
    }
}
