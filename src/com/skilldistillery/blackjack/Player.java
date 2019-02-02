package com.skilldistillery.blackjack;

import java.util.List;
import com.skilldistillery.cards.common.*;

import com.skilldistillery.cards.common.*;

public class Player extends Participant {

	private Hand playerHand;;
	private BlackJackHand playerhand;

	public Player() {
		playerHand = new BlackJackHand();
	}

	public void addCardToHand(Card card) {
		playerHand.addCard(card);
	}

	public void setValue(int amount) {

	}

	public int getValue() {
		int playerHandValue = playerHand.getHandValue();
		return playerHandValue;
	}

	@Override
	void checkForBlackJack() {
		if (playerhand.getHandValue() > 21) {
			playerhand.clearCurrentHand();
			System.out.println("You won");
		}
	}

}
