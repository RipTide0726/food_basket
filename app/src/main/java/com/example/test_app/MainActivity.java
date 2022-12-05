package com.example.test_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.test_app.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    // Used to load the 'test_app' library on application startup.
    static {
        System.loadLibrary("test_app");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Button btn =  (Button)findViewById(R.id.loginButton);

        btn.setOnClickListener(new View.OnClickListener()
        {
           @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, MenuTest.class));
            }
        });



    }


    /**
     * A native method that is implemented by the 'test_app' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}