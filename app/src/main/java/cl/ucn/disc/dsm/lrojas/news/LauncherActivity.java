/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cl.ucn.disc.dsm.lrojas.news;

import android.content.Intent;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class LauncherActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getWindow().setFlags(
        WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);

    setContentView(R.layout.activity_launcher);

    // Add Animations
    Animation swipeUpAnimation = AnimationUtils.loadAnimation(this, R.anim.swipe_up);
    Animation swipeDownAnimation = AnimationUtils.loadAnimation(this, R.anim.swipe_down);

    TextView txtCourse = findViewById(R.id.txtCurso);
    ImageView imgLogo = findViewById(R.id.imgLogo);

    txtCourse.setAnimation(swipeUpAnimation);
    imgLogo.setAnimation(swipeDownAnimation);

    new Handler().postDelayed(() -> {
      Intent intent = new Intent(LauncherActivity.this, MainActivity.class);
      startActivity(intent);
      finish();
    }, 4000);

  }
}