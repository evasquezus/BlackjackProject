package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.skilldistillery.blackjack.Dealer;

public class Hand {

	private List<Card> hand = new ArrayList<Card>();;

	public Hand() {

	}

	public int checkDeckSize(Card e) {
		return getCards().size();

	}

	public void showCurrentHand() {
		System.out.println(hand);
	}

	public void addCard(Card card) {
		hand.add(card);
	}

	public void clearCurrentHand() {
		getCards().clear();
	}

	public int getHandValue() {
		int totalForHand = 0;
		for (int i = 0; i < hand.size(); i++) {
			totalForHand += hand.get(i).getValue();
		}
		return totalForHand;

	}

	public List<Card> getCards() {
		return hand;
	}

	public void setCards(Card card) {
		this.hand.add(card);
	}

	public void clearHand() {
		hand.clear();
	}
}
