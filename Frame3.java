package songapp;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Frame3 extends JFrame {

    private final JLabel appNameLabel;
    private final JLabel developerFullnameLabel;
    private final JLabel developerAMLabel;
    private final JLabel projectTimeLabel;
    private final JLabel appImageLabel;
    private final JLabel imageLabel;


    public Frame3() {

        appNameLabel=new JLabel("App Name: Songs Registration App");
        developerFullnameLabel=new JLabel("Developer's Fullname: Gourdomichalis Dimitrios");
        developerAMLabel=new JLabel("Developer's AM: ice20390043");
        projectTimeLabel=new JLabel("Time period of development of the project: 2/6/22 - 9/6/22 ");
        appImageLabel=new JLabel("Logo of the Application: ");


        imageLabel= new JLabel(new ImageIcon("D:\\JAVA_PROJECTS\\SongApp\\src\\songapp\\solKey.png"));
        imageLabel.setSize(20,20);



        //Λογότυπο εφαρμογής->2ος Τρόπος
        /*Image img = Toolkit.getDefaultToolkit().getImage("D:\\JAVA_PROJECTS\\SongApp\\src\\songapp\\solKey.png");
            this.setContentPane(new JPanel() {
                @Override
                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(img, 20, 20, null);
                }
            });

*/

        JPanel Panel3 = new JPanel();
        Panel3.setLayout(new BoxLayout(Panel3, BoxLayout.Y_AXIS)); //Αλλαγή γραμμής μετά από κάθε  JLabel

        Panel3.add(appNameLabel);
        Panel3.add(developerFullnameLabel);
        Panel3.add(developerAMLabel);
        Panel3.add(projectTimeLabel);
        Panel3.add(appImageLabel);
        Panel3.add(imageLabel);


        this.setTitle("Information about the Application");
        this.setDefaultCloseOperation(Frame3.DISPOSE_ON_CLOSE);   //return to Main Frame
        this.getContentPane().add(Panel3);
        this.setSize(700, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
