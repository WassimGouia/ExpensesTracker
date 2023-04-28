package com.example.financetracker;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;

public class BarChartStat extends Fragment {

    private final ArrayList<String> labels;
    private RadioGroup timeRangeRadioGroup;
    private BarChart statisticsBarChart;
    private ArrayList<String> xLabels = new ArrayList<>();
    private ArrayList<BarEntry> yValues = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.barchartstat, container, false);

        timeRangeRadioGroup = root.findViewById(R.id.time_range_radio_group);
        statisticsBarChart = root.findViewById(R.id.statistics_bar_chart);

        // Set default data to display (monthly)
        setMonthlyData();

        // Add listener to the radio group to update the displayed data when the user selects a different time range
        timeRangeRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.daily_radio_button:
                        setDailyData();
                        break;
                    case R.id.monthly_radio_button:
                        setMonthlyData();
                        break;
                    case R.id.annually_radio_button:
                        setAnnualData();
                        break;
                }
            }
        });

        return root;
    }

    private void setMonthlyData() {
        // Set x-axis labels for the bar chart
        xLabels.clear();
        xLabels.add("Week 1");
        xLabels.add("Week 2");
        xLabels.add("Week 3");
        xLabels.add("Week 4");

        // Set y-axis values for the bar chart
        yValues.clear();
        yValues.add(new BarEntry(1f, 100f));
        yValues.add(new BarEntry(2f, 150f));
        yValues.add(new BarEntry(3f, 200f));
        yValues.add(new BarEntry(4f, 250f));

        // Create and customize the bar chart
        BarDataSet dataSet = new BarDataSet(yValues, "Monthly Expenses");
        dataSet.setColor(getResources().getColor(R.color.monthly_color));
        BarData barData = new BarData(dataSet);
        statisticsBarChart.setData(barData);
        statisticsBarChart.getXAxis().setValueFormatter(new LabelFormatter(xLabels));
        statisticsBarChart.getDescription().setEnabled(false);
        statisticsBarChart.animateY(1000);
        statisticsBarChart.invalidate(); // refresh the chart
    }
    private void setDailyData() {
        // Set x-axis labels for the bar chart
        xLabels.clear();
        xLabels.add("Monday");
        xLabels.add("Tuesday");
        xLabels.add("Wednesday");
        xLabels.add("Thursday");
        xLabels.add("Friday");
        xLabels.add("Saturday");
        xLabels.add("Sunday");

        // Set y-axis values for the bar chart
        yValues.clear();
        yValues.add(new BarEntry(1f, 20f));
        yValues.add(new BarEntry(2f, 40f));
        yValues.add(new BarEntry(3f, 30f));
        yValues.add(new BarEntry(4f, 60f));
        yValues.add(new BarEntry(5f, 50f));
        yValues.add(new BarEntry(6f, 45f));
        yValues.add(new BarEntry(7f, 35f));

        // Create and customize the bar chart
        BarDataSet dataSet = new BarDataSet(yValues, "Daily Expenses");
        dataSet.setColor(getResources().getColor(R.color.daily_color));
        BarData barData
                = new BarData(dataSet);
        statisticsBarChart.setData(barData);
        statisticsBarChart.getXAxis().setValueFormatter(new LabelFormatter(xLabels));
        statisticsBarChart.getDescription().setEnabled(false);
        statisticsBarChart.animateY(1000);
        statisticsBarChart.invalidate(); // refresh the chart
    }

    private void setAnnualData() {
        // Set x-axis labels for the bar chart
        xLabels.clear();
        xLabels.add("Q1");
        xLabels.add("Q2");
        xLabels.add("Q3");
        xLabels.add("Q4");

        // Set y-axis values for the bar chart
        yValues.clear();
        yValues.add(new BarEntry(1f, 500f));
        yValues.add(new BarEntry(2f, 800f));
        yValues.add(new BarEntry(3f, 1000f));
        yValues.add(new BarEntry(4f, 1200f));

        // Create and customize the bar chart
        BarDataSet dataSet = new BarDataSet(yValues, "Annual Expenses");
        dataSet.setColor(getResources().getColor(R.color.annually_color));
        BarData barData = new BarData(dataSet);
        statisticsBarChart.setData(barData);
        statisticsBarChart.getXAxis().setValueFormatter(new LabelFormatter(xLabels));
        statisticsBarChart.getDescription().setEnabled(false);
        statisticsBarChart.animateY(1000);
        statisticsBarChart.invalidate(); // refresh the chart
    }

    public BarChartStat(ArrayList<String> labels) {
        super();
        this.labels = labels;
    }

    public String getFormattedValue(float value) {
        int index = (int) value - 1;
        if (index >= 0 && index < labels.size()) {
            return labels.get(index);
        } else {
            return "";
        }
    }

    private class LabelFormatter extends ValueFormatter {
        public LabelFormatter(ArrayList<String> xLabels) {
        }
    }
}

