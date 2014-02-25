package com.example.yimq;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
	private static final String TAG = "MainActivity";
	private Button b1;
	private Button b2;
	private Button b3;
	private Button b4;
	private Button b5;
	private Button b6;
	private YimqService mService;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final ArrayList<String> items = new ArrayList<String>();
		registerReceiver(new RegisterReceiver((TextView) findViewById(R.id.textView1)), new IntentFilter("com.yimq.re"));
		ListView lv = (ListView) findViewById(R.id.listView1);
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
		lv.setAdapter(adapter);
		final EditText ev = (EditText) findViewById(R.id.editText1);
		ev.setOnKeyListener(new OnKeyListener() {

			@Override
			public boolean onKey(View arg0, int arg1, KeyEvent arg2) {
				if (arg1 == KeyEvent.KEYCODE_ENTER || arg1 == KeyEvent.KEYCODE_DPAD_DOWN) {
					items.add(0, ev.getText().toString());
					System.out.println(items.size());
					System.out.println("dfdfd");
					System.out.println(ev.getText().toString() + "sdsd");
					adapter.notifyDataSetChanged();
					ev.getText().clear();
					return true;
				}
				return false;
			}
		});
		((Button) (findViewById(R.id.button1))).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent i = new Intent();
				i.setAction("com.yimq.re");
				sendBroadcast(i);
				items.add(0, ev.getText().toString());
				System.out.println(items.size());
				System.out.println(ev.getText().toString());
				adapter.notifyDataSetChanged();
				ev.getText().clear();
			}
		});
		b1 = (Button) findViewById(R.id.button2);
		b2 = (Button) findViewById(R.id.button3);
		b3 = (Button) findViewById(R.id.button4);
		b4 = (Button) findViewById(R.id.button5);
		b5 = (Button) findViewById(R.id.button6);
		b6 = (Button) findViewById(R.id.button7);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
		b5.setOnClickListener(this);
		b6.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		Intent i = new Intent();
		switch(v.getId()){
		case R.id.button2:
			i.setClass(this, YimqService.class);
			startService(i);
			break;
		case R.id.button3:
			i.setClass(this, YimqService.class);
			stopService(i);
			break;
		case R.id.button4:
			
			break;
		case R.id.button5:
			break;
		case R.id.button6:
			break;
		case R.id.button7:
			break;
		default:
			break;
		}
	}
	private ServiceConnection mConnection = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			mService = ((YimqService.YimqBinder)service).getService();
		}
	};
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		Log.d(TAG, "onSaveInstanceState");
		super.onSaveInstanceState(outState);
	}

	@Override
	protected void onRestart() {
		Log.d(TAG, "onRestart");
		super.onRestart();
	}

	@Override
	protected void onStart() {
		Log.d(TAG, "onStart");
		super.onStart();
	}

	@Override
	protected void onStop() {
		Log.d(TAG, "onStop");
		super.onStop();
	}

	@Override
	protected void onPause() {
		Log.d(TAG, "onPause");
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

	@Override
	protected void onResume() {
		Log.d(TAG, "onResume");
		super.onResume();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
