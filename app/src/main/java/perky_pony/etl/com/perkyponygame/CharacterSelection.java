package perky_pony.etl.com.perkyponygame;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CharacterSelection extends AppCompatActivity {

    Button spider_btn, bird_btn;
    DrawTheBird dtb;

    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

     //   requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.character_selection);

        dtb        = (DrawTheBird) findViewById(R.id.drawthebird);

        spider_btn = (Button) findViewById(R.id.spider_select);
        bird_btn   = (Button) findViewById(R.id.bird_select);



        spider_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent nextScreen = new Intent(getApplicationContext(), MainActivity.class);

                DrawTheBird.x_velocity = 5;
                DrawTheBird.score      = 1;
                DrawTheBird.temp_score = 1;
                DrawTheBird.k          = 1;

                DrawTheBird.bird_up_image     = BitmapFactory.decodeResource(getResources(), R.drawable.spider_up);
                DrawTheBird.bird_down_image   = BitmapFactory.decodeResource(getResources(), R.drawable.spider_down);

                DrawTheBird.background        = BitmapFactory.decodeResource(getResources(), R.drawable.bg);

                DrawTheBird.bottom_block     = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block);
                DrawTheBird.top_block        = BitmapFactory.decodeResource(getResources(), R.drawable.top_block);

                DrawTheBird.bottom_block_2   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block);
                DrawTheBird.top_block_2      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block);

                DrawTheBird.bottom_block_3   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block);
                DrawTheBird.top_block_3      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block);

                DrawTheBird.bottom_block_4   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block);
                DrawTheBird.top_block_4      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block);


                startActivity(nextScreen);
                //finish();
            }
        });


        bird_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent nextScreen = new Intent(getApplicationContext(), MainActivity.class);
                DrawTheBird.x_velocity = 5;
                DrawTheBird.score      = 1;
                DrawTheBird.temp_score = 1;
                DrawTheBird.k          = 1;
                DrawTheBird.bird_up_image     = BitmapFactory.decodeResource(getResources(), R.drawable.bird_up);
                DrawTheBird.bird_down_image   = BitmapFactory.decodeResource(getResources(), R.drawable.bird_down);

                DrawTheBird.background     = BitmapFactory.decodeResource(getResources(), R.drawable.bg);

                DrawTheBird.bottom_block     = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block);
                DrawTheBird.top_block        = BitmapFactory.decodeResource(getResources(), R.drawable.top_block);

                DrawTheBird.bottom_block_2   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block);
                DrawTheBird.top_block_2      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block);

                DrawTheBird.bottom_block_3   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block);
                DrawTheBird.top_block_3      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block);

                DrawTheBird.bottom_block_4   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block);
                DrawTheBird.top_block_4      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block);

                startActivity(nextScreen);
                //finish();
            }
        });

    }



    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }


}