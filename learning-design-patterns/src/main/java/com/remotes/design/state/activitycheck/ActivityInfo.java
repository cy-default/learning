package com.remotes.design.state.activitycheck;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/11/24
 */
@Data
public class ActivityInfo {
    /**
     * 活动ID
     */
    private String activityId;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 活动状态
     */
    private Enum<Status> status;

    /**
     * 开始时间
     */
    private LocalDateTime beginTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;
}
