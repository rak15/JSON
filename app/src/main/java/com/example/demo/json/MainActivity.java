package com.example.demo.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    JsonObjectRequest objectRequest;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.listView);
        //Asyntask at=new Asyntask(MainActivity.this, lv);
        objectRequest = new JsonObjectRequest("http://www.androidbegin.com/tutorial/jsonparsetutorial.txt", new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                CountryPopulation countryPopulation=new Gson().fromJson(response.toString(),CountryPopulation.class);
                adapter=new Adapter(MainActivity.this, countryPopulation.getWorldpopulation());
                lv.setAdapter(adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

    });
        VollyJson.getmInstance().getRequestQueue().add(objectRequest);

        //at.execute("http://www.androidbegin.com/tutorial/jsonparsetutorial.txt");

    }
}
