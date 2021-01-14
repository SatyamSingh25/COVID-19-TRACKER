package com.example.covid19tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class IndianData extends AppCompatActivity {
    TextView totalCasesAns,recoveredTotalAns,RecoveredTodayAns, todayCasesAns,
            todayDeathAns, totalDeathAns;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indian_data);
        totalCasesAns = findViewById(R.id.totalCasesAns);
        recoveredTotalAns = findViewById(R.id.recoveredTotalAns);
        RecoveredTodayAns = findViewById(R.id.RecoveredTodayAns);
        todayCasesAns = findViewById(R.id.todayCasesAns);
        todayDeathAns = findViewById(R.id.todayDeathAns);
        totalDeathAns = findViewById(R.id.totalDeathAns);
        getInfo();
    }
    public void getInfo(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://api.apify.com/v2/key-value-stores/toDWvRj1JpTXiM8FF/records/LATEST?disableRedirect=true";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsObj = new JSONObject(response.toString());
                    totalCasesAns.setText(jsObj.getString("totalCases"));
                    recoveredTotalAns.setText(jsObj.getString("recovered"));
                    RecoveredTodayAns.setText(jsObj.getString("recoveredNew"));
                    todayCasesAns.setText(jsObj.getString("activeCasesNew"));
                    todayDeathAns.setText(jsObj.getString("deathsNew"));
                    totalDeathAns.setText(jsObj.getString("deaths"));
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