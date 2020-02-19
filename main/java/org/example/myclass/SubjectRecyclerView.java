package org.example.myclass;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
//import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class SubjectRecyclerView extends RecyclerView.Adapter<SubjectRecyclerView.ViewHolder> {
    private ArrayList<Subject> subjects;
    private Context context;
    private SharedPreferences sharedPreferences;



    @Override
    public void onBindViewHolder(@NonNull final SubjectRecyclerView.ViewHolder holder, final int position) {
        holder.subInfo.setText(subjects.get(position).getName());
        holder.subCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "taped", Toast.LENGTH_SHORT).show();

            }
        });

        holder.subImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,GalleryActivity.class);
                intent.putExtra("faculty",subjects.get(position).getFaculty());
                intent.putExtra("reference",subjects.get(position).getReference());
                intent.putExtra("attendance",Float.toString(subjects.get(position).getAttendancePercent()));
                context.startActivity(intent);

            }
        });




        holder.attbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "incremented", Toast.LENGTH_SHORT).show();
                subjects.get(position).addAtt(subjects.get(position).getAttendance());
                holder.attbtn.setText(Integer.toString(subjects.get(position).getAttendance()));
                subjects.get(position).computePerc(subjects.get(position).getAttendance(),subjects.get(position).getMissed());
                holder.subAtt.setText(Float.toString(subjects.get(position).getAttendancePercent()));

                //sharedPreferences=Context.getSharedPreferences("org.example.myclass", Context.MODE_PRIVATE);

                sharedPreferences.edit().putInt("attendance"+Integer.toString(position),subjects.get(position).getAttendance());
            }
        });


        holder.missedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "taped", Toast.LENGTH_SHORT).show();

                subjects.get(position).addMiss(subjects.get(position).getMissed());
                holder.missedBtn.setText(Integer.toString(subjects.get(position).getMissed()));
                subjects.get(position).computePerc(subjects.get(position).getAttendance(),subjects.get(position).getMissed());
                holder.subAtt.setText(Float.toString(subjects.get(position).getAttendancePercent()));
            }
        });


        //Glide.with(context).load("https://www1.sunybroome.edu/wp-content/uploads/2017/04/math2.jpg" ).into(holder.subImg);
        //Glide.with(context).asBitmap()).load(subjects.get(position).getImgUrl()).override(20, 20)//5
                //error(R.drawable.ic_launcher_foreground).into(holder.subImg);

        Glide.with(context).asBitmap().load(subjects.get(position).getImgUrl())
                .into(holder.subImg);


    }

    @NonNull
    @Override
    public SubjectRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subjectrecyclerview, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView subImg;
        private TextView subInfo;
        private TextView subAtt;
        private TextView attPerc;
        private CardView subCard;
        private Button attbtn,missedBtn;
        public ViewHolder(View itemView) {
            super(itemView);
            subImg = itemView.findViewById(R.id.subImg);
            subInfo = itemView.findViewById(R.id.subInfo);
            subAtt = itemView.findViewById(R.id.subAtt);
            attPerc = itemView.findViewById(R.id.percent);
            subCard = itemView.findViewById(R.id.subCard);
            attbtn=itemView.findViewById(R.id.attbtn);
            missedBtn=itemView.findViewById(R.id.missedBtn);
        }


    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;

        notifyDataSetChanged();
    }

}
