package com.skilldistillery.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Hand;

public class Player extends Participant {

	private Hand playerHand;;

	public Player() {
		playerHand = new Hand();

	}

	public void addCardToHand(Card card) {
		playerHand.addCard(card);
	}

	public int getValue() {
		int playerHandValue = playerHand.getHandValue();
		return playerHandValue;
	}

	@Override
	void checkForBlackJack() {
		if (playerHand.getHandValue() == 21) {
			System.out.println("You won");
		}
	}

}
