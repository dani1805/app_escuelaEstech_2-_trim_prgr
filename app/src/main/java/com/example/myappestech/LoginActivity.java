package com.example.myappestech;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText loginUsername = findViewById(R.id.loginUsername);
        EditText loginPassword = findViewById(R.id.loginPassword);
        Button loginForgotPass = findViewById(R.id.loginForgotPass);
        Button loginButton = findViewById(R.id.loginButton);
        Button loginCallHelp = findViewById(R.id.loginCallHelp);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = loginUsername.getText().toString();
                String passwd = loginPassword.getText().toString();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                SharedPreferences preferences = getSharedPreferences("myPreferences", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

                if (user.equals("invitado") && passwd.equals("estech1234")) {
                    editor.putString("user", user);
                    editor.apply();
                    startActivity(intent);
                } else if (user.equals("alumno") && passwd.equals("alumno1234")) {
                    editor.putString("user", user);
                    editor.apply();
                    startActivity(intent);
                } else if (user.equals("profesor") && passwd.equals("profesor1234")) {
                    editor.putString("user", user);
                    editor.apply();
                    startActivity(intent);
                } else if (user.isEmpty()) {
                    loginUsername.setError("El campo está vacío");
                } else if (passwd.isEmpty()) {
                    loginPassword.setError("El campo está vacío");
                } else {

                    androidx.appcompat.app.AlertDialog.Builder otherBuilder = new androidx.appcompat.app.AlertDialog.Builder(LoginActivity.this);
                    otherBuilder.setTitle("Error");
                    otherBuilder.setMessage("Usuario y contraseña incorrectos. Vuelva a intentarlo");
                    otherBuilder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    androidx.appcompat.app.AlertDialog otherDialog = otherBuilder.create();
                    otherDialog.show();

                    loginUsername.setError("Datos incorrectos");
                    loginPassword.setError("Datos incorrectos");
                }
            }
        });

        loginForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pattern pattern = Patterns.EMAIL_ADDRESS;

                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                View view = getLayoutInflater().inflate(R.layout.data,null);
                EditText user_email = view.findViewById(R.id.user_email);
                builder.setView(view);

                builder.setPositiveButton("OK" , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(LoginActivity.this, "Enviado a " + user_email.getText(),
                                Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(LoginActivity.this, "No se ha guardado ningún email.",
                                Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog dialog = builder.create();

                user_email.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    // Pattern tiene un método estático compile(«…») por el cual se obtiene una instancia, dado un String que contiene la expresión regular. Este objeto debe reutilizarse entre usos de la misma expresión regular, para evitar incurrir en tiempos innecesarios al compilar una y otra vez la misma expresión.

                    @Override
                    public void afterTextChanged(Editable s) {
                        if (TextUtils.isEmpty(s)) {
                            user_email.setError("Campo obligatorio");
                            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
                        } else if(!pattern.matcher(s).matches()) {
                            user_email.setError("El texto introducido no tiene formato de correo electrónico");
                            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
                        } else {
                            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(true);
                        }
                    }
                });

                dialog.show();
            }
        });

        loginCallHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:953636000"));
                startActivity(callIntent);
            }
        });
}
}