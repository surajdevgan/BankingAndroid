package com.surajdev.bankingandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String name, gender = "male", account_type, password,cpassword;
    Spinner accountType;
    int account_num = 0, age = 0;
    double deposit_amt = 0.0;
    EditText etName, etAccountNo, etAmount, etPassword , etcPassword;
    TextView txtage;
    User ba = new User();
    SeekBar seekBar;
    public static String[] accounttypes = {"Select Account Type","Current", "Savings"};
    boolean female = false;
    boolean male = true;
    ArrayList<User> userList = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etName = findViewById(R.id.name);
        etAccountNo = findViewById(R.id.accountid);
        etAmount = findViewById(R.id.amount);
        etPassword = findViewById(R.id.password);
        etcPassword = findViewById(R.id.cpassword);
        accountType = findViewById(R.id.accounttype);
        seekBar = findViewById(R.id.age);
        txtage = findViewById(R.id.txtage);
        accountType.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,accounttypes);
        accountType.setAdapter(aa);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtage.setText("Age: " + String.valueOf(progress));
                age = progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // We are adding some dummy data because because currently we are not using any database
        userList.add(new User("Suraj Devgan", 11111, 2000, "Savings", "Male", 27, "123456"));
        userList.add(new User("Sukhjeet Singh", 22222, 3500, "Savings", "Male", 27, "1234"));
        userList.add(new User("Gracy Sai", 33333, 5000, "Current", "Female", 27, "12345"));


    }

    public void onRadioButtonClicked(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.male:
                if (checked)
                {
                    gender = "male";
                    male = true;
                    female = false;

                }

                else
                    male = false;
                break;

            case R.id.female:
                if (checked)
                {
                    gender = "female";
                    female = true;
                    male = false;

                }

                else
                    female = false;

                break;

        }
    }

    public void Register(View view) {

//        ArrayList<BankAccount> object = new ArrayList<>();
//        object.add(new BankAccount(2,"2","Suraj Devgan","Savings",1100.0,27));
//
//        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
//        Bundle args = new Bundle();
//        args.putSerializable("ARRAYLIST",(Serializable)object);
//        intent.putExtra("BUNDLE",args);
//        startActivity(intent);


//        ArrayList<BankAccount> userList = new ArrayList<>();
//        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
//        Bundle bundle = new Bundle();
//        bundle.putParcelableArrayList("Birds", userList);
//        intent.putExtras(bundle);
//        startActivity(intent);


        name = etName.getText().toString();
        if(!etAccountNo.getText().toString().isEmpty())
        {
            account_num = Integer.parseInt(etAccountNo.getText().toString());


        }

        if(!etAmount.getText().toString().isEmpty())
        {

            deposit_amt = Double.parseDouble(etAmount.getText().toString());

        }
        password = etPassword.getText().toString();
        cpassword = etcPassword.getText().toString();


        if ((!name.equals("")) && (account_num != 0) && (deposit_amt!= 0.0) && (!account_type.equals("Select Account Type")) && (age != 0)&&  (!password.equals("")) && (!cpassword.equals(""))) {


            // this user's data will be added realtime on the time of registration
            userList.add(new User(name, account_num, deposit_amt, account_type, gender, age, cpassword));

            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            intent.putExtra("QuestionListExtra", userList);
            startActivity(intent);
            Toast.makeText(this, "User Registration Successful. Now please login", Toast.LENGTH_LONG).show();

        }


        else {

            Toast.makeText(RegisterActivity.this, "All Fields Are Mandatory", Toast.LENGTH_SHORT).show();


        }






    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        account_type = String.valueOf(accounttypes[position]);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void LoginScreen(View view) {


        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        intent.putExtra("QuestionListExtra", userList);
        startActivity(intent);


    }
}