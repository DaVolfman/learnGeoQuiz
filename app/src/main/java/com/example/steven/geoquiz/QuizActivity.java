package com.example.steven.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class QuizActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;

    private TFQuestion[] mQuestionBank = new TFQuestion[] {
            new TFQuestion(R.string.question_australia, true),
            new TFQuestion(R.string.question_oceans, true),
            new TFQuestion(R.string.question_mideast, false),
            new TFQuestion(R.string.question_africa, false),
            new TFQuestion(R.string.question_americas, true),
            new TFQuestion(R.string.question_americas, true)
    };
    private int mQuestionIndex = 0;

    private void updateQuestionText(){
        int t = mQuestionBank[mQuestionIndex].getTextResID();
        mQuestionTextView.setText(t);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mNextButton = (Button) findViewById(R.id.next_button);
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);

        updateQuestionText();

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mQuestionIndex == (mQuestionBank.length-1)){
                    mQuestionIndex = 0;
                }else{
                    mQuestionIndex++;
                }
                updateQuestionText();
            }
        });

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mQuestionBank[mQuestionIndex].isAnswerTrue())
                    Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mQuestionBank[mQuestionIndex].isAnswerTrue())
                    Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
