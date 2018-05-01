package cs125_illinois_students.github.com.networks;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import android.widget.TextView;
import android.util.Log;
import android.util.Base64;

import java.io.File;
import java.io.FileWriter;
import java.security.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Generate extends Settings {
    private static final String TAG = "Generate";
    protected KeyPair keyPair;
    protected String[] publicPrivateArray = new String[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        publicPrivateArray = createDisplayKeyPair();
        setContentView(R.layout.generate);
    }

    public void clickSave(View view) {

        saveToStorage(keyPair.getPublic(), keyPair.getPrivate());
        Toast.makeText(this,"Saved!", 10).show();
    }
    public void clickPublic(View view) {
        startActivity(new Intent(this, MyPublicKey.class));
    }
    public void clickPrivate(View view) {
        startActivity(new Intent(this, MyPrivateKey.class));
    }

    protected String[] createDisplayKeyPair() {
        try {
            KeyPairGenerator myKeyPair = KeyPairGenerator.getInstance("RSA");
            myKeyPair.initialize(bitLength);
            keyPair = myKeyPair.generateKeyPair();
            publicPrivateArray[0] = Base64.encodeToString(keyPair.getPublic().getEncoded(), Base64.DEFAULT);
            publicPrivateArray[1] = Base64.encodeToString(keyPair.getPrivate().getEncoded(), Base64.DEFAULT);
            return publicPrivateArray;
        } catch (NoSuchAlgorithmException e) {
            Log.e(TAG, "NoSuchAlgorithmException detected: " + e.getMessage());
        }
        String[] uhOh = new String[2];
        uhOh[0] = "Oops. An error has occurred.";
        uhOh[1] = "Please yell at the coder.";
        return uhOh;
    }

    private void saveToStorage(PublicKey part, PrivateKey parttwo) {
        String root = Environment.getExternalStorageDirectory().toString();
        File myDir = new File(root + "/download"); // Am I certain that every user will have this? Nope!
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).format(new Date()); // This really should be unique enough
        File myFile = new File (myDir, timeStamp);
        try {
            FileWriter writeMe = new FileWriter(myFile);
            writeMe.write(part.toString());
            writeMe.write(parttwo.toString());
            writeMe.flush();
            writeMe.close();
        } catch (Exception e) {
            Log.e(TAG, "Exception detected: " + e.getMessage());
        }
    }


}