package edu.temple.signupform;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    final int NAME = 0;
    final int EMAIL = 1;
    final int PASSWORD = 2;
    final int CONFIRMATION = 3;

    TextView fields[];
    Button save;
    TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fields = new TextView[4];
        fields[NAME] = findViewById(R.id.name);
        fields[EMAIL] = findViewById(R.id.email);
        fields[PASSWORD] = findViewById(R.id.password);
        fields[CONFIRMATION] = findViewById(R.id.confirmation);

        message = findViewById(R.id.message);

        save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                resetBackground(fields);
                message.setText("");
                if(fieldsEmpty(fields)) {
                    Toast toast = Toast.makeText(FormActivity.this, "Please fill out all fields", Toast.LENGTH_LONG);
                    toast.show();
                }else if(!passwordsEqual(fields)){
                    Toast toast = Toast.makeText(FormActivity.this, "Passwords must match", Toast.LENGTH_LONG);
                    toast.show();
                }else
                    message.setText("Welcome, " + fields[NAME].getText() + ", to the SignUpForm App");
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

    private boolean passwordsEqual(TextView fields[]){
        return fields[PASSWORD].getText().toString().equals(fields[CONFIRMATION].getText().toString());
    }
}
