package com.example.dashboardtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    // Variable verrouillage bouton
    EditText mail, psw;
    Button connexion;
    private FirebaseAuth mAuth;
    final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        Button connexion=(Button) findViewById(R.id.coButton);
        EditText mail=(EditText) findViewById(R.id.mailCo);
        EditText psw=(EditText) findViewById(R.id.pswCo);

        /*
        connexion.setEnabled(false);
        //Ecouteur pour Bouton connexion condition remplissage
        mail.addTextChangedListener(ecoute);
        psw.addTextChangedListener(ecoute);*/

        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(mail.getText().toString(),psw.getText().toString());
            }
        });

        //Methode ouverture activité par click sur TextView
        final TextView inscri=(TextView) findViewById(R.id.inscription);
        inscri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Inscription.class);
                startActivity(intent);
            }
        });

    }

    /*private final TextWatcher ecoute= new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) { }
        @Override
        public void afterTextChanged(Editable s) {
            if((mail.getText().toString().length()==0)&&(psw.getText().toString().length()==0)){
                connexion.setEnabled(false);
            }
            else connexion.setEnabled(true);
        }
    };*/

    private  void login(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(MainActivity.this, "Authentication success." + user.getEmail(),
                                    Toast.LENGTH_SHORT).show();
                            Intent co=new Intent(MainActivity.this,ListeAct.class);
                            startActivity(co);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}