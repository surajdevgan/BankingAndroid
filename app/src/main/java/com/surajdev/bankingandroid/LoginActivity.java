package com.surajdev.bankingandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    EditText AccountId, AccountPassword;
    boolean userfound = false;

    ArrayList<User> userList = new ArrayList<>();

    ArrayList<User> payee=new ArrayList<>(); // this list will contains all required payee
    int choice = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AccountId = findViewById(R.id.accountId);
        AccountPassword = findViewById(R.id.password);


        userList = (ArrayList<User>) getIntent().getSerializableExtra("QuestionListExtra");



        //  Intent intent = getIntent();
        //Bundle args = intent.getBundleExtra("BUNDLE");
        //userList = (ArrayList<BankAccount>) args.getSerializable("ARRAYLIST");

    }




    public void Register(View view) {

        startActivity(new Intent(this, RegisterActivity.class));
    }

    public void Login(View view) {
        int enteredAccountNumber = Integer.parseInt(AccountId.getText().toString());
        String enteredPassword = AccountPassword.getText().toString();

        for(User ba : userList)
        {
            if(ba.accountNumber == enteredAccountNumber && ba.password.equals(enteredPassword))
            {

userfound = true;
//Create the bundle
                Bundle bundle = new Bundle();
//Add your data from getFactualResults method to bundle
                bundle.putString("UserName", ba.name);
                bundle.putString("AcType", ba.accountType);
                bundle.putDouble("UserBalance", ba.depositAmount);
//Add the bundle to the intent

                Intent i = new Intent(this, HomeActivity.class);
                i.putExtras(bundle);
                i.putExtra("QuestionListExtra", userList);
                startActivity(i);
                finish();

                break;

            }




        }

        if(!userfound)
        {

            Toast.makeText(this, "Invalid Account Or Password", Toast.LENGTH_SHORT).show();




        }


    }
}