package com.example.financetracker;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class Home extends AppCompatActivity {

    private TextView monthlyMoneySpentValueTextView;
    private double monthlyMoneySpent = 123.45; // Replace with your actual monthly spending value

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);

        monthlyMoneySpentValueTextView = findViewById(R.id.monthly_money_spent_value);

        // Set monthly money spent value to a specific format
        DecimalFormat decimalFormat = new DecimalFormat("0.00 TND");
        String formattedMonthlyMoneySpent = decimalFormat.format(monthlyMoneySpent);

        monthlyMoneySpentValueTextView.setText(formattedMonthlyMoneySpent);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button button = findViewById(R.id.add_button);
    }
}
