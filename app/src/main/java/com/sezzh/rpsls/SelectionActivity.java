package com.sezzh.rpsls;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.sezzh.rpsls.ui.SelectionFragment;

public class SelectionActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.setContentView(R.layout.activity_selection);
    FragmentManager fragmentManager = this.getSupportFragmentManager();
    fragmentManager.beginTransaction()
      .add(R.id.selection_main, new SelectionFragment())
      .commit();
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == android.R.id.home) {
      this.finish();
      this.overridePendingTransition(
        R.transition.transition_activity_main_back_in,
        R.transition.transition_activity_main_back_out
      );
    }
    return super.onOptionsItemSelected(item);
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    this.overridePendingTransition(
      R.transition.transition_activity_main_back_in,
      R.transition.transition_activity_main_back_out
    );
  }


}
