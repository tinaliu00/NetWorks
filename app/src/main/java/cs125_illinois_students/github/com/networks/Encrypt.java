package cs125_illinois_students.github.com.networks;

import android.content.Intent;
import android.util.Log;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import javax.crypto.Cipher;

public class Encrypt extends Generate {
    private static final String TAG = "Encrypt";
    byte[] encryptArray;
    byte[] decryptArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        publicPrivateArray = createDisplayKeyPair();
        setContentView(R.layout.encrypt);
    }

    public void clickEncrypt(View view) {
        EditText inputTxt = findViewById(R.id.meEncrypt);
        encryptArray = toEncrypt(inputTxt.getText().toString());
        startActivity(new Intent(this, ShowEncrypt.class));
    }

    public void clickDecrypt(View view) {
        EditText inputTxt = findViewById(R.id.meDecrypt);
        decryptArray = toDecrypt(inputTxt.getText().toString());
        startActivity(new Intent(this, ShowDecrypt.class));
    }

    private byte[] toEncrypt(String encryptMe) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
            return cipher.doFinal(encryptMe.getBytes());
        } catch (Exception e) {
            Log.e(TAG, "Exception detected: " + e.getMessage());
        }
        return new byte[0];
    }

    private byte[] toDecrypt(String decryptMe) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
            return cipher.doFinal(decryptMe.getBytes());
        } catch (Exception e) {
            Log.e(TAG, "Exception detected: " + e.getMessage());
        }
        return new byte[0];
    }

}
