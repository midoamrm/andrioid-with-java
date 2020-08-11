package contorel;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieshow.MainActivity2;
import com.example.movieshow.R;

import java.util.List;

import model.Move;

public class Movieadpter extends RecyclerView.Adapter<Movieadpter.myveiwholder> {
    private List<Move> movelist;
    private Context context;

    public Movieadpter( Context context ,   List<Move> movelist) {
        this.movelist = movelist;
        this.context=context;
    }

    @NonNull
    @Override
    public myveiwholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itView= LayoutInflater.from(parent.getContext()).inflate(R.layout.move,parent,false);
        return new myveiwholder(itView);
    }

    @Override
    public void onBindViewHolder(@NonNull myveiwholder holder, int position) {
        Move move=movelist.get(position);
        holder.name.setText(move.getName());
        holder.descrptiom.setText(move.getDescrption());
        holder.tpe.setText(move.getType());
        holder.image.setImageResource(move.getImage());
    }

    @Override
    public int getItemCount() {
        return movelist.size();
    }

    public class myveiwholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView name;
        private TextView  tpe;
        private TextView descrptiom;
        private ImageView image;
        public myveiwholder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name=itemView.findViewById(R.id.name);
            tpe=itemView.findViewById(R.id.kind);
            descrptiom=itemView.findViewById(R.id.decrption);
            image=itemView.findViewById(R.id.imageView2);
        }

        @Override
        public void onClick(View view) {

            int p=getAdapterPosition();
            Move move=movelist.get(p);
            Intent intent=new Intent(context, MainActivity2.class);
           intent.putExtra("des",move.getDes());
           intent.putExtra("link",move.getLink());
            intent.putExtra("im",move.getImage());
            context.startActivity(intent);

        }
    }
}


