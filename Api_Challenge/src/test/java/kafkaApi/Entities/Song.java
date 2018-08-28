package kafkaApi.Entities;

public class Song {
    private String artist;
    private String album;
    private String name;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SongBean{" +
                "artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
