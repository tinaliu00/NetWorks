package cs125_illinois_students.github.com.networks;

import android.os.Bundle;
import android.util.Base64;
import android.widget.TextView;
import android.util.Log;
import android.widget.Toast;

public class MyPrivateKey extends Generate {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.privatekey);
        TextView privateView = findViewById(R.id.displayPrivate);
        try {
            privateView.setText(displayPrivateKey());
        } catch (Exception e) {
            Toast.makeText(this,"Error. No private key found!", 10).show();
        }
    }

    private String displayPrivateKey() {
        return Base64.encodeToString(myPrivateKey.getEncoded(), Base64.DEFAULT);
    }
}

