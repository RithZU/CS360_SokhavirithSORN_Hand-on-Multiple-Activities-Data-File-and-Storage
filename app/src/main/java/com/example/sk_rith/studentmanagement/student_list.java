package com.example.sk_rith.studentmanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class student_list extends AppCompatActivity {


    private ListView studentListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        setTitle("Student's List");
        studentListView = (ListView) findViewById(R.id.student_list_view);
        ArrayList<String> studentList = new ArrayList<>();

        Scanner scan = null;
        try {
            scan = new Scanner(openFileInput("students.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



        while (scan.hasNextLine()) {
            studentList.add(scan.nextLine());
        }

        StudentListAdapter stuAdapter = new StudentListAdapter(this,studentList);
        studentListView.setAdapter(stuAdapter);


    }
}
