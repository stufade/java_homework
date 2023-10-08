package hw_7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CardGameQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.next();
        String input2 = scanner.next();

        if (input1.length() != 5 || input2.length() != 5) {
            System.out.println("Неправильный формат ввода. Введите 5 цифр для каждого игрока.");
            System.exit(-1);
        }
        Queue<Integer> player1Deck = new LinkedList<>();
        Queue<Integer> player2Deck = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            player1Deck.add(Integer.parseInt(String.valueOf(input1.charAt(i))));
            player2Deck.add(Integer.parseInt(String.valueOf(input2.charAt(i))));
        }

        int moves = 0;

        while (true) {

            System.out.println("Player 1's deck: " + player1Deck);
            System.out.println("Player 2's deck: " + player2Deck);

            int card1 = player1Deck.remove();
            int card2 = player2Deck.remove();

            if (card1 > card2 && card1 - card2 != 9) {
                player1Deck.add(card1);
                player1Deck.add(card2);
            } else {
                player2Deck.add(card1);
                player2Deck.add(card2);
            }

            moves++;

            if (player1Deck.isEmpty()) {
                System.out.println("second " + moves);
                break;
            } else if (player2Deck.isEmpty()) {
                System.out.println("first " + moves);
                break;
            }
            if (moves == 100){
                System.out.println("Победитель не определен");
                break;
            }
        }
    }
}


