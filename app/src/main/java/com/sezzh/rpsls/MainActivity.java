package com.sezzh.rpsls;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;

import com.sezzh.rpsls.ui.RulesFragment;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener {

  private Toolbar toolbar;
  private FloatingActionButton startButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.setContentView(R.layout.activity_main);
    this.toolbar = (Toolbar) this.findViewById(R.id.toolbar);
    this.setSupportActionBar(toolbar);
    this.startButton =
        (FloatingActionButton) this.findViewById(R.id.button_play);

    FragmentManager fragmentManager = this.getSupportFragmentManager();
    FragmentTransaction fragmentTransaction
        = fragmentManager.beginTransaction();
    fragmentTransaction.add(R.id.main_content, new RulesFragment());
    fragmentTransaction.commit();
    this.startButton.setOnClickListener(this);
    this.setupWindowAnimation();
    /*
    this.startButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        startGame(view);
      }
    });*/

  }

  @Override
  protected void onStart() {
    super.onStart();
  }

  @Override
  public void onClick(View v) {
    if (v.getId() == this.startButton.getId()) {
      this.startGame(v);
    }
  }

  private void startGame(View view) {
    Intent intent = new Intent(this, SelectionActivity.class);
    this.startActivity(
        intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this)
            .toBundle()
    );
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  private void setupWindowAnimation() {
    Slide slide = null;
    if (android.os.Build.VERSION.SDK_INT >=
        android.os.Build.VERSION_CODES.LOLLIPOP) {
      slide = new Slide();
      slide.setDuration(300);
      slide.setSlideEdge(Gravity.LEFT);
      this.getWindow().setExitTransition(slide);
    }

  }

}
