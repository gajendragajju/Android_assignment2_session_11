package com.crcis.downloader;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

public class DownloaderActivity extends Activity {
    /** Called when the activity is first created. */
    private static final int HELLO_ID = 1;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        if(isInternetConnectionActive(getApplicationContext())) {
        	showNotification(1);
       	}
       	//else {
       		//showNotification(0);
       	//}
    }
     
    private boolean isInternetConnectionActive(Context context) {
    	NetworkInfo networkInfo = ((ConnectivityManager) context
    	    .getSystemService(Context.CONNECTIVITY_SERVICE))
    	    .getActiveNetworkInfo();

    	if(networkInfo == null || !networkInfo.isConnected()) {
    	   return false;
    	}
    	return true;
    }
    
    private void showNotification(int status){
    	String ns = Context.NOTIFICATION_SERVICE;
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);

        int icon = android.R.drawable.ic_media_play;
        CharSequence ticketText = "Connection";
        long when = System.currentTimeMillis();

        Notification notification = new Notification(icon, ticketText, when);

        Context context = getApplicationContext();
        CharSequence contentTitle = "Internet Connection";
        CharSequence contentText = "";
        
        if(status == 1){
        	contentText = "Internet connected, Are you Update your Application?";
        }
        else{
        	contentText = "Internet disconnected!";
        }
        
        Intent notificationIntent = new Intent(this, NotifyPage.class);
        notificationIntent.addFlags(Notification.FLAG_ONGOING_EVENT);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

        notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);

        mNotificationManager.notify(HELLO_ID, notification);
    }

}