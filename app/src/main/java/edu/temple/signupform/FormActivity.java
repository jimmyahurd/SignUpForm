package edu.temple.signupform;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    TextView fields[];
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fields = new TextView[4];
        fields[0] = findViewById(R.id.name);
        fields[1] = findViewById(R.id.email);
        fields[2] = findViewById(R.id.password);
        fields[3] = findViewById(R.id.confirmation);

        save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                resetBackground(fields);
                if(fieldsEmpty(fields)) {
                    Toast toast = Toast.makeText(FormActivity.this, "Please fill out all fields", Toast.LENGTH_LONG);
                    toast.show();
                }else if(!fields[2].getText().equals(fields[3].getText())){
                    Toast toast = Toast.makeText(FormActivity.this, "Passwords must match", Toast.LENGTH_LONG);
                    toast.show();
                }else{

                }
            }
        });
    }

    private boolean fieldsEmpty(TextView fields[]){
        boolean toReturn = false;
        for(int i = 0; i < fields.length; i++){
            if(fields[i].getText().length() == 0){
                toReturn = true;
                fields[i].setBackgroundColor(Color.RED);
            }
        }
        return toReturn;
    }

    private void resetBackground(TextView fields[]){
        for(int i = 0; i < fields.length; i++){
            fields[i].setBackgroundColor(Color.TRANSPARENT);
        }
    }
}
