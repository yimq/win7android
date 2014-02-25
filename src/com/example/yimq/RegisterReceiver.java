package com.example.yimq;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

public class RegisterReceiver extends BroadcastReceiver {
	
	private TextView tv;
	private static int count = 0;
	public RegisterReceiver(TextView tv){
		this.tv = tv;
	}
	@Override
	public void onReceive(Context context, Intent intent) {
		tv.setText("这是第"+count+++"一次收到");
	}

}
