package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText editFrom, editTo;
    double usd2vnd = 24000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editFrom = findViewById(R.id.edit_from);
        editTo = findViewById(R.id.edit_to);

        findViewById(R.id.button_convert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fromStr = editFrom.getText().toString();
                double from = Double.parseDouble(fromStr);
                double to = from * usd2vnd;
                editTo.setText(String.valueOf(to));
            }
        });

        findViewById(R.id.button_clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editFrom.setText("");
                editTo.setText("");
            }
        });

        editFrom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String fromStr = editable.toString();
                double from = Double.parseDouble(fromStr);
                double to = from * usd2vnd;
                editTo.setText(String.valueOf(to));
            }
        });
    }
}