package io.github.rodhino212.essaie;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListAllFragment extends Fragment {

    public ListAllFragment(){}

    List<Operation>operations = new ArrayList<Operation>();
    List<Operation>operations_users = new ArrayList<Operation>();
    int user_id;

    RecyclerView recyclerView;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        operations =((MainActivity2)getActivity()).getAllOp();
        user_id = ((MainActivity2)getActivity()).getUser_id_rec();
        View view = inflater.inflate(R.layout.fragment_all, container, false );
        recyclerView=view.findViewById(R.id.recycler_view_all);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter(new ListOpeAdapter(getUserOperations()));

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        inflater.inflate(R.menu.add_ope,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.addope){
            Intent ajoutoper = new Intent(getActivity(), AjoutOpe.class);
            ajoutoper.putExtra("tk",user_id);
            startActivity(ajoutoper);
            getActivity().finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public List<Operation> getUserOperations(){
        String ref = "oui";
        for(int i=0;i<operations.size();i++){
            if(operations.get(i).getUser_id_op() == user_id && ref.equals(operations.get(i).getPointee())){
                    Operation ope = operations.get(i);
                    operations_users.add(ope);
            }
        }
        return operations_users;
    }
}
