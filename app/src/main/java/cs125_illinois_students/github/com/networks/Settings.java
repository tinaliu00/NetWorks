package cs125_illinois_students.github.com.networks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Settings extends AppCompatActivity {

    static protected int bitLength = 512;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        Button button = findViewById(R.id.bits);
        button.setText(getApplicationContext().getString(R.string.bits, bitLength));
    }

    public void clickBits(View view) {
        if (bitLength == 512) {
            bitLength = 1024;
        } else if (bitLength == 1024) {
            bitLength = 2048;
        } else if (bitLength == 2048) {
            bitLength = 4096;
        } else {
            bitLength = 512;
        }
        Button button = findViewById(R.id.bits);
        button.setText(getApplicationContext().getString(R.string.bits, bitLength));

    }

}
