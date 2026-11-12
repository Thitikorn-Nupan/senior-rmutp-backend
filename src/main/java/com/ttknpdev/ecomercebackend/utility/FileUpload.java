package com.ttknpdev.ecomercebackend.utility;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/*
*   utility class that reads the multipart file data from the request and then saves the file on to disk
*/
public class FileUpload {

    /* Java Files class contains static methods that work on files and directories. */
    public String saveFile(String filename , MultipartFile multipartFile) throws Exception {
        // name folder upload should be "files"
        // Path uploadPath = Paths.get("/home/spring-boot-projects/restapi-upload-downloadfile/files");
        // B:/senior-project/ecomerce-frontend/src/assets/images/qr_purchases    // ** frontend path
        // Path uploadPath = Paths.get("B:/senior-project/ecomerce-frontend/src/assets/images/qr_purchases");
        // B:/senior-project/ecomerce-backend/files
        // Path uploadPath = Paths.get("B:/senior-project/ecomerce-backend/files");
        // /home/senior-project/ecomerce-frontend/src/assets/images/qr_purchases
        // Path uploadPath = Paths.get("/home/senior-project/ecomerce-frontend/src/assets/images/qr_purchases");
        Path uploadPath = Paths.get("/var/www/thitikorn-nupan/public_html/qr_payments");
        Path filePath;
        String fileCode;

        try {
                if(!Files.exists(uploadPath)) {
                    /* exits() This method checks if file exists at specified path and if the file exists it will return true or else it returns false. */
                    Files.createDirectories(uploadPath); // it creates the Files-Upload directory if not exits
                    /* createDirectories() This method creates a directories using given path by creating all nonexistent parent directories first.*/
                }

                fileCode = RandomStringUtils.randomAlphanumeric(8);
                /* inserts 8 alphanumeric characters before the file name, so in the file download API it can identify a file based on an identifier.*/

                try(InputStream inputStream = multipartFile.getInputStream()) {

                    filePath = uploadPath.resolve(fileCode+"-"+filename);
                    Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);
                    /* REPLACE_EXISTING  It means if the target file exists then replaces it if it is not a non-empty directory */
                    /* copy() This method copies all bytes from specified input stream to specified target file and it returns number of bytes read or written as long value. */

                    } catch (IOException ioException) {
                        throw new IOException("Could not save file : " + filename, ioException);
                    }


            } catch (Exception exception) {
                throw new Exception("Maybe something wrong : "+exception.getMessage());
            }

        return fileCode+"-"+filename;
        // return fileCode;
    }

}
