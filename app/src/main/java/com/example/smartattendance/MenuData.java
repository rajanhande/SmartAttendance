package com.example.smartattendance;

public class MenuData {

    private String menuName;
    //private String menuDescription;
    private int menuImage;

    public MenuData(String menuName,  int menuImage)
    {
        this.menuName = menuName;
       // this.menuDescription = menuDescription;
        this.menuImage = menuImage;
    }

    public String getMenuName() {
        return menuName;
    }

   // public String getMenuDescription(){return menuDescription;}

    public int getMenuImage(){return menuImage;}
}
