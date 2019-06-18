package com.ytt.shopping.web.util;

import java.util.function.Predicate;

public enum WorkStatusEnum{
    CHILD ("幼儿",1,"没有上学，或者上幼儿园", age -> 0<=age&&age<=7),
    PUPIL ("小学生", 1, "正在上小学", age -> 7<age&&age<=13),
    MIDDLE_SCHOOL_STUDENT ("中学生", 1, "正在上中学", age -> 13<age&&age<=19),
    UNIVERSITY_STUDENT ("大学生", 1, "正在上大学", age -> 19<age&&age<=23),
    WORKER ("工作者", 1, "已经工作了",age -> 23<age),
    NULL(),
    ;

    private String work;

    private int status;

    private String message;

    private Predicate<Integer> ageCondition;

    WorkStatusEnum(){};

    WorkStatusEnum(String work, int status, String message, Predicate<Integer> ageCondition) {
        this.work = work;
        this.status = status;
        this.message = message;
        this.ageCondition = ageCondition;
    }

    public String getWork() {
        return work;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Predicate<Integer> getAgeCondition() {
        return ageCondition;
    }
}
