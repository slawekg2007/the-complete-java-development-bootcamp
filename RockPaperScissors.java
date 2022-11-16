import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Let's play Rock Paper Scissors.");
        System.out.println("When I say 'shoot', Choose: rock, paper, or scissors.\n");
        System.out.println("Are you ready? Write 'yes' if you are.");

        //Task 1: See if the user wants to play.
        String answer = scan.next();
        answer.toLowerCase();

    //Task 2: Set up the game
        String wordOfChoice = "";
        if (answer.equals("yes")) {
            System.out.println("Great !");
            System.out.println("rock - paper - scissors, shoot !");
            //answer = scan.next();
            wordOfChoice=wordOfChoice();
            System.out.println("you choise was "+ answer);
            System.out.println("computer choise was "+wordOfChoice);
            System.out.println(result(answer, wordOfChoice));
        } else {
            System.out.println("Darn, some other time...!");
        }
        scan.close();
    }

    public static String wordOfChoice(){
        int comChoice = (int)(Math.random()*3);
        switch (comChoice){
            case 0: return "rock";
            case 1: return "paper";
            case 2: return "scissors";
            default: return "";
        }

    }

    public static String result(String yourChoice, String computerChoice) {
        Scanner scan = new Scanner(System.in);
        String result = "";
        int toTree = 0;

        while (toTree!=1&&toTree!=-1) {
            if (yourChoice.equals(computerChoice)){
                result = "draw, try again";
                yourChoice=scan.next();
            }
            else if (yourChoice.equals("rock") && computerChoice.equals("scissors")
                    || yourChoice.equals("scissors") && computerChoice.equals("paper")
                    || yourChoice.equals("paper") && computerChoice.equals("rock")) {
//                System.out.println("Conratulations, you won!");
                toTree++;
                result = "Conratulations, you won!";
                yourChoice=scan.next();
            } else {
                toTree--;
//                System.out.println("sorry you loss");
                result = "sorry you loss";
                yourChoice=scan.next();
            }
        }
        return result;
    }

}