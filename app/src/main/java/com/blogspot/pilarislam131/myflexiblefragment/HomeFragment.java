package com.blogspot.pilarislam131.myflexiblefragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//         Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Button btnCategory = (Button)view.findViewById(R.id.btn_category);
        btnCategory.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_category){
            CategoryFragment mCategoryfragment = new CategoryFragment();
            FragmentManager mFragmentM2 = getFragmentManager();
            FragmentTransaction mFragmentT2 = mFragmentM2.beginTransaction();
            mFragmentT2.replace(R.id.frame_container,mCategoryfragment, CategoryFragment.class.getSimpleName());
            mFragmentT2.addToBackStack(null);
            mFragmentT2.commit();
        }
    }
}