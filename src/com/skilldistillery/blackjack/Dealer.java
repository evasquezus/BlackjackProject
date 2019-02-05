package com.skilldistillery.blackjack;

import java.util.List;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.Hand;

public class Dealer extends Participant {

	private Deck deck;
	private BlackJackHand dealerHand;
	private Dealer dealer;

	public Dealer() {
		deck = new Deck();
		this.dealerHand = new BlackJackHand();
		this.deck.shuffle();
		new Hand();
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

	public int remainingCards() {
		return deck.checkDeckSize();
	}

	@Override
	void checkForBlackJack() {
		if (getDealerHand().getHandValue() == 21) {
			System.out.println("Dealer has busted");
		}
	}

	void checkIfDealerShouldHit() {
		if (getDealerHand().getHandValue() < 17) {
			dealer.dealCard();
		}
	}

	public void showDealerHand(List<Card> cardTakenByDealer) {
		int counter = 0;
		for (Card card : cardTakenByDealer) {
			if (counter == 0) {
				System.out.println("Hidden Card");
			} else {
				System.out.println(card.toString());
			}
			counter++;
		}
	}

}
