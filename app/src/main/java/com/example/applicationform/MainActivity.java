package com.example.applicationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg_radioGroup;

    CheckBox cb_checkBox;

    Spinner sp_spinner;

    Button btn_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg_radioGroup = findViewById(R.id.radio);

        cb_checkBox = findViewById(R.id.checkbox);

        sp_spinner = findViewById(R.id.spinner);

        btn_button = findViewById(R.id.button);


        // Radio Group

        rg_radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton radioButton = findViewById(checkedId);

                Toast.makeText(MainActivity.this, "You Select   " + radioButton.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });


        // Check Box
        cb_checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "Check box is Check", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Check box is not check", Toast.LENGTH_SHORT).show();

                }
            }
        });


        // Spinner

        String[] course = {"Java" , "SQL","HTML","CSS","JavaScript"};

        ArrayAdapter<String>adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,course);
        sp_spinner.setAdapter(adapter);


        // Button
        btn_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,HomePage.class);
                startActivity(intent);
            }
        });



    }
}
