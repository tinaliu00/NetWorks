package cs125_illinois_students.github.com.networks;

import android.os.Bundle;
import android.widget.TextView;

public class MyPrivateKey extends Generate {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.privatekey);
        TextView privateView = findViewById(R.id.displayPrivate);
        privateView.setText(publicPrivateArray[1]);
    }
}

