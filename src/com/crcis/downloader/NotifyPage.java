package com.crcis.downloader;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

public class NotifyPage extends Activity {
	NotificationManager mNotificationManager = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test2);
		
		mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
	}
	
	public void clearNotification(View v) {
		mNotificationManager.cancel(1);
	    finish();
	}
	
	public void UpdateApplication(View v){
		mNotificationManager.cancel(1);
		new DownloadTask(this).execute("http://animal.discovery.com/birds/peacock/pictures/peacock-picture.jpg");
	}	
}