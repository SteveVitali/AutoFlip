package com.example.autoflipfinal;

import java.util.ArrayList;

public class Presentation {

    ArrayList<NoteCard> cards;
    String title;

    public Presentation(ArrayList<NoteCard> c)
    {
        cards = c;
    }
    
    public Presentation()
    {
    	cards = new ArrayList<NoteCard>();

    	ArrayList<String> strings1 = new ArrayList<String>();
    	strings1.add("Anecdote - Prepared talking points; issues keeping stack");
    	strings1.add("Speech; looked down; bullets small; order; hard to follow");
    	
    	ArrayList<String> strings2 = new ArrayList<String>();
    	strings2.add("Autoflip - virtual notecard; technologies");
    	strings2.add("solve issues with Autoflip");


    	
    	ArrayList<String> strings3 = new ArrayList<String>();
    	strings3.add("Cloud computing; voice recognition");
    	strings3.add("Most relevant; glance down at");

    	
    	ArrayList<String> strings4 = new ArrayList<String>();
    	strings4.add("Demo");
    	strings4.add("The quick brown fox jumps over the lazy dog.");
    	
    	ArrayList<String> strings5 = new ArrayList<String>();
    	strings5.add("Thank you.");
    	
    	NoteCard card1 = new NoteCard(strings1, 1);
    	NoteCard card2 = new NoteCard(strings2, 2);
    	NoteCard card3 = new NoteCard(strings3, 3);
    	NoteCard card4 = new NoteCard(strings4, 4);
    	NoteCard card5 = new NoteCard(strings5, 5);
    	
    	cards.add(card1);
    	cards.add(card2);
    	cards.add(card3);
    	cards.add(card4);
    	cards.add(card5);

    }
}
