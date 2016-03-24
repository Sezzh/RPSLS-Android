package com.sezzh.rpsls;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.sezzh.rpsls.ui.RulesFragment;

public class MainActivity extends AppCompatActivity {

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
    fragmentManager.beginTransaction()
      .add(R.id.main_content, new RulesFragment())
      .commit();

    this.startButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startGame();
      }
    });
  }

  private void startGame() {
    Intent intent = new Intent(this, SelectionActivity.class);
    this.startActivity(intent);
    this.overridePendingTransition(
      R.transition.transition_activity_main_in,
      R.transition.transition_activity_main_out
    );
  }
}
