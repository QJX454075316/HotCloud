package com.qjx.hot.service.impl;

import com.qjx.hot.dao.HotSearchMapper;
import com.qjx.hot.entrty.SearchEntrty;
import com.qjx.hot.service.HotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotServiceImpl implements HotService {

    @Autowired
    private HotSearchMapper hotSearchMapper;

    @Override
    public List<SearchEntrty> getAllhot() {
        return hotSearchMapper.selectAllSearch();
    }

    @Override
    public SearchEntrty getHotById(long id) {
        return hotSearchMapper.selectHotById(id);
    }
}
