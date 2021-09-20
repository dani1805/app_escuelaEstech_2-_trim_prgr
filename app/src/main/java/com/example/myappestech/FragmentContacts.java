package com.example.myappestech;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentContacts#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentContacts extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentContacts() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentContacts.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentContacts newInstance(String param1, String param2) {
        FragmentContacts fragment = new FragmentContacts();
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
        View view = inflater.inflate(R.layout.fragment_contacts, container, false);

        LinearLayout location = view.findViewById(R.id.location);
        LinearLayout mailInfo = view.findViewById(R.id.mailInfo);
        LinearLayout mailSchool = view.findViewById(R.id.mailSchool);
        LinearLayout phone = view.findViewById(R.id.phone);
        LinearLayout whaatsapp = view.findViewById(R.id.whatsapp);
        EditText etName = view.findViewById(R.id.etName);
        EditText etEmail = view.findViewById(R.id.etEmail);
        EditText etPhone = view.findViewById(R.id.etPhone);
        EditText etMessage = view.findViewById(R.id.etMessage);
        Button login = view.findViewById(R.id.login);
        CheckBox myCheckBox = view.findViewById(R.id.myCheckBox);

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("geo: 38.0941902,-3.6334425?15zdata=!3m1!4b1!4m5!3m4!1s0xd6e9bd065a783ed:0x2d4b0fd6aae7f47e!8m2!3d38.0941902!4d-3.6312538(Escuela Estech"));
                startActivity(intent);
            }
        });

        mailInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String [] adress = {"info@escuelaestech.es"};
                String subject = "asunto";
                String text = "";
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, adress);
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, text);
                startActivity (Intent.createChooser(intent,"Elige un cliente de correo"));
            }
        });

        mailSchool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String [] adress = {"secretaria@escuelaestech.es"};
                String subject = "asunto";
                String text = "";
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, adress);
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, text);
                startActivity (Intent.createChooser(intent,"Elige un cliente de correo"));
            }
        });

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:953636000"));
                startActivity(callIntent);
            }
        });

        whaatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://api.whatsapp.com/send?phone=34697246008");
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(uri);
                startActivity(intent);

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("raul", etName.getText().toString());

                String name = etName.getText().toString();
                String email = etEmail.getText().toString();
                String telephone = etPhone.getText().toString();
                String message = etMessage.getText().toString();

                Log.i("raul", etName.getText().toString());

                if (name.isEmpty()) {
                    etName.setError("Campo vacío");
                } else if (email.isEmpty()) {
                    etEmail.setError("Campo vacío");
                } else if (telephone.isEmpty()) {
                    etPhone.setError("Campo vacío");
                } else if (message.isEmpty()) {
                    etMessage.setError("Campo vacío");
                } else if (!myCheckBox.isChecked()) {
                    myCheckBox.setError("Campo vacío");
                } else {

                    AlertDialog.Builder builder = new AlertDialog.Builder(container.getContext());
                    builder.setTitle("Atención");
                    builder.setMessage("Vas a enviar estos datos por correo electrónico.¿Estás seguro de ello?");
                    builder.setNegativeButton("CANCELAR", null);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String [] adresses = {"secretaria@escuelaestech.es, info@escuelaestech.es"};
                            String subject = "asunto";
                            Intent intent = new Intent(Intent.ACTION_SEND);
                            intent.setDataAndType(Uri.parse("mailto"),"text/plain");
                            intent.putExtra(Intent.EXTRA_EMAIL, adresses);
                            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                            intent.putExtra(Intent.EXTRA_TEXT, "\nNombre: " + name + "\nEmail: " + email + "\nTeléfono: " + telephone + "\nMensaje: " + message);
                            
                               startActivity (Intent.createChooser(intent,"Elige un cliente de correo"));
                        }
                    });

                    AlertDialog dialog = builder.create();
                    dialog.show();

                }

            }
        });

        return view;
    }
}