package com.example.yimq;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class YimqReceiver extends BroadcastReceiver {
	private static final String TAG = "YimqReceiver";
	@Override
	public void onReceive(Context arg0, Intent arg1) {
		Log.d(TAG, "收到了receiver");
	}

}
