package com.flo.soco;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.TextInputEditText;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Homepage extends AppCompatActivity  {

    private TextInputEditText company;
    private TextInputEditText address;
    private TextInputEditText postalCode;
    private TextInputEditText town;
    private Button save;
    private Button goListPage;

    private BusinessManager bm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        //database
        bm = new BusinessManager(this);

        company = (TextInputEditText) findViewById(R.id.company);
        address = (TextInputEditText) findViewById(R.id.address);
        postalCode = (TextInputEditText) findViewById(R.id.postalCode);
        town = (TextInputEditText) findViewById(R.id.town);
        save = (Button) findViewById(R.id.save);
        goListPage = (Button) findViewById(R.id.goListPage);

        //initialisation du Listener
        save.setOnClickListener(btnSaveListener);
        goListPage.setOnClickListener(btnGoListPage);

        init();
    }

    private void init() {

        // initialisation
        company.setText("");
        address.setText("");
        postalCode.setText("");
        town.setText("");

    }

    private View.OnClickListener btnSaveListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            bm.open();
            Business b = new Business();

            String strCompany = company.getText().toString();
            b.setCompany(strCompany);

            String strAddress = address.getText().toString();
            b.setCompany(strAddress);

            String strPostalCode = postalCode.getText().toString();
            b.setCompany(strPostalCode);

            String strTown = town.getText().toString();
            b.setCompany(strTown);

            long data = bm.addBusiness(b);
            init();
            Log.i("Test", "Données envoyées");

        }
    };

    private View.OnClickListener btnGoListPage = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("Test", "Ouverture de la page Liste");
            setContentView(R.layout.list_page);


        }
    };



}
