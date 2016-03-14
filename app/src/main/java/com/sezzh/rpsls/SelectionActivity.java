package com.sezzh.rpsls;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;

import com.sezzh.rpsls.ui.SelectionFragment;

public class SelectionActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.setContentView(R.layout.activity_selection);
    this.setupWindowAnimation();
    FragmentManager fragmentManager = this.getSupportFragmentManager();
    FragmentTransaction fragmentTransaction =
        fragmentManager.beginTransaction();
    fragmentTransaction.add(R.id.selection_main, new SelectionFragment());
    fragmentTransaction.commit();
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  private void setupWindowAnimation() {
    Slide slide = null;
    if (android.os.Build.VERSION.SDK_INT >=
        android.os.Build.VERSION_CODES.LOLLIPOP) {
      slide = new Slide();
      slide.setDuration(300);
      slide.setSlideEdge(Gravity.RIGHT);
      this.getWindow().setEnterTransition(slide);
    }
  }

}
