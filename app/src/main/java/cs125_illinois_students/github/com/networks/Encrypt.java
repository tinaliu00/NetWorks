package cs125_illinois_students.github.com.networks;

import android.content.Intent;
import android.util.Log;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.util.Base64;

import javax.crypto.Cipher;

public class Encrypt extends Generate {
    private static final String TAG = "Encrypt";
    protected static String showEncrypt;
    protected static String showDecrypt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.encrypt);
    }

    public void clickEncrypt(View view) {
        EditText plain = findViewById(R.id.meEncrypt);
        showEncrypt = toEncrypt(plain.getText().toString());
        startActivity(new Intent(this, ShowEncrypt.class));
    }

    public void clickDecrypt(View view) {
        EditText plain = findViewById(R.id.meDecrypt);
        showDecrypt = toDecrypt(plain.getText().toString());
        startActivity(new Intent(this, ShowDecrypt.class));
    }

    protected String toEncrypt(String encryptMe) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, myPublicKey);
            byte[] cipherArray = cipher.doFinal(encryptMe.getBytes());
            return Base64.encodeToString(cipherArray, Base64.DEFAULT);
        } catch (Exception e) {
            Log.e(TAG, "Exception detected: " + e.getMessage());
        }
        return "Oops, something went wrong.";
    }

    protected String toDecrypt(String decryptMe) {
        try {
            byte[] cipherArray = Base64.decode(decryptMe, Base64.DEFAULT);
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher.init(Cipher.DECRYPT_MODE, myPrivateKey);
            return new String(cipher.doFinal(cipherArray));
        } catch (Exception e) {
            Log.e(TAG, "Exception detected: " + e.getMessage());
        }
        return "Oops, something went wrong.";
    }

}
