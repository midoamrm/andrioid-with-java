package com.example.movieshow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
  private TextView des,link;
  private ImageView imageView;
  private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bundle=getIntent().getExtras();
        link=findViewById(R.id.link);
        des=findViewById(R.id.desc);
        imageView=findViewById(R.id.imageView);

       if(bundle!=null){
           des.setText(bundle.getString("des"));
             link.setText(bundle.getString("link"));
            imageView.setImageResource(bundle.getInt("im"));


        }
    }
}