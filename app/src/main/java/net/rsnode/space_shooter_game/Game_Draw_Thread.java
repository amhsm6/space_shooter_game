package net.rsnode.space_shooter_game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class Game_Draw_Thread extends Thread {
    private SurfaceHolder surfaceHolder;
    private Paint pt = new Paint();
    private volatile boolean running = true;
    private Paint backgroundPaint = new Paint();
    private Bitmap enemy, player, space;

    public Game_Draw_Thread(Context context, SurfaceHolder surfaceHolder) {
        backgroundPaint.setColor(Color.BLACK);
        backgroundPaint.setStyle(Paint.Style.FILL);
        pt.setColor(Color.WHITE);
        pt.setTextSize(50.0f);

        player = BitmapFactory.decodeResource(context.getResources(), R.drawable.player);
        enemy = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy);
        space = BitmapFactory.decodeResource(context.getResources(), R.drawable.space);
        this.surfaceHolder = surfaceHolder;
    }

    public void requestStop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            Canvas canvas = surfaceHolder.lockCanvas();
            if (canvas != null) {
                canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), backgroundPaint);
                canvas.drawBitmap(space, Content.player.x, Content.player.y, backgroundPaint);
                Content.player.x += Content.player.vx;
                Content.player.y += Content.player.vy;
                canvas.drawBitmap(Content.player.rotate(player, Content.player.angle), 300, 600, backgroundPaint);
                canvas.drawText(String.valueOf(Content.player.x), 50, 50, pt);
                canvas.drawText(String.valueOf(Content.player.y), 50, 100, pt);
                canvas.drawText(String.valueOf(Content.player.angle), 50, 250, pt);

                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }
}
