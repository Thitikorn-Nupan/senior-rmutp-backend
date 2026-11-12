package com.ttknpdev.ecomercebackend.utility;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDownload {

    private Path foundFile;

    public Resource getFileAsResource(String fileCode) {
        Path dirPath = Paths.get("/var/www/thitikorn-nupan/public_html/qr_payments");
        // Path dirPath = Paths.get("B:/practice-java-one-jetbrains/LearnSpringBean/restapi-upload-downloadfile/files");
        try {
            Files.list(dirPath).forEach(
                    file -> {
                        if (file.getFileName().toString().startsWith(fileCode)) {
                            foundFile = file;
                        }
                    });
            if (foundFile != null) {
                return new UrlResource(foundFile.toUri());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
