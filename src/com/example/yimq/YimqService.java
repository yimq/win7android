package com.example.yimq;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class YimqService extends Service{

	@Override
	public IBinder onBind(Intent intent) {
		return binder;
	}
	@Override
	public void onCreate() {
		super.onCreate();
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
//		TODO 添加代码
		return Service.START_STICKY;
	}
	public class YimqBinder extends Binder {
		YimqService getService(){
			return YimqService.this;
		}
	}
	private final IBinder binder = new YimqBinder();
	private void startPlayBack(){
		Intent i = new Intent(this,MainActivity.class);
		PendingIntent pi = PendingIntent.getActivity(this, 1, i, 0);
		Notification notification = new Notification(R.drawable.ic_launcher,"starting Playback",System.currentTimeMillis());
		notification.setLatestEventInfo(this, "hello", "world", pi);
		notification.flags = notification.flags|Notification.FLAG_ONGOING_EVENT;
		startForeground(1, notification);
	}
	private void pausePlayback(){
		stopForeground(true);
	}

}
