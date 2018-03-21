package com.example.oscarchavez.littquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {


    private static final String EXTRA_ANSWER = "com.example.oscarchavez.littquiz.answer_is_true";

    private char mAnswerIsTrue;
    private TextView mAnswerTextView;
    private Button mShowAnswerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAnswerIsTrue = getIntent().getCharExtra(EXTRA_ANSWER, 'k');

        mAnswerTextView = findViewById(R.id.answer_text_view);
        mShowAnswerButton = findViewById(R.id.show_answer_button);

        mShowAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mAnswerIsTrue == 'A'){
                    mAnswerTextView.setText("A");
                }
                else if (mAnswerIsTrue == 'B'){
                    mAnswerTextView.setText("B");
                }
                else if (mAnswerIsTrue == 'C'){
                    mAnswerTextView.setText("C");
                }
                else if (mAnswerIsTrue == 'D'){
                    mAnswerTextView.setText("D");
                }
            }

        });
    }





    public static Intent newIntent(Context packageContext, char answer){
        Intent i = new Intent(packageContext, CheatActivity.class);//send context and class
        i.putExtra(EXTRA_ANSWER, answer);
        return i;
    }

}
