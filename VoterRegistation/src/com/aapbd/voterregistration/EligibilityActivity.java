package com.aapbd.voterregistration;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class EligibilityActivity extends Activity {

	private Context con;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.eligibility);
		con = this;

	}

	public void setCancel(View v) {
		finish();
	}

	public void setNext(View v) {
		Intent next = new Intent(con, CheckallThatApplyActivity.class);
		startActivity(next);
		finish();
	}

}