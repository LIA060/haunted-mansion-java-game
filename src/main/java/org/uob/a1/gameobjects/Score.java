package org.uob.a1.gameobjects;

public class Score {

    private int score = 100;
    private int moving = -1;
    private int unlocking = 10;

    public int getScore() {//
        return score;
    }

    public void updatemove(){
        score += moving;
    }

    public void updateunlock(){
        score += unlocking;
    }
    
}
