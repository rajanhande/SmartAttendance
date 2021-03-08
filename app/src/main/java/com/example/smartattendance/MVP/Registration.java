package com.example.smartattendance.MVP;

public class Registration {

    private String stud_id;
    private String stud_name;
    private String stud_class;
    private String date_of_birth;
    private String gender;
    private String mob_no;
    private String email;
    private String password;
    private String PRN;
    private String path;

    public Registration(String stud_id,String stud_name,String stud_class,String date_of_birth,String gender,String mob_no,String email,String password,String path,String PRN)
    {
        this.stud_id=stud_id;
        this.stud_name=stud_name;
        this.stud_class=stud_class;
        this.date_of_birth=date_of_birth;
        this.gender=gender;
        this.mob_no=mob_no;
        this.email=email;
        this.password=password;
        this.PRN=PRN;
        this.path=path;
    }

    public String getStud_id(){return stud_id;}
    public String getStud_name(){return stud_name;}
    public String getStud_class(){return stud_class;}
    public String getDate_of_birth(){return date_of_birth;}
    public String getGender(){return gender;}
    public String getMob_no(){return mob_no;}
    public String getEmail(){return email;}
    public String getPassword(){return password;}
    public String getPRN(){return PRN;}
    public String getPath(){return path;}


}
