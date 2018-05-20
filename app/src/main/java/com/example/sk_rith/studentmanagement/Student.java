package com.example.sk_rith.studentmanagement;

/**
 * Created by SK_Rith on 5/17/2018.
 */
import java.util.ArrayList;
public class Student {
    private Integer id;
    private String name;
    private String sex;
    private String Address;
    private Integer yearOfStudy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Integer getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(Integer yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public Student(int id, String name, String sex, String Address, Integer yearOfStudy){
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.Address = Address;
        this.yearOfStudy = yearOfStudy;
    }



    public static ArrayList<String> getStudentList(ArrayList<Student> ListOfStu){

        ArrayList<String> studentArrayList = new ArrayList<>();
        String studentList;

        for(Student student : ListOfStu){
            studentList = student.getId().toString() + " , ";
            studentList += student.getName().toString() + " , ";
            studentList += student.getSex().toString() + " , ";
            studentList += student.getAddress().toString() + " , ";
            studentList += student.getYearOfStudy().toString();

            studentArrayList.add(studentList);
        }
        return studentArrayList;
    }
}
