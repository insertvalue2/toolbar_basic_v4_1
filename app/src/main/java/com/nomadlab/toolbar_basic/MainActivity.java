package com.nomadlab.toolbar_basic;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView helloTv;
    ActivityResultLauncher<Intent> startActivityResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Log.d("TAG", " comeback 돌아왔다. ");
                    Intent resultData = result.getData();
                    int returnValue = resultData.getIntExtra("result", 0);
                    helloTv.setText(String.valueOf(returnValue));
                    Log.d("TAG", "returnValue : " + returnValue);
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        helloTv = findViewById(R.id.helloTv);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuItem1:
                Log.d("TAG", "menu1 selected");
                Intent intent = new Intent(this, SubActivity.class);
                intent.putExtra("value1", 10);
                startActivityResult.launch(intent);
                break;
            case R.id.menuITem2:
                Log.d("TAG", "menu2 selected");
                break;
            case R.id.menuItem3:
                Log.d("TAG", "menu3 selected");
                break;
        }
        return true;
    }
}