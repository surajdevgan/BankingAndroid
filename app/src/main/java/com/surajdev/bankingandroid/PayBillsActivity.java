package com.surajdev.bankingandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.lang.Double.parseDouble;

public class PayBillsActivity extends AppCompatActivity {
    ArrayList<User> userList = new ArrayList<>();


    EditText bill1, bill2, bill3;
    TextView remainBal,errmsg;
    double AcBalance=0.0;
    double billtopay1=0.0;
    double billtopay2=0.0;
    double billtopay3=0.0;
    double updateBal=0.0;
    double totalbilltopay = 0.0;
    public static double bal=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_bills);
        bill1 = findViewById(R.id.edtbill1);
        bill2 = findViewById(R.id.edtbill2);
        bill3 = findViewById(R.id.edtbill3);
        errmsg = findViewById(R.id.error);
        remainBal = findViewById(R.id.extRemainingBalance);
        Bundle bundle = getIntent().getExtras();
        AcBalance = bundle.getDouble("UserBalance");
        String Balances = Double.toString(AcBalance);
        remainBal.setText(Balances);
        userList = (ArrayList<User>) getIntent().getSerializableExtra("QuestionListExtra");

    }





    public void payBillButton(View view) {



        if(!bill3.getText().toString().isEmpty())
        {
            billtopay3 = Double.parseDouble(bill3.getText().toString());

        }

        else {

            billtopay3 = 0.0;
        }

        if(!bill2.getText().toString().isEmpty())
        {
            billtopay2 = Double.parseDouble(bill2.getText().toString());


        }

        else {

            billtopay2 = 0.0;
        }


        if(!bill1.getText().toString().isEmpty())
        {
            billtopay1 = Double.parseDouble(bill1.getText().toString());

        }

        else {

            billtopay1 = 0.0;
        }


        updateBal= Double.parseDouble(remainBal.getText().toString());
        totalbilltopay = billtopay1+billtopay2+billtopay3;


        if(updateBal >= totalbilltopay ){

            bal=updateBal - totalbilltopay;
            remainBal.setText(String.valueOf(bal));
        }
        else{
            errmsg.setText("You have insufficient balance!!!!!!");
        }



    }
}
