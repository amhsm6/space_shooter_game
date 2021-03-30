package net.rsnode.space_shooter_game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class DrawThread extends Thread {
    private SurfaceHolder surfaceHolder;
    private Paint pt = new Paint();
    private volatile boolean running = true;
    private Paint backgroundPaint = new Paint();
    private Bitmap bitmap;

    public DrawThread(Context context, SurfaceHolder surfaceHolder) {
        backgroundPaint.setColor(Color.BLACK);
        backgroundPaint.setStyle(Paint.Style.FILL);
        pt.setColor(Color.WHITE);
        pt.setTextSize(50.0f);

        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.space2);
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
                canvas.drawBitmap(bitmap, Content.space.x1, Content.space.y, backgroundPaint);
                canvas.drawBitmap(bitmap, Content.space.x2, Content.space.y, backgroundPaint);
                Content.space.x1++;
                Content.space.x2++;
                canvas.drawText(String.valueOf(Content.space.x1), 50, 50, pt);
                canvas.drawText(String.valueOf(Content.space.x2), 50, 100, pt);
                Content.space.check();

                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }
}