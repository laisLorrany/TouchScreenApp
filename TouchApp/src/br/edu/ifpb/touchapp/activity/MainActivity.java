package br.edu.ifpb.touchapp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);

		final TextView coordenadasTextView = (TextView) findViewById(R.id.coordenadasTextView);
		coordenadasTextView.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent event) {

				String coordenadas;
				
				if (event.getAction() == MotionEvent.ACTION_MOVE) {
					coordenadas = "Movendo, X: " + event.getX() 
							+ ", Y: "	+ event.getY();
				} else {
					coordenadas = "Parado, X:" + event.getX() 
							+ ", Y:"	+ event.getY();
				}
				coordenadasTextView.setText(coordenadas);
				return true;
			}
		});
		return true;
	}

}
