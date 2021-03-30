package net.rsnode.space_shooter_game;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public class Player {
    float x = -512f;
    float y = -404f;
    int angle = 0;
    float vx = 0;
	float vy = 0;
    float normal_speed = 10;

    public Bitmap rotate(Bitmap source, float angleR) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angleR);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
    }
}
