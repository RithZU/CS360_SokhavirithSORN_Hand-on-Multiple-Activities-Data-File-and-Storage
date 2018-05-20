package com.example.sk_rith.studentmanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button addStu, showStu, deleteStu;
    static final int ADD_PRODUCT_REQUEST = 1;
    private ArrayList<Student> mStudentStock = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addStu = (Button) findViewById(R.id.btn_add);
        addStu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(),add_activity.class);
                startActivity(intent);
            }
        });

        showStu = (Button) findViewById(R.id.btn_show);
        showStu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(),student_list.class);
                startActivity(intent);
            }
        });

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        int studentId;
        String studentName;
        String studentAddress;
        String studentSex;
        int studentYos;

        if(resultCode == RESULT_OK){
            studentId = data.getIntExtra("studentId", -1);
            studentName = data.getStringExtra("studentName");
            studentAddress = data.getStringExtra("studentAddress");
            studentSex = data.getStringExtra("studentSex");
            studentYos = data.getIntExtra("studentYos",0);
            mStudentStock.add(new Student(studentId, studentName, studentAddress,studentSex,studentYos));
        }
    }
    public void showProduct(View view){
        ArrayList<String> studentArrayList = new ArrayList<>();
        studentArrayList = Student.getStudentList(mStudentStock);

        Intent intent = new Intent(MainActivity.this, student_list.class);
        intent.putStringArrayListExtra("productList", studentArrayList);
        startActivity(intent);
    }



}
