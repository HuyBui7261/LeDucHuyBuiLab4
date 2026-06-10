package huy.bui.n01667261;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BuiActivity22 extends AppCompatActivity {

    private String logValueToPrint = "No data received";
    private final int[] imageResources = {
            R.drawable.images,
            R.drawable.download,
            R.drawable.download1
    };

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
        rotateAndDisplayImage(imageViewR);
    }
    private void rotateAndDisplayImage(ImageView imageView) {
        SharedPreferences prefs = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        int lastImageIndex = prefs.getInt("last_image_index", 0);
        imageView.setImageResource(imageResources[lastImageIndex]);
        int nextImageIndex = (lastImageIndex + 1) % imageResources.length;
        prefs.edit().putInt("last_image_index", nextImageIndex).apply();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Navigating Back Value: " + logValueToPrint);
    }
}