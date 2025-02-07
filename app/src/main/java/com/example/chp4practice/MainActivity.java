package com.example.chp4practice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private String []Questions={"Is Java a statically typed language?","Can a Java class have multiple public classes?","Does Java support multiple inheritance using classes?","Is the main method in Java always public static void main(String[] args)?",
    "Can a constructor in Java be final?","Does Java support method overloading?","Is String in Java mutable? ","Does Java allow operator overloading? ",
    "Can we use this keyword inside a static method? "};
    private boolean []Answers={true,false,false,true,false,true,false,false,false};

    private int Score=0;


    TextView question;
    private int index=0;
    Button Yes;
    Button No;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Yes=findViewById(R.id.button);
        No=findViewById(R.id.button2);

        question=findViewById(R.id.textView3);
        question.setText(Questions[index]);

        Yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (index < Questions.length) {

                    if (Answers[index] == true) {
                        Score++;
                    }
                    question.setText(Questions[index++]);
                }
                else{
                    Toast.makeText(MainActivity.this, "your score is= "+Score, Toast.LENGTH_SHORT).show();
                }
            }
        });

        No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (index < Questions.length) {

                    if (Answers[index] == false) {
                        Score++;
                    }
                    question.setText(Questions[index++]);
                }
                else {
                    Toast.makeText(MainActivity.this, "your score is= "+Score, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}