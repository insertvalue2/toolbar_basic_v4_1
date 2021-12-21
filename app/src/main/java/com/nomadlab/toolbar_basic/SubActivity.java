package com.nomadlab.toolbar_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Button button = findViewById(R.id.btnEnd);

        // 값을 꺼내는 방법
        int value1 = getIntent().getIntExtra("value1", 0);

        button.setOnClickListener(view -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("result", value1 + 10);
            setResult(Activity.RESULT_OK, resultIntent);
            finish(); // activity 종료
        });
    }
}