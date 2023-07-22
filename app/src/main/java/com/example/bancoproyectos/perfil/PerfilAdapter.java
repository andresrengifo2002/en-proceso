package com.example.bancoproyectos.perfil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bancoproyectos.Listadoproyectos;
import com.example.bancoproyectos.R;

import java.util.ArrayList;


/*public class PerfilAdapter {
    public class ViewHolder  {

        private TextView perfiltxt;
        private ImageView image;


 */
public class PerfilAdapter extends RecyclerView.Adapter<PerfilAdapter.ViewHolder> {

    private ArrayList<Perfils> dataset;
    private Context context;

    public PerfilAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
    }

    public void setDataset(ArrayList<Perfils> data) {
        dataset = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_perfil, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Perfils m = dataset.get(position);
        holder.title.setText(m.getUsername());
        Glide.with(context)
                .load(m.getFoto())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.text1); // Reemplaza "R.id.tvTitle" con el ID correcto del TextView en tu layout item_perfil.xml
            image = itemView.findViewById(R.id.imageView12); // Reemplaza "R.id.ivImage" con el ID correcto del ImageView en tu layout item_perfil.xml
        }
    }
}

