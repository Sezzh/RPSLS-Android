package com.sezzh.rpsls;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sezzh.rpsls.ui.ResultFragment;

/**
 * Created by sezzh on 23/03/2016.
 */
public class ResultActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.setContentView(R.layout.activity_result);
    this.getSupportFragmentManager().beginTransaction()
      .add(R.id.result_content, new ResultFragment())
      .commit();
  }
}
