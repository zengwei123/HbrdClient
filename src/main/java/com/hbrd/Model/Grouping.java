package com.hbrd.Model;

import com.google.gson.annotations.Expose;

public class Grouping{
    @Expose(serialize = true)
    private int GroupingId;
    @Expose(serialize = false)
    private String UserId;
    @Expose(serialize = true)
    private String GroupingName;

    public String getGroupingName() {
        return GroupingName;
    }
    public void setGroupingName(String groupingName) {
        GroupingName = groupingName;
    }

    public int getGroupingId() {
        return GroupingId;
    }

    public void setGroupingId(int groupingId) {
        GroupingId = groupingId;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }
}
