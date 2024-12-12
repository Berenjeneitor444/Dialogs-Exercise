package com.example.dialogsexercise;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DialogActivity extends AppCompatActivity {
    private TextView textView;

    public void setTextViewText(String text) {
        this.textView.setText(text);
    }
    public void setTextViewText(String[] text){
        StringBuilder builder = new StringBuilder();
        builder.append("You selected ");
        for(int i = 0; i < text.length; i++){
            String s = text[i];
            if(i == text.length - 1)
                builder.append(s);
            else if (i == text.length - 2) {
                builder.append(s).append(" and ");
            } else
            builder.append(s).append(", ");
        }
        this.textView.setText(builder.toString());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.dialog_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textView = findViewById(R.id.textView);
        findViewById(R.id.radio_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogRadius dialogRadius = new DialogRadius();
                dialogRadius.show(getSupportFragmentManager(),"MiDialogo");

            }
        });
        findViewById(R.id.checkbox_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogCheckBox dialogCheckBox = new DialogCheckBox();
                dialogCheckBox.show(getSupportFragmentManager(),"MiDialogo");
            }
        });
        findViewById(R.id.login_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogLogin dialogLogin = new DialogLogin();
                dialogLogin.show(getSupportFragmentManager(), "MiDialogo");
            }
        });
    }
}