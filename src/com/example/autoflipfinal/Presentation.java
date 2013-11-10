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
    	strings1.add("this is bullet number 1, card number 1");
    	strings1.add("this is bullet number 2, card number 1");
    	strings1.add("this is bullet number 3, card number 1");
    	
    	NoteCard card1 = new NoteCard(strings1, 1);
    	
    	ArrayList<String> strings2 = new ArrayList<String>();
    	strings2.add("this is bullet number 1, card number 1");
    	strings2.add("this is bullet number 2, card number 1");
    	strings2.add("this is bullet number 3, card number 1");
    	
    	NoteCard card2 = new NoteCard(strings2, 2);
    	
    	cards.add(card1);
    	cards.add(card2);

    }
}
