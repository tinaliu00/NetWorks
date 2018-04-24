package cs125_illinois_students.github.com.networks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
    }

    public void clickFilters(View view) {
        Toast.makeText(this,"Filters clicked!", 10).show();
    }

    public void clickModes(View view) {
        Toast.makeText(this,"Modes clicked!", 10).show();
    }

    public void clickRecords(View view) {
        Toast.makeText(this,"Records clicked!", 10).show();
    }
}
