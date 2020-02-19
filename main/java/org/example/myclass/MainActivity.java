package org.example.myclass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView subrecview;
    private static DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subrecview = findViewById(R.id.subRecView);

        subrecview.setLayoutManager(new GridLayoutManager(this, 1));
        //util util = new util();
        final ArrayList<Subject> subjects = new ArrayList<>();
        //  final ArrayList<Subject> subjects=new ArrayList<>();
        reference = FirebaseDatabase.getInstance().getReference().child("subjects");

            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()) {


                    String imgUrl=dataSnapshot1.getValue("")
                    String faculty=dataSnapshot1.getValue("faculty").toString();
                    subjects.add(new Subject());

                }



                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Log.i("yo", " ");

                }
            });

            //Toast.makeText(getApplicationContext(),"yo",Toast.LENGTH_SHORT).show();
        SubjectRecyclerView adapter = new SubjectRecyclerView(this);
        subrecview.setAdapter(adapter);


        adapter.setSubjects(subjects);
        Log.i("yo", "adapterset");

        }


    }

