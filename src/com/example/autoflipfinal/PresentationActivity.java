package com.example.autoflipfinal;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

public class PresentationActivity extends Activity {
	
	Presentation presentation;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.presentation_activity);
//		
		TextView cardText = (TextView) findViewById(R.id.cardText);
//		
//		cardText.setText((CharSequence) presentation.cards.get(1).toString().subSequence(0,  presentation.cards.get(1).toString().length()));
	}	
	
}
