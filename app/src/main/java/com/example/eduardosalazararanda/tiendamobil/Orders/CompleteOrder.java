package com.example.eduardosalazararanda.tiendamobil.Orders;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.braintreepayments.cardform.view.CardForm;
import com.example.eduardosalazararanda.tiendamobil.R;

public class CompleteOrder extends AppCompatActivity {
    ApiOrders orders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_order);
        Intent intent = getIntent();
        String state = intent.getStringExtra("state");
        String orderId = intent.getStringExtra("orderId");
        final Order newOrder = new Order(orderId,state);
        orders = new ApiOrders();

        final CardForm cardForm = findViewById(R.id.card_form);
        Button buy = findViewById(R.id.btnBuy);

        cardForm.cardRequired(true)
                .expirationRequired(true)
                .cvvRequired(true)
                .postalCodeRequired(true)
                .mobileNumberRequired(true)
                .setup(CompleteOrder.this);

        cardForm.getCvvEditText().setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cardForm.isValid()){
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(CompleteOrder.this);
                    alertBuilder.setTitle("Confirme antes de comprar");
                    alertBuilder.setMessage("Numero de tarjeta: " + cardForm.getCardNumber() + "\n" +
                            "Fecha de expiracion: " + cardForm.getExpirationDateEditText().getText().toString() + "\n" +
                            "CVV: " + cardForm.getCvv() + "\n" +
                            "Codigo Postal: " + cardForm.getPostalCode() + "\n" +
                            "Numero Telefonico: " + cardForm.getMobileNumber());
                    alertBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            Toast.makeText(CompleteOrder.this, "Gracias por su compra", Toast.LENGTH_LONG).show();
                            newOrder.setPay(cardForm.getCardNumber());
                            orders.Update(newOrder, new ApiOrders.ServiceCallCack() {
                                @Override
                                public void response(Boolean bool) {
                                    if(true){
                                        Intent intent = new Intent(getApplicationContext(), OrdersListActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });

                        }
                    });
                    alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            finish();
                        }
                    });
                    AlertDialog alertDialog = alertBuilder.create();
                    alertDialog.show();
                }else {
                    Toast.makeText(CompleteOrder.this, "Porfavor complete los campos", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
