package com.example.smartattendance.MVP;

public class Attendance {

    private String id;
    private String stud_id;
    private String date;

    public Attendance(String id,String stud_id,String date)
    {
        this.id=id;
        this.stud_id=stud_id;
        this.date=date;
    }

    public String getId(){return id;}
    public String getStud_id(){return stud_id;}
    public String getDate(){return date;}
}
