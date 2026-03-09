package com.example.starrail;

import android.content.Intent;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class trip_info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_trip_info);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView Page_Title = findViewById(R.id.page_info_name);
        TextView Page_Description = findViewById(R.id.page_info_description);
        TextView Page_Price = findViewById(R.id.page_info_price);
        Intent intent = getIntent();
        model_trip Data = (model_trip) intent.getSerializableExtra("TRIP_INFO");
        if(Data != null){
            Page_Title.setText(Data.getTrip_name());
            Page_Description.setText(Data.getTrip_description());
            Page_Price.setText("Fare: PHP" + String.valueOf(Data.getTrip_price()));
        }
        MaterialButton button_bookTrip = findViewById(R.id.bookTrip);
        button_bookTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sheet_book sheet = new sheet_book();
                sheet.show(getSupportFragmentManager(), "BookTrip");
            }
        });
        MaterialButton button_reportTrip = findViewById(R.id.reportTrip);
        button_reportTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                window_report window = new window_report();
                window.show(getSupportFragmentManager(), "ReportTrip");
            }
        });

        MaterialButton button_infoTrip = findViewById(R.id.infoTrip);
        button_infoTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sheet_info window = new sheet_info();
                window.show(getSupportFragmentManager(), "InfoTrip");
            }
        });
    }
}