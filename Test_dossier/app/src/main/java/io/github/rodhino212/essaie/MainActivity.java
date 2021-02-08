package io.github.rodhino212.essaie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    List<User> billys = new ArrayList<User>();
    List<Operation> operations = new ArrayList<Operation>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.buttonCo);
        EditText name = findViewById(R.id.EditTextName);
        EditText prom = findViewById(R.id.EditTextPrenom);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.14:8080/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<User>> call = jsonPlaceHolderApi.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                billys = response.body();

                for(User user : billys){
                    Log.i("Response", "::::: "+user.getUser_id()+" :::: "+user.getUser_name()+" ::::: "+user.getUser_pren());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("FAILURE",t.getMessage());
            }
        });

        Call<List<Operation>> calle = jsonPlaceHolderApi.getOperations();
        calle.enqueue(new Callback<List<Operation>>() {
            @Override
            public void onResponse(Call<List<Operation>> call, Response<List<Operation>> response) {
                operations = response.body();

                for (Operation ope : operations){
                    Log.i("response","::::"+ope.getOp_description()+"::::::::"+ope.getOp_date()+":::::::"+ope.getOp_montant());
                }
            }

            @Override
            public void onFailure(Call<List<Operation>> call, Throwable t) {
                Log.e("FAILURE",t.getMessage());

            }
        });





        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pr = prom.getText().toString();
                String nm = name.getText().toString();
                int idIntent;

                for (int i=0; i<billys.size();i++){

                if(pr.equals(billys.get(i).getUser_pren()) && nm.equals(billys.get(i).getUser_name())){
                    Intent activity2Intent = new Intent(getApplicationContext(), MainActivity2.class);
                    User user = billys.get(i);
                    activity2Intent.putExtra("id", user);
                    activity2Intent.putExtra("UserList", (Serializable) billys);
                    activity2Intent.putExtra("OperationList", (Serializable) operations);
                    startActivity(activity2Intent);

                }else {
                    System.out.println("pas le bon utilisateur");
                }
            }}
        });
    }
}