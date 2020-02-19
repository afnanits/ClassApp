package org.example.myclass;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GalleryActivity extends AppCompatActivity {

    private static final String TAG = "GalleryActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        getIncomingExtras();

    }
    private void getIncomingExtras(){
        if(getIntent().hasExtra("faculty")&&getIntent().hasExtra("reference")){
            String faculty=getIntent().getStringExtra("faculty");
            String reference=getIntent().getStringExtra("reference");
            float attendance=Float.parseFloat(getIntent().getStringExtra("attendance"));

            TextView facult=findViewById(R.id.faculties);
            facult.setText(Float.toString(attendance));


            TextView books=findViewById(R.id.books);
            books.setText(reference);


        }
    }

    private void setImage(String faculty,String reference){

    }

}
