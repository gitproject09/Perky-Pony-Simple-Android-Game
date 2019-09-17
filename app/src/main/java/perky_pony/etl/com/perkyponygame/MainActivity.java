package perky_pony.etl.com.perkyponygame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    DrawTheBird view;

    static TextView score_board, high_score, new_high_score, your_score;

    static TextView congratulations, entered, level, tap;

    static SoundPool sp;

    static int[] spids = new int[5];

    static Button restart, share_button, contBtn, vob_button;
    static SharedPreferences sharedPref;
    static SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //  requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        view           = (DrawTheBird) findViewById(R.id.drawthebird);
        score_board    = (TextView)    findViewById(R.id.score_board);
        restart        = (Button)      findViewById(R.id.restart_button);
        share_button   = (Button)      findViewById(R.id.share);
        high_score     = (TextView)    findViewById(R.id.high_score);
        your_score     = (TextView)    findViewById(R.id.your_score);
        new_high_score = (TextView)    findViewById(R.id.new_high_score);

        vob_button     = (Button)      findViewById(R.id.btn_vob);


        congratulations = (TextView) findViewById(R.id.tvCongrates);
        entered         = (TextView) findViewById(R.id.tvEntered);
        level           = (TextView) findViewById(R.id.tvLevel);
        tap             = (TextView) findViewById(R.id.tvTap);

        contBtn         = (Button)   findViewById(R.id.contBtn);

        congratulations.setVisibility(View.GONE);
        entered.setVisibility(View.GONE);
        level.setVisibility(View.GONE);
        tap.setVisibility(View.GONE);
        contBtn.setVisibility(View.GONE);

        your_score.setVisibility(View.GONE);
        new_high_score.setVisibility(View.GONE);
        restart.setVisibility(View.GONE);
        share_button.setVisibility(View.GONE);
        high_score.setVisibility(View.GONE);

        vob_button.setVisibility(View.GONE);

        sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        spids[0] = sp.load(this, R.raw.sfx_hit, 1);    // hit sound
        spids[1] = sp.load(this, R.raw.sfx_point, 1); // passes sound
        spids[2] = sp.load(this, R.raw.sfx_wing, 1); // wing sound


        sharedPref = getSharedPreferences("highscore", 0);
        editor = sharedPref.edit();
        high_score.setText("Best : " + Integer.toString(sharedPref.getInt("high_score", 0)));
        level.setText("Level : " + Integer.toString(DrawTheBird.x_velocity - 3));
        restart.setOnClickListener(this);
        contBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

        switch (v.getId()) {

            case R.id.restart_button:

                congratulations.setVisibility(View.GONE);
                entered.setVisibility(View.GONE);
                level.setVisibility(View.GONE);
                tap.setVisibility(View.GONE);
                contBtn.setVisibility(View.GONE);

                your_score.setVisibility(View.GONE);
                new_high_score.setVisibility(View.GONE);
                restart.setVisibility(View.GONE);
                share_button.setVisibility(View.GONE);
                vob_button.setVisibility(View.GONE);
                high_score.setVisibility(View.GONE);

                if(DrawTheBird.x_velocity  == 6){

                    DrawTheBird.background = BitmapFactory.decodeResource(getResources(), R.drawable.bg1);

                    DrawTheBird.bottom_block     = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block1);
                    DrawTheBird.top_block        = BitmapFactory.decodeResource(getResources(), R.drawable.top_block1);

                    DrawTheBird.bottom_block_2   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block1);
                    DrawTheBird.top_block_2      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block1);

                    DrawTheBird.bottom_block_3   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block1);
                    DrawTheBird.top_block_3      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block1);

                    DrawTheBird.bottom_block_4   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block1);
                    DrawTheBird.top_block_4      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block1);
                }

                else if(DrawTheBird.x_velocity  == 7){

                    DrawTheBird.background = BitmapFactory.decodeResource(getResources(), R.drawable.bg2);

                    DrawTheBird.bottom_block     = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block2);
                    DrawTheBird.top_block        = BitmapFactory.decodeResource(getResources(), R.drawable.top_block2);

                    DrawTheBird.bottom_block_2   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block2);
                    DrawTheBird.top_block_2      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block2);

                    DrawTheBird.bottom_block_3   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block2);
                    DrawTheBird.top_block_3      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block2);

                    DrawTheBird.bottom_block_4   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block2);
                    DrawTheBird.top_block_4      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block2);
                }

                else if(DrawTheBird.x_velocity  == 8){

                    DrawTheBird.background = BitmapFactory.decodeResource(getResources(), R.drawable.bg3);

                    DrawTheBird.bottom_block     = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block3);
                    DrawTheBird.top_block        = BitmapFactory.decodeResource(getResources(), R.drawable.top_block3);

                    DrawTheBird.bottom_block_2   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block3);
                    DrawTheBird.top_block_2      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block3);

                    DrawTheBird.bottom_block_3   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block3);
                    DrawTheBird.top_block_3      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block3);

                    DrawTheBird.bottom_block_4   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block3);
                    DrawTheBird.top_block_4      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block3);
                }

                else if(DrawTheBird.x_velocity  == 9){

                    DrawTheBird.background = BitmapFactory.decodeResource(getResources(), R.drawable.bg4);

                    DrawTheBird.bottom_block     = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block4);
                    DrawTheBird.top_block        = BitmapFactory.decodeResource(getResources(), R.drawable.top_block4);

                    DrawTheBird.bottom_block_2   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block4);
                    DrawTheBird.top_block_2      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block4);

                    DrawTheBird.bottom_block_3   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block4);
                    DrawTheBird.top_block_3      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block4);

                    DrawTheBird.bottom_block_4   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block4);
                    DrawTheBird.top_block_4      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block4);
                }

                else if(DrawTheBird.x_velocity  == 10){

                    DrawTheBird.background = BitmapFactory.decodeResource(getResources(), R.drawable.bg5);

                    DrawTheBird.bottom_block     = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block5);
                    DrawTheBird.top_block        = BitmapFactory.decodeResource(getResources(), R.drawable.top_block5);

                    DrawTheBird.bottom_block_2   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block5);
                    DrawTheBird.top_block_2      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block5);

                    DrawTheBird.bottom_block_3   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block5);
                    DrawTheBird.top_block_3      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block5);

                    DrawTheBird.bottom_block_4   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block5);
                    DrawTheBird.top_block_4      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block5);
                }

                else if(DrawTheBird.x_velocity  == 11){

                    DrawTheBird.background = BitmapFactory.decodeResource(getResources(), R.drawable.bg6);

                    DrawTheBird.bottom_block     = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block6);
                    DrawTheBird.top_block        = BitmapFactory.decodeResource(getResources(), R.drawable.top_block6);

                    DrawTheBird.bottom_block_2   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block6);
                    DrawTheBird.top_block_2      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block6);

                    DrawTheBird.bottom_block_3   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block6);
                    DrawTheBird.top_block_3      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block6);

                    DrawTheBird.bottom_block_4   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block6);
                    DrawTheBird.top_block_4      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block6);
                }

                else if(DrawTheBird.x_velocity  == 12){

                    DrawTheBird.background = BitmapFactory.decodeResource(getResources(), R.drawable.bg7);

                    DrawTheBird.bottom_block     = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block7);
                    DrawTheBird.top_block        = BitmapFactory.decodeResource(getResources(), R.drawable.top_block7);

                    DrawTheBird.bottom_block_2   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block7);
                    DrawTheBird.top_block_2      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block7);

                    DrawTheBird.bottom_block_3   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block7);
                    DrawTheBird.top_block_3      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block7);

                    DrawTheBird.bottom_block_4   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block7);
                    DrawTheBird.top_block_4      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block7);
                }

                else if(DrawTheBird.x_velocity  == 13){

                    DrawTheBird.background = BitmapFactory.decodeResource(getResources(), R.drawable.bg8);

                    DrawTheBird.bottom_block     = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block8);
                    DrawTheBird.top_block        = BitmapFactory.decodeResource(getResources(), R.drawable.top_block8);

                    DrawTheBird.bottom_block_2   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block8);
                    DrawTheBird.top_block_2      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block8);

                    DrawTheBird.bottom_block_3   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block8);
                    DrawTheBird.top_block_3      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block8);

                    DrawTheBird.bottom_block_4   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block8);
                    DrawTheBird.top_block_4      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block8);
                }

                else if(DrawTheBird.x_velocity  == 14){

                    DrawTheBird.background = BitmapFactory.decodeResource(getResources(), R.drawable.bg9);

                    DrawTheBird.bottom_block     = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block9);
                    DrawTheBird.top_block        = BitmapFactory.decodeResource(getResources(), R.drawable.top_block9);

                    DrawTheBird.bottom_block_2   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block9);
                    DrawTheBird.top_block_2      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block9);

                    DrawTheBird.bottom_block_3   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block9);
                    DrawTheBird.top_block_3      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block9);

                    DrawTheBird.bottom_block_4   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block9);
                    DrawTheBird.top_block_4      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block9);
                }

                else if(DrawTheBird.x_velocity  == 15){

                    DrawTheBird.background       = BitmapFactory.decodeResource(getResources(), R.drawable.bg10);

                    DrawTheBird.bottom_block     = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block10);
                    DrawTheBird.top_block        = BitmapFactory.decodeResource(getResources(), R.drawable.top_block10);

                    DrawTheBird.bottom_block_2   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block10);
                    DrawTheBird.top_block_2      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block10);

                    DrawTheBird.bottom_block_3   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block10);
                    DrawTheBird.top_block_3      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block10);

                    DrawTheBird.bottom_block_4   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block10);
                    DrawTheBird.top_block_4      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block10);
                }

                else if(DrawTheBird.x_velocity  == 16){

                    DrawTheBird.background       = BitmapFactory.decodeResource(getResources(), R.drawable.bg11);

                    DrawTheBird.bottom_block     = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block11);
                    DrawTheBird.top_block        = BitmapFactory.decodeResource(getResources(), R.drawable.top_block11);

                    DrawTheBird.bottom_block_2   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block11);
                    DrawTheBird.top_block_2      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block11);

                    DrawTheBird.bottom_block_3   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block11);
                    DrawTheBird.top_block_3      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block11);

                    DrawTheBird.bottom_block_4   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block11);
                    DrawTheBird.top_block_4      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block11);
                }

                else if(DrawTheBird.x_velocity  >= 17){

                    DrawTheBird.background = BitmapFactory.decodeResource(getResources(), R.drawable.bg);

                    DrawTheBird.bottom_block     = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block);
                    DrawTheBird.top_block        = BitmapFactory.decodeResource(getResources(), R.drawable.top_block);

                    DrawTheBird.bottom_block_2   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block);
                    DrawTheBird.top_block_2      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block);

                    DrawTheBird.bottom_block_3   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block);
                    DrawTheBird.top_block_3      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block);

                    DrawTheBird.bottom_block_4   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block);
                    DrawTheBird.top_block_4      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block);
                }

                //DrawTheBird.x_velocity = 3;
                DrawTheBird.score = DrawTheBird.temp_score;
                //	DrawTheBird.k          = 1;

                Intent in = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(in);
                finish();

                break;

            case R.id.contBtn:

                congratulations.setVisibility(View.GONE);
                entered.setVisibility(View.GONE);
                level.setVisibility(View.GONE);
                tap.setVisibility(View.GONE);
                contBtn.setVisibility(View.GONE);

                your_score.setVisibility(View.GONE);
                new_high_score.setVisibility(View.GONE);
                restart.setVisibility(View.GONE);
                share_button.setVisibility(View.GONE);
                vob_button.setVisibility(View.GONE);
                high_score.setVisibility(View.GONE);

                if(DrawTheBird.x_velocity  == 6){

                    DrawTheBird.background = BitmapFactory.decodeResource(getResources(), R.drawable.bg1);

                    DrawTheBird.bottom_block     = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block1);
                    DrawTheBird.top_block        = BitmapFactory.decodeResource(getResources(), R.drawable.top_block1);

                    DrawTheBird.bottom_block_2   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block1);
                    DrawTheBird.top_block_2      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block1);

                    DrawTheBird.bottom_block_3   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block1);
                    DrawTheBird.top_block_3      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block1);

                    DrawTheBird.bottom_block_4   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block1);
                    DrawTheBird.top_block_4      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block1);
                }

                else if(DrawTheBird.x_velocity  == 7){

                    DrawTheBird.background = BitmapFactory.decodeResource(getResources(), R.drawable.bg2);

                    DrawTheBird.bottom_block     = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block2);
                    DrawTheBird.top_block        = BitmapFactory.decodeResource(getResources(), R.drawable.top_block2);

                    DrawTheBird.bottom_block_2   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block2);
                    DrawTheBird.top_block_2      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block2);

                    DrawTheBird.bottom_block_3   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block2);
                    DrawTheBird.top_block_3      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block2);

                    DrawTheBird.bottom_block_4   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block2);
                    DrawTheBird.top_block_4      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block2);
                }

                else if(DrawTheBird.x_velocity  == 8){

                    DrawTheBird.background = BitmapFactory.decodeResource(getResources(), R.drawable.bg3);

                    DrawTheBird.bottom_block     = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block3);
                    DrawTheBird.top_block        = BitmapFactory.decodeResource(getResources(), R.drawable.top_block3);

                    DrawTheBird.bottom_block_2   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block3);
                    DrawTheBird.top_block_2      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block3);

                    DrawTheBird.bottom_block_3   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block3);
                    DrawTheBird.top_block_3      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block3);

                    DrawTheBird.bottom_block_4   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block3);
                    DrawTheBird.top_block_4      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block3);
                }

                else if(DrawTheBird.x_velocity  == 9){

                    DrawTheBird.background = BitmapFactory.decodeResource(getResources(), R.drawable.bg4);

                    DrawTheBird.bottom_block     = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block4);
                    DrawTheBird.top_block        = BitmapFactory.decodeResource(getResources(), R.drawable.top_block4);

                    DrawTheBird.bottom_block_2   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block4);
                    DrawTheBird.top_block_2      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block4);

                    DrawTheBird.bottom_block_3   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block4);
                    DrawTheBird.top_block_3      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block4);

                    DrawTheBird.bottom_block_4   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block4);
                    DrawTheBird.top_block_4      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block4);
                }

                else if(DrawTheBird.x_velocity  == 10){

                    DrawTheBird.background = BitmapFactory.decodeResource(getResources(), R.drawable.bg5);

                    DrawTheBird.bottom_block     = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block5);
                    DrawTheBird.top_block        = BitmapFactory.decodeResource(getResources(), R.drawable.top_block5);

                    DrawTheBird.bottom_block_2   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block5);
                    DrawTheBird.top_block_2      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block5);

                    DrawTheBird.bottom_block_3   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block5);
                    DrawTheBird.top_block_3      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block5);

                    DrawTheBird.bottom_block_4   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block5);
                    DrawTheBird.top_block_4      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block5);
                }

                else if(DrawTheBird.x_velocity  == 11){

                    DrawTheBird.background = BitmapFactory.decodeResource(getResources(), R.drawable.bg6);

                    DrawTheBird.bottom_block     = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block6);
                    DrawTheBird.top_block        = BitmapFactory.decodeResource(getResources(), R.drawable.top_block6);

                    DrawTheBird.bottom_block_2   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block6);
                    DrawTheBird.top_block_2      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block6);

                    DrawTheBird.bottom_block_3   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block6);
                    DrawTheBird.top_block_3      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block6);

                    DrawTheBird.bottom_block_4   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block6);
                    DrawTheBird.top_block_4      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block6);
                }

                else if(DrawTheBird.x_velocity  == 12){

                    DrawTheBird.background = BitmapFactory.decodeResource(getResources(), R.drawable.bg7);

                    DrawTheBird.bottom_block     = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block7);
                    DrawTheBird.top_block        = BitmapFactory.decodeResource(getResources(), R.drawable.top_block7);

                    DrawTheBird.bottom_block_2   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block7);
                    DrawTheBird.top_block_2      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block7);

                    DrawTheBird.bottom_block_3   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block7);
                    DrawTheBird.top_block_3      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block7);

                    DrawTheBird.bottom_block_4   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block7);
                    DrawTheBird.top_block_4      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block7);
                }

                else if(DrawTheBird.x_velocity  == 13){

                    DrawTheBird.background = BitmapFactory.decodeResource(getResources(), R.drawable.bg8);

                    DrawTheBird.bottom_block     = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block8);
                    DrawTheBird.top_block        = BitmapFactory.decodeResource(getResources(), R.drawable.top_block8);

                    DrawTheBird.bottom_block_2   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block8);
                    DrawTheBird.top_block_2      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block8);

                    DrawTheBird.bottom_block_3   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block8);
                    DrawTheBird.top_block_3      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block8);

                    DrawTheBird.bottom_block_4   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block8);
                    DrawTheBird.top_block_4      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block8);
                }

                else if(DrawTheBird.x_velocity  == 14){

                    DrawTheBird.background = BitmapFactory.decodeResource(getResources(), R.drawable.bg9);

                    DrawTheBird.bottom_block     = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block9);
                    DrawTheBird.top_block        = BitmapFactory.decodeResource(getResources(), R.drawable.top_block9);

                    DrawTheBird.bottom_block_2   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block9);
                    DrawTheBird.top_block_2      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block9);

                    DrawTheBird.bottom_block_3   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block9);
                    DrawTheBird.top_block_3      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block9);

                    DrawTheBird.bottom_block_4   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block9);
                    DrawTheBird.top_block_4      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block9);
                }

                else if(DrawTheBird.x_velocity  == 15){

                    DrawTheBird.background       = BitmapFactory.decodeResource(getResources(), R.drawable.bg10);

                    DrawTheBird.bottom_block     = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block10);
                    DrawTheBird.top_block        = BitmapFactory.decodeResource(getResources(), R.drawable.top_block10);

                    DrawTheBird.bottom_block_2   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block10);
                    DrawTheBird.top_block_2      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block10);

                    DrawTheBird.bottom_block_3   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block10);
                    DrawTheBird.top_block_3      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block10);

                    DrawTheBird.bottom_block_4   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block10);
                    DrawTheBird.top_block_4      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block10);
                }

                else if(DrawTheBird.x_velocity  == 16){

                    DrawTheBird.background       = BitmapFactory.decodeResource(getResources(), R.drawable.bg11);

                    DrawTheBird.bottom_block     = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block11);
                    DrawTheBird.top_block        = BitmapFactory.decodeResource(getResources(), R.drawable.top_block11);

                    DrawTheBird.bottom_block_2   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block11);
                    DrawTheBird.top_block_2      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block11);

                    DrawTheBird.bottom_block_3   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block11);
                    DrawTheBird.top_block_3      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block11);

                    DrawTheBird.bottom_block_4   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block11);
                    DrawTheBird.top_block_4      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block11);
                }

                else if(DrawTheBird.x_velocity  >= 17){

                    DrawTheBird.background = BitmapFactory.decodeResource(getResources(), R.drawable.bg);

                    DrawTheBird.bottom_block     = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block);
                    DrawTheBird.top_block        = BitmapFactory.decodeResource(getResources(), R.drawable.top_block);

                    DrawTheBird.bottom_block_2   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block);
                    DrawTheBird.top_block_2      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block);

                    DrawTheBird.bottom_block_3   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block);
                    DrawTheBird.top_block_3      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block);

                    DrawTheBird.bottom_block_4   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block);
                    DrawTheBird.top_block_4      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block);
                }

                DrawTheBird.score = DrawTheBird.temp_score + 1;
                Intent cont = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(cont);
                finish();

                break;

            default:
                break;
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            DrawTheBird.y_position -= 8;
            DrawTheBird.velocity = -8;
            sp.play(spids[2], 1, 1, 1, 0, (float) 1.0);
        }

        return super.onTouchEvent(event);
    }

    public void onShare(View v){

        Intent shar = new Intent(Intent.ACTION_SEND);
        shar.setType("text/plain");

        shar.putExtra(Intent.EXTRA_TEXT, "Hey!!! Can you beat my highscore at this game? My Score is : "
                + Integer.toString(sharedPref.getInt("high_score", 0)));

        startActivity(Intent.createChooser(shar, "Share your score!"));
    }



}

