package example.androidstudio.fight_rank;

/**
 * Created by thomasmilgrew on 12/18/16.
 */

public class FighterComparator {

    public int compare (Fighter fighter1, Fighter fighter2){
        return Double.compare(fighter1.getScore(), fighter2.getScore());
    }
}
