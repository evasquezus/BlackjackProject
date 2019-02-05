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

		System.out.println(" \nDealer will start dealing hands \n");
		player.addCardToHand(dealer.dealCard());
		totalForCurrentHand = player.getValue();
		System.out.println("Dealer dealt first card current hand total is: " + totalForCurrentHand);
		dealer.addCardToHand(dealer.dealCard());
		player.addCardToHand(dealer.dealCard());
		totalForCurrentHand = player.getValue();
		System.out.println("Dealer dealt second card current hand total is: " + totalForCurrentHand + "\n");
		if (totalForCurrentHand == 21) {
			determineWhoHasWon(dealer, player);

		} else if (dealer.getDealerHand().getHandValue() == 21) {
			determineWhoHasWon(dealer, player);

		} else {

			dealer.addCardToHand(dealer.dealCard());
			boolean continueGame = true;
			while (totalForCurrentHand < 21 && continueGame) {
				System.out.println(" \n " + "Which option do you want to take \n" + "(1) to hit (2) to stand");
				int userChoice = kb.nextInt();
				switch (userChoice) {
				case 1:
					System.out.println(" You have decided to hit ");
					player.addCardToHand(dealer.dealCard());
					totalForCurrentHand = player.getValue();
					System.out.println(" Your current hand value is " + totalForCurrentHand);
					break;
				case 2:
					System.out.println(" You have decided to stand the value of your hand is: " + totalForCurrentHand);
					ifDealerOver21DetermineHit(dealer, kb);
					determineWhoHasWon(dealer, player);
					continueGame = false;
					if (continueGame) {
					}
					break;
				}
			}

		}
	}

	public void ifDealerOver21DetermineHit(Dealer dealer, Scanner kb) {
		int dealerHandValue = dealer.getDealerHand().getHandValue();
		while (dealer.getDealerHand().getHandValue() < 17) {
			dealerHandValue = dealer.getDealerHand().getHandValue();
			System.out.println("Current value of dealer hand is " + dealerHandValue + "\n");
			dealer.addCardToHand(dealer.dealCard());
			dealerHandValue = dealer.getDealerHand().getHandValue();
		}
		System.out.println("Dealer adds card current value of dealer hand is " + dealerHandValue + "\n");
	}

	public int determineWhoHasWon(Dealer dealer, Player player) {
		int totalForDealer = dealer.getDealerHand().getHandValue();
		int totalForPlayer = player.getValue();
		if (totalForDealer > 21) {
			playerWins();
		} else if (totalForPlayer > 21) {
			dealerWins();
		} else if (totalForDealer > totalForPlayer) {
			dealerWins();
		} else if (totalForPlayer > totalForDealer) {
			playerWins();
		} else {
			totalForPlayer = totalForDealer;
			System.out.println("Tied scores");

		}
		return totalForDealer;

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

}
