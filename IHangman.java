package ed.edu.alexu.csd.datastructure.hangman.csx22;
public interface IHangman {
void setDictionary(String[] words);
String selectRandomSecretWord();
String guess(Character c) throws Exception;
void setMaxWrongGuesses(Integer max);
}
