package piraterie.mousquetaire.gameallnight;

import android.animation.Animator;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Bus extends Fragment {

    private ImageView imageView;
    private TextView text;
    private Button refresh;
    private View rootView;
    private Integer index;
    private Iterator<Integer> iter;
    private List<Integer> shuffledCards;

    private Integer[] images = {
            R.drawable.ace_of_clubs, R.drawable.ace_of_diamonds, R.drawable.ace_of_hearts, R.drawable.ace_of_spades,
            R.drawable.eight_of_clubs, R.drawable.eight_of_diamonds, R.drawable.eight_of_hearts, R.drawable.eight_of_spades,
            R.drawable.five_of_clubs, R.drawable.five_of_diamonds, R.drawable.five_of_hearts, R.drawable.five_of_spades,
            R.drawable.four_of_clubs, R.drawable.four_of_diamonds, R.drawable.four_of_hearts, R.drawable.four_of_spades,
            R.drawable.jack_of_clubs, R.drawable.jack_of_diamonds, R.drawable.jack_of_hearts, R.drawable.jack_of_spades,
            R.drawable.king_of_clubs, R.drawable.king_of_diamonds, R.drawable.king_of_hearts, R.drawable.king_of_spades,
            R.drawable.nine_of_clubs, R.drawable.nine_of_diamonds, R.drawable.nine_of_hearts, R.drawable.nine_of_spades,
            R.drawable.queen_of_clubs, R.drawable.queen_of_diamonds, R.drawable.queen_of_hearts, R.drawable.queen_of_spades,
            R.drawable.seven_of_clubs, R.drawable.seven_of_diamonds, R.drawable.seven_of_hearts, R.drawable.seven_of_spades,
            R.drawable.six_of_clubs, R.drawable.six_of_diamonds, R.drawable.six_of_hearts, R.drawable.six_of_spades,
            R.drawable.ten_of_clubs, R.drawable.ten_of_diamonds, R.drawable.ten_of_hearts, R.drawable.ten_of_spades,
            R.drawable.three_of_clubs, R.drawable.three_of_diamonds, R.drawable.three_of_hearts, R.drawable.three_of_spades,
            R.drawable.two_of_clubs, R.drawable.two_of_diamonds, R.drawable.two_of_hearts, R.drawable.two_of_spades};

    private Integer image;

    public static Bus newInstance() {
        return (new Bus());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_bus, container, false);

        imageView = rootView.findViewById(R.id.imageView);

        text = rootView.findViewById(R.id.button2);
        refresh = rootView.findViewById(R.id.button3);

        shuffledCards = new ArrayList<>(Arrays.asList(images));

        init();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!iter.hasNext() || index == 0) {
                    return;
                }
                ViewPropertyAnimator animation = imageView.animate();
                animation.rotationYBy(180).setDuration(500).setInterpolator(new LinearInterpolator());
                animation.setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {
                        imageView.setImageResource(R.drawable.back);
                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        index--;
                        image = iter.next();
                        imageView.setRotationY(360);
                        imageView.setImageResource(image);
                        //button.invalidate();
                        if (index == 0) {
                            text.setText("Bien joué !!");
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    if(index == 0){
                                        imageView.setImageResource(R.drawable.thelegendaryexodiaincarnate);
                                    }
                                }
                            }, 5000);
                        } else {
                            text.setText("Plus que " + index + " carte(s)");
                        }
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });
                animation.start();
            }
        });

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
            }
        });

        return rootView;
    }

    private void init() {
        Collections.shuffle(shuffledCards);
        iter = shuffledCards.iterator();
        index = 5;
        imageView.setImageResource(R.drawable.back);
        text.setText("Plus que " + index + " carte(s)");
    }

}
