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
import java.util.Arrays;

public class PresentationActivity extends MainActivity {
		
	protected static final int RESULT_SPEECH = 1;
	Button nextButton, previousButton;
	TextView cardText; 
	String tempSpokenText = new String();
	String spokenText = new String();
	
	SpeechRecognizer sr;
	MyRecognitionListener listener;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.presentation_activity);
		
		startRecognizerNonsense();
		
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
	
	
	public void startRecognizerNonsense()
	{
		
		sr = SpeechRecognizer.createSpeechRecognizer(getApplicationContext());
		listener = new MyRecognitionListener();
		listener.setPresentationActivity(this);
		sr.setRecognitionListener(listener);
		sr.startListening(RecognizerIntent.getVoiceDetailsIntent(getApplicationContext()));
	}
	
	public void checkIntersection()
	{
		String fullText = "";
		String compareText = spokenText;
		for(int i=0; i<presentation.cards.get(currentCard).bullets.size(); i++)
		{
			fullText += presentation.cards.get(this.currentCard).bullets.get(i);
		}
		
		String[] fullList  = fullText.split("\\s+");
		String[] spokenList=compareText.split("\\s+");
		
	//	int dist = LevenshteinDistance.computeDistance(fullText, compareText);
		
	//	Log.e("", "THE LEVENSHABANGARANG DISTANCE IS: "+dist);
		
		int count = 0;
		for (int i = 0; i < fullList.length; i++) 
		{
			for (int j = 0; j < spokenList.length; j++) 
			{
				if (fullList[i].equals(spokenList[j])){
					count++;
				}
			}
		}
		
		float ratio = (float) count/fullList.length;
		
		if (ratio > .20)
		{
			nextCard();
		}
		
		Log.e("", "Full Text: "+fullText);
		Log.e("", "Spoken Text: "+compareText);
		Log.e("", "Ratio:"+ratio);
		Log.e("", "THE LEVENSHABANGARANG COUNT IS: "+count);
		
	}
	
	public void nextCard()
	{
    	currentCard++;
    	updateCard();
    	spokenText = "";
	}
	
	public void previousCard()
	{
		currentCard--;
		updateCard();
    	spokenText = "";
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
//		cardText.setText(s);
//		cardText.refreshDrawableState();
	}
}
