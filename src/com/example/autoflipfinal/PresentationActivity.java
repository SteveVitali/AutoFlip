package com.example.autoflipfinal;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.view.Menu;
import android.widget.ImageButton;
import android.widget.Toast;
import java.util.ArrayList;

public class PresentationActivity extends MainActivity {
		
	protected static final int RESULT_SPEECH = 1;
	Button nextButton, previousButton;
	TextView cardText; 
	String tempSpokenText = new String();
	String spokenText = new String();
	
	SpeechRecognizer sr;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.presentation_activity);
		
		sr = SpeechRecognizer.createSpeechRecognizer(getApplicationContext());
		
		MyRecognitionListener listener = new MyRecognitionListener();
		
		listener.setPresentationActivity(this);
		
		sr.setRecognitionListener(listener);

		sr.startListening(RecognizerIntent.getVoiceDetailsIntent(getApplicationContext()));
		
		cardText = (TextView) findViewById(R.id.cardText);
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
	
	public void startListeningAgain()
	{
		sr.startListening(RecognizerIntent.getVoiceDetailsIntent(getApplicationContext()));
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
	
	public void showSpokenText(String s) {
		cardText.setText(s);
		cardText.refreshDrawableState();
	}
}
