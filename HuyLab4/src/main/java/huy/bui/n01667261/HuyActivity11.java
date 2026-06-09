package huy.bui.n01667261;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class HuyActivity11 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editTextDigits = findViewById(R.id.editTextText);
        ImageButton imageButtonSubmit = findViewById(R.id.imageButton);


        imageButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Your Full Name", Snackbar.LENGTH_INDEFINITE)
                        .setAction("START", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                String inputText = editTextDigits.getText().toString().trim();
                                Intent intent = new Intent(HuyActivity11.this, BuiActivity22.class);
                                if (!inputText.isEmpty()) {
                                    try {
                                        long dataAsLong = Long.parseLong(inputText);
                                        intent.putExtra("EXTRA_NUMBER_DATA", dataAsLong);
                                    } catch (NumberFormatException e) {
                                        e.printStackTrace();
                                    }
                                }
                                editTextDigits.setText("");
                                startActivity(intent);
                            }
                        }).show();
            }
        });
    }
}