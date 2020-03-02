package ed.edu.alexu.csd.datastructure.hangman.csx22;
import java.util.Scanner;
public class mykame {

	public static void main(String[] args) {
		char c;
		myGame game=new myGame();
		int max=game.Getmax();
		System.out.println("Welcome to Hangman Game");
		String t=new String();
		String t2=new String();
		t=game.selectRandomSecretWord();
		t2=game.getWord(t);
		int n=game.getCorrectGuesses();
		char arrGuessed[]=new char[t2.length()+7];
		int count=0;
		int j=0;
		for(j=0;j<arrGuessed.length;j++) {
			arrGuessed[j]='0';
		}
		int flag=0;
		System.out.println("The Word :"+t2);

		while((max>0)) {
			@SuppressWarnings("resource")
			Scanner s=new Scanner(System.in);
		try {
		c=s.next().charAt(0);
		for(j=0;j<arrGuessed.length;j++) {
		if(arrGuessed[j]==c) {
			flag=1;
		}
		}
		if (flag==0) {
		t2=game.guess(c);
		n=game.getCorrectGuesses();
		max=game.Getmax();
		if(t2.contentEquals(t)) {
			System.err.println("Congratulations,you win");
			System.out.printf("The word is : %s",t2);
			break;
		}
		arrGuessed[count]=c;
		count++;
		}
		else {
			System.err.println("you have guessed this character before");
		}
		flag=0;
		}
		catch(RuntimeException v) {
			System.err.println(v.getMessage());
		}
		catch(Exception h) {
			System.err.println(h.getMessage());
			System.err.printf("The word is %s",t);
			break;
		}
		n=game.getCorrectGuesses();
		max=game.Getmax();
		System.out.println("Number Of Remaining Wrong Guesses = "+max);
		System.out.println("Number Of correct Guesses = "+n);
		System.out.println("The Word is : "+t2);
			}
		}
	}
