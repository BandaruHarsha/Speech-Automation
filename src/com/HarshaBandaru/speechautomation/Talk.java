package com.HarshaBandaru.speechautomation;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.speech.RecognizerIntent;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Talk extends Activity {

	Button speak;
	TextView display;
	private static final int REQUEST_CODE = 1234;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_talk);

		speak = (Button) findViewById(R.id.button1);
		display = (TextView) findViewById(R.id.textView1);

		// Disable button if no recognition service is present
		PackageManager pm = getPackageManager();

		List<ResolveInfo> activities = pm.queryIntentActivities(new Intent(

		RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);

		if (activities.size() == 0) {

			speak.setEnabled(false);

			Toast.makeText(getApplicationContext(), "Recognizer Not Found",
					Toast.LENGTH_SHORT).show();

		}

		speak.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				startVoiceRecognitionActivity();
			}

		});
	}

	private void startVoiceRecognitionActivity() {

		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,

		RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

		intent.putExtra(RecognizerIntent.EXTRA_PROMPT,

		"PSK...");

		startActivityForResult(intent, REQUEST_CODE);

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REQUEST_CODE) {
			if (resultCode == RESULT_OK) {
				ArrayList<String> text = data
						.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

				display.setText(text.get(0));
				String display1 = display.getText().toString();
				String msg1 = "light on";
				String msg2 = "fan on";
				String msg3 = "light off";
				String msg4 = "fan off";

				if ((display1.equals(msg1)) || (display1.equals("light on"))) {
					String phoneNo = "7416628323";
					String msg11 = "A";

					try {
						SmsManager smsManager = SmsManager.getDefault();
						smsManager.sendTextMessage(phoneNo, null, msg11, null,
								null);
						Toast.makeText(getApplicationContext(), "SMS Sent!",
								Toast.LENGTH_LONG).show();
					} catch (Exception e) {
						Toast.makeText(getApplicationContext(),
								"SMS faild, please try again later!",
								Toast.LENGTH_LONG).show();
						e.printStackTrace();
					}

				}

				if ((display1.equals(msg2)) || (display1.equals("lights off"))) {
					String phoneNo = "9396553329";
					String msg22 = "B";

					try {
						SmsManager smsManager = SmsManager.getDefault();
						smsManager.sendTextMessage(phoneNo, null, msg22, null,
								null);
						Toast.makeText(getApplicationContext(), "SMS Sent!",
								Toast.LENGTH_LONG).show();
					} catch (Exception e) {
						Toast.makeText(getApplicationContext(),
								"SMS faild, please try again later!",
								Toast.LENGTH_LONG).show();
						e.printStackTrace();
					}

				}

				if (display1.equals(msg3) || (display1.equals("fan on"))) {
					String phoneNo = "9396553329";
					String msg33 = "C";

					try {
						SmsManager smsManager = SmsManager.getDefault();
						smsManager.sendTextMessage(phoneNo, null, msg33, null,
								null);
						Toast.makeText(getApplicationContext(), "SMS Sent!",
								Toast.LENGTH_LONG).show();
					} catch (Exception e) {
						Toast.makeText(getApplicationContext(),
								"SMS faild, please try again later!",
								Toast.LENGTH_LONG).show();
						e.printStackTrace();
					}

				}

				if ((display1.equals(msg4)) || (display1.equals("fan off"))) {
					String phoneNo = "9396553329";
					String msg44 = "D";

					try {
						SmsManager smsManager = SmsManager.getDefault();
						smsManager.sendTextMessage(phoneNo, null, msg44, null,
								null);
						Toast.makeText(getApplicationContext(), "SMS Sent!",
								Toast.LENGTH_LONG).show();
					} catch (Exception e) {
						Toast.makeText(getApplicationContext(),
								"SMS faild, please try again later!",
								Toast.LENGTH_LONG).show();
						e.printStackTrace();
					}

				}
			}
		}
		super.onActivityResult(requestCode, resultCode, data);

	}

}
