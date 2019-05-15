package com.example.mayank.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean gameon=true;
    ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9;
    int counter=1,i,turns=0;
    int used[] = {0,0,0,0,0,0,0,0,0};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1=(ImageView)findViewById(R.id.img1);
        img2=(ImageView)findViewById(R.id.img2);
        img3=(ImageView)findViewById(R.id.img3);
        img4=(ImageView)findViewById(R.id.img4);
        img5=(ImageView)findViewById(R.id.img5);
        img6=(ImageView)findViewById(R.id.img6);
        img7=(ImageView)findViewById(R.id.img7);
        img8=(ImageView)findViewById(R.id.img8);
        img9=(ImageView)findViewById(R.id.img9);

        Button replay=(Button)findViewById(R.id.replay);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=0;
                if (used[0]==0 && gameon==true) {
                    turn(v,i);
                }
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=1;
                if (used[1]==0 && gameon==true)
                {
                    turn(v,i);

                }

            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=2;
                if (used[2]==0 && gameon==true)
                {
                    turn(v,i);

                }
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=3;
                if (used[3]==0 && gameon==true)
                {
                    turn(v,i);

                }
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=4;
                if (used[4]==0 && gameon==true)
                {
                    turn(v,i);

                }
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=5;
                if (used[5]==0 && gameon==true)
                {
                    turn(v,i); }

            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=6;
                if (used[6]==0 && gameon==true)
                {
                    turn(v,i);
                }
            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=7;
                if (used[7]==0 && gameon==true)
                {
                    turn(v,i);
                }
            }
        });
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=8;
                if (used[8]==0 && gameon==true)
                {
                    turn(v,i);
                }
            }
        });
        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replay();

            }
        });
    }

void turn(View v,int position) {
    ImageView clickedImage = (ImageView) v;
    turns++;
    int winningspots[][] = { { 0, 1, 2},{ 3, 4, 5},{ 6, 7, 8},{ 0, 4, 8},{ 2, 4, 6},{0,3,6},{1,4,7},{2,5,8}};
    int flag=0;
    if (counter == 1) {
        // set X
        clickedImage.setImageResource(R.drawable.red);
        used[position]=1;
        counter = 0;
    } else {
        // set O
        clickedImage.setImageResource(R.drawable.yellow);
        used[position]=2;
        counter = 1;
    }

    clickedImage.setAlpha(1.0f);
    for(int winningspot[]:winningspots)
    {
        if(used[winningspot[0]]==used[winningspot[1]] && used[winningspot[1]]==used[winningspot[2]] && used[winningspot[0]]!=0)
        {
            if(used[winningspot[0]]==1) {
                flag=1;
                Toast.makeText(getApplicationContext(), "Player 1 has won!!", Toast.LENGTH_LONG).show();
                //replay();
                gameon=false;
                break;
            }
            else if(used[winningspot[0]]==2)
            {
                flag=1;
                Toast.makeText(getApplicationContext(),"Player 2 has won!!",Toast.LENGTH_LONG).show();
                //replay();
                gameon=false;
                break;
            }


        }
    }
    if(turns==9 && flag==0) {
        Toast.makeText(getApplicationContext(), "It's a draw :/", Toast.LENGTH_LONG).show();
        //replay();
        gameon=false;
    }
}
void replay(){
        counter=1;
        turns=0;
        gameon=true;
    for(int i=0;i<=8;i++)
    {
        used[i]=0;
    }
    img1.setAlpha(0.0f);
    img2.setAlpha(0.0f);
    img3.setAlpha(0.0f);
    img4.setAlpha(0.0f);
    img5.setAlpha(0.0f);
    img6.setAlpha(0.0f);
    img7.setAlpha(0.0f);
    img8.setAlpha(0.0f);
    img9.setAlpha(0.0f);
}





}