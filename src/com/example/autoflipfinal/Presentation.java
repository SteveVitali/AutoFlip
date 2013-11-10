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
    	strings1.add("2 Chainz but I got me a few on");
    	strings1.add("We made this application with Eclipse");
    	strings1.add("Three more lines of a 2 Chainz song");
    	
    	ArrayList<String> strings2 = new ArrayList<String>();
    	strings2.add("We need a method to compare stuff");
    	strings2.add("Something something algorithm");
    	strings2.add("Shashank says it's too many words");
    	
    	ArrayList<String> strings3 = new ArrayList<String>();
    	strings3.add("It should work with a few or a lot of words");
    	strings3.add("It's finally working!");
    	strings3.add("Yes! The sun is finally out!");
    	
    	NoteCard card1 = new NoteCard(strings1, 1);
    	NoteCard card2 = new NoteCard(strings2, 2);
    	NoteCard card3 = new NoteCard(strings3, 3);
    	
    	cards.add(card1);
    	cards.add(card2);
    	cards.add(card3);

    }
}
