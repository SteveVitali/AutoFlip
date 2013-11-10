package com.example.autoflipfinal;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PresentationActivity extends MainActivity {
		
	Button nextButton, previousButton;
	TextView cardText; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.presentation_activity);
//		
		cardText = (TextView) findViewById(R.id.cardText);
//		
		updateCard();
		

		previousButton = (Button) findViewById(R.id.previousButton);
		previousButton.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (currentCard > 0)
				{
					previousCard();
				}
			    
			}
		});
		
	    nextButton = (Button) findViewById(R.id.nextButton);
		nextButton.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			    if (currentCard < presentation.cards.size()-1)
			    {
			    	nextCard();
			    }
			}
		});
	}
	
	public void nextCard()
	{
    	currentCard++;
    	updateCard();
	}
	
	public void previousCard()
	{
		currentCard--;
		updateCard();
	}
	
	public void updateCard()
	{
		String text = new String();

		for(int j=0; j<presentation.cards.get(currentCard).bullets.size(); j++)
		{
			text = text + presentation.cards.get(currentCard).bullets.get(j).toString()+"\n";
		}
		cardText.setText(text+"");
		cardText.refreshDrawableState();
	}
}
