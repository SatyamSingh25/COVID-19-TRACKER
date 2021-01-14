package com.example.covid19tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

public class WorldData extends AppCompatActivity {
    TextView totalCases, casesAns, recoveryRate, recoveryAns, totalDeaths, totalDeathsAns;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_data);
        totalCases = findViewById(R.id.totalCases);
        casesAns = findViewById(R.id.casesAns);
        recoveryRate = findViewById(R.id.recoveryRate);
        recoveryAns = findViewById(R.id.recoveryAns);
        totalDeaths = findViewById(R.id.totalDeaths);
        totalDeathsAns = findViewById(R.id.totalDeathsAns);
        loadImage();
        loadData();
    }
    public void loadImage(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://covid19.mathdro.id/api";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>(){
                    public void onResponse(JSONObject response) {
                        try{
                            String url = response.getString("image");
                            ImageView imageView = (ImageView) findViewById(R.id.imageView2);
                            Glide.with(WorldData.this).load(url).into(imageView);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });
        queue.add(jsonObjectRequest);
    }
    public void loadData(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://coronavirus-19-api.herokuapp.com/all";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsObj = new JSONObject(response.toString());
                    casesAns.setText(jsObj.getString("cases"));
                    recoveryAns.setText(jsObj.getString("recovered"));
                    totalDeathsAns.setText(jsObj.getString("deaths"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}