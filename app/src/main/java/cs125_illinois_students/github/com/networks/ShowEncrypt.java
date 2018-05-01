package cs125_illinois_students.github.com.networks;


import android.os.Bundle;
import android.widget.TextView;

public class ShowEncrypt extends Encrypt {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showencrypt);
        TextView privateView = findViewById(R.id.showEncrypt);
        try {
            CharSequence seq = new String(encryptArray, "US-ASCII");
            privateView.setText(seq);
        } catch (Exception e) {

        }
    }
}

