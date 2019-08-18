/*
    Robert Higgins
    2013-12-05

    No assignment
*/
package TheButton;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] dimensions = getMonitorSize();
        Font font = new Font("Garamond", Font.BOLD, 24);

        System.out.println("Monitor Dimensions: " + dimensions[0] + "x" + dimensions[1]);

        JFrame frame = new JFrame("Welcome ");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocation(dimensions[0] / 3, 0);
        frame.setResizable(true);
        frame.setUndecorated(true);
        frame.setAlwaysOnTop(true);
        frame.setType(Window.Type.UTILITY);
        JFrame.setDefaultLookAndFeelDecorated(true);

        JButton button01 = new JButton(" Give me a NOOOOOOOOOOOOOOOO! ");
        button01.setFont(font);
        button01.setPreferredSize(new Dimension(dimensions[0] / 3, 28));
        button01.setVisible(true);
        button01.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                int rand = random.nextInt(13) + 1;

                try {
                    System.out.println("/assets/sounds/no" + rand + ".wav");
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(Main.class.getResource("no" + rand + ".wav"));
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioIn);
                    clip.start();

                    //InputStream inputStream = getClass().getResourceAsStream("assets/sounds/no" + rand + ".wav");
                    //AudioStream audioStream = new AudioStream(inputStream);
                    //AudioPlayer.player.start(audioStream);
                } catch (Exception e2) {
                    System.err.println(e2.getMessage());
                }
            }
        });

        frame.getContentPane().add(button01);

        // Show window
        frame.pack();
        frame.setVisible(true);
    }

    private static int[] getMonitorSize() {
        int[] dimensions = {0, 0};
        GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        double width = graphicsDevice.getDisplayMode().getWidth();
        double height = graphicsDevice.getDisplayMode().getHeight();

        if (width != 0 && height != 0) {
            dimensions[0] = (int) width;
            dimensions[1] = (int) height;

            return dimensions;
        } else {
            dimensions[0] = 1280;
            dimensions[1] = 720;

            return dimensions;
        }
    }
}