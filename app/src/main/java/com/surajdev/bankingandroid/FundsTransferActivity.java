package com.surajdev.bankingandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.view.View.VISIBLE;

public class FundsTransferActivity extends AppCompatActivity {
    ArrayList<User> userList = new ArrayList<>();
    EditText edtpayeeaccount,transamt ;
    TextView txtaccountdetails, txtreminingblance;
    boolean foundaccount = false;
    Button Find,transfer;
    double AcBalance=0.0;
    double sendmoney = 0.0;
    double remainingBalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funds_transfer);
        transfer = findViewById(R.id.btntransfer);
        edtpayeeaccount = findViewById(R.id.payeeaccountno);
        transamt=findViewById(R.id.transferamount);
        txtreminingblance = findViewById(R.id.reminingblance);
        Find = findViewById(R.id.findaccount);
        txtaccountdetails = findViewById(R.id.txtaccountdetails);
        userList = (ArrayList<User>) getIntent().getSerializableExtra("QuestionListExtra");
        Bundle bundle = getIntent().getExtras();
        remainingBalance = bundle.getDouble("UserBalance");
        String RemainingBalances= Double.toString(remainingBalance);
        txtreminingblance.setText("Your Remaining Balance is "+remainingBalance);



        // onclick listener on transfer fund button
        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


if(remainingBalance>sendmoney)
{
    sendmoney = Double.parseDouble(transamt.getText().toString());
    remainingBalance -= sendmoney;
    txtreminingblance.setText("Your Remaining "+remainingBalance);

}

else {

    Toast.makeText(FundsTransferActivity.this, "Insufficient Balance", Toast.LENGTH_SHORT).show();
}


            }
        });

    }

    public void FindPayee(View view) {

        int enteredAccountNumber = Integer.parseInt(edtpayeeaccount.getText().toString());

        for(User ba : userList)
        {


            if(ba.accountNumber == enteredAccountNumber)
            {
                Find.setVisibility(View.GONE);
                transfer.setVisibility(VISIBLE);
                transamt.setVisibility(VISIBLE);
                edtpayeeaccount.setVisibility(View.GONE);

                //    foundaccount = true;
                txtaccountdetails.setText("Name: "+ba.name+"\n"+"Account No: "+ba.accountNumber+"\n"+"Account Type: "+ba.accountType+"\n"+"Gender: "+ba.genderType+"\n"+"Age: "+ba.age);

                Toast.makeText(this, "Account Found", Toast.LENGTH_SHORT).show();
                break;

            }


        }

    }


}