package com.example.myappestech;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentBlog#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentBlog extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentBlog() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentBlog.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentBlog newInstance(String param1, String param2) {
        FragmentBlog fragment = new FragmentBlog();
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
        ArrayList<myBlog> notices = new ArrayList<>();
                notices.add(new myBlog(R.string.art1_title, R.drawable.noticia_1, R.string.art1_desc1, R.string.art1_desc2, R.string.art1_desc3, R.drawable.noticia_1_image_1, R.drawable.noticia_1_image_2, R.string.art1_date));
                notices.add(new myBlog(R.string.art2_title, R.drawable.noticia_2, R.string.art2_desc1, R.string.art2_desc2, R.string.art2_desc3, R.drawable.noticia_2_image_1, R.drawable.noticia_2_image_2, R.string.art2_date));
                notices.add(new myBlog(R.string.art3_title, R.drawable.noticia_3, R.string.art3_desc1, R.string.art3_desc2, R.string.art3_desc3, R.drawable.noticia_3_image_1, R.drawable.noticia_3_image_2, R.string.art3_date));
                notices.add(new myBlog(R.string.art4_title, R.drawable.noticia_4, R.string.art4_desc1, R.string.art4_desc2, R.string.art4_desc3, R.drawable.noticia_4_image_1, R.drawable.noticia_4_image_2, R.string.art4_date));
                notices.add(new myBlog(R.string.art5_title, R.drawable.noticia_5, R.string.art5_desc1, R.string.art5_desc2, R.string.art5_desc3, R.drawable.noticia_5_image_1, R.drawable.noticia_5_image_2, R.string.art5_date));
                notices.add(new myBlog(R.string.art6_title, R.drawable.noticia_6, R.string.art6_desc1, R.string.art6_desc2, R.string.art6_desc3, R.drawable.noticia_6_image_1, R.drawable.noticia_6_image_2, R.string.art6_date));

        View view = inflater.inflate(R.layout.fragment_blog, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.rvItems);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        adapterBlog adapterBlog = new adapterBlog(getContext(), notices, new CustomItemClick() {
            @Override
            public void onItemClick(int position) {
                myBlog item = notices.get(position);
                Intent intent = new Intent(getContext(), DetailBlog.class);
                intent.putExtra("item", item);
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(adapterBlog);


        return view;
    }
}