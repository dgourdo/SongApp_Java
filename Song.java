package songapp;

public class Song {
    private String code;
    private String title;
    private String releaseDate;
    private String duration;
    private String artist;
    private String typeOfSong;


    public Song() {
    }

    public Song(String code, String title, String releaseDate,String duration,String artist,String typeOfSong) {
        this.code=code;
        this.title=title;
        this.releaseDate=releaseDate;
        this.duration=duration;
        this.artist=artist;
        this.typeOfSong=typeOfSong;
    }

   public Song(String s, String s1, String s2, String s3, String s4, String s5, String s6) {
    }

    public Song(String s, String s1, String s2, String s3, String s4) {
    }

    public Song(String s, String s1, String s2, String s3) {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }


    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTypeOfSong() {
        return typeOfSong;
    }

    public void setTypeOfSong(String typeOfSong) {
        this.typeOfSong = typeOfSong;
    }


    @Override
    public String toString() {
        return
                "Code= " + code + '\t' +
                "Title= " + title + '\t' +
                "Release date= " + releaseDate + '\t' +
                "Duration= " + duration + '\t' +
                "Artist= " + artist + '\t' +
                "Type of song= " + typeOfSong + '\t' ;
    }
}