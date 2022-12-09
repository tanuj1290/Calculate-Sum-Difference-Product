package com.example.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int numValue1 = 0, numValue2 = 0, temp = 0;
    EditText number1, number2;
    RadioGroup radioGroup;
    TextView resultTextView;
    Button button_calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number1 = findViewById(R.id.enter_number_one);
        number2 = findViewById(R.id.enter_number_two);
        button_calculate = findViewById(R.id.result);
        resultTextView = findViewById(R.id.show_result_text);
        radioGroup = findViewById(R.id.radio_group_sum_diff_product);

        button_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value1 = number1.getText().toString();
                numValue1 = Integer.parseInt(value1);

                String value2 = number2.getText().toString();
                numValue2 = Integer.parseInt(value2);
                int selectedId = radioGroup.getCheckedRadioButtonId();
                switch (selectedId) {
                    case R.id.sum:
                        temp = numValue1 + numValue2;
                        resultTextView.setText("Sum = " + String.valueOf(temp));
                        break;
                    case R.id.difference:
                        temp = Math.abs(numValue1 - numValue2);
                        resultTextView.setText("Difference = " + String.valueOf(temp));
                        break;
                    case R.id.product:
                        temp = numValue1 * numValue2;
                        resultTextView.setText("Product = " + String.valueOf(temp));
                        break;
                }
            }
        });
    }
}