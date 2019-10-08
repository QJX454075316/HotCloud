package com.qjx.hot.service;

import com.qjx.hot.entrty.SearchEntrty;

import java.util.List;

/**
 * @author qjx
 */
public interface HotService {
    /**
     *  查询所有数据
     * @return 返回所有的Search
     */
    List<SearchEntrty> getAllHot();

    /**
     *  根据id查询数据
     * @param id Search 的 id
     * @return 返回对应id的Search
     */
    SearchEntrty getHotById(long id);
}
