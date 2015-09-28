package com.example.trainingproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class EntryActivity extends Activity {

	public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_entry);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.entry, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		int id = item.getItemId();

		switch (id) {
		case R.id.action_search:
			this.openSearchScreen();
			return true;
		case R.id.action_settings:
			this.openSettingsScreen();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void openSearchScreen() {
		// TODO Auto-generated method stub

	}

	private void openSettingsScreen() {
		// TODO Auto-generated method stub

	}

	public void sendMessage(View view) {
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		EditText editText = (EditText) findViewById(R.id.edit_message);
		String message = editText.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, message);
		startActivity(intent);
	}

	public void startService(View view) {
		startService(new Intent(getBaseContext(), MyService.class));
	}

	public void stopService(View view) {
		stopService(new Intent(getBaseContext(), MyService.class));
	}

	public void broadcastIntent(View view) {
		Intent intent = new Intent();
		intent.setAction("com.tutorialspoint.CUSTOM_INTENT");
		sendBroadcast(intent);
	}
}
