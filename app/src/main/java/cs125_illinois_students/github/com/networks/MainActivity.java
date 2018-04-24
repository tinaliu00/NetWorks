package cs125_illinois_students.github.com.networks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickSettings(View view) {
        Toast.makeText(this,"Settings clicked!", 10).show();
    }

    public void clickView(View view) {
        Toast.makeText(this,"View clicked!", 10).show();
    }

    public void clickCapture(View view) {
        Toast.makeText(this,"Capture clicked!", 10).show();
    }
}
