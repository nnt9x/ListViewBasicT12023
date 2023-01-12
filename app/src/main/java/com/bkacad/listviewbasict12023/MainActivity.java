package com.bkacad.listviewbasict12023;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvOs;

    // Data
    private List<String> dataSource;
    // Adapter
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvOs = findViewById(R.id.lvOs);

        // Add data
        dataSource = new ArrayList<>();
        dataSource.add("Android");
        dataSource.add("Windows 7");
        dataSource.add("Windows 8");
        dataSource.add("Windows 10");
        dataSource.add("Windows 11");

        // Tao ra Adapter
        arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, dataSource);

        // Set Adapter cho listview
        lvOs.setAdapter(arrayAdapter);

        // Dang ki lang nghe su kien onlick
        lvOs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, dataSource.get(i).toUpperCase(),Toast.LENGTH_SHORT ).show();
            }
        });
        // Su kien long click
        lvOs.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Cảnh báo")
                        .setMessage("Bạn có muốn xoá bản ghi " + i)
                        .setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int j) {
                                // Xoá trong dataSource -> báo dữ liệu thay đổi
                                dataSource.remove(i);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        })
                        .create()
                        .show();
                return false;
            }
        });
    }
}