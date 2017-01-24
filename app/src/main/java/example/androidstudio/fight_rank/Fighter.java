package example.androidstudio.fight_rank;


import android.app.ActionBar;
import android.content.Context;
import android.app.Activity;
import android.content.res.AssetManager;
import android.media.Image;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

import static android.R.attr.id;
import static android.R.attr.layout_marginBottom;

/**
 * Created by thomasmilgrew on 11/25/16.
 */

public class Fighter extends Activity {

    int fighterScore;
    int linLayID=101;
    String name;

    public Fighter() {
        /*String fightID = fighterName.replace(" ", "").toLowerCase();
        int id = context.getResources().getIdentifier(fightID, "drawable", context.getPackageName());



        LinearLayout layout = new LinearLayout(context);
            layout.setOrientation(LinearLayout.HORIZONTAL);
            layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT, 400));
            layout.setId(linLayID);
            linLayID++;

        ImageView headShot = new ImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(400,400);
        headShot.setLayoutParams(layoutParams);
        headShot.setImageResource(id);
        headShot.setCropToPadding(true);
        layout.addView(headShot);

        TextView name = new TextView(context);
        LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(LinearLayoutCompat.LayoutParams.WRAP_CONTENT,400);
        name.setLayoutParams(textParams);
        name.setText(fighterName);
        name.setTextSize(28);
        name.setGravity(200);
        layout.addView(name);

        parentLayout.addView(layout);*/
    }

    //--------------------------------------------
    //reads the fighters .csv file and calculates a score based on
    //wins and losses
    //--------------------------------------------
    public int calculateScore(AssetManager assetManager, String lastName){

        name = lastName;
        fighterScore = 0;
        String [] ref = new String[]{"win", "loss"};
        String file = lastName + "_Record.csv";

        //AssetManager assetManager = getAssets();
        try{
            InputStream inputStream = assetManager.open(file);
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            inputStream.mark(0);
            String line = null;
            while ((line = in.readLine()) != null){
                String[] fight = line.split(",");
                if(ref[0].equals(fight[0])) {
                    switch (fight[1]) {
                        case "By 2":
                            fighterScore = fighterScore + 4;
                            break;
                        case "By 3":
                            fighterScore = fighterScore + 6;
                            break;
                        case "By 4":
                            fighterScore = fighterScore + 8;
                            break;
                        case "By 5":
                            fighterScore = fighterScore + 10;
                            break;
                        case "ko":
                            fighterScore = fighterScore + 15;
                            break;
                    }
                    switch (fight[2]) {
                        case " ":
                            fighterScore = fighterScore + 0;
                            break;
                        case "Top 10":
                            fighterScore = fighterScore + 2;
                            break;
                        case "Top 5":
                            fighterScore = fighterScore + 3;
                            break;
                        case "Former":
                            fighterScore = fighterScore + 5;
                            break;
                        case "Current":
                            fighterScore = fighterScore + 10;
                            break;
                        case "As Champ":
                            fighterScore = fighterScore + 8;
                            break;
                    }
                }if(ref[1].equals(fight[0])){
                    switch(fight[1]){
                        case "By 2":
                            fighterScore = fighterScore - 5;
                            break;
                        case "By 3":
                            fighterScore = fighterScore - 6;
                            break;
                        case "By 4":
                            fighterScore = fighterScore - 7;
                            break;
                        case "By 5":
                            fighterScore = fighterScore - 8;
                            break;
                        case "ko":
                            fighterScore = fighterScore - 10;
                            break;
                    }
                }
            }

            inputStream.reset();
        }
        catch (IOException e){
            Toast toast = Toast.makeText(this, "Could not load record", Toast.LENGTH_LONG);
        }

        return fighterScore;
    }

    public int getScore(){
        return fighterScore;
    }

    public int getLinLayID(){
        return linLayID;
    }

    public int compare (Fighter fighter1, Fighter fighter2){
        return Double.compare(fighter1.getScore(), fighter2.getScore());
    }

    public String getName (){
        return name;
    }

    public void draw(LinearLayout ll, Context context, String fighterName){
        if(fighterName == "Silva"){
            fighterName = "anderson"+fighterName.toLowerCase();
        }
        else if(fighterName == "Weidman"){
            fighterName = "chris"+fighterName.toLowerCase();
        }
        else if(fighterName == "Brunson"){
            fighterName = "derek"+fighterName.toLowerCase();
        }
        else if(fighterName == "Mousasi"){
            fighterName = "gegard"+fighterName.toLowerCase();
        }
        else if(fighterName == "Rockhold"){
            fighterName = "luke"+fighterName.toLowerCase();
        }
        else if(fighterName == "Bisping"){
            fighterName = "michael"+fighterName.toLowerCase();
        }
        else if(fighterName == "Whittaker"){
            fighterName = "robert"+fighterName.toLowerCase();
        }
        else if(fighterName == "Souza"){
            fighterName = "ronaldo"+fighterName.toLowerCase();
        }
        else if(fighterName == "Belfort"){
            fighterName = "vitor"+fighterName.toLowerCase();
        }
        else if(fighterName == "Romero"){
            fighterName = "yoel"+fighterName.toLowerCase();
        }

        String fightID = fighterName.replace(" ", "").toLowerCase();
        int id = context.getResources().getIdentifier(fightID, "drawable", context.getPackageName());

        ImageView headShot = new ImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(400,400);
        headShot.setLayoutParams(layoutParams);
        headShot.setImageResource(id);
        headShot.setCropToPadding(true);
        ll.addView(headShot);

        TextView name = new TextView(context);
        LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(LinearLayoutCompat.LayoutParams.WRAP_CONTENT,400);
        name.setLayoutParams(textParams);
        name.setText(fighterName);
        name.setTextSize(28);
        name.setGravity(200);
        ll.addView(name);
    }

}
