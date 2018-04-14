package com.example.hario.hbhclassroom.Drawer;

public class RecyclerInfo {
    private String name;
    private int percentage;
private int thumbnail;

private String subject;
private String time;
private String teacherName;
private String room;
    public RecyclerInfo(String name, int Percentage, int thumb) {
        this.name = name;
        this.percentage = Percentage;
        this.thumbnail = thumb;
    }

    public RecyclerInfo(String Subject, String Time, String TeacherName, String Room) {
        this.time = Time;
        this.teacherName = TeacherName;
        this.subject = Subject;
      this.room = Room;
    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
