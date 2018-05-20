package com.example.sk_rith.studentmanagement;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentListAdapter extends BaseAdapter {

    private final Activity context;
    private final ArrayList<String> students;

    public StudentListAdapter(Activity context, ArrayList<String> students)
    {
        this.context = context;
        this.students = students;
    }

    class ViewHolder{
        public TextView id,name,gender,address,yos;
    }


    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int i) {
        return students.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if(rowView==null)
        {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.activity_student_list_adapter,null);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.id = rowView.findViewById(R.id.list_id);
            viewHolder.name = rowView.findViewById(R.id.list_name);
            viewHolder.gender = rowView.findViewById(R.id.list_sex);
            viewHolder.address = rowView.findViewById(R.id.list_address);
            viewHolder.yos = rowView.findViewById(R.id.list_yos);
            rowView.setTag(viewHolder);

        }

        ViewHolder holder = (ViewHolder) rowView.getTag();
        String[] s = students.get(position).split(",");
        holder.id.setText(s[0]);
        holder.name.setText(s[1]);
        holder.gender.setText(s[2]);
        holder.address.setText(s[3]);
        holder.yos.setText(s[4]);

        return rowView;



    }
}
