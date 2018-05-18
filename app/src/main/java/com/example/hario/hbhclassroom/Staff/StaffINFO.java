package com.example.hario.hbhclassroom.Staff;

public class StaffINFO {
    private String staffName,staffGender,staffAadhaarID,staffContactNo,staffOccuption,staffImage;
    private int staffAge,staffID;

    public String getStaffImage() {
        return staffImage;
    }

    public void setStaffImage(String staffImage) {
        this.staffImage = staffImage;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffGender() {
        return staffGender;
    }

    public void setStaffGender(String staffGender) {
        this.staffGender = staffGender;
    }

    public String getStaffAadhaarID() {
        return staffAadhaarID;
    }

    public void setStaffAadhaarID(String staffAadhaarID) {
        this.staffAadhaarID = staffAadhaarID;
    }

    public String getStaffContactNo() {
        return staffContactNo;
    }

    public void setStaffContactNo(String staffContactNo) {
        this.staffContactNo = staffContactNo;
    }

    public String getStaffOccuption() {
        return staffOccuption;
    }

    public void setStaffOccuption(String staffOccuption) {
        this.staffOccuption = staffOccuption;
    }

    public int getStaffAge() {
        return staffAge;
    }

    public void setStaffAge(int staffAge) {
        this.staffAge = staffAge;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public StaffINFO(String staffName, String staffGender, String staffAadhaarID, String staffContactNo, String staffOccuption, String staffImage,int staffAge,int staffID) {
        this.staffName = staffName;
        this.staffGender = staffGender;
        this.staffAadhaarID = staffAadhaarID;
        this.staffContactNo = staffContactNo;
        this.staffOccuption = staffOccuption;
        this.staffImage=staffImage;
        this.staffAge = staffAge;
        this.staffID=staffID;
    }
}
