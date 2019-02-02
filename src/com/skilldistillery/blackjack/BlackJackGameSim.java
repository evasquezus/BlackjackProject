package com.skilldistillery.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Deck;

public class BlackJackGameSim {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		BlackJackGame sim = new BlackJackGame();
		sim.initialMenu();
		sim.logic();

	}

}
