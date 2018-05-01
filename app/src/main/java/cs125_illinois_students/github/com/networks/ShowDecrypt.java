package cs125_illinois_students.github.com.networks;

import android.os.Bundle;
import android.widget.TextView;

public class ShowDecrypt extends Encrypt {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showdecrypt);
        TextView privateView = findViewById(R.id.showDecrypt);
        try {
            CharSequence seq = new String(decryptArray, "US-ASCII");
            privateView.setText(seq);
        } catch (Exception e) {
        }
    }
}

