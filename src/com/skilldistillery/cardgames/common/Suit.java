package com.skilldistillery.cardgames.common;

public enum Suit {
	HEARTS("Hears"),
	SPADES("Spades"),
	CLUBS("Clubs"),
	DIAMONDS("Diamonds");

	Suit(String e){
		name = e;
	}

	final private String name;

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}
}
