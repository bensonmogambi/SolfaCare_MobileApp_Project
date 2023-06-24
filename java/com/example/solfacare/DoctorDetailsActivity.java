package com.example.solfacare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private final String[][] doctor_details1 =
            {
                    {"Doctor Name: Boaz Mogambi", "Hospital Address: Nairobi", "Exp: 6yrs","Mobile No: +254705641405", "500" },
                    {"Doctor Name: Lawrence Omondi", "Hospital Address: Kisumu", "Exp: 10yrs","Mobile No: +254705641405", "500" },
                    {"Doctor Name: Keziah Keya", "Hospital Address: USA", "Exp: 6yrs","Mobile No: +254705641405", "500" },
                    {"Doctor Name: Benson Maengu", "Hospital Address: Nakuru", "Exp: 16yrs","Mobile No: +254705641405", "500" },
                    {"Doctor Name: Kevin Onkoba", "Hospital Address: Narok", "Exp: 1yrs","Mobile No: +254705641405", "500" }
            };

    private final String[][] doctor_details2 =
            {
                    {"Doctor Name: Boaz Mogambi", "Hospital Address: Nairobi", "Exp: 6yrs","Mobile No: +254705641405", "700" },
                    {"Doctor Name: Lawrence Omondi", "Hospital Address: Kisumu", "Exp: 10yrs","Mobile No: +254705641405", "600" },
                    {"Doctor Name: Keziah Keya", "Hospital Address: USA", "Exp: 6yrs","Mobile No: +254705641405", "500" },
                    {"Doctor Name: Benson Maengu", "Hospital Address: Nakuru", "Exp: 16yrs","Mobile No: +254705641405", "500" },
                    {"Doctor Name: Kevin Onkoba", "Hospital Address: Narok", "Exp: 3yrs","Mobile No: +254705641405", "400" }
            };

    private final String[][] doctor_details3 =
            {
                    {"Doctor Name: Boaz Mogambi", "Hospital Address: Nairobi", "Exp: 4yrs","Mobile No: +254705641405", "700" },
                    {"Doctor Name: Lawrence Omondi", "Hospital Address: Kisumu", "Exp: 5yrs","Mobile No: +254705641405", "500" },
                    {"Doctor Name: Keziah Keya", "Hospital Address: USA", "Exp: 6yrs","Mobile No: +254705641405", "500" },
                    {"Doctor Name: Benson Maengu", "Hospital Address: Nakuru", "Exp: 7yrs","Mobile No: +254705641405", "500" },
                    {"Doctor Name: Kevin Onkoba", "Hospital Address: Narok", "Exp: 8yrs","Mobile No: +254705641405", "500" }
            };

    private final String[][] doctor_details4 =
            {
                    {"Doctor Name: Boaz Mogambi", "Hospital Address: Nairobi", "Exp: 6yrs","Mobile No: +254705641405", "1000" },
                    {"Doctor Name: Lawrence Omondi", "Hospital Address: Kisumu", "Exp: 10yrs","Mobile No: +254705641405", "500" },
                    {"Doctor Name: Keziah Keya", "Hospital Address: USA", "Exp: 6yrs","Mobile No: +254705641405", "100" },
                    {"Doctor Name: Benson Maengu", "Hospital Address: Nakuru", "Exp: 16yrs","Mobile No: +254705641405", "500" },
                    {"Doctor Name: Kevin Onkoba", "Hospital Address: Narok", "Exp: 1yrs","Mobile No: +254705641405", "400" }
            };

    private final String[][] doctor_details5 =
            {
                    {"Doctor Name: Boaz Mogambi", "Hospital Address: Nairobi", "Exp: 4yrs","Mobile No: +254705641405", "900" },
                    {"Doctor Name: Lawrence Omondi", "Hospital Address: Kisumu", "Exp: 1yrs","Mobile No: +254705641405", "900" },
                    {"Doctor Name: Keziah Keya", "Hospital Address: USA", "Exp: 7yrs","Mobile No: +254705641405", "900" },
                    {"Doctor Name: Benson Maengu", "Hospital Address: Nakuru", "Exp: 16yrs","Mobile No: +254705641405", "900" },
                    {"Doctor Name: Kevin Onkoba", "Hospital Address: Narok", "Exp: 10yrs","Mobile No: +254705641405", "900" }
            };

    TextView tv;
    Button btn;
    String[][] getDoctor_details = {};
    private String[][] doctor_details;
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians") == 0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician") == 0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist") == 0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon") == 0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));

            }
        });

        list = new ArrayList<>();
        for(int i=0; i<doctor_details.length; i++){
            item = new HashMap<String,String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees:" +doctor_details [i][4]+ "/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
                );
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                    Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                    it.putExtra("text1", title);
                    it.putExtra("text2", doctor_details[i][0]);
                    it.putExtra("text3", doctor_details[i][1]);
                    it.putExtra("text4", doctor_details[i][3]);
                    it.putExtra("text5", doctor_details[i][4]);
                    startActivity(it);

            }
        });


    }
}