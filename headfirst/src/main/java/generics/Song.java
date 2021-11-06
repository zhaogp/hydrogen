package generics;

public class Song implements Comparable<Song> {
	String title;
	String artist;
	String rating;
	String bpm;

	public static void main(String[] args){
		System.out.println("Hello World!!!");
		Song s1 = new Song("Olympics", "liuhuan", "1022", "100");
		Song s2 = new Song("Country", "caiguoqing", "1000", "100");
		System.out.println(s1.equals(s2));
	}

	public Song(String t, String a, String r, String b){
		title = t;
		artist = a;
		rating = r;
		bpm = b;
	}

	public String toString(){
		return title + "|" + artist;
	}

	public String getTitle(){
		return title;
	}

	public String getArtist(){
		return artist;
	}

	public int compareTo(Song s){
		return title.compareTo(s.getTitle());	
	}

	public int hashCode(){
		return title.hashCode();
	}

	public boolean equals(Object o){
		Song s = (Song) o;
		return this.getTitle().equals(s.getTitle());
	}
}
