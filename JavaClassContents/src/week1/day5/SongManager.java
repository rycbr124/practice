package week1.day5;

class Song{
	private String title,artist,album;
	private String[] composer;
	private int year,track;
	
	//생성자 초기화 작업은 웬만하면 꼭 넣어주자
	Song(){
		title = null;
		artist = null;
		album = null;
		composer = null;
		year = 0;
		track = 0;
	}

	public Song(String title, String artist, String album, String[] composer, int year, int track) {
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.composer = composer;
		this.year = year;
		this.track = track;
	}
	
	public void show() {
		System.out.println("노래 제목:"+title);
		System.out.println("가수:"+artist);
		System.out.println("앨범:"+album);
		System.out.print("작곡가:");
		for(int i=0;i<composer.length;i++) {
			System.out.print(composer[i]);
			if(i+1==composer.length)
				System.out.println();//마지막 원소 출력 후 줄넘김
			else
				System.out.print(",");
		}
		System.out.println("년도:"+year);
		System.out.println("트랙 번호:"+track);
	}

}

public class SongManager {

	public static void main(String[] args) {
		Song s = new Song("Dancing Queen",
				"ABBA",
				"Arrival",
				new String[] {"Benny Andersson","Bjorn Ulvaeus"},
				//== new String[]={"AA","BB"}
				1977,
				2);
		s.show();
	}

}
