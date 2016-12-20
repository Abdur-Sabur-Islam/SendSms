package sms.send.sendsms;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import static java.net.Proxy.Type.HTTP;

/**
 * Created by acer on 12/20/2016.
 */

public class SendSmsAction {
    private Context context;
    private String phoneNo;
    private String smsText;

    public SendSmsAction(Context context,String phoneNo, String smsText) {
        this.phoneNo = phoneNo;
        this.smsText = smsText;
        this.context = context;
    }
    public void composeMmsMessage() {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:"+phoneNo));  // This ensures only SMS apps respond
        intent.putExtra("sms_body", smsText);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }
}
