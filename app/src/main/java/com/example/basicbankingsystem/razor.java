package com.example.basicbankingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.razorpay.Checkout;
import com.razorpay.PaymentData;
import com.razorpay.PaymentResultWithDataListener;

import org.json.JSONObject;

import java.util.ArrayList;

public class razor extends AppCompatActivity implements PaymentResultWithDataListener{
ImageView im;
TextView t;
Integer flag=0;

    String name,contact,amount,email,account;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_razor);
        Checkout.preload(getApplicationContext());
        im=(ImageView) findViewById(R.id.imageView2);
        t=(TextView) findViewById(R.id.textView);




                Intent intent= getIntent();
                 name=intent.getStringExtra("name");
                 contact=intent.getStringExtra("contact");
                 email=intent.getStringExtra("email");
                 account=intent.getStringExtra("account");
                 amount=intent.getStringExtra("amount");
               







                Checkout checkout = new Checkout();

                checkout.setKeyID("rzp_test_Egucjyk4cEXrPj");
                /**
                 * Instantiate Checkout
                 */


                /**
                 * Set your logo here
                 */
                checkout.setImage(R.drawable.ic_baseline_account_circle_24);

                /**
                 * Reference to current activity
                 */
                final Activity activity = this;

                /**
                 * Pass your payment options to the Razorpay Checkout as a JSONObject
                 */
                try {
                    JSONObject options = new JSONObject();

                    options.put("name", name);
                    options.put("description", "Reference No. #123456");
                    options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
                    // options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
                    options.put("theme.color", "#3399cc");
                    options.put("currency", "INR");
                    options.put("amount", amount);//pass amount in currency subunits
                    options.put("prefill.email", email);
                    options.put("prefill.contact",contact);
                    JSONObject retryObj = new JSONObject();
                    retryObj.put("enabled", true);
                    retryObj.put("max_count", 4);
                    options.put("retry", retryObj);

                    checkout.open(activity, options);


                } catch(Exception e) {
                    Log.e("TAG", "Error in starting Razorpay Checkout", e);
                }




            }


    @Override
    public void onPaymentSuccess(String s, PaymentData paymentData) {
        Toast.makeText(getApplicationContext(),
                "payment successful" + s, Toast.LENGTH_SHORT).show();
        im.setImageResource(R.drawable.check);
        t.setText("Payment is successful id is" + s);

    }

    @Override
    public void onPaymentError(int i, String s, PaymentData paymentData) {

    }
}