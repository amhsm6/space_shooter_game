package net.rsnode.space_shooter_game;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import io.github.controlwear.virtual.joystick.android.JoystickView;

public class Game_Activity extends AppCompatActivity {
    JoystickView joystick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        joystick = findViewById(R.id.joystick);
        joystick.setOnMoveListener(new JoystickView.OnMoveListener() {
            @Override
            public void onMove(int angle, int strength) {
                Content.player.angle = angle;
                float speed = Content.player.normal_speed*((float) strength / 100);
                Content.player.vx = (float) (speed * Math.cos(Math.toRadians((angle - 90 + 360) % 360)));
		        Content.player.vy = (float) (speed * Math.sin(Math.toRadians((angle - 90 + 360) % 360)));
            }
        });
    }
}
