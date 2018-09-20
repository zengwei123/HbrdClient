package com.hbrd.Dao;

import com.hbrd.Model.Grouping;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GroupingDao {
    List<Grouping> GroupingList(String UserId);
}
