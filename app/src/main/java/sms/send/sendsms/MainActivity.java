package sms.send.sendsms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText phoneNoEt,smsBodyEt;
    Button sendSmsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneNoEt = (EditText) findViewById(R.id.phoneNoEt);
        smsBodyEt = (EditText) findViewById(R.id.smsBodyEt);
        sendSmsBtn = (Button) findViewById(R.id.sendSmsBtn);
        sendSmsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneSt  = phoneNoEt.getText().toString();
                String smsTextSt = smsBodyEt.getText().toString();
                SendSmsAction sendSmsAction = new SendSmsAction(MainActivity.this,phoneSt,smsTextSt);
                sendSmsAction.composeMmsMessage();
            }
        });
    }
}
