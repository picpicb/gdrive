package fr.picpicb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        File file;

        JFrame windowApp = new JFrame("GDrive");
        windowApp.setSize(400, 400);

        JPanel panel = new JPanel();
        panel.setSize(400, 400);
        windowApp.add(panel);

        JButton chooseFileButton = new JButton("Open a File");
        panel.add(chooseFileButton);

        JFileChooser fc = new JFileChooser();
        GDriveUpload uploader = new GDriveUpload();
        chooseFileButton.addActionListener(new FileSelector(uploader,fc,chooseFileButton));

        windowApp.setVisible(true);
    }
}
