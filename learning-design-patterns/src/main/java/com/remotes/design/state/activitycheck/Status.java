package com.remotes.design.state.activitycheck;

/**
 * 营销活动状态
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/11/24
 */
public enum Status {
    // 1创建编辑、2待审核、3审核通过(任务扫描成活动中)、4审核拒绝(可以撤审到编辑状态)、5活动中、6活动关闭、7活动开启(任务扫描成活动中)
    Editing, Check, Pass, Refuse, Doing, Close, Open
}
