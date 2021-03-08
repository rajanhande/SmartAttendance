package com.example.smartattendance;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Leave_Application extends AppCompatActivity {
    EditText prn,edname,edclass,eddate,edleavefrom,edleaveto,edReason;

    Button btnsubmit;
    RequestQueue requestQueue;
    ProgressDialog progressDialog;
    String HttpUrl = "http://www.techlogic.xyz/Rajan/Leave.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leave__application);

        btnsubmit=(Button)findViewById(R.id.btnsubmit);



        prn=(EditText)findViewById(R.id.prn);
        edname=(EditText)findViewById(R.id.edname);
        edclass=(EditText)findViewById(R.id.edclass);
        eddate=(EditText)findViewById(R.id.eddate);
        edleavefrom=(EditText)findViewById(R.id.edleavefrom);
        edleaveto=(EditText)findViewById(R.id.edleaveto);
        edReason=(EditText)findViewById(R.id.reason);

        // Creating Volley newRequestQueue .
        requestQueue = Volley.newRequestQueue(Leave_Application.this);

        progressDialog = new ProgressDialog(Leave_Application.this);


        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                // Showing progress dialog at user registration time.
                progressDialog.setMessage("Please Wait, We are Inserting Your Data on Server");
                progressDialog.show();

                // Calling method to get value from EditText.
              //  GetValueFromEditText();

                // Creating string request with post method.
                StringRequest stringRequest = new StringRequest(Request.Method.POST, HttpUrl,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String ServerResponse) {

                                // Hiding the progress dialog after all task complete.
                                progressDialog.dismiss();

                                // Showing response message coming from server.
                                Toast.makeText(Leave_Application.this, ServerResponse, Toast.LENGTH_LONG).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {

                                // Hiding the progress dialog after all task complete.
                                progressDialog.dismiss();

                                // Showing error message if something goes wrong.
                                Toast.makeText(Leave_Application.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() {

                        // Creating Map String Params.
                        Map<String, String> params = new HashMap<String, String>();

                        // Adding All values to Params.
                        params.put("stud_id", "1");
                        params.put("stud_name", edname.getText().toString());
                        params.put("stud_class", edclass.getText().toString());
                        params.put("leave_from_date", edleavefrom.getText().toString());
                        params.put("leave_to_date", edleaveto.getText().toString());
                        params.put("date",eddate.getText().toString());
                        params.put("reason", edReason.getText().toString());

                        return params;
                    }

                };

                // Creating RequestQueue.
                RequestQueue requestQueue = Volley.newRequestQueue(Leave_Application.this);

                // Adding the StringRequest object into requestQueue.
                requestQueue.add(stringRequest);





            }
        });



    }
}
