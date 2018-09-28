/**
 * @author Alex Petros
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class BlackJack{
    public static int count = 53;
    public static int random = (int)Math.random()*count;
    
    Integer [] deck = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};
        
    public static ArrayList<Integer> deckOfCards = new ArrayList<Integer>();
    
    public static void main(String[] args){
        Integer [] deck = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};
        deckOfCards = new ArrayList<Integer>(Arrays.asList(deck));
        Collections.shuffle(deckOfCards);
        
        int userCard1 = deckOfCards.get(0);
        deckOfCards.remove(0);
        
        int userCard2 = deckOfCards.get((int)(Math.random()*count));
        deckOfCards.remove(0);
        
        int userSum = userCard1 + userCard2;
        
        System.out.println("You get a "+ userCard1 +" and a "+userCard2);
        System.out.println("Your total is "+ userSum);
 
        if(userSum == 21){
            System.out.println("Blackjack! You Win!");
            return;
        }
        
        else if(userSum > 21){
            userSum = 12;
        }
        
        System.out.println();
        
        int houseCard1 = deckOfCards.get(0);
        deckOfCards.remove(0);
        
        int houseCard2 = deckOfCards.get(0);
        deckOfCards.remove(0);
        
        int houseSum = houseCard1 + houseCard2;
        
        System.out.println("The dealer has a " + houseCard1 + " showing and a hidden card");
        System.out.println("His total is hidden too");
        System.out.println();

        String player_preference;
        Scanner in = new Scanner(System.in);

        System.out.println("Would you like to [hit] or [stay]?");
        player_preference = in.nextLine();

        while(player_preference.equals("hit")){
            int player_random3 = deckOfCards.get(0);
            deckOfCards.remove(0);
            
            userSum = userSum + player_random3;
            
            System.out.println("You drew a " + player_random3);
            System.out.println("Your total is " + userSum);
            System.out.println();

            if(userSum > 21){
                System.out.println("You Busted! Dealer wins!");
                return;
            }
            else if(userSum == 21){
                System.out.println("You Win!");
                return;
            }
            System.out.println("Would you like to [hit] or [stay]?");
            player_preference = in.nextLine();
        }
        
        if (player_preference.equals("stay")){
            System.out.println();
            System.out.println("Okay, dealer's turn.");
            
            int dealer_random3 = deckOfCards.get(0);
            deckOfCards.remove(0);

            System.out.println("His hidden card was " + houseCard2);
            System.out.println("His total was " + houseSum);
            System.out.println();

            if(houseSum > 16){
                System.out.println("Dealer stays");
            }
            else {
                while(houseSum <= 16){
                    houseSum = houseSum + dealer_random3;
                    System.out.println("Dealer choses to hit.");
                    System.out.println("He draws a " + dealer_random3);
                    System.out.println("His total is " + houseSum);
                }
            }

            System.out.println();
            System.out.println("Dealer's total is " + houseSum);
            System.out.println("Your total is " + userSum);

            if((userSum > houseSum && userSum < 21) || houseSum > 21){
                System.out.println("YOU WIN!");
            }
            else if((houseSum < 21 && userSum < houseSum) || userSum > 21){
                    System.out.println("DEALER WINS!");
            }
        }
    }
}