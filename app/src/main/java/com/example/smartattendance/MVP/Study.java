package com.example.smartattendance.MVP;

public class Study {

    private String Id;
    //private String menuDescription;
    private String SubName;
    private String Descr;
    private String path;

    public Study(String Id,  String SubName,String Descr,String path)
    {
        this.Id = Id;
        // this.menuDescription = menuDescription;
        this.SubName = SubName;
        this.Descr=Descr;
        this.path=path;
    }

    public String getId() {
        return Id;
    }

    // public String getMenuDescription(){return menuDescription;}


    public String getSubName(){return SubName;}
    public String getDescr(){return Descr;}
    public String getPath(){return path;}


}
