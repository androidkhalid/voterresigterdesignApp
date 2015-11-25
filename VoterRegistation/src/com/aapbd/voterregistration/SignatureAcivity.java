package com.aapbd.voterregistration;

import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

public class SignatureAcivity extends Activity {

	private Context con;
	private EditText signature;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.signature);
		con = this;
		signature = (EditText) findViewById(R.id.SignatureCanvas);
//		if (signature.getText() == null) {
//			writeTestBitmap(signature.getText().toString());
//		}
		canvas();

	}

	public void setCancel(View v) {
		finish();
	}

	public void setBack(View v) {
		Intent next = new Intent(con, PollingQuestionsActivity.class);
		startActivity(next);
		finish();

	}

	public void setNext(View v) {
		Intent next = new Intent(con, NameonLastRegistrationActivity.class);
		startActivity(next);
		finish();
	}

	public void writeTestBitmap(String text) {
		// font size
		float fontSize = new EditText(con).getTextSize();
		fontSize += fontSize * 0.2f;
		// paint to write text with
		Paint paint = new Paint();
		paint.setStyle(Style.FILL);
		paint.setColor(Color.DKGRAY);
		paint.setAntiAlias(true);
		paint.setTypeface(Typeface.SERIF);
		paint.setTextSize((int) fontSize);
		// min. rect of text
		Rect textBounds = new Rect();
		paint.getTextBounds(text, 0, text.length(), textBounds);
		// create bitmap for text
		Bitmap bm = Bitmap.createBitmap(textBounds.width(),
				textBounds.height(), Bitmap.Config.ARGB_8888);
		// canvas
		Canvas canvas = new Canvas();
		//canvas.drawARGB(255, 0, 255, 0);// for visualization
		// y = ?
		// canvas.drawText(text, 0, textBounds.height(), paint);
		canvas.drawText(text, 0, canvas.getHeight(), paint);
		Toast.makeText(con, text, 1000).show();
		// try {
		// FileOutputStream out = new FileOutputStream(fileName);
		// bm.compress(Bitmap.CompressFormat.JPEG, 100, out);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
	}

	public void canvas() {
		String captionString = signature.getText().toString();
		if (captionString != null) {

			Paint paintText = new Paint(Paint.ANTI_ALIAS_FLAG);
			paintText.setColor(Color.BLUE);
			paintText.setTextSize(50);
			paintText.setStyle(Style.FILL);
			paintText.setShadowLayer(10f, 10f, 10f, Color.BLACK);

			Rect rectText = new Rect();
			paintText.getTextBounds(captionString, 0, captionString.length(),
					rectText);

			Canvas canvas = new Canvas();
			canvas.drawARGB(255, 0, 255, 0);

			canvas.drawText(captionString, 0, rectText.height(), paintText);

			Toast.makeText(getApplicationContext(),
					"drawText: " + captionString, Toast.LENGTH_LONG).show();

		} else {
			Toast.makeText(getApplicationContext(), "caption empty!",
					Toast.LENGTH_LONG).show();
		}
	}

}