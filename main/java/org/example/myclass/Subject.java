package org.example.myclass;

public class Subject {
    private String name;
    private int attendance=0;
    private String imgUrl;
    private float attendancePercent;
    private int missed=0;
    private String faculty;
    private String reference;

    public Subject(String name, int attendance, String imgUrl,String faculty,String reference) {
        this.name = name;
        this.attendance = attendance;
        this.imgUrl = imgUrl;
        this.faculty=faculty;
        this.reference=reference;
    }

    public float getAttendancePercent() {
        return attendancePercent;
    }

    public String getReference() {
        return reference;
    }

    public String getName() {
        return name;
    }
    public int getMissed(){
        return missed;
    }
    public int getAttendance() {
        return attendance;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public void setMissed(int missed) {
        this.missed = missed;
    }

    public void setAttendancePercent(float attendancePercent) {
        this.attendancePercent = attendancePercent;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public void addAtt(int attendance){
        this.attendance=attendance+1;
        setAttendance(this.attendance);
    }
    public void addMiss(int missed){
        this.missed=missed+1;
    }
    public void computePerc(int attendance,int missed){
        this.attendancePercent=100*(float)attendance/(float)(attendance+missed);
        setAttendancePercent(this.attendancePercent);
    }


    @Override
    public String toString() {
        return "Book{" +

                " name='" + name + '\'' +
                ", attendance=" + attendance +
                ", imageUrl='" + imgUrl + '\'' +
                ",faculty='"+faculty+'\''+

                '}';

    }
}

