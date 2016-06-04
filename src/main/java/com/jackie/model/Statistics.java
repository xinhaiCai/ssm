package com.jackie.model;

import java.io.Serializable;
import java.util.Date;

public class Statistics implements Serializable {
    private Integer id;

    private Date createTime;

    private Integer userCount;

    private Integer growUserCount;

    private Integer activeUserCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    public Integer getGrowUserCount() {
        return growUserCount;
    }

    public void setGrowUserCount(Integer growUserCount) {
        this.growUserCount = growUserCount;
    }

    public Integer getActiveUserCount() {
        return activeUserCount;
    }

    public void setActiveUserCount(Integer activeUserCount) {
        this.activeUserCount = activeUserCount;
    }
}