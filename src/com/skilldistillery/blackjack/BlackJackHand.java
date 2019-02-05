package com.skilldistillery.blackjack;

import java.util.List;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Hand;

public class BlackJackHand extends Hand {

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
