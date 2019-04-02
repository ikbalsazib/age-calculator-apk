package com.phonefolk.agecalculate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText enteredAge;
    TextView extraText;
    TextView resultText;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enteredAge = findViewById(R.id.enter_year);
        extraText = findViewById(R.id.extra_txt);
        resultText = findViewById(R.id.result_view);
        btnCalculate = findViewById(R.id.btn_calculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ageCalculation();
            }
        });
    }

    public void ageCalculation() {
        String getYear = enteredAge.getText().toString().trim();
        // validation..
        if (getYear.isEmpty()) {
            extraText.setText("Please Enter Your Birth Year!");
            return;
        }
        Calendar calendar = Calendar.getInstance();
        int birthYear = Integer.parseInt(getYear);
        int currentYear = calendar.get(Calendar.YEAR);
        int age = currentYear - birthYear;
        // More validation..
        if (birthYear < 1900 || birthYear > currentYear) {
            extraText.setText("Yoy are not entered Valid Birth Year!");
            return;
        }

        extraText.setText("Your Age Is:");
        resultText.setText(String.valueOf(age));
    }
}
