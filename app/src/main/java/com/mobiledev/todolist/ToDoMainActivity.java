package com.mobiledev.todolist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class ToDoMainActivity extends AppCompatActivity {

    private TextView mCurrentdayTextView;
    private EditText mCurrenDayEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_main);

        Button prevDay = (Button) findViewById(R.id.prev_day_button);
        Button nextDay = (Button) findViewById(R.id.next_day_button);
        Button saveButton = (Button) findViewById(R.id.save_middle_button);

        String[] mDaysoWeek = getResources().getStringArray(R.array.days_of_the_week);

        mCurrentdayTextView = (TextView) findViewById(R.id.current_day_textView);
        mCurrenDayEditText = (EditText) findViewById(R.id.input_editText);

        String mCurrentDay = mDaysoWeek[Calendar.DAY_OF_WEEK - 1];
        String mHintEditText = getString(R.string.hint_editText, mDaysoWeek[Calendar.DAY_OF_WEEK - 1]);

        mCurrentdayTextView.setText(mCurrentDay);
        mCurrenDayEditText.setHint(mHintEditText);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.date_toolbar);
        setSupportActionBar(mToolbar);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayShowTitleEnabled(false);

        Spinner dateSpinner = (Spinner) findViewById(R.id.days_of_week);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.days_of_the_week, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        dateSpinner.setAdapter(adapter);
    }
}
