package cs125_illinois_students.github.com.networks;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Base64;
import android.view.View;
import android.widget.Toast;
import android.util.Log;

import java.io.File;
import java.io.FileWriter;
import java.security.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Generate extends Settings {
    protected static final String TAG = "Generate";
    protected static KeyPair keyPair;
    protected static PublicKey myPublicKey;
    protected static PrivateKey myPrivateKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generate);
    }

    public void clickNew(View view) { createKeyPair(); }
    public void clickPublic(View view) {
        startActivity(new Intent(this, MyPublicKey.class));
    }
    public void clickPrivate(View view) {
        startActivity(new Intent(this, MyPrivateKey.class));
    }
    public void clickSave(View view) {
        saveToStorage(myPublicKey, myPrivateKey);
    }

    private void createKeyPair() {
        try {
            KeyPairGenerator myKeyPair = KeyPairGenerator.getInstance("RSA");
            myKeyPair.initialize(bitLength, new SecureRandom());
            keyPair = myKeyPair.generateKeyPair();
            myPublicKey = keyPair.getPublic();
            myPrivateKey = keyPair.getPrivate();
            Log.e(TAG, Base64.encodeToString(myPrivateKey.getEncoded(), Base64.DEFAULT));
        } catch (NoSuchAlgorithmException e) {
            Log.e(TAG, "NoSuchAlgorithmException detected: " + e.getMessage());
        }
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
            Toast.makeText(this,"Saved!", 10).show();
        } catch (Exception e) {
            Log.e(TAG, "Exception detected: " + e.getMessage());
            Toast.makeText(this,"Error saving!", 10).show();
        }
    }


}