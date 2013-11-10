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
    	strings1.add("This is a notecard with words");
    	strings1.add("We made this application with Eclipse");
    	strings1.add("Java is a programming language");
    	
    	ArrayList<String> strings2 = new ArrayList<String>();
    	strings2.add("We need a method to compare stuff");
    	strings2.add("Something something algorithm");
    	strings2.add("Shashank says it's too many words");
    	
    	ArrayList<String> strings3 = new ArrayList<String>();
    	strings3.add("It should work with a few or a lot of words");
    	strings3.add("We got all the niggly shit out of the way");
    	strings3.add("You know what, uhm, goddamnit, Steve.");
    	
    	NoteCard card1 = new NoteCard(strings1, 1);
    	NoteCard card2 = new NoteCard(strings2, 2);
    	NoteCard card3 = new NoteCard(strings3, 3);
    	
    	cards.add(card1);
    	cards.add(card2);
    	cards.add(card3);

    }
}
