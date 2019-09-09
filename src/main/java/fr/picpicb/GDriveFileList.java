package fr.picpicb;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

import javax.swing.*;
import java.io.IOException;

public class GDriveFileList {

    public DefaultListModel<String>  getFileList(Drive service, String folderId){

        DefaultListModel<String> FileList = new DefaultListModel();
        String pageToken = null;
        do {
            com.google.api.services.drive.model.FileList result = null;
            try {
                result = service.files().list()
                        .setQ("'"+folderId+"' in parents")
                        .setSpaces("drive")
                        .setFields("nextPageToken, files(id, name, parents)")
                        .setPageToken(pageToken)
                        .execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (File file : result.getFiles()) {
                FileList.addElement(file.getName());
            }
            pageToken = result.getNextPageToken();
        } while (pageToken != null);


        return FileList;
    }
}
