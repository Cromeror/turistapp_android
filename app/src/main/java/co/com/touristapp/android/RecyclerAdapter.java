package co.com.touristapp.android;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Next University
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    String [] arreglo={"Layouts","Fragment","Items","Java","Android"};
    Context context;
    LayoutInflater inflater;

    public RecyclerAdapter(Context context){
        this.context=context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.item,parent,false);
        RecyclerViewHolder view1= new RecyclerViewHolder(v);
        return view1;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.t1.setText(arreglo[position]);
        holder.im.setOnClickListener(onClickListener);
        holder.im.setTag(holder);


    }
    View.OnClickListener onClickListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerViewHolder vh=(RecyclerViewHolder)v.getTag();
            int posicion = vh.getAdapterPosition();
            Toast.makeText(context,"La posicion es"+posicion,Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public int getItemCount() {
        return arreglo.length;
    }
}
