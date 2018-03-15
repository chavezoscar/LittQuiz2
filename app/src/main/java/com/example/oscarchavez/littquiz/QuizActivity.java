package com.example.oscarchavez.littquiz;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

import org.w3c.dom.Text;

public class QuizActivity extends AppCompatActivity {

    private Button mAButton;
    private Button mBButton;
    private Button mCButton;
    private Button mDButton;
    private ImageButton mNextButton;
    private ImageButton mPrevButton;
    private TextView mQuestionTextView;

    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX= "index";



    //private char buttonChar;


    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_modernist, 'A'),
            new Question(R.string.question_postmodernist, 'D'),
            new Question(R.string.question_mice, 'A'),
            new Question(R.string.question_beowulf, 'A'),
            new Question(R.string.question_Hamlet, 'A'),
            new Question(R.string.question_poetry, 'B'),


};

    private int mCurrentIndex = 0;

    private void updateQuestion(){
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called");
        setContentView(R.layout.activity_quiz);

        if (savedInstanceState != null){
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }




        mQuestionTextView = findViewById(R.id.question_text_view);
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);

        //toasts are currently not correct


        updateQuestion();



        mAButton = findViewById(R.id.a_button);
        mAButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                /*buttonChar = 'A';
                Toast correctToast = Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT);
                correctToast.setGravity(Gravity.TOP,0,0);
                correctToast.show();*/
                checkAnswer('A');


            }
        });

        mBButton = findViewById(R.id.b_button);
        mBButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                /*buttonChar = 'B';
                Toast incorrectToast = Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT); //create toast object to allow changes of position
                incorrectToast.setGravity(Gravity.BOTTOM,0,0); //change position of toast
                incorrectToast.show();//display*/
                checkAnswer('B');

            }
        });

        mCButton = findViewById(R.id.c_button);
        mCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*buttonChar = 'C';
                Toast incorrectToast = Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT);
                incorrectToast.setGravity(Gravity.BOTTOM,0,0);
                incorrectToast.show();//display*/
               checkAnswer('C');

            }
        });

        mDButton = findViewById(R.id.d_button);
        mDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* buttonChar = 'D';
                Toast incorrectToast = Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT);
                incorrectToast.setGravity(Gravity.BOTTOM,0,0);
                incorrectToast.show();//display*/
               checkAnswer('D');
            }
        });

        mNextButton = findViewById(R.id.next_button);

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                int question = mQuestionBank[mCurrentIndex].getTextResId();
                updateQuestion();
            }
        });

        mPrevButton = findViewById(R.id.prev_button);

        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mCurrentIndex <= 0) {
                    mCurrentIndex = mQuestionBank.length - 1;
                    int question = mQuestionBank[mCurrentIndex].getTextResId();
                    updateQuestion();
                } else {
                    mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;
                    int question = mQuestionBank[mCurrentIndex].getTextResId();
                    updateQuestion();
                }
            }

        });

    }


    private void checkAnswer(char buttonPressed){
        char questionAnswer = mQuestionBank[mCurrentIndex].getAnswerTrue();
        int message = 0;

        if (buttonPressed == questionAnswer)
            message = R.string.correct_toast;
        else {
            message = R.string.incorrect_toast;
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG, "onStart() Called");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG, "onResume() Called");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG, "onPause() Called");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);


    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "onStop() Called");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy() Called");
    }
}
