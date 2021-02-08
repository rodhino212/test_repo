package io.github.rodhino212.essaie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListOpeAdapter extends RecyclerView.Adapter<ListOpeAdapter.ViewHolder> {

    List<Operation> operationLists1;

    public ListOpeAdapter(List<Operation> operationLists){
        this.operationLists1=operationLists;
    }
    @NonNull
    @Override
    public ListOpeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewlist,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListOpeAdapter.ViewHolder holder, int position) {
            holder.numText.setText(operationLists1.get(position).getOp_description());
            holder.dateText.setText(operationLists1.get(position).getOp_date());
            holder.typeText.setText(operationLists1.get(position).getType());
    }

    @Override
    public int getItemCount() {
        return operationLists1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView numText;
        TextView typeText;
        TextView dateText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            numText=itemView.findViewById(R.id.num_op);
            typeText=itemView.findViewById(R.id.op_type);
            dateText=itemView.findViewById(R.id.date_op);
        }
    }
}
