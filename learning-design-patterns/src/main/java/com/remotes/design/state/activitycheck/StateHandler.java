package com.remotes.design.state.activitycheck;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/11/24
 */
public class StateHandler {

    private Map<Enum<Status>, State> stateMap = new ConcurrentHashMap<Enum<Status>, State>();

    public StateHandler() {
        // 待审核
        stateMap.put(Status.Check, new CheckState());
        // 已关闭
        // stateMap.put(Status.Close, new CloseState());
        // 活动中
        // stateMap.put(Status.Doing, new DoingState());
        // 编辑中
        stateMap.put(Status.Editing, new EditingState());
        // 已开启
        // stateMap.put(Status.Open, new OpenState());
        // 审核通过
        // stateMap.put(Status.Pass, new PassState());
        // 审核拒绝
        // stateMap.put(Status.Refuse, new RefuseState());
    }

    public Result arraignment(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).arraignment(activityId, currentStatus);
    }

    public Result checkPass(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).checkPass(activityId, currentStatus);
    }

    public Result checkRefuse(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).checkRefuse(activityId, currentStatus);
    }

    public Result checkRevoke(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).checkRevoke(activityId, currentStatus);
    }

    public Result close(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).close(activityId, currentStatus);
    }

    public Result open(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).open(activityId, currentStatus);
    }

    public Result doing(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).doing(activityId, currentStatus);
    }
}
