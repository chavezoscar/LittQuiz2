package com.example.oscarchavez.littquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {


    private static final String EXTRA_ANSWER_IS_A = "com.example.oscarchavez.littquiz.answer_is_true";
    private static final String EXTRA_ANSWER_IS_B = "com.example.oscarchavez.littquiz.answer_is_true";

    private char mAnswerIsTrue;
    private TextView mAnswerTextView;
    private Button mShowAnswerButton;

    public static Intent newIntent(Context packageContext, char answerIsTrue){
        Intent intent = new Intent(packageContext, CheatActivity.class);
        intent.putExtra(EXTRA_ANSWER_IS_A, 'a');
        intent.putExtra(EXTRA_ANSWER_IS_B, 'b');
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAnswerIsTrue = getIntent().getCharExtra(EXTRA_ANSWER_IS_A, 'a');
        mAnswerIsTrue = getIntent().getCharExtra(EXTRA_ANSWER_IS_A, 'b');

        mAnswerTextView = findViewById(R.id.answer_text_view);

        mShowAnswerButton = findViewById(R.id.show_answer_button);
        mShowAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mAnswerIsTrue == 'a'){
                    mAnswerTextView.setText(R.string.a_button);
                }
                else if (mAnswerIsTrue == 'b'){
                    mAnswerTextView.setText(R.string.b_button);
                }
                else {
                    mAnswerTextView.setText(R.string.incorrect_toast);
                }
            }
        });
    }
}
