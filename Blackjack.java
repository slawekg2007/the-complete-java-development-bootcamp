import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        scan.next();
        //Task 3 – Wait for the user to press enter.
        //Task 4 – Get two random cards.
        int first= create();
        int second=create();
        System.out.println("\n You get a \n" +cardString(first)+ "\n and a \n" + cardString(second));

        int sumOfPoints = Math.min(first,10)+Math.min(second, 10);
        System.out.println("your total is: "+ sumOfPoints+" points");
        int comFirst=create();
        int comSecond=create();
        System.out.println();
        System.out.println("The dealer shows \n" + cardString(comFirst) +"\n and has a card facing down \n" + faceDown());
        int comSumOfPoints=Math.min(comFirst,10)+Math.min(comSecond, 10);

        //       – Print: The dealer shows \n" + <first card> + "\nand has a card facing down \n" + <facedown card>
        System.out.println("\n The dealer's total is hidden");
        System.out.println("do you wanna hit or stay?");
        String doYouWannaPlay="";
        while (!doYouWannaPlay.equals("stay"))
        {
            doYouWannaPlay= scan.next();
            if (doYouWannaPlay.equals("stay")) continue;
            else if (doYouWannaPlay.equals("hit")){
                int newCard =create();
                System.out.println("\n You get a \n" +cardString(newCard));
                sumOfPoints+=Math.min(newCard,10);
                System.out.println("you have "+sumOfPoints+" in total");
            }
            else System.out.println("write another");

            if (sumOfPoints>21){
                System.out.println("Sorry you lost");
                System.exit(0);
            }
        }
        System.out.println("\nDealer's turn");
        System.out.println("\n The dealer's cards are \n" + cardString(comFirst)
                + "\n and a \n" + cardString(comSecond));
        System.out.println("Dealer's total is " + comSumOfPoints);

        while (comSumOfPoints < 17) {
            int newCard = create();

            comSumOfPoints += Math.min(newCard, 10);
            System.out.println("\n Dealer gets a \n" + cardString(newCard));
            System.out.println("Dealer's total is " + comSumOfPoints);
        }

        if (comSumOfPoints > 21) {
            System.out.println("Bust! Dealer loses.");
            System.exit(0);
        }
        if (sumOfPoints>comSumOfPoints){
            System.out.println("Congratulation, you won!");
        } else if (sumOfPoints<comSumOfPoints) {
            System.out.println("Sorry, you loss");
        }
        else System.out.println("Draw!");

        //Task 8 – Keep asking the player to hit or stay (while loop).
        //       1. Every time the player hits
        //             – draw a new card.
        //             – calculate their new total.
        //             – print: (new line) You get a (new line) <show new card>.
        //             - print: your new total is <total>

        //       2. Once the player stays, break the loop. 


        //For tasks 9 to 13, see the article: Blackjack Part II. 
        scan.close();

    }
    public static int create(){
        return (int)(Math.random()*13)+1;
    }
    public static String cardString(int cardNumber) {
        switch(cardNumber) {
            case 1:
                return "   _____\n"+
                        "  |A _  |\n"+
                        "  | ( ) |\n"+
                        "  |(_'_)|\n"+
                        "  |  |  |\n"+
                        "  |____V|\n";
            case 2:
                return  "   _____\n"+
                        "  |2    |\n"+
                        "  |  o  |\n"+
                        "  |     |\n"+
                        "  |  o  |\n"+
                        "  |____Z|\n";

            case 3:
                return"   _____\n" +
                        "  |3    |\n"+
                        "  | o o |\n"+
                        "  |     |\n"+
                        "  |  o  |\n"+
                        "  |____E|\n";

            case 4:
                return "   _____\n" +
                        "  |4    |\n"+
                        "  | o o |\n"+
                        "  |     |\n"+
                        "  | o o |\n"+
                        "  |____h|\n";

            case 5:
                return  "   _____ \n" +
                        "  |5    |\n" +
                        "  | o o |\n" +
                        "  |  o  |\n" +
                        "  | o o |\n" +
                        "  |____S|\n";

            case 6:
                return  "   _____ \n" +
                        "  |6    |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  |____6|\n";

            case 7:
                return
                        "   _____ \n" +
                                "  |7    |\n" +
                                "  | o o |\n" +
                                "  |o o o|\n" +
                                "  | o o |\n" +
                                "  |____7|\n";


            case 8:
                return  "   _____ \n" +
                        "  |8    |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  |____8|\n";
            case 9:
                return  "   _____ \n" +
                        "  |9    |\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |____9|\n";

            case 10:
                return  "   _____ \n" +
                        "  |10  o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |___10|\n";
            case 11:
                return  "   _____\n" +
                        "  |J  ww|\n"+
                        "  | o {)|\n"+
                        "  |o o% |\n"+
                        "  | | % |\n"+
                        "  |__%%[|\n";
            case 12:
                return  "   _____\n" +
                        "  |Q  ww|\n"+
                        "  | o {(|\n"+
                        "  |o o%%|\n"+
                        "  | |%%%|\n"+
                        "  |_%%%O|\n";
            case 13:
                return  "   _____\n" +
                        "  |K  WW|\n"+
                        "  | o {)|\n"+
                        "  |o o%%|\n"+
                        "  | |%%%|\n"+
                        "  |_%%%>|\n";

            default: return "not possible";
        }
    }

    public static String faceDown() {
        return
                "   _____ \n"+
                "  |     |\n"+
                "  |  J  |\n"+
                "  | JJJ |\n"+
                "  |  J  |\n"+
                "  |_____|\n";
    }

}