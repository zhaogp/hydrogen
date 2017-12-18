package generics;

import java.util.*;

public class SongComparator implements Comparator<Song> {
	public int compare(Song s1, Song s2){
		return s1.getArtist().compareTo(s2.getArtist());
	}
}
