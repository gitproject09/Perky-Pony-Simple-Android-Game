package perky_pony.etl.com.perkyponygame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by Emporium on 2/6/2016.
 */
public class DrawTheBird extends View {

    //	int x_first = - 100, x_second = - 400, x_third = - 700, x_fourth = - 1000, ground_position = 0;
    int x_first = 0, x_second = 0, x_third = 0, x_fourth = 0, ground_position = 0, background_position = 0;
    int first_block_height = 100, second_block_height = 150, third_block_height = 80, fourth_block_height = 120;
    int sub_score = 0, block_gap;
    int block_position;
    int block_width;
    int starting_width;

    int i = 0, level_no;
    final int image_height = 600;
    //final int block_width  = 120;

    static int y_position, initial, plus, velocity = 1, score = 1, temp_score;
    final static int sub_point = 45;
    final static int acceleration = 1;
    static int x_velocity = 5, k = 1, tile_pass = 0;// block_gap = 250;

    boolean lose = false;
    boolean level_pass = false;

    Rect oval, ground, ground2, back;

    Rect block_bottom;
    Rect block_bottom_2;
    Rect block_bottom_3;
    Rect block_bottom_4;

    Rect block_top;
    Rect block_top_2;
    Rect block_top_3;
    Rect block_top_4;

    Random rand;

    Bitmap image_ground; //, background;

    static Bitmap bottom_block;
    static Bitmap bottom_block_2;
    static Bitmap bottom_block_3;
    static Bitmap bottom_block_4;

    static Bitmap top_block;
    static Bitmap top_block_2;
    static Bitmap top_block_3;
    static Bitmap top_block_4;

    static Bitmap bird_up_image;
    static Bitmap bird_down_image;

    static Bitmap background;


    public DrawTheBird(Context context, AttributeSet atrib) {
        super(context);
        // TODO Auto-generated constructor stub


        oval = new Rect();

        block_bottom = new Rect();
        block_top = new Rect();

        block_bottom_2 = new Rect();
        block_top_2 = new Rect();

        block_bottom_3 = new Rect();
        block_top_3 = new Rect();

        block_bottom_4 = new Rect();
        block_top_4 = new Rect();

        ground = new Rect();
        ground2 = new Rect();
        back = new Rect();

        rand = new Random();

	/*	bottom_block   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block);
		top_block      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block);

		bottom_block_2   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block);
		top_block_2      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block);

		bottom_block_3   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block);
		top_block_3      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block);

		bottom_block_4   = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_block);
		top_block_4      = BitmapFactory.decodeResource(getResources(), R.drawable.top_block); */

        image_ground = BitmapFactory.decodeResource(getResources(), R.drawable.img_ground);
        //	background     = BitmapFactory.decodeResource(getResources(), R.drawable.bg);

        //	bird_up_image     = BitmapFactory.decodeResource(getResources(), R.drawable.bird_up);
        //	bird_down_image   = BitmapFactory.decodeResource(getResources(), R.drawable.bird_down);

        //	spider_up_image   = BitmapFactory.decodeResource(getResources(), R.drawable.spider_up);
        //	spider_down_image = BitmapFactory.decodeResource(getResources(), R.drawable.spider_down);

        y_position = 100;
        velocity = 1;

    }


    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        //canvas.drawARGB(100, 100, 0, 10);
        //	back.set(0, 0, canvas.getWidth(), canvas.getHeight());
        //	canvas.drawBitmap(background, null, back, null);
        block_gap = canvas.getHeight() / 2;


        block_position = canvas.getWidth() / 3;

        block_width = block_position / 4;
        starting_width = 4 * block_position;
        // if(i== 0 || i== 4 * canvas.getWidth() + block_width){
        if (i == 0) {

            initial = block_gap / 3;
            plus = initial / 3;
            x_first = 0;
            x_second = -block_position;
            x_third = -2 * block_position;
            x_fourth = -3 * block_position;
            i = 5;

        }
        // Background label
        back.set(-background_position, 0, canvas.getWidth() - background_position, canvas.getHeight());
        canvas.drawBitmap(background, null, back, null);

        // Background label 2
        back.set(canvas.getWidth() - background_position, 0, 2 * canvas.getWidth() - background_position, canvas.getHeight());
        canvas.drawBitmap(background, null, back, null);


        // The Bird or oval
        oval.set(canvas.getWidth() / 4, y_position,
                canvas.getWidth() / 4 + initial + plus, y_position + initial);


        if (velocity < 0) {

            canvas.drawBitmap(bird_up_image, null, oval, null);

        } else {
            canvas.drawBitmap(bird_down_image, null, oval, null);
        }


        velocity = velocity + acceleration;
        y_position = y_position + velocity;


        // Top Block top = height - image_height
        block_top.set(canvas.getWidth() - x_first, -block_gap,
                canvas.getWidth() - x_first + block_width, first_block_height);

        canvas.drawBitmap(top_block, null, block_top, null);

        // Bottom Block bottom = height + block_gap + image_height
        block_bottom.set(canvas.getWidth() - x_first, first_block_height + block_gap,
                canvas.getWidth() - x_first + block_width, canvas.getHeight() + block_gap);

        canvas.drawBitmap(bottom_block, null, block_bottom, null);


        // Top Block top = height - image_height
        block_top_2.set(canvas.getWidth() - x_second, -block_gap,
                canvas.getWidth() - x_second + block_width, second_block_height);

        canvas.drawBitmap(top_block_2, null, block_top_2, null);

        // Bottom Block bottom = height + block_gap + image_height
        block_bottom_2.set(canvas.getWidth() - x_second, second_block_height + block_gap,
                canvas.getWidth() - x_second + block_width, canvas.getHeight() + block_gap);

        canvas.drawBitmap(bottom_block_2, null, block_bottom_2, null);


        // Top Block top = height - image_height
        block_top_3.set(canvas.getWidth() - x_third, -block_gap,
                canvas.getWidth() - x_third + block_width, third_block_height);

        canvas.drawBitmap(top_block_3, null, block_top_3, null);

        // Bottom Block bottom = height + block_gap + image_height
        block_bottom_3.set(canvas.getWidth() - x_third, third_block_height + block_gap,
                canvas.getWidth() - x_third + block_width, canvas.getHeight() + block_gap);

        canvas.drawBitmap(bottom_block_3, null, block_bottom_3, null);


        // Top Block top = height - image_height
        block_top_4.set(canvas.getWidth() - x_fourth, -block_gap,
                canvas.getWidth() - x_fourth + block_width, fourth_block_height);

        canvas.drawBitmap(top_block_4, null, block_top_4, null);

        // Bottom Block bottom = height + block_gap + image_height
        block_bottom_4.set(canvas.getWidth() - x_fourth, fourth_block_height + block_gap,
                canvas.getWidth() - x_fourth + block_width, canvas.getHeight() + block_gap);

        canvas.drawBitmap(bottom_block_4, null, block_bottom_4, null);


        // Ground label
        ground.set(-ground_position, canvas.getHeight() - 50,
                canvas.getWidth() - ground_position, canvas.getHeight());

        canvas.drawBitmap(image_ground, null, ground, null);


        // Ground label 2
        ground2.set(canvas.getWidth() - ground_position, canvas.getHeight() - 50,
                2 * canvas.getWidth() - ground_position, canvas.getHeight());

        canvas.drawBitmap(image_ground, null, ground2, null);


        x_first += x_velocity;
        x_second += x_velocity;
        x_third += x_velocity;
        x_fourth += x_velocity;

        ground_position += 5;
        background_position += 2;


        if (ground_position >= canvas.getWidth()) {
            ground_position = 0;
        }

        if (background_position >= canvas.getWidth()) {
            background_position = 0;
        }


        if (x_first >= canvas.getWidth() + block_width) {
            x_first = -block_position + block_width;
            first_block_height = 10 + rand.nextInt(canvas.getHeight() / 4);

        }

        if (x_second >= canvas.getWidth() + block_width) {
            x_second = -block_position + block_width;
            second_block_height = rand.nextInt(canvas.getHeight() / 2 - 50);
            if (second_block_height >= canvas.getHeight() / 2)
                second_block_height = second_block_height - 50;
        }

        if (x_third >= canvas.getWidth() + block_width) {
            x_third = -block_position + block_width;
            third_block_height = rand.nextInt(canvas.getHeight() / 3) + 20;
        }

        if (x_fourth >= canvas.getWidth() + block_width) {
            x_fourth = -block_position + block_width;
            fourth_block_height = rand.nextInt(canvas.getHeight() / 2);
            if (fourth_block_height >= canvas.getHeight() / 2)
                fourth_block_height = fourth_block_height - 80;
        }

        //	if(score % 5 == 0 && x_position == canvas.getWidth() + block_width && score !=0){
        //		x_position = score / 5;
        //	}

        if (oval.bottom > canvas.getHeight() - 50) {

            lose = true;
            //	level_pass = true;
            MainActivity.sp.play(MainActivity.spids[0], 1, 1, 1, 0, (float) 1.0);
        }

        if (oval.right < block_bottom.left ||
                oval.left > block_bottom.right ||
                oval.right < block_bottom_2.left ||
                oval.left > block_bottom_2.right ||
                oval.right < block_bottom_3.left ||
                oval.left > block_bottom_3.right ||
                oval.right < block_bottom_4.left ||
                oval.left > block_bottom_4.right) {


            if (!lose && !level_pass) {

                score++;

                // pass the tiles successfully

                MainActivity.score_board.setText(Integer.toString(score));

                if (score % 100 == 0) {
                    MainActivity.sp.play(MainActivity.spids[1], 1, 1, 1, 0, (float) 1.0);
                    //  tile_pass++;
                    //   MainActivity.score_board.setText(Integer.toString(tile_pass));
                    //   score = 1;
                }

                if (score != 0 && score % (k * 1000) == 0) {

                    level_pass = true;
                    k *= 2;
                    temp_score = score;
                    x_velocity++;

                    //	MainActivity.sp.play(MainActivity.spids[1], 1, 1, 1, 0, (float) 1.0);

                }


            }

        }


        if (block_top.intersect(oval) ||
                block_bottom.intersect(oval) ||
                block_top_2.intersect(oval) ||
                block_bottom_2.intersect(oval) ||
                block_top_3.intersect(oval) ||
                block_bottom_3.intersect(oval) ||
                block_top_4.intersect(oval) ||
                block_bottom_4.intersect(oval)) {


            lose = true;
            level_pass = false;
            MainActivity.sp.play(MainActivity.spids[0], 1, 1, 1, 0, (float) 1.0);
        }


        //	else {
			/*if(oval.bottom < block_bottom.top && oval.top > block_top.bottom ||
			   oval.bottom < block_bottom_2.top && oval.top > block_top_2.bottom) {

			//	sub_score++; // sub_score = 45  for this screen
				//if(sub_score == sub_point){
					score++;
				//	MainActivity.sp.play(MainActivity.spids[1], 1, 1, 1, 0, (float) 1.0); // pass the tiles successfully

				    MainActivity.score_board.setText(Integer.toString(score));

				    sub_score = 0;
			//	}

			}*/// else {
        //	lose = true;
        //	MainActivity.sp.play(MainActivity.spids[0], 1, 1, 1, 0, (float) 1.0);
        //}

        //	}
        if (lose) {

            MainActivity.restart.setVisibility(View.VISIBLE);
            MainActivity.high_score.setVisibility(View.VISIBLE);
            MainActivity.share_button.setVisibility(View.VISIBLE);
            MainActivity.vob_button.setVisibility(View.VISIBLE);

            //	if(MainActivity.share.getInt("high_score", 0) >= score){

            //		MainActivity.your_score.setVisibility(View.VISIBLE);
            //	}

            if (MainActivity.sharedPref.getInt("high_score", 0) < score) {

                MainActivity.editor.putInt("high_score", score);
                MainActivity.editor.commit();
                MainActivity.new_high_score.setVisibility(View.VISIBLE);
                MainActivity.high_score.setText("Best : " + Integer.toString(MainActivity.sharedPref.getInt("high_score", 0)));

            }

        } else if (level_pass) {


            MainActivity.congratulations.setVisibility(View.VISIBLE);
            MainActivity.entered.setVisibility(View.VISIBLE);
            MainActivity.level.setVisibility(View.VISIBLE);
            MainActivity.tap.setVisibility(View.VISIBLE);
            MainActivity.contBtn.setVisibility(View.VISIBLE);
            MainActivity.vob_button.setVisibility(View.VISIBLE);
        } else {
            invalidate();
        }

    }

}