package io.github.rodhino212.essaie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
        List<Operation>test=new ArrayList<Operation>();
        int user_id_rec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        int index = 0;
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ListAllFragment()).commit();

        Intent intent = getIntent();
        User user =(User)intent.getSerializableExtra("id");
        List<User>Users = (List<User>) intent.getSerializableExtra("UserList");
        Log.e("id-user",":::"+user.getUser_id());
        user_id_rec = user.getUser_id();
        for (User users:
                Users) {
            Log.d("Print Users name: ", users.getUser_name() + "");
        }

        List<Operation>Operations = (List<Operation>) intent.getSerializableExtra("OperationList");
        test = Operations;
        for (Operation operations:
                Operations) {
            Log.d("Print Operations item: ", operations.getOp_description() +":::::::"+operations.getOp_montant()+":::::::::"+operations.getOp_date());
        }



    }

    public int getUser_id_rec(){return user_id_rec;}

    public List<Operation> getAllOp(){
        return test;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()){
                        case R.id.navLsitOp:
                            selectedFragment = new ListAllFragment();
                            break;
                        case R.id.navLsitMo:
                            selectedFragment = new MonthFragment();
                            break;
                        case R.id.navLsitNp:
                            selectedFragment = new NpFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    return true;
                }
            };
}