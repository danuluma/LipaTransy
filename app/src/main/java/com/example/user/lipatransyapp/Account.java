package com.example.user.lipatransyapp;


import android.widget.Toast;

public class Account {
    private String phone_number;
    private String password;

    private int deposit;
    private int payment;
    private int balance = 0;

    public Account(){
    }

    // Methods
    // Get Balance
    private int getBalance(){
        return this.balance;
    }
    private int getPayment(){
        return this.payment;
    }
    public String getPhoneNumber(){
        return this.phone_number;
    }
    public String getPassword(){
        return this.password;
    }

    // Set payment
    private void setPhoneNumber(String phone_number){
        this.phone_number = phone_number;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setPayment(int payment){
        this.payment = payment;
    }
    public int setBalance(int balance){
        return this.balance = balance;
    }

    // Make Payment
    public void makePayment(){
        if(this.balance >= getPayment()){
            setBalance(getBalance() - getPayment());
            
        }
        else{
//            Toast.makeText(, "", Toast.LENGTH_SHORT).show();
        }
    }
}
