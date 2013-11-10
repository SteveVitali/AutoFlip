package com.example.autoflipfinal;

import java.util.ArrayList;

import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.SpeechRecognizer;
import android.util.Log;

class MyRecognitionListener implements RecognitionListener {

	PresentationActivity activity;
	
	public void setPresentationActivity(PresentationActivity p)
	{
		activity = p;
	}
	@Override
	public void onBeginningOfSpeech() {
		Log.d("Speech", "onBeginningOfSpeech");
	}

	@Override
	public void onBufferReceived(byte[] buffer) {
		Log.d("Speech", "onBufferReceived");
	}

	@Override
	public void onEndOfSpeech() {
		Log.d("Speech", "onEndOfSpeech");
	}

	@Override
	public void onError(int error) {
		activity.startListeningAgain();
		Log.d("Speech", "onError");
	}

	@Override
	public void onEvent(int eventType, Bundle params) {
		Log.d("Speech", "onEvent");
	}

	@Override
	public void onPartialResults(Bundle results) {
		/*String[] results1 = results.getStringArray("com.google.android.voicesearch.UNSUPPORTED_PARTIAL_RESULTS");
		activity.spokenText += results1.toString();
		activity.tempSpokenText = "";
		activity.showSpokenText(activity.spokenText);
		activity.startListeningAgain();
		Log.d("Speech", "result=" + activity.spokenText);*/
	}

	@Override
	public void onReadyForSpeech(Bundle params) {
		Log.d("Speech", "onReadyForSpeech");
	}

	@Override
	public void onResults(Bundle results) {
		Log.d("Speech", "onResults");
		ArrayList strlist = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
	//	for (int i = 0; i < strlist.size(); i++) {
	//		activity.tempSpokenText += strlist.get(i);
			
	//	}
		activity.tempSpokenText += strlist.get(0);
		
		activity.spokenText += activity.tempSpokenText;
		activity.tempSpokenText = "";
		activity.showSpokenText(activity.spokenText);
		
		activity.checkIntersection();
		activity.startListeningAgain();
		Log.d("Speech", "result=" + activity.spokenText);
	}

	@Override
	public void onRmsChanged(float rmsdB) {
		Log.d("Speech", "onRmsChanged");
	}
}