package com.skilldistillery.blackjack;

import com.skilldistillery.cards.common.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import com.skilldistillery.cards.common.*;

public class BlackJackGame extends Hand {

	Scanner kb = new Scanner(System.in);

	public void initialMenu() {

		System.out.println("| |   | |          | |  (_)          | |   \n"
				+ "| |__ | | __ _  ___| | ___  __ _  ___| | __\n" + "| '_ \\| |/ _` |/ __| |/ / |/ _` |/ __| |/ /\n"
				+ "| |_) | | (_| | (__|   <| | (_| | (__|   < \n"
				+ "|_.__/|_|\\__,_|\\___|_|\\_\\ |\\__,_|\\___|_|\\_\\\n"
				+ "                       _/ |                \n" + "                      |__/                 ");
	}

	public void logic() {
		int totalForCurrentHand = 0;
		Deck deck = new Deck();
		deck.shuffle();
		Player player = new Player();
		Dealer dealer = new Dealer();

		player.addCardToHand(dealer.dealCard());
		dealer.addCardToHand(dealer.dealCard());
		player.addCardToHand(dealer.dealCard());
		dealer.addCardToHand(dealer.dealCard());

		dealer.checkForBlackJack();
		player.checkForBlackJack();

		while (totalForCurrentHand < 21) {
			System.out.println("Which option do you want to take \n (1) to hit (2) \n to stand");
			int userChoice = kb.nextInt();
			switch (userChoice) {
			case 1:
				System.out.println("You have decided to hit ");
				player.addCardToHand(dealer.dealCard());
				totalForCurrentHand = player.getValue();
				System.out.println("Your current hand value is " + totalForCurrentHand);
				System.out.println("Which option do you want to take \n (1) to hit (2) \n to stand");

				break;
			case 2:
				System.out.println("You have decided to stand the value of your card ");
				System.out.println("Your current hand value is " + totalForCurrentHand);
				break;
			}
		}

	}

	public void ifDealerOver21DetermineHitOrStand(Dealer blackDealer, Scanner kb) {
		if (blackDealer.getDealerHand().getHandValue() < 17) {
			int dealerHandValue = blackDealer.getDealerHand().getHandValue();
			System.out.println("Current value of dealer hand is " + dealerHandValue);
			dealerHit();
		}
	}

	public int determineWhoHasWon(Dealer blackdealer, Player player) {
		int totalForDealer = blackdealer.getDealerHand().getHandValue();
		int totalForPlayer = player.getValue();
		if (totalForDealer < totalForPlayer) {
			playerWins();
		} else {
			dealerWins();
		}
		return 0;

	}

	public void getCounterOfHards() {

	}

	public int checkValueOfHand() {
		return getHandValue();
	}

	public boolean playerWins() {
		System.out.println("Player wins");
		return true;
	}

	public boolean dealerWins() {
		System.out.println("Dealer wins");
		return true;
	}

	public void playerHit() {

	}

	public void dealerHit() {

	}

}
