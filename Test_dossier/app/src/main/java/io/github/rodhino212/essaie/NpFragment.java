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

import java.util.ArrayList;
import java.util.List;

public class NpFragment extends Fragment {

    public NpFragment(){}
    List<Operation> np = new ArrayList<Operation>();
    List<Operation>nps = new ArrayList<Operation>();
    int us_id;

    RecyclerView rcv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        np =((MainActivity2)getActivity()).getAllOp();
        us_id = ((MainActivity2)getActivity()).getUser_id_rec();
        View vi = inflater.inflate(R.layout.fragment_np, container, false );
        rcv=vi.findViewById(R.id.recycler_view_np);
        rcv.setHasFixedSize(true);
        rcv.setLayoutManager(new LinearLayoutManager(getContext()));

        rcv.setAdapter(new ListOpeNpAdapter(getUserOperationsNp()));

        return vi;
    }
   public List<Operation> getUserOperationsNp(){
        String ref = "non";
        for(int k=0;k<np.size();k++){
            if(np.get(k).getUser_id_op() == us_id && ref.equals(np.get(k).getPointee())){
                Operation ope = np.get(k);
                nps.add(ope);
            }
        }

        return nps;
    }
}
