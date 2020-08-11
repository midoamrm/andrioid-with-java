package com.example.celendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tw,tw1;
    CalendarView calv;
    Calendar cal;
    Button bb;
    AlertDialog.Builder ale;
    EditText tm;
    String task;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tw=findViewById(R.id.ttw);
        calv=findViewById(R.id.calendarView);
        bb=findViewById(R.id.exit);
        tm=findViewById(R.id.tm);
        tw1=findViewById(R.id.textView1);
        next=findViewById(R.id.next);
        calv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                tw.setText(i2+"/"+i1+"/"+i+":");


            }
        });
    bb.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            task=tm.getText().toString();

            tw1.setText(task);
            ale=new AlertDialog.Builder(MainActivity.this);
            ale.setTitle("warnig");
            ale.setMessage(" you will delet last task !");
            ale.setCancelable(false);
            ale.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //MainActivity.this.finish();
                    task="";
                }
            });
            ale.setNegativeButton("no", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                   dialogInterface.cancel();
                }
            });
            AlertDialog dialog=ale.create();
            dialog.show();
        }
    });

    next.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intt=new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intt);
        }
    });


    }
}