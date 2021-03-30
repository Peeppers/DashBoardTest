package com.example.dashboardtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.ProgressDialog;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Inscription extends AppCompatActivity {

    EditText  cpsw, nom, prenom;
    private FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    final String TAG="RegistrationActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription);

        firebaseAuth=FirebaseAuth.getInstance();
        Button valider=(Button) findViewById(R.id.validerButton);
        final EditText mail=findViewById(R.id.mailSI);
        final EditText psw=findViewById(R.id.pswSI);

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp(mail.getText().toString(),psw.getText().toString());
            }
        });

       /* AlertDialog.Builder pswPopup=new AlertDialog.Builder(this);
        pswPopup.setTitle("Erreur");
        pswPopup.setMessage("Les mots de passes de correspondents pas");

        //Bouton verrouiller variable

        nom=(EditText) findViewById(R.id.nomSI);
        cpsw=(EditText) findViewById(R.id.cpswSI);
        prenom=(EditText) findViewById(R.id.prenomSI);
        valider.setEnabled(false);
        //Ecouteur pour verrouiller bouton
        mail.addTextChangedListener(ecoute);
        psw.addTextChangedListener(ecoute);
        nom.addTextChangedListener(ecoute);
        cpsw.addTextChangedListener(ecoute);
        prenom.addTextChangedListener(ecoute);

        //Methode ouverture activité par click sur TextView
        final TextView fen=(TextView) findViewById(R.id.validerButton);
        fen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Inscription.this, MainActivity.class);
                String psw1=psw.getText().toString();
                String psw2=cpsw.getText().toString();
                if(psw1.equals(psw2)){
                    startActivity(intent);
                }
                else pswPopup.show();
            }
        });*/
    }

    private void signUp(String email,String password){
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.d(TAG,"createrUserWithEmail:success");
                    FirebaseUser user= firebaseAuth.getCurrentUser();
                    Toast.makeText(Inscription.this,"Authentification success." + user.getEmail(),Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    Log.w(TAG,"createrUserWithEmail:failure",task.getException());
                    Toast.makeText(Inscription.this,"Authentification failed.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
   /* private final TextWatcher ecoute= new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) { }
        @Override
        public void afterTextChanged(Editable s) {
            if(valChamp(mail)&&valChamp(psw)&&valChamp(nom)&&valChamp(cpsw)&&valChamp(prenom)) {
                    valider.setEnabled(true);
            }
            else valider.setEnabled(false);
        }
    };

    private boolean valChamp(EditText value){
        if(value.getText().toString().length()>0) return true;
        else return false;
    }



    private void registerUser(){
        //getting email and password from edit texts
        String email = mail.getText().toString().trim();
        String password  = psw.getText().toString().trim();

        //checking if email and passwords are empty
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }

        //if the email and password are not empty
        //displaying a progress dialog

        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();

        //creating a new user
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful()){
                            //display some message here
                            Toast.makeText(Inscription.this,"Successfully registered",Toast.LENGTH_LONG).show();
                        }else{
                            //display some message here
                            Toast.makeText(Inscription.this,"Registration Error",Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                });
    }
    @Override
    public void onClick(View view) {
        //calling register method on click
        registerUser();
    }*/
}