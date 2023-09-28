/**
 * This class contains methods for the intent/ activity that displays date & time selected on the home screen
 * MAD-E7
 *
 * @author Pratyush Kumar (github.com/pratyushgta)
 */

package com.example.mad_e6_datetimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AppointmentConfirmation extends AppCompatActivity {

    TextView setDate, setTime;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_confirmation);

        setDate = findViewById(R.id.confirm_date);
        setTime = findViewById(R.id.confirm_time);
        back = findViewById(R.id.backBtn);

        // Retrieving a bundle, basically all messages sent
        // By the Calling Activity (i.e. MainActivity.class)
        /*Bundle bundle = getIntent().getExtras();
        String date = bundle.getString("date");
        String time = bundle.getString("time");

        dateAndTime.setText(date + " " + time);*/

        setDate.setText(DateTimeHandler.getDate());
        setTime.setText(DateTimeHandler.getTime());

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main = new Intent(AppointmentConfirmation.this, MainActivity.class);
                startActivity(main);
            }
        });
    }
}