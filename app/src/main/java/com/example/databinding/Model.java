package com.example.databinding;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class Model implements Contractor.Model {
    String date;
    String time;
    int mYear,mMonth,mDay;
    int mHour,mMinute;
    @Override
    public void getNextCourse(OnFinishedListener onFinishedListener, Context context, int i) {
        final Calendar c = Calendar.getInstance();
        if (i==0){
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);
            date= mDay+"/"  +(mMonth+1)+"/"+ mYear;
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);
            time= mHour+":" +mMinute;
            onFinishedListener.onFinished(date,time);
        }
        else if (i==1){
            DatePickerDialog datePickerDialog=new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    date=dayOfMonth+"/"+(month+1)+"/"+year;
                    onFinishedListener.onFinished(date,time);

                }
            },mYear, mMonth, mDay);
            datePickerDialog.show();

        }
        else if(i==2){
            TimePickerDialog timePickerDialog=new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    time=hourOfDay+":"+minute;
                    onFinishedListener.onFinished(date,time);
                }
            },mHour, mMinute, false);
            timePickerDialog.show();
        }
    }
}
