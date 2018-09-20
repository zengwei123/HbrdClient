package com.hbrd.Service.impl;

import com.hbrd.Dao.GroupingDao;
import com.hbrd.Model.Grouping;
import com.hbrd.Service.GroupingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupingImpl implements GroupingService {
    @Autowired
    private GroupingDao groupingDao;
    @Override
    public List<Grouping> GroupingList(String UserId) {
        return groupingDao.GroupingList(UserId);
    }
}
