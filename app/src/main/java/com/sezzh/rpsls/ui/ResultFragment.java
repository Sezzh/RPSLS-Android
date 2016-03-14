package com.sezzh.rpsls.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sezzh.rpsls.R;

/**
 * Created by sezzh on 14/03/2016.
 */
public class ResultFragment extends Fragment {
  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_result, container, false);
    return root;
  }
}
