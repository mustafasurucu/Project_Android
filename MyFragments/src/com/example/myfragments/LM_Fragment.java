package com.example.myfragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass. Activities that contain this fragment
 * must implement the {@link LM_Fragment.OnFragmentInteractionListener}
 * interface to handle interaction events. Use the
 * {@link LM_Fragment#newInstance} factory method to create an instance of this
 * fragment.
 * 
 */
public class LM_Fragment extends Fragment {
	

	public LM_Fragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_lm_, container, false);
	}

}
