package io.github.rodhino212.essaie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MonthFragment extends Fragment {

    public MonthFragment(){}

    List<Operation> ope = new ArrayList<Operation>();
    List<Operation>opes = new ArrayList<Operation>();
    int use_id;

    RecyclerView rView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ope =((MainActivity2)getActivity()).getAllOp();
        use_id = ((MainActivity2)getActivity()).getUser_id_rec();
        View vi =inflater.inflate(R.layout.fragment_month, container, false );
        rView=vi.findViewById(R.id.recycler_view_month);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(new LinearLayoutManager(getContext()));

        rView.setAdapter(new MonthOpeAdatpter(getUserMOperations()));
        return vi;
    }

    public List<Operation> getUserMOperations(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date now = new Date();
        String d1 = "";
        String d2 = "";
        String date1="";
        Date strDate = now;
        String date2 = sdf.format(strDate).toString();
        d2 = date2.substring(3, 10);

        for(int j=0;j<ope.size();j++){
            if(ope.get(j).getUser_id_op() == use_id) {
                date1 = ope.get(j).getOp_date();
                d1 = date1.substring(3, 10);
                if (d1.equals(d2)) {
                    Operation opera = ope.get(j);
                    opes.add(opera);
                }
            }
        }
        return opes;
    }
}
