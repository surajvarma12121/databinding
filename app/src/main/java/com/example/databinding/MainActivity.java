package com.example.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.databinding.databinding.ActivityMainBinding;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements Contractor.View {
    TextView tv1,tv2;
    Presenter presenter;
    ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
      //setContentView(R.layout.activity_main);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        presenter = new Presenter(this, new Model());
        presenter.onButtonClick(0,MainActivity.this);
        activityMainBinding.tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButtonClick(1,MainActivity.this);
            }
        });
        activityMainBinding.tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButtonClick(2,MainActivity.this);
            }
        });
    }
    @Override
    public void setData(String date, String time) {
        activityMainBinding.setDate(date);
        activityMainBinding.setTime(time);
    }
}