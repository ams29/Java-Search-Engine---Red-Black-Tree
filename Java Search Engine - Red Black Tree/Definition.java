public class Definition implements Comparable<Definition> {
	public String KeyWord;
	public String info;

	public Definition(String KeyWord, String info) {
		this.KeyWord = KeyWord;
		this.info = info;
	}

	public String getKeyWord() {
		return KeyWord;
	}

	public String getinfo() {
		return info;
	}

	public int compareTo(Definition CompareObject) {
		return KeyWord.compareTo(CompareObject.KeyWord);
	}
	
	@Override
	public String toString() {
		return KeyWord + info;
	}

}
