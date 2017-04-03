import java.util.Scanner;

public class hangman{
     public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        String word = "hello", game = "";
        for(int i = 0; i < word.length(); i++)
            game += "-";
        boolean run = true;
        int temp = 7, score = 0;
    	System.out.println(game);
        System.out.println("Guess a letter!");
        while(run == true) {
            String fakeInput = scan.nextLine();
            char input = fakeInput.charAt(0);
            boolean point = false;
            for(int i = 0; i < word.length(); i++) {
                if(input == word.charAt(i)) {
                  char[] theWord = game.toCharArray();
                  theWord[i] = input;
                  game = String.valueOf(theWord);
                  point = true;
                }
            }
            if(point == true)
                System.out.println(input + " is in the word! ");
            if(point == false) {
                temp--;
                System.out.println(input + " is not in the word. ");
            }
            if(word.equals(game)) {
                System.out.println("You won! Good game!" );
                score++;
                run = false;
            }
            else if(temp == 0) {
                System.out.println("You lost! Good try. The word was " + word + ".");
                run = false;
            }
            else {
        	    System.out.println(game);
                System.out.println("Guess another letter!");
            }
        }
    }
}
