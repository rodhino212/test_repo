package io.github.rodhino212.essaie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListOpeNpAdapter extends RecyclerView.Adapter<ListOpeNpAdapter.ViewHolder> {
    List<Operation> npList1;
    public ListOpeNpAdapter(List<Operation>npList){this.npList1=npList;}
    @NonNull
    @Override
    public ListOpeNpAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vis = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewlist_options,parent,false);
        ViewHolder vH = new ViewHolder(vis);
        return vH;
    }

    @Override
    public void onBindViewHolder(@NonNull ListOpeNpAdapter.ViewHolder holder, int position) {

        holder.textDesc.setText(npList1.get(position).getOp_description());
        holder.textDate.setText(npList1.get(position).getOp_date());

    }

    @Override
    public int getItemCount() {
        return npList1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textDesc;
        TextView textDate;

        public ViewHolder(@NonNull View iV) {
            super(iV);
            textDesc = iV.findViewById(R.id.description_op);
            textDate = iV.findViewById(R.id.date_op_options);
        }
    }
}
