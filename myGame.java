package ed.edu.alexu.csd.datastructure.hangman.csx22;
import java.io.File;
//import java.lang.*; 
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
public class myGame implements IHangman {
	public static int max=7;
	public int z;
	public int i;
	public static int v;
	public static int noOfCorrectGuesses=0;
	public static String SecretWord;
	public char []secretArr;
	public String[] read(String file){
	    String []words= new String[10000];
		try {
	int i=0;
	File dict=new File(file);
    Scanner myReader=new Scanner(dict);
    while(myReader.hasNextLine()) {
    	words[i]=myReader.next();
    	i++;
    }
	z=words.length;
	myReader.close();
	}
    catch(FileNotFoundException h){
    	System.err.println(h.getMessage());
    }	
	catch(Exception k) {
    	System.err.println(k.getMessage());
	}
	    return words;
	}
public void setDictionary(String[] words) {
	int i;
	String[]dictionary=read("myDictionary.txt");
	for(i=0;i<words.length;i++) {
		words[i]=dictionary[i];
	}
}
public String selectRandomSecretWord() {
	myGame l=new myGame();
	String []x=(l.read("myDictionary.txt"));
	Random randomWordNumber=new Random();
	int randomNumber=randomWordNumber.nextInt(x.length);
	SecretWord=x[randomNumber];
    return(SecretWord);
}


public String getWord(String SecretWord) {
	secretArr=new char[SecretWord.length()];
	for(i=0;i<SecretWord.length();i++) {
		secretArr[i]='-';
	}
	String string=new String(secretArr);
	return string;
}


public String guess(Character c) throws Exception{
	char z=Character.toLowerCase(c);
	int counter=-1;
	String y=null;
	int flag=1;
	char guessedBefore[]=new char[SecretWord.length()+7];
	for(i=0;i<SecretWord.length()+7;i++) {
		guessedBefore[i]='0';
	}
	int count=0;
	int j;
	if((z>='a')&&(z<='z')) {
		for(i=0;i<SecretWord.length();i++) {
			if(z==(SecretWord.charAt(i))&&(secretArr[i]=='-')){
			counter=i;
			secretArr[i]=z;
			}
		}
		if(counter!=-1) {
			String strrr=new String(secretArr);
			y=strrr;
			for(j=0;j<guessedBefore.length;j++) {
				if(guessedBefore[j]==z) {
					flag=0;
					break;
				}
			}
			if(flag==1) {
			guessedBefore[count]=z;
			count++;
			noOfCorrectGuesses++;
			}
			flag=1;
		}
		else if(counter==-1) {
			for(j=0;j<guessedBefore.length;j++) {
				if(guessedBefore[j]==z) {
					flag=0;
					break;
				}
			}
			if(flag==1) {
			guessedBefore[count]=z;
			count++;
			max--;
			}
			else {
				System.err.println("you have guessed it before");
			}
			if(max<=0) {
				throw new Exception("you loss");
			}
			else {
				String s=new String(secretArr);
				y=s;
			}
		}
		return y;
	}
	else {
		throw new RuntimeException("you can enter characters only");
		//note that instead of throwing exception we can return null 
	}
}
public void setMaxWrongGuesses(Integer max) {
	/*if(max==null) {
		max=1;
	}*///I controlled my game so that the max never equals null 
	/*if this function means that we should let the player enter the max no of guesses then the 
	 * code will be
	 * System.out.println("Enter max no of guesses");
	 * max=System.in.read();
	 * if(max==null){
	 * max=1;
	 * }
	 * then we call this function in main only to let the player enter max number
	 * in main
	 * myGame n=new myGame();
	 * n.setMaxWrongGuesses(int m)
	 * we must call this function by reference in the main then the remaining code is the same
	 */
}
public int getCorrectGuesses() {
	return noOfCorrectGuesses;
}
public int Getmax() {
	return max;
}
}
