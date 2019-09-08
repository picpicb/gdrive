package fr.picpicb;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileSelector implements ActionListener {
    private GDriveUpload uploader;
    private JFileChooser fc;
    private File file;
    private JButton button;

    public FileSelector(GDriveUpload uploader, JFileChooser fc, JButton button){
        this.uploader = uploader;
        this.fc = fc;
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int returnVal = fc.showOpenDialog(button);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would open the file.
                System.out.println("Opening: " + file.getName());
            } else {
                System.out.println("Open command cancelled by user.");
            }

    }
}
