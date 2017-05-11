package com.example.demo.json;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DEMO on 05-10-2016.
 */
public class Adapter extends BaseAdapter {
    Context c;
    ArrayList<Worldpopulation> worldpopulations;
    LayoutInflater li;

    public Adapter(Context c, ArrayList<Worldpopulation> worldpopulations) {
        this.c = c;
        this.worldpopulations = worldpopulations;
        li=LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return worldpopulations.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView=li.inflate(R.layout.item,parent,false);

        }
        TextView tv=(TextView)convertView.findViewById(R.id.textView);
        TextView tv2=(TextView)convertView.findViewById(R.id.textView2);
        TextView tv3=(TextView)convertView.findViewById(R.id.textView3);
        TextView tv4=(TextView)convertView.findViewById(R.id.textView4);

        tv.setText(worldpopulations.get(position).getCountry());
        tv2.setText(worldpopulations.get(position).getFlag());
        tv3.setText(worldpopulations.get(position).getPopulation());
        tv4.setText(worldpopulations.get(position).getRank()+"");
        //rank in integer formate
        //it should convert to string formate so +"" is used

        return convertView;


    }

}

