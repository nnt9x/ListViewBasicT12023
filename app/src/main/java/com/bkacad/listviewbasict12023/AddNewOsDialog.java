package com.bkacad.listviewbasict12023;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

public abstract class AddNewOsDialog extends Dialog {

    private EditText edt;
    private Button btn;

    public abstract void addNewOs(String newOs);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diaglog_add_new_os);
        // Bind id
        btn = findViewById(R.id.btnAddNewOs);
        edt = findViewById(R.id.edt);

        // Dang ki su kien
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String os = edt.getText().toString();
                if(os.isEmpty()){
                    edt.setError("Dữ liệu rỗng");
                    return;
                }
                addNewOs(os);
            }
        });

    }

    public AddNewOsDialog(@NonNull Context context) {
        super(context);
    }
}
