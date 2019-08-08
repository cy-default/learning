package com.remotes.design.observer;

import java.util.Observable;

/**
 * 课程（被观察者），老师观察课程，看课程上是否有人提问。
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-28
 */
public class Course extends Observable {

    private String courseName;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void addQuestion(Question question){
        System.out.println(question.getUserName()+"在"+courseName+"课上提了："+question.getQuestionDescription()+"问题");
        setChanged();
        notifyObservers(question);
    }
}
