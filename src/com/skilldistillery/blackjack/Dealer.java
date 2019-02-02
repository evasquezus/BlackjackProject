package com.skilldistillery.blackjack;

import com.skilldistillery.cards.common.*;

public class Dealer extends Participant {

	private Deck deck;
	private BlackJackHand dealerHand;
	private Dealer dealer;

	public Dealer() {
		deck = new Deck();
		this.dealerHand = new BlackJackHand();
		this.deck.shuffle();
	}

	public void addCardToHand(Card card) {
		dealerHand.addCard(card);
	}

	public Card dealCard() {
		return deck.dealCard();

	}

	public BlackJackHand getDealerHand() {
		return dealerHand;
	}
	

	public int 	remainingCards() {
		return deck.checkDeckSize();
	}

	@Override
	void checkForBlackJack() {
		if (dealer.getDealerHand().getHandValue() >= 21) {
			System.out.println("Dealer has busted");
		}
	}

	void checkIfDealerShouldHit() {
		if (dealer.getDealerHand().getHandValue() < 17) {
			dealer.dealCard();
		}
	}

}
