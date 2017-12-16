package generics;

public class Song implements Comparable<Song> {
	String title;
	String artist;
	String rating;
	String bpm;

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
}
