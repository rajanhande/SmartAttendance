package com.example.smartattendance;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;

    RecyclerView mRecyclerView;
    List<MenuData> mMenuList;
    MenuData mMenuData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer=(DrawerLayout)findViewById(R.id.drawer);
        toggle= new ActionBarDrawerToggle(this,drawer,R.string.open,R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        mRecyclerView = findViewById(R.id.recyclerview);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        mMenuList=new ArrayList<>();
        mMenuData=new MenuData("attendance_report", R.drawable.attendance_report);
        mMenuList.add(mMenuData);

        mMenuData=new MenuData("Document",R.drawable.study_material);
        mMenuList.add(mMenuData);

        mMenuData=new MenuData("Peifile", R.drawable.my_profile);
        mMenuList.add(mMenuData);

        mMenuData=new MenuData("Leave_Application",R.drawable.leave_appli);
        mMenuList.add(mMenuData);


        MyAdapter myAdapter = new MyAdapter(MainActivity.this, mMenuList);
        mRecyclerView.setAdapter(myAdapter);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(toggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
