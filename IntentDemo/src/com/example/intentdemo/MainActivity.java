package com.example.intentdemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button startBrowser = (Button) findViewById(R.id.start_browser);
		startBrowser.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
						.parse("http://www.example.com"));
				startActivity(i);
			}
		});

		Button startBrowser_b = (Button) findViewById(R.id.start_browser_b);
		startBrowser_b.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Intent i = new Intent("com.example.intentdemo.LAUNCH", Uri
						.parse("http://www.example.com"));
				startActivity(i);
			}
		});

		Button startBrowser_c = (Button) findViewById(R.id.start_browser_c);
		startBrowser_c.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Intent i = new Intent("com.example.intentdemo.LAUNCH", Uri
						.parse("https://www.example.com"));
				startActivity(i);
			}
		});
		
		Button startPhone = (Button) findViewById(R.id.start_phone);
		startPhone.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
						.parse("tel:9510300000"));
				startActivity(i);
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
}
