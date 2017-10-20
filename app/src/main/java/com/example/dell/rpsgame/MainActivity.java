package com.example.dell.rpsgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageButton b_rock, b_paper, b_scissors;
    ImageView cpu_hand, user_hand;
    String myChoice, cpuChoice, result;
    Random mRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cpu_hand = (ImageView) findViewById(R.id.cpu_hand);
        user_hand = (ImageView) findViewById(R.id.user_hand);

        b_rock = (ImageButton) findViewById(R.id.b_rock);
        b_paper = (ImageButton) findViewById(R.id.b_paper);
        b_scissors = (ImageButton) findViewById(R.id.b_scissors);

        mRandom = new Random();

        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoice = "rock";
                user_hand.setImageResource(R.drawable.rock);
                calculate();
            }
        });
        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoice = "paper";
                user_hand.setImageResource(R.drawable.paper);
                calculate();
            }
        });
        b_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoice = "scissors";
                user_hand.setImageResource(R.drawable.scissors);
                calculate();
            }
        });
    }

    public void calculate() {
        int cpu = mRandom.nextInt(3);
        if (cpu == 0) {
            cpuChoice = "rock";
            cpu_hand.setImageResource(R.drawable.rock);
        } else if (cpu == 1) {
            cpuChoice = "paper";
            cpu_hand.setImageResource(R.drawable.paper);
        } else if (cpu == 2) {
            cpuChoice = "scissors";
            cpu_hand.setImageResource(R.drawable.scissors);
        }
        if (myChoice.equals("rock") && cpuChoice.equals("paper")) {
            result = "you lose";
        } else if (myChoice.equals("paper") && cpuChoice.equals("scissors")) {
            result = "you lose";
        } else if (myChoice.equals("scissors") && cpuChoice.equals("rock")) {
            result = "you lose";
        } else if (myChoice.equals("rock") && cpuChoice.equals("scissors")) {
            result = "you win";
        } else if (myChoice.equals("paper") && cpuChoice.equals("rock")) {
            result = "you win";
        } else if (myChoice.equals("scissors") && cpuChoice.equals("paper")) {
            result = "you win";
        } else if (myChoice.equals("scissors") && cpuChoice.equals("scissors")) {
            result = "Draw";
        } else if (myChoice.equals("paper") && cpuChoice.equals("paper")) {
            result = "Draw";
        } else if (myChoice.equals("rock") && cpuChoice.equals("rock")) {
            result = "Draw";
        }

        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }
}
