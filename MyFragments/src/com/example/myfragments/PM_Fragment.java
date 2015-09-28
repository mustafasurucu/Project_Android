package com.example.myfragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass. Activities that contain this fragment
 * must implement the {@link PM_Fragment.OnFragmentInteractionListener}
 * interface to handle interaction events. Use the
 * {@link PM_Fragment#newInstance} factory method to create an instance of this
 * fragment.
 * 
 */
public class PM_Fragment extends Fragment {

	public PM_Fragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_pm_, container, false);
	}
}
