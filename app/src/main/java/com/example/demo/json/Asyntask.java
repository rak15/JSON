package com.example.demo.json;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.CursorAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by DEMO on 05-10-2016.
 */
public class Asyntask extends AsyncTask<String,String,String> {
    Context con;
    ListView lv;
    ProgressDialog pd;


    public Asyntask(Context con, ListView lv) {
        this.con = con;
        this.lv = lv;


    }

    @Override

    protected String doInBackground(String... params) {
        String line = null;
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(params[0]);
            URLConnection connection = url.openConnection();
            connection.connect();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = br.readLine()) != null) {
                sb.append(line);

            }
    }   catch (IOException e){
                e.printStackTrace();
            }
            line = sb.toString();
            return line;
        }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd=new ProgressDialog(con);
        pd.setMessage("loading....");
        pd.show();
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            JSONObject jo=new JSONObject(s);
            JSONArray ja=jo.getJSONArray("worldpopulation");

            ArrayList<Worldpopulation> world=new ArrayList<Worldpopulation>();
            for (int i=0;i<ja.length();i++){
                Worldpopulation c=new Worldpopulation();
                c.setCountry(ja.getJSONObject(i).getString("country"));
                c.setFlag(ja.getJSONObject(i).getString("flag"));
                c.setPopulation(ja.getJSONObject(i).getString("population"));
                c.setRank(ja.getJSONObject(i).getInt("rank"));

                world.add(c);
            }
            Adapter ma=new Adapter(con,world);
            lv.setAdapter(ma);
            pd.dismiss();
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}

