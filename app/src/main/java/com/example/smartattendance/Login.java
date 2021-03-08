package com.example.smartattendance;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    Button btn,btnreg;
    EditText eduname,edupass;

    TextView txtshow;
    int counter = 3;


    EditText Email, Password;

    // Creating button;
    Button LoginButton;

    // Creating Volley RequestQueue.
    RequestQueue requestQueue;


    // Creating Progress dialog.
    ProgressDialog progressDialog;

    // Storing server url into String variable.
    String HttpUrl = "http://www.techlogic.xyz/Rajan/Login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        btn = (Button) findViewById(R.id.btn);
        btnreg=(Button)findViewById(R.id.btnreg);


        Email = (EditText) findViewById(R.id.eduname);
        Password = (EditText) findViewById(R.id.edupass);

        txtshow = (TextView) findViewById(R.id.txtshow);
        txtshow.setVisibility(View.GONE);
        requestQueue = Volley.newRequestQueue(Login.this);

        // Assigning Activity this to progress dialog.
        progressDialog = new ProgressDialog(Login.this);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UserLogin();
            }

        });

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Regestration.class);
                startActivity(intent);

            }
        });

    }




    public void UserLogin() {

        // Showing progress dialog at user registration time.
        progressDialog.setMessage("Please Wait");
        progressDialog.show();

        // Creating string request with post method.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, HttpUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String ServerResponse) {

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();

                        // Matching server responce message to our text.
                        if(ServerResponse.equalsIgnoreCase("Data Matched")) {

                            // If response matched then show the toast.
                            Toast.makeText(Login.this, "Logged In Successfully", Toast.LENGTH_LONG).show();

                            // Finish the current Login activity.
                            finish();
                            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Login.this);
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putString("email", Email.getText().toString().trim());
                            editor.commit();
                            // Opening the user profile activity using intent.
                            Intent intent = new Intent(Login.this, MainActivity.class);

                            // Sending User Email to another activity using intent.


                            startActivity(intent);
                        }
                        else {

                            // Showing Echo Response Message Coming From Server.
                            Toast.makeText(Login.this, ServerResponse, Toast.LENGTH_LONG).show();

                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();

                        // Showing error message if something goes wrong.
                        Toast.makeText(Login.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {

                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();

                // Adding All values to Params.
                // The firs argument should be same sa your MySQL database table columns.
                params.put("email", Email.getText().toString().trim());
                params.put("password", Password.getText().toString().trim());

                return params;
            }

        };

        // Creating RequestQueue.
        RequestQueue requestQueue = Volley.newRequestQueue(Login.this);

        // Adding the StringRequest object into requestQueue.
        requestQueue.add(stringRequest);

    }
}


