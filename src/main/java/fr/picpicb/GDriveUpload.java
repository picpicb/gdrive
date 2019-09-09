package fr.picpicb;

import com.google.api.client.http.FileContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;

import java.io.IOException;
import java.util.Collections;


public class GDriveUpload {
    private Drive driveService;
    public GDriveUpload(Drive service){
        this.driveService = service;
    }
    public boolean upload(java.io.File selectedFile) {
        String folderId =  "1QBwgRYYnkqEWtp80Si1LzDpPi5soM4iO";
        File fileMetadata = new File();
        fileMetadata.setName(selectedFile.getName());
        fileMetadata.setParents(Collections.singletonList(folderId));
        java.io.File filePath = new java.io.File(selectedFile.getAbsolutePath());
        FileContent mediaContent = new FileContent("image/jpeg", filePath);
        try {
            File file = driveService.files().create(fileMetadata, mediaContent)
                    .setFields("id, parents")
                    .execute();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }
}
