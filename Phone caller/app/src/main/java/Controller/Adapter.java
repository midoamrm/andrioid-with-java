package Controller;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import Model.Data;
import Views.EditData;
import Views.Call;

import com.example.sqlnndrecview.MainActivity;
import com.example.sqlnndrecview.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {


    private Context context;
    private List<Data> List;
    private DatabaseHelper databaseHelper;

    public Adapter(Context context , List<Data> allData) {
        this.context = context;
        this.List = allData;
    }

    public Adapter(Context context, List<Data> list, DatabaseHelper databaseHelper) {
        this.context = context;
        List = list;
        this.databaseHelper = databaseHelper;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_content,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        final Data data = List.get(position);
        holder.data.setText(data.getName());
        holder.timestamp.setText(formatDate(data.getTimeStamp()));
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteData(position);
            }
        });
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,String.valueOf(data.getId()),Toast.LENGTH_LONG).show();

                Intent intent = new Intent(context, EditData.class);
                intent.putExtra("position",String.valueOf(data.getId()));
                context.startActivity(intent);
            }
        });
       holder.call.setOnClickListener(new View.OnClickListener(){


           @Override
           public void onClick(View view) {

               Intent intent = new Intent(context, Call.class);
               intent.putExtra("numberp",String.valueOf(data.getId()));
               context.startActivity(intent);

           }
       });


    }

    @Override
    public int getItemCount() {
        return List.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView data,timestamp;
        public ImageView delete,edit,call;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            data = itemView.findViewById(R.id.data);
            timestamp = itemView.findViewById(R.id.timestamp);
            delete  = itemView.findViewById(R.id.delete);
            edit   = itemView.findViewById(R.id.edit);
            call= itemView.findViewById(R.id.call);
        }
    }




    private String formatDate(String dateStr){
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = fmt.parse(dateStr);
            SimpleDateFormat fmtOut  = new SimpleDateFormat("MMM d");
            return  fmtOut.format(date);
        } catch (ParseException e) {
            Log.e("error", e.getMessage());
        }
        return "";
    }


    private  void deleteData(int position){
        databaseHelper.deleteData(List.get(position));
        List.remove(position);
         MainActivity.notifyAdapter();
    }




}

