package com.remotes.design.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 老师（观察者）， 观察课程，获取课程上的问题
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-28
 */
public class Teacher implements Observer {

    private String userName;

    public Teacher(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(Observable o, Object arg) {
            Course course = (Course)o;
            Question question = (Question) arg;
        System.out.println(userName+"在课程+"+course.getCourseName()+"上，获得一个问题："+question.getQuestionDescription());
    }
}
