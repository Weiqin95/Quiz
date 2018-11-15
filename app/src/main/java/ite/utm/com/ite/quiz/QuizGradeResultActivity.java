package ite.utm.com.ite.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ite.utm.com.ite.R;

public class QuizGradeResultActivity extends AppCompatActivity {
    private String truePoint;
    private TextView tvScore;
    private TextView tvCorrect;
    private TextView tvIncorrect;
    private Button btnCondition;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grade_result_activity);
        Bundle bundle = getIntent().getExtras();
        int truePoint = bundle.getInt("truePoint");
        int countQuiz = bundle.getInt("countQuiz");
        float result = (float) truePoint / countQuiz;
        tvScore = findViewById(R.id.tvScore);
        tvScore.setText("Score : " + result);

        tvCorrect = findViewById(R.id.tvCorrect);
        tvCorrect.setText("Correct : " + truePoint);
        tvIncorrect = findViewById(R.id.tvIncorrect);
        int inc = countQuiz - truePoint;
        tvIncorrect.setText("Incorrect : " + inc);
        btnCondition = findViewById(R.id.btnCondition);

        if (countQuiz == 3) {
            if (truePoint >= 2) {
                btnCondition.setText("Lanjut");
                btnCondition.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(QuizGradeResultActivity.this, QuizDashboardActivity.class));
                    }
                });
            } else {
                btnCondition.setText("Try Again");
                btnCondition.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(QuizGradeResultActivity.this, QuizBeginnerActivity.class));
                    }
                });
            }
        } else {

        }


    }
}
