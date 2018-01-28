package com.example.ritisha.ralist;

import android.content.Context;
import android.content.SearchRecentSuggestionsProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Ritisha on 1/13/2018.
 */

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    String[] raNames;
    String[] dutyDay;

    public ItemAdapter(Context c, String[] r, String[] d){
        raNames = r;
        dutyDay = d;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return raNames.length;
    }

    @Override
    public Object getItem(int i) {
        return raNames[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = mInflater.inflate(R.layout.ra_list_detail, null);
        TextView RaNameTextView = (TextView) v.findViewById(R.id.RaNameTextView);
        TextView dutyDayTextView = (TextView)v.findViewById(R.id.dutyDayTextView);

        String name = raNames[i];
        String day = dutyDay[i];

        RaNameTextView.setText(name);
        dutyDayTextView.setText(day);

        return v;
    }
}
