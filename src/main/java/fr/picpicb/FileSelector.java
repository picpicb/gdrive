package fr.picpicb;

import com.google.api.services.drive.Drive;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class FileSelector implements ActionListener {
    private GDriveUpload uploader;
    private JFileChooser fc;
    private JButton button;
    private JPanel panel;
    private JLabel label;
    private JList liste;
    private Drive service;
    GDriveFileList fileList;

    public FileSelector(Drive service, JButton button, JPanel panel, JLabel label, JList liste){
        this.uploader = new GDriveUpload(service);
        this.service = service;
        this.fc = new JFileChooser();
        this.button = button;
        this.panel = panel;
        this.label = label;
        this.liste = liste;
        button.addActionListener(this);
        fileList = new GDriveFileList();

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int returnVal = fc.showOpenDialog(button);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                label.setText("Uploading...");
                if(uploader.upload(file)){
                    label.setText("File "+file.getName()+" uploaded !");
                    liste.setModel(fileList.getFileList(service,"1QBwgRYYnkqEWtp80Si1LzDpPi5soM4iO"));
                }else{
                    label.setText("ERROR : File "+file.getName()+" not uploaded !");
                }
            } else {
                System.out.println("Open command cancelled by user.");
            }

    }
}
