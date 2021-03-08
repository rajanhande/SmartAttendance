package com.example.smartattendance;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import com.example.smartattendance.MVP.Study;

import java.util.List;

public class Study_Material extends AppCompatActivity {

    private static final String URL_PRODUCTS = "http://www.techlogic.xyz/Rajan/study_material.php";

    List<Study> productList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study__material);

        recyclerView = findViewById(R.id.recyclerviewStudyMaterial);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productList = new ArrayList<>();

        loadProducts();
    }


    private void loadProducts() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_PRODUCTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONArray array = new JSONArray(response);

                            for (int i = 0; i < array.length(); i++) {

                                JSONObject product = array.getJSONObject(i);

                                productList.add(new Study(
                                        product.getString("id"),
                                        product.getString("sub_name"),
                                        product.getString("notes"),
                                        product.getString("path")

                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            studyAdapter adapter = new studyAdapter(Study_Material.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Study_Material.this,error.getMessage() ,Toast.LENGTH_SHORT).show();
                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }
}
