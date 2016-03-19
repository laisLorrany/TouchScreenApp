package br.edu.ifpb.touchapp.activity;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	/*
	 * Para o acelerômetro:
	 * http://ubuntu.blog.br/acelerometro-e-sensor-de-gravidade-no-android/
	 * */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		SensorEventListener sensorEvent = new SensorEventListener() {
			
			@Override
			public void onSensorChanged(SensorEvent event) {
				
				if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
					float inclinacao = event.values[0];
					
					TextView movimento = (TextView) findViewById(R.id.movimentoTextView);
					movimento.setText("Inclinação: " + inclinacao);
				}
				
			}
			
			@Override
			public void onAccuracyChanged(Sensor sensor, int accuracy) {
								
			}
		};
		((SensorManager)getSystemService(SENSOR_SERVICE)).
		registerListener(sensorEvent,((SensorManager)getSystemService(SENSOR_SERVICE)).
				getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.
				SENSOR_DELAY_GAME);
		   
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);

		final TextView coordenadasTextView = (TextView) findViewById(R.id.coordenadasXYTextView);
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
