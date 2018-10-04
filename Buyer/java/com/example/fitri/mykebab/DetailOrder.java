package com.example.fitri.mykebab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DetailOrder extends AppCompatActivity {

    private Order myOrder = new Order();
    private Bundle Userbundle;
    private String PRICE;
    private String QUANTITY;
    private String EXTRAS;
    private String DLOCATION;

    DatabaseReference OrderDatabase;

    //String EXTRAS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_order);

        Userbundle = getIntent().getExtras();
        final String[] location = getResources().getStringArray(R.array.Location_Array);

        //myOrder.setName(Userbundle.getString("NAME"));
        //myOrder.setPhoneNumber(Userbundle.getString("PHONE"));
        myOrder.setOrderItem(Userbundle.getString("OITEM"));

        OrderDatabase = FirebaseDatabase.getInstance().getReference("Orders").child(Userbundle.getString("USER_ID"));
        //OrderDatabase = FirebaseDatabase.getInstance().getReference("Orders");

        ImageView BannerImage = (ImageView) findViewById(R.id.bannerPicture);
        TextView BannerName = (TextView) findViewById(R.id.bannerItemName);
        TextView BannerPrice = (TextView) findViewById(R.id.bannerprice);
        final EditText EDITEXTRAS = (EditText) findViewById(R.id.extrasEditText);
        final EditText quantity = (EditText) findViewById(R.id.quantityEdit);
        final Spinner locationSpinner = (Spinner) findViewById(R.id.locationspinner);
        final TextView totalprice = (TextView) findViewById(R.id.totalprice);
        final TextView quantityfinal = (TextView) findViewById(R.id.quantity);
        final TextView finalLocation = (TextView) findViewById(R.id.deliveryLocationfinal);

        if(myOrder.getOrderItem().equals("Kebab"))
        {
            BannerImage.setImageResource(R.drawable.pitakebab);
        }else if (myOrder.getOrderItem().equals("Burger Goreng"))
        {
            BannerImage.setImageResource(R.drawable.burger);
        }
        else if (myOrder.getOrderItem().equals("Kebab Rolls"))
        {
            BannerImage.setImageResource(R.drawable.kebabwrap);
        }
        else if (myOrder.getOrderItem().equals("Satay Ikan"))
        {
            BannerImage.setImageResource(R.drawable.satay);
        }

        BannerName.setText(myOrder.getOrderItem());
        BannerPrice.setText("RM "+ Userbundle.getString("OPRICE"));

        totalprice.setText("Total Price:\t\t RM"+Userbundle.getString("OPRICE"));
        PRICE = Userbundle.getString("OPRICE");
        QUANTITY = quantity.getText().toString();
        DLOCATION = location[0];
        EXTRAS = EDITEXTRAS.getText().toString();


        final RadioGroup radioMeatGroup = (RadioGroup) findViewById(R.id.meatType);

        //set the delivery location
        locationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                finalLocation.setText("Delivery Location:\t\t "+ location[i]);
                //add the selected location to object
                DLOCATION = location[i];


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //set the price and quantity
        quantity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(quantity.getText().toString().equals(""))
                {

                }
                else{
                    QUANTITY = quantity.getText().toString();
                    int quan = Integer.parseInt(QUANTITY);
                    Toast.makeText(getBaseContext(), "Quantity: "+ String.valueOf(quan), Toast.LENGTH_SHORT).show();
                    float price = (float) (quan* Float.parseFloat(Userbundle.getString("OPRICE")));
                    totalprice.setText("Total Price:\t\t\tRM" + String.valueOf(price));
                    quantityfinal.setText("Quantity:\t\t\t" + String.valueOf(quan));
                    PRICE = String.valueOf(price);

                }

            }
        });


        Button ordersubmit = (Button) findViewById(R.id.ordersubmit);

        ordersubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EXTRAS = EDITEXTRAS.getText().toString();

                RadioButton radioMeatButton = (RadioButton) findViewById(radioMeatGroup.getCheckedRadioButtonId());

                myOrder.setQuantity(QUANTITY);
                myOrder.setPrice(PRICE);
                myOrder.setLocation(DLOCATION);
                myOrder.setExtras(EXTRAS);

                myOrder.setMeatType(radioMeatButton.getText().toString());



                String id = OrderDatabase.push().getKey();

                myOrder.setID(id);

                OrderDatabase.child(id).setValue(myOrder);

                Toast.makeText(getBaseContext(),"Order Submited" ,Toast.LENGTH_SHORT).show();


                finish();
            }
        });
    }
}
