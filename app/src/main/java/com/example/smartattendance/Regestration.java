package com.example.smartattendance;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.smartattendance.MVP.Registration;

import java.util.HashMap;
import java.util.Map;

public class Regestration extends AppCompatActivity {

    RadioGroup radiogrp;
    Button btnsave, btncancle;
    EditText prn, edname, edclass, edcard,edmob, email, edpassword, edconfpassword;
    String gender;

    RequestQueue requestQueue;
    ProgressDialog progressDialog;
    String HttpUrl = "http://www.techlogic.xyz/Rajan/Registration.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        btnsave = (Button) findViewById(R.id.btnsave);
        btncancle = (Button) findViewById(R.id.btncancle);


        //final ProgressDialog progressDialog;
        //final String HttpUrl = "http://www.techlogic.xyz/Rajan/Registration.php";

        prn = (EditText) findViewById(R.id.prn);
        edname = (EditText) findViewById(R.id.edname);
        edclass = (EditText) findViewById(R.id.edclass);
        edcard = (EditText) findViewById(R.id.txtCardNo);
        edmob = (EditText) findViewById(R.id.edmob);
        email = (EditText) findViewById(R.id.email);
        edpassword = (EditText) findViewById(R.id.edpassword);
        edconfpassword = (EditText) findViewById(R.id.edconfpassword);
        gender = "male";

        radiogrp = (RadioGroup) findViewById(R.id.radiogrp);

        requestQueue = Volley.newRequestQueue(Regestration.this);

        progressDialog = new ProgressDialog(Regestration.this);


        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog.setMessage("Please Wait, We are Inserting Your Data on Server");
                progressDialog.show();

                StringRequest stringRequest = new StringRequest(Request.Method.POST, HttpUrl,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String ServerResponse) {

                                // Hiding the progress dialog after all task complete.
                                progressDialog.dismiss();

                                // Showing response message coming from server.
                                Toast.makeText(Regestration.this, ServerResponse.trim(), Toast.LENGTH_LONG).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {

                                // Hiding the progress dialog after all task complete.
                                progressDialog.dismiss();

                                // Showing error message if something goes wrong.
                                Toast.makeText(Regestration.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() {

                        // Creating Map String Params.
                        Map<String, String> params = new HashMap<String, String>();

                        // Adding All values to Params.
                        params.put("stud_id", "1");
                        params.put("PRN", prn.getText().toString());
                        params.put("stud_name", edname.getText().toString());
                        params.put("stud_class", edclass.getText().toString());
                        params.put("cardNo", edcard.getText().toString());
                        params.put("gender","male");
                        params.put("mob_no", edmob.getText().toString());
                        params.put("email", email.getText().toString());
                        params.put("password", edpassword.getText().toString());

                        return params;
                    }
                };
                // Creating RequestQueue.
                RequestQueue requestQueue = Volley.newRequestQueue(Regestration.this);

                // Adding the StringRequest object into requestQueue.
                requestQueue.add(stringRequest);


            }
        });
    }
}
