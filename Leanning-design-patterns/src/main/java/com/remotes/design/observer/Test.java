package com.remotes.design.observer;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-28
 */
public class Test {
    public static void main(String[] args) {
        Course course = new Course("JAVA设计模式");
        Teacher teacher1 = new Teacher("老师001");
        Teacher teacher2 = new Teacher("老师002");
        course.addObserver(teacher1);
        course.addObserver(teacher2);

        Question question = new Question();
        question.setUserName("张三");
        question.setQuestionDescription("什么是策略模式");
        course.addQuestion(question);

    }
}
