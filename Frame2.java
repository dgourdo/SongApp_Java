package songapp;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Frame2 extends JFrame {
    private JLabel songsNumberLabel;
    private JLabel bestTypeOfSongLabel;
    private JLabel maxSongDurationLabel;
    private JLabel minSongDurationLabel;

    private JTextField songsNumberTF;
    private JTextField bestTypeOfSongTF;
    private JTextField numOfSongsOfBestTypeTF;
    private JTextField maxSongDurationTF;
    private JTextField durMaxTF;
    private JTextField minSongDurationTF;
    private JTextField durMinTF;


    public Frame2() throws FileNotFoundException {
        songsNumberLabel = new JLabel("Total number of songs listed(THIS IS A git TESTTT!): ");
        songsNumberTF = new JTextField(5);
        songsNumberTF.setEnabled(false);

        bestTypeOfSongLabel = new JLabel("Genre with the most songs (and number of songs): ");
        bestTypeOfSongTF = new JTextField(7);
        bestTypeOfSongTF.setEnabled(false);
        numOfSongsOfBestTypeTF = new JTextField(5);
        numOfSongsOfBestTypeTF.setEnabled(false);


        maxSongDurationLabel = new JLabel("Song with the longest duration (and its duration): ");
        maxSongDurationTF = new JTextField(20);
        maxSongDurationTF.setEnabled(false);
        durMaxTF = new JTextField(5);
        durMaxTF.setEnabled(false);

        minSongDurationLabel = new JLabel("Song with the shortest duration (and its duration): ");
        minSongDurationTF = new JTextField(20);
        minSongDurationTF.setEnabled(false);
        durMinTF = new JTextField(5);
        durMinTF.setEnabled(false);

        JPanel Panel2 = new JPanel();
        Panel2.setLayout(new FlowLayout(FlowLayout.LEFT));

        Panel2.add(songsNumberLabel);
        Panel2.add(songsNumberTF);

        Panel2.add(bestTypeOfSongLabel);
        Panel2.add(bestTypeOfSongTF);
        Panel2.add(numOfSongsOfBestTypeTF);

        Panel2.add(maxSongDurationLabel);
        Panel2.add(maxSongDurationTF);
        Panel2.add(durMaxTF);

        Panel2.add(minSongDurationLabel);
        Panel2.add(minSongDurationTF);
        Panel2.add(durMinTF);


        int rockCount = 0;
        int hip_hopCount = 0;
        int rapCount = 0;
        int popCount = 0;
        int jazzCount = 0;
        int countLines = 0;

        int u = 0;
        String[] duration = new String[0];

        try {
            BufferedReader buff = new BufferedReader(
                    new FileReader("D:\\JAVA_PROJECTS\\SongApp\\src\\songapp\\Statistics.txt"));

            String line;
            while (buff.ready()) {
                line = buff.readLine();
                countLines++;
            }

            String[] words = null;
            String s;

            String input1 = "Rock"; // Input word to be searched
            String input2 = "Hip-Hop";
            String input3 = "Rap";
            String input4 = "Pop";
            String input5 = "Jazz";

            while ((s = buff.readLine()) != null) {
                words = s.split(" ");
                for (String word : words) {
                    if (word.equals(input1)) {
                        rockCount++;
                    }
                    if (word.equals(input2)) {
                        hip_hopCount++;
                    }

                    if (word.equals(input3)) {
                        rapCount++;
                    }
                    if (word.equals(input4)) {
                        popCount++;
                    }
                    if (word.equals(input5)) {
                        jazzCount++;
                    }



                    //For the Durations.txt
                    String[] token;
                    while (buff.ready()) {
                        line = buff.readLine();
                        token = line.split("\t");
                        if (token.length == 6) {
                            Song song = new Song(token[0], token[1], token[2], token[3], token[4], token[5]);

                            for(u=countLines;u>=0;u--) {
                                String temp=token[3];
                                 String temp2=temp.substring(11,15);
                                 String temp3= String.valueOf(temp2.matches("[^[0-9]]"));  //temp3==temp without ':'
                                 int res=Integer.parseInt(temp3);
                                 duration[u]= String.valueOf(res);
                            }
                        }
                    }



                    buff.close();
                }
            }
        } catch (FileNotFoundException ex2) {
            System.err.print(ex2.getMessage());
        } catch (IOException ex2) {
            System.err.print(ex2.getMessage());
        }


        String durationPath = "D:\\JAVA_PROJECTS\\SongApp\\src\\songapp\\Durations.txt";
        try {
            BufferedWriter buffer2 = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(durationPath, true), StandardCharsets.UTF_8));

            buffer2.write(Arrays.toString(duration));
            buffer2.newLine();
            buffer2.close();
        } catch (IOException ex) {
            System.err.print(ex.getMessage());
            System.err.print("ERROR");
        }

            int[] typeOfSongCountArray = {rockCount, hip_hopCount, rapCount, popCount, jazzCount};

            int max = typeOfSongCountArray[0];

            for (int j : typeOfSongCountArray)
                if (j > max) {
                    max = j;
                }



        //For the Statistics(minDuration,maxDuration) with help from Durations.txt
        String[] words = null;  //Intialize the word Array
        String s;
        int[] durationArray=null;
        int w=0;
        int maxDur=0;
        int minDur=0;

            try {
            BufferedReader buff = new BufferedReader(
                    new FileReader(durationPath));

            String[] token;
            String line;
             while ((s = buff.readLine()) != null) {
                 words = s.split(" ");


                 Scanner input = new Scanner(new FileReader(durationPath));

                 //Read the numbers. Get count.
                 while (input.hasNextInt()) {
                     durationArray[w] = Integer.parseInt(input.next());
                     for (int j : durationArray)
                         if (j > maxDur) {
                             maxDur = j;
                         }
                     for (int j : durationArray)
                         if (j < minDur) {
                             minDur = j;
                         }

                 }
             }


        } catch (FileNotFoundException ex2) {
            System.err.print(ex2.getMessage());
        } catch (IOException ex2) {
            System.err.print(ex2.getMessage());
        }



            songsNumberTF.setText("" + countLines);
            //bestTypeOfSongTF.setText();
            numOfSongsOfBestTypeTF.setText("" + max);
          //maxSongDurationTF.setText();
           durMaxTF.setText(String.valueOf(maxDur));
          //minSongDurationTF.setText();
           durMinTF.setText(String.valueOf(minDur));

            songsNumberTF.setBackground(Color.BLACK);
            bestTypeOfSongTF.setBackground(Color.BLACK);
            numOfSongsOfBestTypeTF.setBackground(Color.BLACK);
            maxSongDurationTF.setBackground(Color.BLACK);
            durMaxTF.setBackground(Color.BLACK);
            minSongDurationTF.setBackground(Color.BLACK);
            durMinTF.setBackground(Color.BLACK);

            this.setTitle("App Statistics");
            this.setDefaultCloseOperation(Frame2.DISPOSE_ON_CLOSE);   //return to Main Frame
            this.getContentPane().add(Panel2);
            this.setSize(700, 400);
            this.setLocationRelativeTo(null);
            this.setVisible(true);
        }

    }
