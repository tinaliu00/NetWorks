package cs125_illinois_students.github.com.networks;

import android.content.Intent;
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
        startActivity(new Intent(this, Settings.class));
    }

    public void clickGenerate(View view) {
        startActivity(new Intent(this, Generate.class));
    }

    public void clickEncrypt(View view) {
        startActivity(new Intent(this, Encrypt.class));
    }
}
