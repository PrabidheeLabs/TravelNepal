package com.prabidhee.www.travelnepalv2.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prabidhee.www.travelnepalv2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdventureFragment extends Fragment {


    public AdventureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_adventure, container, false);
    }

}
