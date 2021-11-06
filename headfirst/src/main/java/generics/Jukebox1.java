package generics;


import java.util.*;
import java.io.*;


public class Jukebox1 {
	ArrayList<Song> songList = new ArrayList<>();

	public static void main(String[] args){
		Jukebox1 box = new Jukebox1();
		box.readSongs();
		Collections.sort(box.songList);
		System.out.println("Sorted by title: " + box.songList);
		Collections.sort(box.songList, new SongComparator());
		System.out.println("Sorted by artist: " + box.songList);

		HashSet<Song> songSet = new HashSet<>();
		songSet.addAll(box.songList);
		System.out.println("In HashSet: " + songSet);
		
		TreeSet<Song> songTreeSet = new TreeSet<>();
		songTreeSet.addAll(box.songList);
		System.out.println("In TreeSet: " + songTreeSet);
	
		// TreeSet with comparator
		TreeSet<Song> songTreeSet2 = new TreeSet<>(new SongComparator());
		songTreeSet2.addAll(box.songList);
		System.out.println("In TreeSet with comparator: " + songTreeSet2);
	}

	void readSongs(){
		try {
			File file;
			file = new File(this.getClass().getResource("/SongList.txt").toURI());
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] lineArray = line.split("/");
				songList.add(new Song(lineArray[0], lineArray[1], lineArray[2], lineArray[3]));
			}
		} catch (Exception ex){
			ex.printStackTrace();
		}
		//Collections.sort(songList, new SongComparator());
	}
}
