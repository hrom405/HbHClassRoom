package com.example.hario.hbhclassroom.Staff;

public class TeacherTimeTableINFO {
    private String Classs,subject1,subject2,subject3,subject4,subject5,subject6,subject7,subject8;
    private String teacherID,day,nothing;
    private String tc1,tc2,tc3,tc4,tc5,tc6,tc7,tc8;

    public String getNothing() {
        return nothing;
    }

    public void setNothing(String nothing) {
        this.nothing = nothing;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTc1() {
        return tc1;
    }

    public void setTc1(String tc1) {
        this.tc1 = tc1;
    }

    public String getTc2() {
        return tc2;
    }

    public void setTc2(String tc2) {
        this.tc2 = tc2;
    }

    public String getTc3() {
        return tc3;
    }

    public void setTc3(String tc3) {
        this.tc3 = tc3;
    }

    public String getTc4() {
        return tc4;
    }

    public void setTc4(String tc4) {
        this.tc4 = tc4;
    }

    public String getTc5() {
        return tc5;
    }

    public void setTc5(String tc5) {
        this.tc5 = tc5;
    }

    public String getTc6() {
        return tc6;
    }

    public void setTc6(String tc6) {
        this.tc6 = tc6;
    }

    public String getTc7() {
        return tc7;
    }

    public void setTc7(String tc7) {
        this.tc7 = tc7;
    }

    public String getTc8() {
        return tc8;
    }

    public void setTc8(String tc8) {
        this.tc8 = tc8;
    }

    public String getClasss() {
        return Classs;
    }

    public void setClass(String Classs) {
        this.Classs = Classs;
    }

    public String getSubject1() {
        return subject1;
    }

    public void setSubject1(String subject1) {
        this.subject1 = subject1;
    }

    public String getSubject2() {
        return subject2;
    }

    public void setSubject2(String subject2) {
        this.subject2 = subject2;
    }

    public String getSubject3() {
        return subject3;
    }

    public void setSubject3(String subject3) {
        this.subject3 = subject3;
    }

    public String getSubject4() {
        return subject4;
    }

    public void setSubject4(String subject4) {
        this.subject4 = subject4;
    }

    public String getSubject5() {
        return subject5;
    }

    public void setSubject5(String subject5) {
        this.subject5 = subject5;
    }

    public String getSubject6() {
        return subject6;
    }

    public void setSubject6(String subject6) {
        this.subject6 = subject6;
    }

    public String getSubject7() {
        return subject7;
    }

    public void setSubject7(String subject7) {
        this.subject7 = subject7;
    }

    public String getSubject8() {
        return subject8;
    }

    public void setSubject8(String subject8) {
        this.subject8 = subject8;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }
    public TeacherTimeTableINFO(){}

    public TeacherTimeTableINFO(String classs,String day, String subject1, String subject2, String subject3, String subject4, String subject5, String subject6, String subject7, String subject8) {
        this.Classs = classs;
        this.day=day;
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
        this.subject4 = subject4;
        this.subject5 = subject5;
        this.subject6 = subject6;
        this.subject7 = subject7;
        this.subject8 = subject8;
    }

    public TeacherTimeTableINFO(String Classs,String day, String subject1, String subject2, String subject3, String subject4, String subject5, String subject6, String subject7, String subject8, String teacherID) {
        this.Classs = Classs;
        this.day=day;
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
        this.subject4 = subject4;
        this.subject5 = subject5;
        this.subject6 = subject6;
        this.subject7 = subject7;
        this.subject8 = subject8;
        this.teacherID = teacherID;
    }
    public TeacherTimeTableINFO(String teacherID,String Classs,String day,String tc1, String tc2,String tc3,String tc4,String tc5,String tc6,String tc7,String tc8,String nothing){
        this.teacherID=teacherID;
        this.Classs=Classs;
        this.day=day;
        this.tc1=tc1;
        this.tc2=tc2;
        this.tc3=tc3;
        this.tc4=tc4;
        this.tc5=tc5;
        this.tc6=tc6;
        this.tc7=tc7;
        this.tc8=tc8;
        this.nothing=nothing;

    }
}
