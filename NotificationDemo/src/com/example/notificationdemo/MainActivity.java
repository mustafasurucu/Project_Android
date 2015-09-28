package com.example.notificationdemo;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	private NotificationManager mNotificationManager;
	private int notificationID = 100;
	private int numMessages = 0;

	protected void cancelNotification() {
		Log.i("Cancel", "notification");
		mNotificationManager.cancel(notificationID);
	}

	protected void displayNotification() {
		Log.i("Start", "notification"); /*
										 * Invoking the default notification
										 * service
										 */
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
				this);
		mBuilder.setContentTitle("New Message");
		mBuilder.setContentText("You've received new message.");
		mBuilder.setTicker("New Message Alert!");
		mBuilder.setSmallIcon(R.drawable.ic_launcher); /*
														 * Increase notification
														 * number every time a
														 * new notification
														 * arrives
														 */
		mBuilder.setNumber(++numMessages);

		/* Add Big View Specific Configuration */
		NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
		String[] events = new String[6];
		events[0] = new String("This is first line....");
		events[1] = new String("This is second line...");
		events[2] = new String("This is third line...");
		events[3] = new String("This is 4th line...");
		events[4] = new String("This is 5th line...");
		events[5] = new String("This is 6th line...");
		// Sets a title for the Inbox style big view
		inboxStyle.setBigContentTitle("Big Title Details:");
		// Moves events into the big view
		for (int i = 0; i < events.length; i++) {
			inboxStyle.addLine(events[i]);
		}
		mBuilder.setStyle(inboxStyle);

		/* Creates an explicit intent for an Activity in your app */
		Intent resultIntent = new Intent(this, NotificationActivity.class);
		TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
		stackBuilder.addParentStack(NotificationActivity.class); /*
																 * Adds the
																 * Intent that
																 * starts the
																 * Activity to
																 * the top of
																 * the stack
																 */
		stackBuilder.addNextIntent(resultIntent);
		PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,
				PendingIntent.FLAG_UPDATE_CURRENT);
		mBuilder.setContentIntent(resultPendingIntent);
		mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); /*
																									 * notificationID
																									 * allows
																									 * you
																									 * to
																									 * update
																									 * the
																									 * notification
																									 * later
																									 * on
																									 * .
																									 */
		mNotificationManager.notify(notificationID, mBuilder.build());
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button startBtn = (Button) findViewById(R.id.start);
		startBtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				displayNotification();
			}
		});

		Button cancelBtn = (Button) findViewById(R.id.cancel);
		cancelBtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				cancelNotification();
			}
		});
		Button updateBtn = (Button) findViewById(R.id.update);
		updateBtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				updateNotification();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	protected void updateNotification() {
		Log.i("Update", "notification");

		/* Invoking the default notification service */
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
				this);
		mBuilder.setContentTitle("Updated Message");
		mBuilder.setContentText("You've got updated message.");
		mBuilder.setTicker("Updated Message Alert!");
		mBuilder.setSmallIcon(R.drawable.ic_launcher);
		/* Increase notification number every time a new notification arrives */
		mBuilder.setNumber(++numMessages);
		/* Creates an explicit intent for an Activity in your app */
		Intent resultIntent = new Intent(this, NotificationActivity.class);
		TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
		stackBuilder.addParentStack(NotificationActivity.class);
		/* Adds the Intent that starts the Activity to the top of the stack */
		stackBuilder.addNextIntent(resultIntent);
		PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,
				PendingIntent.FLAG_UPDATE_CURRENT);
		mBuilder.setContentIntent(resultPendingIntent);
		mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		/* Update the existing notification using same notification ID */
		mNotificationManager.notify(notificationID, mBuilder.build());
	}
}
