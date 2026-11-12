package com.ttknpdev.ecomercebackend.controllers;


import com.ttknpdev.ecomercebackend.entities.file.File;
import com.ttknpdev.ecomercebackend.utility.FileDownload;
import com.ttknpdev.ecomercebackend.utility.FileUpload;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@Controller
@RestController
@RequestMapping(value = "/api")
public class FileManageControl {

    private FileUpload fileUpload;
    private FileDownload fileDownload;
    private File file;

    public FileManageControl() {
        fileUpload = new FileUpload();
        fileDownload = new FileDownload();
    }

    // for upload user's receipt to server
    @PostMapping(value = "/upload-file")
    private ResponseEntity<File> uploaded(@RequestParam("file") MultipartFile multipartFile) {
        String filename,fileCode;
        Long size;
        // FileUpload fileUpload;
        File file = new File();

        try {
            filename = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
            size = multipartFile.getSize();
            String filenameResult = fileUpload.saveFile(filename , multipartFile); // save
            // file.setFilename(filenameResult);
            file.setFileCode(filenameResult.substring(0,8));
            // example , http://<domain>/api/download-file/sFSeIsNL when you enter this url after uploaded you will get download it
            file.setDownloadUrl("http://thitikorn-nupan.com/qr_payments/"+filenameResult);
            file.setStatus("success");
            file.setSize(size);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return new ResponseEntity<>(file, HttpStatus.OK);
    }

    // ** this work after done the upload file if you enter this url after uploaded you will get download it ** fileCode-<file name>
    @GetMapping(value = "/download-file/{fileCode}")
    private ResponseEntity<?> downloaded(@PathVariable String fileCode) {
        // FileDownload fileDownload = new FileDownload();
        Resource resource = null;
        String contentType;
        String headerValue;
        try {
            resource = fileDownload.getFileAsResource(fileCode);

            if (resource == null) {

                return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);

            }

            contentType = "application/octet-stream";
            headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";

        } catch (Exception ioException) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                .body(resource);
    }

}
