package com.example.covid19tracker;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class StateAdapter extends ArrayAdapter<StateStats> {

    public StateAdapter(@NonNull Context context, ArrayList<StateStats> states) {
        super(context, 0, states);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.state_list_item, parent, false);
        }

        StateStats currentState = getItem(position);

        TextView stateNameTextView,
                todayCasesTextView,
                todayRecoveredTextView,
                todayDeathsTextView,
                totalCasesTextView,
                totalRecoveredTextView;

        stateNameTextView = listView.findViewById(R.id.tv_state_name);
        todayCasesTextView = listView.findViewById(R.id.tv_today_cases);
        todayRecoveredTextView = listView.findViewById(R.id.tv_today_recovered);
        todayDeathsTextView = listView.findViewById(R.id.tv_today_deaths);
        totalCasesTextView = listView.findViewById(R.id.tv_total_cases);
        totalRecoveredTextView = listView.findViewById(R.id.tv_total_recovered);

        stateNameTextView.setText(currentState.getStateName());
        todayCasesTextView.setText(Integer.toString(currentState.getTodayCases()));
        todayRecoveredTextView.setText(Integer.toString(currentState.getTodayRecovered()));
        todayDeathsTextView.setText(Integer.toString(currentState.getTodayDeaths()));
        totalCasesTextView.setText(Integer.toString(currentState.getTotalCases()));
        totalRecoveredTextView.setText(Integer.toString(currentState.getTotalRecovered()));

        return listView;
    }
}
