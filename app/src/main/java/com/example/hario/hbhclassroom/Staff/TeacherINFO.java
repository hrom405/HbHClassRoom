package com.example.hario.hbhclassroom.Staff;

public class TeacherINFO {
    private String TCname,TCdesignation,TCcontact,TCgender,TCimage,TCdoj;
    private int TCid,TCage;

    public String getTCname() {
        return TCname;
    }

    public String getTCdesignation() {
        return TCdesignation;
    }

    public String getTCgender() {
        return TCgender;
    }

    public String getTCimage() {
        return TCimage;
    }

    public String  getTCcontact() {
        return TCcontact;
    }

    public int getTCid() {
        return TCid;
    }

    public int getTCage() {
        return TCage;
    }

    public String getTCdoj() {
        return TCdoj;
    }

    public void setTCname(String TCname) {
        this.TCname = TCname;
    }

    public void setTCdesignation(String TCdesignation) {
        this.TCdesignation = TCdesignation;
    }

    public void setTCgender(String TCgender) {
        this.TCgender = TCgender;
    }

    public void setTCimage(String TCimage) {
        this.TCimage = TCimage;
    }

    public void setTCcontact(String TCcontact) {
        this.TCcontact = TCcontact;
    }

    public void setTCid(int TCid) {
        this.TCid = TCid;
    }

    public void setTCage(int TCage) {
        this.TCage = TCage;
    }

    public void setTCdoj(String  TCdoj) {
        this.TCdoj = TCdoj;
    }

    public TeacherINFO(String TCname, String TCdesignation, String TCgender, String TCimage, String  TCcontact, int TCid, int TCage, String TCdoj) {
        this.TCname = TCname;
        this.TCdesignation = TCdesignation;
        this.TCgender = TCgender;
        this.TCimage = TCimage;
        this.TCcontact = TCcontact;
        this.TCid = TCid;
        this.TCage = TCage;
        this.TCdoj = TCdoj;
    }
}
