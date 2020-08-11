package Views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sqlnndrecview.MainActivity;
import com.example.sqlnndrecview.R;

public class Makecalle extends AppCompatActivity {
     public String str="",sho="";
     ImageView a1,a2,a3,a4,a5,a6,a7,call;
      Button a8,a9,a0,del;
     Switch backk;
      View view;

      TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makecalle);
        textView=findViewById(R.id.rep);


         a0=findViewById(R.id.a0);
       a1=findViewById(R.id.a1);
        a2=findViewById(R.id.a2);
        a3=findViewById(R.id.a3);
        a4=findViewById(R.id.a4);
        a5=findViewById(R.id.a5);
        a6=findViewById(R.id.a6);
        a7=findViewById(R.id.a7);
        a8=findViewById(R.id.a8);
        a9=findViewById(R.id.a9);
        call=findViewById(R.id.caall);
        del=findViewById(R.id.del);
        backk=findViewById(R.id.switch111);

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                         a1();
            }
        });

        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 a2();
            }
        });
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  a3();
            }
        });
        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a4();
            }
        });
        a5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a5();
            }
        });
        a6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    a6();
            }
        });
        a7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a7();
            }
        });
        a8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           a8();
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT >= 23){
                    if(checkPermission()){
                        Toast.makeText(getApplicationContext(),
                                "Permission granted",Toast.LENGTH_SHORT).show();
                    }else{
                        requestPermission();
                        Log.d("num","true");
                    }
                }
                  call1(view);

            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  delet();
            }
        });
        a9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a9();
            }
        });

        a0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a0();
            }
        });

        backk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Intent intent = new Intent(Makecalle.this, MainActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(Makecalle.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });




    }

   private void  a1(){

      str=str+"1";
       textView.setText(str);

    }

    public void   a2(){

        str=str+"2";
        textView.setText(str);


    }
    public void a3(){

        str=str+"3";
        textView.setText(str);


    }

    public void a4(){

        str=str+"4";
        textView.setText(str);


    }
    public void a5(){

        str=str+"5";
        textView.setText(str);


    }
    public void a6(){

        str=str+"6";
        textView.setText(str);


    }
    public void a7(){

        str=str+"7";
        textView.setText(str);


    }
    public void   a8(){

        str=str+"8";
        textView.setText(str);


    }
    public void   a9(){

        str=str+"9";
        textView.setText(str);


    }
    public void   a0(){

        str=str+"0";


        textView.setText(str);

    }

    public void   delet(){
        if(!TextUtils.isEmpty(str)){
        str=str.substring(0,str.length()-1);



                textView.setText(str);



    }


    }
    public boolean checkPermission(){
        int CallPermissionResult =   ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.CALL_PHONE);

        return  CallPermissionResult == PackageManager.PERMISSION_GRANTED;
    }

    public void requestPermission(){
        ActivityCompat.requestPermissions(
                Makecalle.this,new String[]{
                        Manifest.permission.CALL_PHONE
                },1);
        Log.d("num","tuess");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        //  super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case 1:


                if(grantResults.length > 0){
                    boolean CallPermission = grantResults[0] == PackageManager.PERMISSION_GRANTED;

                    if(CallPermission){
                        Toast.makeText(Makecalle.this,"Permission accepted !",
                                Toast.LENGTH_LONG).show();
                              call1(view);

                    }else {
                        Toast.makeText(Makecalle.this,"Permission denied !",
                                Toast.LENGTH_LONG).show();


                    }
                    break;
                }
        }
    }


    public void call1(View view){

        if(!TextUtils.isEmpty(str )){
            String dial = "tel:"+ str;

            if(checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                return;
            }

            startActivity(new Intent( Intent.ACTION_CALL , Uri.parse(dial) ));

        }else{
            Toast.makeText(Makecalle.this,"Please put a phone number",
                    Toast.LENGTH_SHORT).show();
        }


    }



































}