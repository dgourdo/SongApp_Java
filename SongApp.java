package songapp;

public class SongApp {
    public static void main(String[] args){
        createSongAppFrame();
    }

    static void createSongAppFrame() {
        MainFrame frame = new MainFrame();
        frame.prepareUI();
    }
}
