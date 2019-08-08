package com.remotes.design.observer;

/**
 * 问题，把问题加入到课程中，触发观察者，被观察者逻辑
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-28
 */
public class Question {
    private String userName;
    private String questionDescription;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }
}
