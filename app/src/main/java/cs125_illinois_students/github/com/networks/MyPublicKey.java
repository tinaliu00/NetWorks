package cs125_illinois_students.github.com.networks;

import android.os.Bundle;
import android.util.Base64;
import android.widget.TextView;
import android.widget.Toast;

public class MyPublicKey extends Generate {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.publickey);
        TextView publicView = findViewById(R.id.displayPublic);
        try {
            publicView.setText(displayPublicKey());
        } catch (Exception e) {
            Toast.makeText(this,"Error. No public key found!", 10).show();
        }
    }

    private String displayPublicKey() {
        return Base64.encodeToString(myPublicKey.getEncoded(), Base64.DEFAULT);
    }
}