package com.taslak.promdm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, R.string.alarm_receiver, Toast.LENGTH_SHORT).show();
        Intent intent1= new Intent(context,SendDataService.class);
        context.startService(intent1);
    }
}
