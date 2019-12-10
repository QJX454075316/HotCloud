package com.qjx.hot.dao;

import com.qjx.hot.entrty.SearchEntrty;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author qjx
 */
@Repository
@Mapper
public interface HotSearchMapper {

    /**
     * 查询所有的Search
     * @return 所有的Search
     */
    List<SearchEntrty> selectAllSearch();

    /**
     * 根据id查询Search
     * @param id search 的 id
     * @return 返回对应id的search
     */
    SearchEntrty selectHotById(long id);
}
