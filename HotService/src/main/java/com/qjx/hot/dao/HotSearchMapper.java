package com.qjx.hot.dao;

import com.qjx.hot.entrty.SearchEntrty;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HotSearchMapper {

    List<SearchEntrty> selectAllSearch();

    SearchEntrty selectHotById(long id);
}
