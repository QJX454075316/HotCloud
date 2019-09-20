package com.qjx.hot.service;

import com.qjx.hot.entrty.SearchEntrty;

import java.util.List;

public interface HotService {

    public List<SearchEntrty> getAllhot();


    SearchEntrty getHotById(long id);
}
