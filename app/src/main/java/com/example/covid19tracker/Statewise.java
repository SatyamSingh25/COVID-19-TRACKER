package com.example.covid19tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.HttpAuthHandler;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.android.volley.Request.*;

public class Statewise extends AppCompatActivity {

    public Object JsonObjectRequest;
    public String url = "https://api.apify.com/v2/key-value-stores/toDWvRj1JpTXiM8FF/records/LATEST?disableRedirect=true";
    public ListView statesEntry;
    public StateAdapter stateAdapter;
    public  ArrayList<StateStats> states;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statewise);

        statesEntry = findViewById(R.id.statesEntry);
        states = new ArrayList<>();

        stateData();
    }

    public void stateData(){


        StringRequest stringRequest = new StringRequest(Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsnObj = new JSONObject(response);
                    JSONArray arrayJsn = jsnObj.getJSONArray("regionData");
                    for(int i=0; i<arrayJsn.length(); i++){
                        JSONObject obj = arrayJsn.getJSONObject(i);


                        String name  = obj.getString("region");
                        int todayCases = obj.getInt("newInfected");
                        int todayRecover = obj.getInt("newRecovered");
                        int todayDeaths = obj.getInt("newDeceased");
                        int totalCases =  obj.getInt("totalInfected");
                        int totalRecovered = obj.getInt("recovered");
//                        arr.add("name: "+name+"todayCases: " + todayCases+ "\n" + " Today Recovered: "+ todayRecover+ "\n"
//
//                                + "Today Death: "+ todayDeaths+ "\n" + "TotalCases: "+totalCases +"\n"+ "Total Recovered: " + totalRecovered);
//                        arr.add(name);
                        states.add(new StateStats(name, todayCases, todayRecover, todayDeaths, totalCases, totalRecovered));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                stateAdapter = new StateAdapter(Statewise.this, states);
                statesEntry.setAdapter(stateAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

//        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr);
//        statesEntry.setAdapter(arrayAdapter);

    }
}