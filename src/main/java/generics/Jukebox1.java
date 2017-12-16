package generics;

import java.util.*;
import java.io.*;

public class Jukebox1 {
	ArrayList<String> songList = new ArrayList<>();

	public static void main(String[] args){
		Jukebox1 box = new Jukebox1();
		box.readSongs();
		System.out.println(box.songList);
	}

	void readSongs(){
		try {
			File file = new File(this.getClass().getResource("/SongList.txt").toURI());
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				songList.add(line.split("/")[0]);
			}
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}
}
