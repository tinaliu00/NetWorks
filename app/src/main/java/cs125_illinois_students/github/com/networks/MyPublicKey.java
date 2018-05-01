package cs125_illinois_students.github.com.networks;

import android.os.Bundle;
import android.widget.TextView;

public class MyPublicKey extends Generate {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.publickey);
        TextView publicView = findViewById(R.id.displayPublic);
        publicView.setText(publicPrivateArray[0]);
    }
}