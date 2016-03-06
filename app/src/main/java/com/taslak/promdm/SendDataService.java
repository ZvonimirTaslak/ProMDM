package com.taslak.promdm;

import android.app.IntentService;
import android.content.Intent;
import android.net.TrafficStats;
import android.os.Handler;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class SendDataService extends IntentService {

    private static final String SERVER="http://vps52650.vps.ovh.ca";
    private static final MediaType MEDIA_TYPE =MediaType.parse("text/html");

    private Handler handler= new Handler();

    public SendDataService() {
        super("SendDataService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        OkHttpClient client= new OkHttpClient();
        RequestBody body= RequestBody.create(MEDIA_TYPE,TrafficStats.getMobileRxBytes() +"");
        Request request= new Request.Builder().url(SERVER).post(body).build();
        try {
            final Response response = client.newCall(request).execute();
            handler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(SendDataService.this,TrafficStats.getMobileRxBytes() +"", Toast.LENGTH_SHORT).show();
                    Toast.makeText(SendDataService.this, R.string.data_send, Toast.LENGTH_SHORT).show();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
