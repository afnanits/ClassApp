package org.example.myclass;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;



public class util {

    private static DatabaseReference reference;
private static ArrayList<Subject> subjects;
    private static int id=0;
    public util() {
       if (subjects==null){
          subjects=new ArrayList<>();
           initSubjects();
       }
    }
    public static void initSubjects(){
        String name="";
        String imgUrl="";
        String faculy="";
        int attendance=0;
        id++;

        reference=FirebaseDatabase.getInstance().getReference().child("subjects");
        for (int i=0;i<4;i++){
            DatabaseReference subRef=reference.child(String.valueOf(i));
           // Log.i("yo",+" ");

            subRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                            String name=dataSnapshot.child("name").getValue().toString();
                            String faculty=dataSnapshot.child("faculty").getValue().toString();
                            String reference=dataSnapshot.child("reference").getValue().toString();
                            int attendance= Integer.parseInt(dataSnapshot.child("attendance").getValue().toString());
                            String imgUrl=dataSnapshot.child("imgUrl").getValue().toString();

                            subjects.add(new Subject(name,attendance,imgUrl,faculty,reference));
                Log.i("yo",name+" "+faculty);
                    }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.i("yo"," ");

            }
        });
            }





        //subjects.add(new Subject("e",0,"snns",))



    }
    //private static int id;
    public static ArrayList<Subject> getAllsubjects(){
        return subjects;
    }



}
