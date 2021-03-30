package net.rsnode.space_shooter_game;

public class Start_Front {
    float x1 = 0f;
    float x2 = -2880f;
    float y = 0f;
    public boolean isInMove;

    public void check() {
        if (x1 >= 2880) {
            x1 = -2880;
        }

        if (x2 >= 2880) {
            x2 = -2880;
        }
    }

    public Start_Front(boolean move) {
        isInMove = move;
    }
}
