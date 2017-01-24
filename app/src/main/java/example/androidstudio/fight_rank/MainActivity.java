package example.androidstudio.fight_rank;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import static android.R.attr.name;

public class MainActivity extends AppCompatActivity {

    /*LinkedList<Fighter> fighters = new LinkedList<>();
    String[] names = new String[]{"Michael Bisping", "Yoel Romero", "Luke Rockhold", "Ronaldo Souza", "Chris Weidman", "Gegard Mousasi", "Robert Whittaker", "Anderson Silva", "Vitor Belfort", "Derek Brunson"};*/
    //LinearLayout layout = (LinearLayout)findViewById(R.id.activity_main);

    Fighter bisping;
    Fighter romero;
    Fighter rockhold;
    Fighter souza;
    Fighter weidman;
    Fighter mousasi;
    Fighter whittaker;
    Fighter silva;
    Fighter belfort;
    Fighter brunson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = this;
        context.getApplicationContext();

        //LinearLayout layout = (LinearLayout)findViewById(R.id.activity_main);
        //bisping = new Fighter("Michael Bisping",layout, context);
        bisping = new Fighter();
        romero = new Fighter();
        rockhold = new Fighter();
        souza = new Fighter();
        weidman = new Fighter();
        mousasi = new Fighter();
        whittaker = new Fighter();
        silva = new Fighter();
        belfort = new Fighter();
        brunson = new Fighter();
    }

    public void pushFirstButton (View view){

        AssetManager assetManager = getAssets();

        /*for(int i=0; i< fighters.size(); i++){
            int score = fighters.get(i).calculateScore(assetManager, names[i]);
            Log.d("score", "----------------score is " + score );
        }*/

            int score1 = bisping.calculateScore(assetManager, "Bisping");
            int score2 = romero.calculateScore(assetManager, "Romero");
            int score3 = rockhold.calculateScore(assetManager, "Rockhold");
            int score4 = souza.calculateScore(assetManager, "Souza");
            int score5 = weidman.calculateScore(assetManager, "Weidman");
            int score6 = mousasi.calculateScore(assetManager, "Mousasi");
            int score7 = whittaker.calculateScore(assetManager, "Whittaker");
            int score8 = silva.calculateScore(assetManager, "Silva");
            int score9 = belfort.calculateScore(assetManager, "Belfort");
            int score10 = brunson.calculateScore(assetManager, "Brunson");

            Log.d("score", "---------score is " + score1);
            Log.d("score", "---------score is " + score2);
            Log.d("score", "---------score is " + score3);
            Log.d("score", "---------score is " + score4);
            Log.d("score", "---------score is " + score5);
            Log.d("score", "---------score is " + score6);
            Log.d("score", "---------score is " + score7);
            Log.d("score", "---------score is " + score8);
            Log.d("score", "---------score is " + score9);
            Log.d("score", "---------score is " + score10);



        showScore(view, bisping, (LinearLayout)findViewById(R.id.bisping_id));
        showScore(view, romero,(LinearLayout)findViewById(R.id.romero_id));
        showScore(view, rockhold, (LinearLayout)findViewById(R.id.rockhold_id));
        showScore(view, souza, (LinearLayout)findViewById(R.id.souza_id));
        showScore(view, weidman, (LinearLayout)findViewById(R.id.weidman_id));
        showScore(view, mousasi, (LinearLayout)findViewById(R.id.mousasi_id));
        showScore(view, whittaker, (LinearLayout)findViewById(R.id.whittaker_id));
        showScore(view, silva, (LinearLayout)findViewById(R.id.silva_id));
        showScore(view, brunson, (LinearLayout)findViewById(R.id.brunson_id));

        Button btn = (Button)findViewById(R.id.calculate_scores);
        btn.setEnabled(false);
    }

    //-----------------------------------------------------------
    //displays each fighter's new score in the UI
    //-----------------------------------------------------------
    private void showScore(View view, Fighter fighter, LinearLayout linearLayout){
        //LinearLayout = (LinearLayout)findViewById(R.id.bisping_id);
        TextView score = new TextView(this);

        Integer temp = fighter.getScore();
        String temp1 = temp.toString();
        score.setText(temp1);
        score.setTextSize(22);
        score.setTextColor(Color.RED);
        linearLayout.addView(score);
    }

    public void sortFighters(View view){
        ArrayList<Fighter> fighterArrayList = new ArrayList<>(10);
        fighterArrayList.add(bisping);
        fighterArrayList.add(romero);
        fighterArrayList.add(rockhold);
        fighterArrayList.add(souza);
        fighterArrayList.add(weidman);
        fighterArrayList.add(mousasi);
        fighterArrayList.add(whittaker);
        fighterArrayList.add(silva);
        fighterArrayList.add(brunson);

        MergeSort.mergeSort(fighterArrayList);

        for(int i=0; i< fighterArrayList.size(); i++){
            Log.d("name", "---------name is " + fighterArrayList.get(i).getName());
        }

        Stack<Fighter> fighterStack = new Stack<>();
        for(int i=0; i<fighterArrayList.size(); i++){
            fighterStack.push(fighterArrayList.get(i));
        }


        Context context = this;
        context.getApplicationContext();

        LinearLayout ll = (LinearLayout) findViewById(R.id.one);
        ll.removeAllViews();
        Fighter postFighter1 = fighterStack.pop();
        postFighter1.draw(ll, context, postFighter1.getName());

        LinearLayout ll2 = (LinearLayout) findViewById(R.id.two);
        ll2.removeAllViews();
        Fighter postFighter2 = fighterStack.pop();
        postFighter2.draw(ll2, context, postFighter2.getName());

        LinearLayout ll3 = (LinearLayout) findViewById(R.id.three);
        ll3.removeAllViews();
        Fighter postFighter3 = fighterStack.pop();
        postFighter3.draw(ll3, context, postFighter3.getName());

        LinearLayout ll4 = (LinearLayout) findViewById(R.id.four);
        ll4.removeAllViews();
        Fighter postFighter4 = fighterStack.pop();
        postFighter4.draw(ll4, context, postFighter4.getName());

        LinearLayout ll5 = (LinearLayout) findViewById(R.id.five);
        ll5.removeAllViews();
        Fighter postFighter5 = fighterStack.pop();
        postFighter5.draw(ll5, context, postFighter5.getName());

        LinearLayout ll6 = (LinearLayout) findViewById(R.id.six);
        ll6.removeAllViews();
        Fighter postFighter6 = fighterStack.pop();
        postFighter6.draw(ll6, context, postFighter6.getName());

        LinearLayout ll7 = (LinearLayout) findViewById(R.id.seven);
        ll7.removeAllViews();
        Fighter postFighter7 = fighterStack.pop();
        postFighter7.draw(ll7, context, postFighter7.getName());

        LinearLayout ll8 = (LinearLayout) findViewById(R.id.eight);
        ll8.removeAllViews();
        Fighter postFighter8 = fighterStack.pop();
        postFighter8.draw(ll8, context, postFighter8.getName());

        LinearLayout ll9 = (LinearLayout) findViewById(R.id.nine);
        ll9.removeAllViews();
        Fighter postFighter9 = fighterStack.pop();
        postFighter9.draw(ll9, context, postFighter9.getName());
    }
}

