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
import android.widget.Toast;

import com.example.sqlnndrecview.MainActivity;
import com.example.sqlnndrecview.R;

import Controller.DatabaseHelper;
import Model.Data;

public class Call extends AppCompatActivity {
     String num;
     String   str_nump;
    Data personInfo1;
     int p;
     View view;
    private DatabaseHelper databaseHelper1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        Bundle bundle = getIntent().getExtras();
        str_nump = bundle.getString("numberp");
        p=Integer.parseInt(str_nump);
        databaseHelper1 = new DatabaseHelper(this);
        personInfo1=databaseHelper1.getData(p);
        num=personInfo1.getAge();
       // num = Integer.parseInt(str_num);

        if(Build.VERSION.SDK_INT >= 23){
            if(checkPermission()){
                Toast.makeText(getApplicationContext(),
                        "Permission granted",Toast.LENGTH_SHORT).show();
            }else{
                requestPermission();
                Toast.makeText(Call.this,"Please click again",
                        Toast.LENGTH_LONG).show();
            }
        }

         call(view);
         finish();

    }




    public boolean checkPermission(){
        int CallPermissionResult =   ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.CALL_PHONE);

        return  CallPermissionResult == PackageManager.PERMISSION_GRANTED;
    }

    public void requestPermission(){
        ActivityCompat.requestPermissions(
                Call.this,new String[]{
                        Manifest.permission.CALL_PHONE
                },2);
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
                    boolean CallPermission1 = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                    Log.d("ss","hy");
                    if(CallPermission1){
                        Toast.makeText(Call.this,"Permission accepted !",
                                Toast.LENGTH_LONG).show();
                                call(view);
                                finish();
                    }else {
                        Toast.makeText(Call.this,"Permission denied !",
                                Toast.LENGTH_LONG).show();
                                finish();

                    }
                    break;
                }
        }
    }


    public void call(View view){

        if(!TextUtils.isEmpty(num )){
            String dial = "tel:"+ num;

            if(checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                return;
            }

           startActivity(new Intent( Intent.ACTION_CALL , Uri.parse(dial) ));

        }else{
            Toast.makeText(Call.this,"Please put a phone number",
                    Toast.LENGTH_SHORT).show();
        }


    }




















}