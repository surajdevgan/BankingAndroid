package com.surajdev.bankingandroid;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class User implements Parcelable, Serializable {


    // this is the Model/ POJO class for bank customers

    protected String name;
    protected int accountNumber;
    protected double depositAmount;
    protected String accountType;
    protected String genderType;
    protected int age;
    protected String password;


    public User() {
    }

    public User(String name, int accountNumber, double depositAmount, String accountType, String genderType, int age, String password) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.depositAmount = depositAmount;
        this.accountType = accountType;
        this.genderType = genderType;
        this.age = age;
        this.password = password;
    }


    protected User(Parcel in) {
        name = in.readString();
        accountNumber = in.readInt();
        depositAmount = in.readDouble();
        accountType = in.readString();
        genderType = in.readString();
        age = in.readInt();
        password = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getGenderType() {
        return genderType;
    }

    public void setGenderType(String genderType) {
        this.genderType = genderType;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "BankAccount{" +
                "name='" + name + '\'' +
                ", accountNumber=" + accountNumber +
                ", depositAmount=" + depositAmount +
                ", accountType='" + accountType + '\'' +
                ", genderType='" + genderType + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(accountNumber);
        dest.writeDouble(depositAmount);
        dest.writeString(accountType);
        dest.writeString(genderType);
        dest.writeInt(age);
        dest.writeString(password);
    }
}