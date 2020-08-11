package Views;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import Controller.DatabaseHelper;
import Model.Data;

import com.example.sqlnndrecview.MainActivity;
import com.example.sqlnndrecview.R;

public class AddData extends AppCompatActivity {
    private EditText nameText , lnameText , ageText , descriptionText;
    private Button saveButton;
    private DatabaseHelper databaseHelper;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        databaseHelper = new DatabaseHelper(this);
        nameText = findViewById(R.id.name);
        lnameText = findViewById(R.id.lname);
        ageText = findViewById(R.id.age);
        saveButton = findViewById(R.id.buttonsave);
        descriptionText   = findViewById(R.id.description);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nameText.getText().toString();
                String lname = lnameText.getText().toString();
                String description = descriptionText.getText().toString();
                String age = ageText.getText().toString();

                long id = databaseHelper.insertData(new Data(name,lname,description,age));
                Intent intent = new Intent(AddData.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}