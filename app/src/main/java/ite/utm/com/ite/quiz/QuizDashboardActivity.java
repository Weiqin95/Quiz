package ite.utm.com.ite.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import ite.utm.com.ite.R;

public class QuizDashboardActivity extends AppCompatActivity {
    private Button btnB;
    private Button btnI;
    private Button btnExpert;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_quiz_activity);
        btnB = findViewById(R.id.btnB);
        btnI = findViewById(R.id.btnI);
        btnExpert = findViewById(R.id.btnExpert);
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuizDashboardActivity.this, QuizBeginnerActivity.class));
            }
        });
        btnI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnExpert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
