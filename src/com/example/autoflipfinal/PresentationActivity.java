package com.example.autoflipfinal;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.widget.TextView;

public class PresentationActivity extends MainActivity {
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.presentation_activity);
//		
		TextView cardText = (TextView) findViewById(R.id.cardText);
//		
		String text = new String();

		for(int j=0; j<presentation.cards.get(currentCard).bullets.size(); j++)
		{
			text = text + presentation.cards.get(currentCard).bullets.get(j).toString()+"\n";
		}
		cardText.setText(text+"");
	}	
}
