package ite.utm.com.ite.quiz;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ite.utm.com.ite.R;
import ite.utm.com.ite.model.Quiz;

public class QuizBeginnerActivity extends AppCompatActivity {
    private ArrayList<Quiz> listQuiz;
    private TextView tvQuestion;
    private Button btnA;
    private Button btnB;
    private Button btnC;
    private Button btnD;
    private int index = 0;
    private int truePoint = 0;
    private ImageView ivHelp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beginner_activity);

        listQuiz = new ArrayList<Quiz>() {
            {
                add(new Quiz("question1", "1C", "1A", "1B", "1C", "1D", "beginner", "SfJnHdBC-X8&t=317s"));
                add(new Quiz("question2", "1D", "1A", "1B", "1C", "1D", "beginner", "4uOHQ7mO-Kk"));
                add(new Quiz("question3", "1A", "1A", "1B", "1C", "1D", "beginner", "SfJnHdBC-X8&t=317s"));
            }
        };

        initView();
    }

    private void initView() {
        tvQuestion = findViewById(R.id.tvQuestion);
        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);
        btnD = findViewById(R.id.btnD);
        ivHelp = findViewById(R.id.ivHelp);
        initQuestion();


        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnA.getText().equals(listQuiz.get(index).answer)) {
                    truePoint = truePoint + 1;
                }
                initQuestion();
                if (index < listQuiz.size() - 1) {
                    index = index + 1;
                    initQuestion();
                } else {
                    Toast.makeText(QuizBeginnerActivity.this, "Selesai", Toast.LENGTH_SHORT).show();
                    initResult();
                }
            }
        });
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnB.getText().equals(listQuiz.get(index).answer)) {
                    truePoint = truePoint + 1;
                }
                if (index < listQuiz.size() - 1) {
                    index = index + 1;
                    initQuestion();
                } else {
                    Toast.makeText(QuizBeginnerActivity.this, "Selesai", Toast.LENGTH_SHORT).show();
                    initResult();
                }

            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnC.getText().equals(listQuiz.get(index).answer)) {
                    truePoint = truePoint + 1;
                }
                initQuestion();
                if (index < listQuiz.size() - 1) {
                    index = index + 1;
                    initQuestion();
                } else {
                    Toast.makeText(QuizBeginnerActivity.this, "Selesai", Toast.LENGTH_SHORT).show();
                    initResult();
                }
            }
        });
        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnD.getText().equals(listQuiz.get(index).answer)) {
                    truePoint = truePoint + 1;
                }
                initQuestion();
                if (index < listQuiz.size() - 1) {
                    index = index + 1;
                    initQuestion();
                } else {
                    Toast.makeText(QuizBeginnerActivity.this, "Selesai", Toast.LENGTH_SHORT).show();
                    initResult();
                }
            }
        });
    }

    private void initResult() {
        Intent intent = new Intent(this, QuizGradeResultActivity.class);
        intent.putExtra("truePoint", truePoint);
        intent.putExtra("countQuiz", listQuiz.size());
        startActivity(intent);
        finish();
    }

    private void initQuestion() {
        tvQuestion.setText(listQuiz.get(index).question);
        btnA.setText(listQuiz.get(index).optionA);
        btnB.setText(listQuiz.get(index).optionB);
        btnC.setText(listQuiz.get(index).optionC);
        btnD.setText(listQuiz.get(index).optionD);

        ivHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + listQuiz.get(index).urlLink));
                Intent webIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.youtube.com/watch?v=" + listQuiz.get(index).urlLink));
                try {
                    startActivity(appIntent);
                } catch (ActivityNotFoundException ex) {
                    startActivity(webIntent);
                }
            }
        });
    }
}
