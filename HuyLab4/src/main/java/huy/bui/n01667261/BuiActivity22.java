package huy.bui.n01667261;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BuiActivity22 extends AppCompatActivity {

    private String logValueToPrint = "No data received";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bui22);

        TextView textviewpassdata = findViewById(R.id.textView4);
        ImageView imageViewR = findViewById(R.id.imageView);

        Intent intent= getIntent();
        long receivedData = intent.getLongExtra("NUMBER_DATA", -1L);

        if(receivedData != -1L)
        {
            String formattedText = "Number: " + receivedData;
            textviewpassdata.setText(formattedText);
            logValueToPrint = formattedText;
        }
        else
        {
            textviewpassdata.setText("");
            logValueToPrint = "No data passed from Screen 1";
        }
    }
}