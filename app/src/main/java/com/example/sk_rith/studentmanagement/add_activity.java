package com.example.sk_rith.studentmanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class add_activity extends AppCompatActivity {
    private Button addButton;
    private EditText idEditText, nameEditText, addressEditText, yosEditText;
    private RadioGroup radSex;
    private RadioButton radioButton_Sex;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_activity);
        setTitle("Add Student");
        // Get instance of the add button
        addButton = (Button) findViewById(R.id.save);

       idEditText = (EditText) findViewById(R.id.stu_id);
       nameEditText = (EditText) findViewById(R.id.stu_name);
       addressEditText = (EditText) findViewById(R.id.stu_address);
       yosEditText = (EditText) findViewById(R.id.stu_yearOfStudy);
          radSex = (RadioGroup) findViewById(R.id.rad_sex);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // get the data
                Integer studentId;
                String studentName;
                String studentAddress;
                String studentSex;
                Integer studentYos;
               radioButton_Sex = (RadioButton) findViewById(radSex.getCheckedRadioButtonId());

                studentId = Integer.parseInt(idEditText.getText().toString());
                studentName = nameEditText.getText().toString();
                studentAddress = addressEditText.getText().toString();
                studentSex = radioButton_Sex.getText().toString();
                studentYos = Integer.parseInt(yosEditText.getText().toString());

                Log.d("Student : ", studentId + " "+studentName + " "+studentAddress + " "+studentSex + " "+studentYos);
                try {

                    PrintStream out = new PrintStream(openFileOutput("students.txt", MODE_APPEND));
                    out.println(studentId+","+studentName+","+studentSex+","+studentAddress+","+studentYos);

                    out.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

//
//                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//                startActivity(intent);

                // Pass the data back to main activity
            }
        });
//        addButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view)
//            {
//                //get the data
//                Integer studentId;
//                String studentName;
//                String studentAddress;
//                String studentSex;
//                Integer studentYos;
//               // radioButton_Sex = (RadioButton) findViewById(radSex.getCheckedRadioButtonId());
//
////                studentId = Integer.parseInt(idEditText.getText().toString());
////                studentName = nameEditText.getText().toString();
////                studentAddress = addressEditText.getText().toString();
////                studentSex = radioButton_Sex.getText().toString();
////                studentYos = Integer.parseInt(yosEditText.getText().toString());
////                // Pass the data back to main activity
//
//            }
//        });
    }
}
