package Examen.App.Robles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter_productos extends RecyclerView.Adapter<MyAdapter_productos.ViewHolder>  {

    private List<Film_productos> mFilms;
    private OnRecyclerViewItemListener_productos mItemListener;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView titleTextView;
        public TextView descTextView;
        public ImageView imageImageView;

        public ViewHolder(View itemView) {
            super(itemView);

            titleTextView = (TextView) itemView.findViewById(R.id.title);
            descTextView = (TextView) itemView.findViewById(R.id.description);
            imageImageView = (ImageView) itemView.findViewById(R.id.image);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mItemListener.onItemClick(null, view, getAdapterPosition());
        }

    }


    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter_productos(List<Film_productos> films, OnRecyclerViewItemListener_productos itemListener) {
        mFilms = films;
        mItemListener = itemListener;
    }

    @Override
    public MyAdapter_productos.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View filmView = inflater.inflate(R.layout.film_item_productos, parent, false);

        ViewHolder viewHolder = new ViewHolder(filmView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Film_productos film = mFilms.get(position);

        holder.titleTextView.setText(film.getTitle());
        holder.descTextView.setText(film.getDescription());
        holder.imageImageView.setImageResource(film.getImage());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mFilms.size();
    }

}
