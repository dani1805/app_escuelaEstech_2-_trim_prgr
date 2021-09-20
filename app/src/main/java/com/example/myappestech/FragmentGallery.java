package com.example.myappestech;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentGallery#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentGallery extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentGallery() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentGallery.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentGallery newInstance(String param1, String param2) {
        FragmentGallery fragment = new FragmentGallery();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        ArrayList<myGallery> images = new ArrayList<>();

        images.add(new myGallery(R.drawable.escuela_1));
        images.add(new myGallery(R.drawable.escuela_2));
        images.add(new myGallery(R.drawable.escuela_3));
        images.add(new myGallery(R.drawable.escuela_4));
        images.add(new myGallery(R.drawable.escuela_6));
        images.add(new myGallery(R.drawable.escuela_7));
        images.add(new myGallery(R.drawable.escuela_8));

        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        ViewPager2 viewPager = view.findViewById(R.id.viewPager);

        adapterGallery adapterGallery = new adapterGallery(images, getContext());
        viewPager.setAdapter(adapterGallery);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        adapterSubGallery adapterSubGallery = new adapterSubGallery(images, getContext(), new CustomItemClick() {
            @Override
            public void onItemClick(int position) {
                adapterGallery.setResource(position);
            }
        });

        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapterSubGallery);

        return view;
    }

}