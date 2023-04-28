package songapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Random;

import static java.lang.System.exit;

public class MainFrame extends JFrame {

    private final JLabel codeLabel;
    private final JLabel titleLabel;
    private final JLabel releaseDateLabel;
    private final JLabel durationLabel;
    private final JLabel artistLabel;
    private final JLabel typeOfSongLabel;

    private final JTextField codeTF; //not-editable,auto-filled
    private final JTextField titleTF;
    private final JTextField durationTF;
    private final JTextField artistTF;

    private final JComboBox releaseDateCB;

    private final JRadioButton Rock;
    private final JRadioButton Hip_Hop;
    private final JRadioButton Rap;
    private final JRadioButton Pop;
    private final JRadioButton Jazz;
    private final ButtonGroup btnGroup;

    private final JButton saveButton;
    private final JButton statisticsButton;
    private final JButton informationButton;
    private final JButton closeButton;

    private final JMenuBar MenuBar;
    private final JMenu extraMenu;
    private final JMenu aboutMenu;
    private final JMenuItem saveItem;
    private final JMenuItem statisticsItem;
    private final JMenuItem informationItem;
    private final JMenuItem closeItem;


    public MainFrame() {

        codeLabel=new JLabel("Code: ");
        titleLabel=new JLabel("Title: ");
        releaseDateLabel=new JLabel("Release Date(Year): ");
        durationLabel=new JLabel("Duration :");
        artistLabel=new JLabel("Artist: ");
        typeOfSongLabel=new JLabel("Type of song: ");

        codeTF = new JTextField(5);
        codeTF.setEnabled(false);
        titleTF = new JTextField(15);
        durationTF = new JTextField(4);
        artistTF = new JTextField(10);

        releaseDateCB=new JComboBox();
        for(int i=1950;i<=2022;i++)          //Ενδεικτικά χρησιμοποιείται το 1950 ως χρονική έναρξη,
            releaseDateCB.addItem(i);       // θα μπορούσε να είναι οποιοσδήποτε άλλος αριθμός(ανάλογα τα είδη μουσικής).
        
        Rock = new JRadioButton("Rock");
        Hip_Hop = new JRadioButton("Hip_Hop");
        Rap = new JRadioButton("Rap");
        Pop = new JRadioButton("Pop");
        Jazz = new JRadioButton("Jazz");

        btnGroup = new ButtonGroup();  //to check only one JRadioButton at time
        btnGroup.add(Rock);
        btnGroup.add(Hip_Hop);
        btnGroup.add(Rap);
        btnGroup.add(Pop);
        btnGroup.add(Jazz);


        saveButton =new JButton("Save");
        statisticsButton =new JButton("Statistics");
        informationButton =new JButton("About");
        closeButton =new JButton("Close");

        MenuBar = new JMenuBar();
        extraMenu = new JMenu("Extra");
        saveItem = new JMenuItem("Save");
        statisticsItem = new JMenuItem("Statistics");
        closeItem = new JMenuItem("Close");
        aboutMenu = new JMenu("Information");
        informationItem = new JMenuItem("About");



    }


    public void prepareUI() {
        //Panels of Main Frame-Frame1
        JPanel northPanel1 = new JPanel();
        northPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel southPanel1 = new JPanel();
        southPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));

        //Add items to northPanel1
        northPanel1.add(codeLabel);
                Random rand = new Random();
                String randomNumber = String.format("%04d", rand.nextInt(1001));
                //rand function found in https://stackoverflow.com/questions/48210530/how-to-generate-4-digit-random-numbers-in-java-from-0000-to-9999
            codeTF.setBackground(Color.BLACK);
            codeTF.setText("S" + randomNumber);     //π.χ S1587 is the code of a song

        northPanel1.add(codeTF);

        northPanel1.add(titleLabel);
        northPanel1.add(titleTF);

        northPanel1.add(releaseDateLabel);
        northPanel1.add(releaseDateCB);

        northPanel1.add(durationLabel);
        int s=0;
        String durFormat=String.format("%02d:%02d", (s % 3600) / 60, (s % 60));
        //found in https://stackoverflow.com/questions/266825/how-to-format-a-duration-in-java-e-g-format-hmmss
        durationTF.setText(durFormat);
        northPanel1.add(durationTF);

        northPanel1.add(artistLabel);
        northPanel1.add(artistTF);

        northPanel1.add(typeOfSongLabel);
        northPanel1.add(Rock);
        northPanel1.add(Hip_Hop);
        northPanel1.add(Rap);
        northPanel1.add(Pop);
        northPanel1.add(Jazz);

        //Add items to southPanel1(Buttons)
        southPanel1.add(saveButton);
        southPanel1.add(statisticsButton);
        southPanel1.add(informationButton);
        southPanel1.add(closeButton);

        //Add items to Menu
        extraMenu.add(saveItem);
        extraMenu.add(statisticsItem);
        extraMenu.add(closeItem);

        aboutMenu.add(informationItem);

        MenuBar.add(extraMenu);
        MenuBar.add(aboutMenu);

        this.setJMenuBar(MenuBar);

        //Προσθέτουμε λειτουργικότητα στα κουμπιά και στο μενού
        //anonymous inner classes
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int i = JOptionPane.showConfirmDialog(null, "Do you want to exit the app?");
                if (i == JOptionPane.YES_OPTION)
                    exit(0);
            }

        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });

        closeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });



        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });

        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });



       statisticsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    openFrame2();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        });

       statisticsItem.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               try {
                   openFrame2();
               } catch (FileNotFoundException fileNotFoundException) {
                   fileNotFoundException.printStackTrace();
               }
           }
       });

        informationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFrame3();
            }
        });

        informationItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFrame3();
            }
        });



        this.add(northPanel1);
        this.add(southPanel1,BorderLayout.PAGE_END);

        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    //Φτιάχνουμε μεθόδους εκτός της κεντρικής,ώστε να είναι εύκολα αναγνώσιμη και λειτουργική
    //Στη μέθοδο prepareUI υπάρχουν τα πρωτότυπα τους
    private void openFrame2() throws FileNotFoundException {
        new Frame2();
    }

    private void openFrame3(){
        new Frame3();
    }


    private void save() {
        String code = codeTF.getText();           //Κώδικας που χρησιμοποιήθηκε και στην Άσκηση 4
        String title = titleTF.getText();
        String releaseDate =  releaseDateCB.getSelectedItem().toString();
        String duration = durationTF.getText();
        String artist = artistTF.getText();

        String typeOfSong = "";
        JRadioButton[] array = {Rock, Hip_Hop, Rap, Pop, Jazz};
        for (JRadioButton button : array)
            if (button.isSelected())
                typeOfSong = button.getText();




        String filePath = "D:\\JAVA_PROJECTS\\SongApp\\src\\songapp\\Statistics.txt";
        Song song = new Song(code, title, releaseDate, duration, artist, typeOfSong);

        //ΕΛΕΓΧΟΣ 1
        if (    !(code.equals("")
                || title.equals("")
                || releaseDate.equals("")
                || duration.equals("")
                || artist.equals("")
                || typeOfSong.equals("")
        )) {
            try {
                BufferedWriter buffer = new BufferedWriter(
                                         new OutputStreamWriter(
                                          new FileOutputStream(filePath, true), StandardCharsets.UTF_8));
                                                                            //true is for append
                                                                            //do not delete the previous registration



                buffer.write(song.toString());
                buffer.newLine();
                buffer.close();
            } catch (IOException ex) {
                System.err.print(ex.getMessage());
                System.err.print("ERROR");
            }
        } else {
            JOptionPane.showMessageDialog(
                    MainFrame.this,
                    "The order fields are not filled.",
                    "Fields error",
                    JOptionPane.WARNING_MESSAGE);    //found in Object-oriented solution (in eclass)
        }


        //ΕΛΕΓΧΟΣ 2
        try {
            BufferedReader buff = new BufferedReader(
                                  new FileReader(filePath));

            String[] words = null;  //Intialize the word Array
            String s;

            String input1 = title;
            String input2 = releaseDate;
            String input3 = artist;
            //Εγγραφή με ίδιο τίτλο τραγουδιού,χρονολογία κυκλοφορίας και όνομα καλλιτέχνη
            //με κάποια από τις ήδη υπάρχουσες στο αρχείο -> Δε γίνεται αποδεκτή.

            while ((s = buff.readLine()) != null) {
                words = s.split(" ");       //Split the word using space
                for (String word : words) {       //for-each loop

                    if (word.equals(input1) && word.equals(input2)  && word.equals(input3) )
                    {
                        JOptionPane.showMessageDialog(
                                MainFrame.this,
                                "This particular registration has already been registered!",
                                "Not-unique registration error",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            buff.close();
        } catch (FileNotFoundException ex2) {
            System.err.print(ex2.getMessage());
        } catch (IOException ex2) {
            System.err.print(ex2.getMessage());
        }
    }


    private void close() {
        if (saveButton.isSelected() || saveItem.isSelected()) {
            int i = JOptionPane.showConfirmDialog(MainFrame.this, "Do you want to exit the app?");
            if (i == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        } else {
            JOptionPane.showMessageDialog(
                    MainFrame.this,
                    "This particular registration has not been saved!",
                    "Save error",
                    JOptionPane.WARNING_MESSAGE);

        }
    }
}
