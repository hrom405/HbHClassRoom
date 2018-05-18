package com.example.hario.hbhclassroom.Staff;

import android.widget.Spinner;

public class StudentINFO {
    private String STname,STclasss,STgender,STimage,STcontact;
    private int STrollno,STsection,STsemester,STage;

    public String getSTname() {
        return STname;
    }

    public String getSTclasss() {
        return STclasss;
    }

    public String getSTgender() {
        return STgender;
    }

    public String getSTimage() {
        return STimage;
    }

    public int getSTrollno() {
        return STrollno;
    }

    public int getSTsection() {
        return STsection;
    }

    public int getSTsemester() {
        return STsemester;
    }

    public String getSTcontact() {
        return STcontact;
    }

    public int getSTage() {
        return STage;
    }

    public void setSTname(String STname) {
        this.STname = STname;
    }

    public void setSTclasss(String STclasss) {
        this.STclasss = STclasss;
    }

    public void setSTgender(String STgender) {
        this.STgender = STgender;
    }

    public void setSTimage(String STimage) {
        this.STimage = STimage;
    }

    public void setSTrollno(int STrollno) {
        this.STrollno = STrollno;
    }

    public void setSTsection(int STsection) {
        this.STsection = STsection;
    }

    public void setSTsemester(int STsemester) {
        this.STsemester = STsemester;
    }

    public void setSTcontact(String STcontact) {
        this.STcontact = STcontact;
    }

    public void setSTage(int STage) {
        this.STage = STage;
    }

    public StudentINFO(String STname, String STclasss, String STgender, String STimage, int STrollno, int STsection, int STsemester, String STcontact, int STage) {
        this.STname = STname;
        this.STclasss = STclasss;
        this.STgender = STgender;
        this.STimage = STimage;
        this.STrollno = STrollno;
        this.STsection = STsection;
        this.STsemester = STsemester;
        this.STcontact = STcontact;
        this.STage = STage;
    }
}
