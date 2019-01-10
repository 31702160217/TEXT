package com.example.jrz.android_shixun;

/**
 * Created by jrz on 2019/1/5.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
public class FirstFragment2 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate( R.layout.fragment2, container, false );
        return view;
    }
}