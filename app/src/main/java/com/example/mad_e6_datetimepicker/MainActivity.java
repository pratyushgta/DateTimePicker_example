/**
 * This class contains methods for the home screen which handles date & time pickers
 * MAD-E7
 *
 * @author Pratyush Kumar (github.com/pratyushgta)
 */

package com.example.mad_e6_datetimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView title;
    ImageView img;
    Button datePicker, timePicker, confirm;
    String setDate, setTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.monke3_name);
        img = findViewById(R.id.monke3_img);
        datePicker = findViewById(R.id.dateBtn);
        timePicker = findViewById(R.id.timeBtn);
        confirm = findViewById(R.id.confirmBtn);

        title.setText("Celebes Crested Macaque Monkey");
        img.setImageResource(R.drawable.monke3);

        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialDatePicker<Long> materialDatePicker = MaterialDatePicker.Builder.datePicker()
                        .setTitleText("Select a date")
                        .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                        .build();
                materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Long>() {
                    @Override
                    public void onPositiveButtonClick(Long selection) {
                        setDate = new SimpleDateFormat("MM-dd-yyyy", Locale.getDefault()).format(new Date(selection));
                        datePicker.setText(setDate);
                        DateTimeHandler.setDate(setDate);
                    }
                });
                materialDatePicker.show(getSupportFragmentManager(), "MATERIAL_DATE_PICKER");
            }
        });

        timePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialTimePicker materialTimePicker = new MaterialTimePicker.Builder()
                        .setTitleText("Select a time")
                        .setTimeFormat(TimeFormat.CLOCK_12H)
                        .setHour(12)
                        .setMinute(0)
                        .setInputMode(MaterialTimePicker.INPUT_MODE_CLOCK)
                        .build();

                materialTimePicker.addOnPositiveButtonClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setTime = MessageFormat.format("{0}:{1}",
                                String.format(Locale.getDefault(), "%02d", materialTimePicker.getHour()),
                                String.format(Locale.getDefault(), "%02d", materialTimePicker.getMinute()));
                        timePicker.setText(setTime);
                        DateTimeHandler.setTime(setTime);
                    }
                });
                materialTimePicker.show(getSupportFragmentManager(), "MATERIAL_TIME_PICKER");
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (setDate == null || setTime == null) {
                    Toast.makeText(getApplicationContext(), "No date or time selected!", Toast.LENGTH_LONG).show();
                } else {
                    Intent confirmationPage = new Intent(MainActivity.this, AppointmentConfirmation.class);
                    startActivity(confirmationPage);
                    //confirmationPage.putExtra("date",setDate);
                    //confirmationPage.putExtra("time",setTime);
                }
            }
        });
    }
}