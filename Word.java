public class Word {
	char letter;
	String word = "";
	String guess = "";
	
	public void setWord(String s) {
		this.word = s;
		for(int i = 0; i < this.word.length(); i++)
			this.guess += "-";
	}
	
	public String print() {
		return this.guess;
	}
	
	public boolean win() {
		if(this.word.equals(this.guess))
			return true;
		return false;
	}
	
	public boolean check(String s) {
		String fakeInput = s;
        char input = fakeInput.charAt(0);
        boolean test = false;
        for(int i = 0; i < word.length(); i++) {
            if(input == word.charAt(i)) {
            	test = true;
            	char[] theWord = guess.toCharArray();
                theWord[i] = input;
                this.guess = String.valueOf(theWord);
            }
        }
        if(test == false)
        	return true;
    	return false;
	}
}
