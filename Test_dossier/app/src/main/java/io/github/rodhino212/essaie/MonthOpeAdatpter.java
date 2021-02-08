package io.github.rodhino212.essaie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MonthOpeAdatpter extends RecyclerView.Adapter<MonthOpeAdatpter.ViewHolder> {

    List<Operation> monthList1;
    public MonthOpeAdatpter(List<Operation>monthList){this.monthList1=monthList;}
    @NonNull
    @Override
    public MonthOpeAdatpter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vie = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewlist_options,parent,false);
        ViewHolder vh = new ViewHolder(vie);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MonthOpeAdatpter.ViewHolder holder, int position) {
        holder.texdesc.setText(monthList1.get(position).getOp_description());
        holder.textdate.setText(monthList1.get(position).getOp_date());

    }

    @Override
    public int getItemCount() {
        return monthList1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView texdesc;
        TextView textdate;
        public ViewHolder(@NonNull View Itv) {
            super(Itv);
            texdesc = Itv.findViewById(R.id.description_op);
            textdate = Itv.findViewById(R.id.date_op_options);

        }
    }
}
