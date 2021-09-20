package com.example.myappestech;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentIndex#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentIndex extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentIndex() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentIndex.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentIndex newInstance(String param1, String param2) {
        FragmentIndex fragment = new FragmentIndex();
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

    int count = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Random rnd = new Random();
        View view = inflater.inflate(R.layout.fragment_index, container, false);

        TextView tvUser = view.findViewById(R.id.tvUser);
        ImageView eagsterEgg = view.findViewById(R.id.eagsterEgg);

        SharedPreferences preferences = getActivity().getSharedPreferences("myPreferences", Context.MODE_PRIVATE);
        String user = preferences.getString("user", "No se ha encontrado ningún usuario");

        tvUser.setText("Bienvenido, " + user);
        String winner = preferences.getString("winner", "");

        if (!winner.equals("winner")) {
            eagsterEgg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    count++;
                    if (count == 10) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        builder.setTitle("Elige un premio");
                        builder.setItems(R.array.premios, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                int code = (int)(100000 * Math.random());
                                List<String> rewards = Arrays.asList(getResources().getStringArray(R.array.premios));
                                AlertDialog.Builder otherBuilder = new AlertDialog.Builder(getActivity());
                                otherBuilder.setTitle("Atención");
                                otherBuilder.setMessage("Has seleccionado el premio: " + rewards.get(which) + ". Pasa por nuestra oficina con el código " + code + " y te lo entregaremos.");
                                otherBuilder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                });
                                AlertDialog otherDialog = otherBuilder.create();

                                otherDialog.show();

                                SharedPreferences.Editor editor = preferences.edit();
                                editor.putString("winner", "winner");
                                editor.apply();
                            }
                        });

                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }

                }
            });
        }

        return view;

    }
}