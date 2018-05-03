package cs125_illinois_students.github.com.networks;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ShowDecrypt extends Encrypt {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showdecrypt);
        TextView privateView = findViewById(R.id.showDecrypt);
        try {
            privateView.setText(showDecrypt);
        } catch (Exception e) {
            Log.e("ShowEncrypt", e.getMessage() );
        }
    }
}

