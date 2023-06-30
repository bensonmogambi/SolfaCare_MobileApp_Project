package com.example.solfacare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {

    private String[][] packages =
            {
                    {"Package1: Full Body Checkup", "", "", "", "3500"},
                    {"Package2: Blood Chemistry Testing", "", "", "", "7500"},
                    {"Package3: DNA Testing", "", "", "", "20000"},
                    {"Package4: Stool Culture", "", "", "", "3000"},
                    {"Package5: Pap Smear", "", "", "", "5000"}

            };
    private String[][] package_details = {
            {
                    "Blood Chemistry Testing",
                    "lipid profile",
                    "Liver Function Test",
                    "Kidney Function Test",
                    "Iron Studies",
                    "Complete Blood Count"
            },
            {
                    "Covid-19 Antibody Test"
            },
            {
                    "Blood Glucose Test"
            },
            {
                    "Complete Hemogram",
                    "Vitamin D Total",
                    "Liver Function Test",
                    "Kidney Function Test",
                    "Iron Studies",
                    "Complete Blood Count"
            }
    };


    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGoToCart, btnBack;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnBack = findViewById(R.id.buttonLTBack);
        btnGoToCart = findViewById(R.id.buttonLTGoToCart);
        listView = findViewById(R.id.listViewLT);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestActivity.this, HomeActivity.class));

            }

        });

        list = new ArrayList();
        for(int i=0; i<packages.length;i++){
            item = new HashMap<String,String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total Cost:" +packages [i][4]+ "/-");
            list.add(item);

        }
    }
}