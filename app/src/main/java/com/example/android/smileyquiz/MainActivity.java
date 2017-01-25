package com.example.android.smileyquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.breadCrumbShortTitle;
import static android.R.attr.button;
import static android.R.attr.name;
import static android.R.attr.onClick;
import static android.R.attr.value;
import static android.R.id.button1;
import static com.example.android.smileyquiz.R.id.question2_answer2;
import static com.example.android.smileyquiz.R.id.score;
import static com.example.android.smileyquiz.R.string.answer;
import static com.example.android.smileyquiz.R.string.question;

public class MainActivity extends AppCompatActivity {

    // Global variables for answers to 4 questions.
    String answer1;
    String answer2;
    String answer3;
    String answer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Handling of question 1 with buttons.
     *
     * @param view View to be rendered.
     */
    public void question1(View view) {
        // Get an assigned tag of the tapped button, and if it is "Happy", consider the answer correct.
        String button = (String) view.getTag();
        if (button.equals("Happy")) {
            answer1 = "correct";
        } else answer1 = "wrong";

        // After an answer to question 1 is submitted, the next smiley image (question 2) is shown.
        ImageView imageSmiley = (ImageView) findViewById(R.id.smiley_image);
        imageSmiley.setImageResource(R.drawable.s2);

        // After an answer to question 1 is submitted, the current question block (question 1) is hidden.
        LinearLayout questionBlock1 = (LinearLayout) findViewById(R.id.block_question1);
        questionBlock1.setVisibility(LinearLayout.GONE);

        // After an answer to question 1 is submitted, the next question block (question 2) is shown.
        LinearLayout questionBlock2 = (LinearLayout) findViewById(R.id.block_question2);
        questionBlock2.setVisibility(LinearLayout.VISIBLE);
    }

    /**
     * Handling of question 2 with check boxes.
     *
     * @param view View to be rendered.
     */
    public void question2(View view) {
        // Check which check boxes the user has checked.
        CheckBox option1CheckBox = (CheckBox) findViewById(R.id.question2_answer1);
        boolean isCheckedQ2A1 = option1CheckBox.isChecked();

        CheckBox option2CheckBox = (CheckBox) findViewById(R.id.question2_answer2);
        boolean isCheckedQ2A2 = option2CheckBox.isChecked();

        CheckBox option3CheckBox = (CheckBox) findViewById(R.id.question2_answer3);
        boolean isCheckedQ2A3 = option3CheckBox.isChecked();

        // If the user checked both the 1st and the 3rd check boxes, consider the answer correct, otherwise - wrong.
        if (isCheckedQ2A1){
            if (isCheckedQ2A3) {
                answer2 = "correct";
            } else answer2 = "wrong";
        } else answer2 = "wrong";

        // If the user checked only the 2nd option, consider the answer wrong.
        if (isCheckedQ2A2){
            answer2 = "wrong";
        }

        // After an answer to question 2 is submitted, the next smiley image (question 3) is shown.
        ImageView imageSmiley = (ImageView) findViewById(R.id.smiley_image);
        imageSmiley.setImageResource(R.drawable.s3);

        // After an answer to question 2 is submitted, the current question block (question 2) is hidden.
        LinearLayout questionBlock2 = (LinearLayout) findViewById(R.id.block_question2);
        questionBlock2.setVisibility(LinearLayout.GONE);

        // After an answer to question 2 is submitted, the next question block (question 3) is shown.
        LinearLayout questionBlock3 = (LinearLayout) findViewById(R.id.block_question3);
        questionBlock3.setVisibility(LinearLayout.VISIBLE);
    }

    /**
     * Handling of question 3 with an input field.
     *
     * @param view View to be rendered.
     */
    public void question3(View view) {
        // Get the typed answer by the user and convert it to lower case.
        EditText question3 = (EditText) findViewById(R.id.question3_typed);
        String question3_answer = question3.getText().toString().toLowerCase();
        if (question3_answer.equals("angry")) {
            answer3 = "correct";
        } else answer3 = "wrong";

        // After an answer to question 3 is submitted, the next smiley image (question 4) is shown.
        ImageView imageSmiley = (ImageView) findViewById(R.id.smiley_image);
        imageSmiley.setImageResource(R.drawable.s4);

        // After an answer to question 3 is submitted, the current question block (question 4) is hidden.
        LinearLayout questionBlock3 = (LinearLayout) findViewById(R.id.block_question3);
        questionBlock3.setVisibility(LinearLayout.GONE);

        // After an answer to question 3 is submitted, the next question block (question 4) is shown.
        LinearLayout questionBlock4 = (LinearLayout) findViewById(R.id.block_question4);
        questionBlock4.setVisibility(LinearLayout.VISIBLE);
    }

    /**
     * Handling of question 4 with radio buttons.
     *
     * @param view View to be rendered.
     */
    public void question4(View view) {
        // Check which radio button the user has selected.
        RadioButton option1RadioButton = (RadioButton) findViewById(R.id.question4_answer1);
        boolean isCheckedQ4A1 = option1RadioButton.isChecked();

        RadioButton option2RadioButton = (RadioButton) findViewById(R.id.question4_answer2);
        boolean isCheckedQ4A2 = option2RadioButton.isChecked();

        RadioButton option3RadioButton = (RadioButton) findViewById(R.id.question4_answer3);
        boolean isCheckedQ4A3 = option3RadioButton.isChecked();

        // If the user selected the 2nd radio button, consider the answer correct, otherwise - wrong.
        if (isCheckedQ4A2){
            answer4 = "correct";
        } else answer4 = "wrong";

        // If the user selected the 1st or the 3rd radio buttons, consider the answer wrong.
        if (isCheckedQ4A1){
            answer4 = "wrong";
        }

        if (isCheckedQ4A3){
            answer4 = "wrong";
        }

        // After an answer to question 4 is submitted, the final smiley image is shown.
        ImageView imageSmiley = (ImageView) findViewById(R.id.smiley_image);
        imageSmiley.setImageResource(R.drawable.s5);

        // After an answer to question 4 is submitted, the current question block (question 4) is hidden.
        LinearLayout questionBlock4 = (LinearLayout) findViewById(R.id.block_question4);
        questionBlock4.setVisibility(LinearLayout.GONE);

        // After an answer to question 4 is submitted, the question text is hidden.
        TextView questionText = (TextView) findViewById(R.id.question_text);
        questionText.setVisibility(LinearLayout.GONE);

        // After an answer to question 4 is submitted, the text block with the "Show score" button is shown.
        LinearLayout summary = (LinearLayout) findViewById(R.id.block_summary);
        summary.setVisibility(LinearLayout.VISIBLE);
    }

    /**
     * Calculate score after all questions have been answered.
     *
     * @param answer1 shows whether answer 1 was correct.
     * @param answer2 shows whether answer 2 was correct.
     * @param answer3 shows whether answer 3 was correct.
     * @param answer4 shows whether answer 3 was correct.
     * @return returns the calculated score.
     */
    public int calculateScore(String answer1, String answer2, String answer3, String answer4) {
        int score = 0;
        // If an answer to each question is correct, add 1 point to the score.
        if (answer1.equals("correct")) {
            score = score + 1;
        }
        if (answer2.equals("correct")) {
            score = score + 1;
        }
        if (answer3.equals("correct")) {
            score = score + 1;
        }
        if (answer4.equals("correct")) {
            score = score + 1;
        }
        return score;
    }

    /**
     * Show the score when the "Show score" button is tapped.
     *
     * @param view View to be rendered.
     */
    public void showScore(View view) {
        // Calculate the number of correct answers after the "Show score" button is tapped.
        Button button = (Button) findViewById(R.id.score);
        int score = calculateScore(answer1, answer2, answer3, answer4);
        // Convert the correct answer-to-question ratio to percentage.
        float percentage = score * 100 / 4;
        // Show the percentage score in a toast
        Toast.makeText(this, "Your score: " + percentage + "%", Toast.LENGTH_SHORT).show();
    }

}
