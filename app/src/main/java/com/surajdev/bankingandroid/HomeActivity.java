package com.surajdev.bankingandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    TextView Name, Balance, AcType;
    String venName;
    String actype;
    double AcBalance;
    ArrayList<User> userList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Name = findViewById(R.id.welcome);
        Balance = findViewById(R.id.totalbalance);
        AcType = findViewById(R.id.actype);


        Bundle bundle = getIntent().getExtras();

//Extracting the data…
        venName = bundle.getString("UserName");
         actype = bundle.getString("AcType");


        AcBalance = bundle.getDouble("UserBalance");
        String Balances= Double.toString(AcBalance);


        Name.setText("Welcome\n"+venName);
        Balance.setText(Balances);
        AcType.setText(actype);
        userList = (ArrayList<User>) getIntent().getSerializableExtra("QuestionListExtra");

    }



    public void TransferFund(View view) {

        Bundle bundle = new Bundle();
//Add your data from getFactualResults method to bundle

        bundle.putDouble("UserBalance", AcBalance);
//Add the bundle to the intent

        Intent intent = new Intent(this, FundsTransferActivity.class);
        intent.putExtra("QuestionListExtra", userList);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void PayBill(View view) {
//Create the bundle
        Bundle bundle = new Bundle();
//Add your data from getFactualResults method to bundle
        bundle.putDouble("UserBalance", AcBalance);
//Add the bundle to the intent

        Intent i = new Intent(this, PayBillsActivity.class);
        i.putExtras(bundle);
        startActivity(i);


    }

    public void SignOut(View view) {
startActivity(new Intent(this, LoginActivity.class));    }
}