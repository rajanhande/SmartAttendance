package com.example.smartattendance;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.smartattendance.MVP.Attendance;
import com.example.smartattendance.MVP.Study;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Profile extends AppCompatActivity {
TextView txtName,txtClass,txtMobNo,txtEmail,txtGender;
    private static final String URL_PRODUCTS = "http://www.techlogic.xyz/Rajan/profile.php";
String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        final SharedPreferences mSharedPreference= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        email=(mSharedPreference.getString("email", ""));


        txtClass=(TextView) findViewById(R.id.txtclass);
        txtName=(TextView) findViewById(R.id.txtname);
        txtMobNo=(TextView) findViewById(R.id.txtmob);
        txtEmail=(TextView) findViewById(R.id.txtmail);
        txtGender=(TextView) findViewById(R.id.txtgender);
        UserAttend();

    }





    public void UserAttend() {



        // Creating string request with post method.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_PRODUCTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String ServerResponse) {
                        try {

                            JSONArray array = new JSONArray(ServerResponse);

                            for (int i = 0; i < array.length(); i++) {

                                JSONObject product = array.getJSONObject(i);


                                txtName.setText(product.getString("stud_name"));
                                txtClass.setText(product.getString("stud_class"));
                                txtMobNo.setText(product.getString("mobno"));
                                txtEmail.setText(product.getString("email"));
                                txtGender.setText(product.getString("gender"));

                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {


                        // Showing error message if something goes wrong.
                        Toast.makeText(Profile.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {

                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();

                // Adding All values to Params.
                // The firs argument should be same sa your MySQL database table columns.
                params.put("email", email);

                return params;
            }

        };

        // Creating RequestQueue.
        RequestQueue requestQueue = Volley.newRequestQueue(Profile.this);

        // Adding the StringRequest object into requestQueue.
        requestQueue.add(stringRequest);

    }




}
