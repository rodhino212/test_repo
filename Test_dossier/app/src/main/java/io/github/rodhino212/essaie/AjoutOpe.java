package io.github.rodhino212.essaie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AjoutOpe extends AppCompatActivity {




    private int tk;
    private String sp1,sp2,sp3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_ope);

        Button button2;
        EditText ed1 = findViewById(R.id.descTxt),ed2 = findViewById(R.id.dateTxt),ed3 = findViewById(R.id.mntTxt),ed4 = findViewById(R.id.ctgTxt);
        button2 = findViewById(R.id.addBtn);
        Spinner spinner1 = findViewById(R.id.sp_type);
        Spinner spinner2 = findViewById(R.id.sp_frequence);
        Spinner spinner3 = findViewById(R.id.sp_pointee);



        ArrayAdapter<CharSequence> adap1 = ArrayAdapter.createFromResource(this,R.array.type, android.R.layout.simple_spinner_item);
        adap1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adap1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sp1 = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<CharSequence> adap2 = ArrayAdapter.createFromResource(this,R.array.frequence, android.R.layout.simple_spinner_item);
        adap2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adap2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sp2 = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<CharSequence> adap3 = ArrayAdapter.createFromResource(this,R.array.pointee, android.R.layout.simple_spinner_item);
        adap3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adap3);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sp3 = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Intent it = getIntent();
        tk = it.getIntExtra("tk",0);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.14:8080/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a,b,d;
               a = ed1.getText().toString();
                b = ed2.getText().toString();
                String get = ed3.getText().toString();
                float c = Float.valueOf(get);
                d=ed4.getText().toString();
                //Operation operat = new Operation(a,b,c,sp3,sp2,sp1,d,tk);
                //Log.i("create",""+operat.getOp_description()+","+operat.getOp_date()+","+operat.getOp_montant()+","+operat.getCategorie()+","+operat.getPointee()+","+operat.getFrequence()+","+operat.getType()+","+operat.getUser_id_op());
                Call<Operation> calli = jsonPlaceHolderApi.createOperation(a,b,c,sp3,sp2,sp1,d,tk);
                calli.enqueue(new Callback<Operation>() {
                    @Override
                    public void onResponse(Call<Operation> call, Response<Operation> response) {
                        Operation responseQr = response.body();
                    }

                    @Override
                    public void onFailure(Call<Operation> call, Throwable t) {
                            Log.e("erreur" ,""+t);
                    }
                });
            }
        });
    }
}