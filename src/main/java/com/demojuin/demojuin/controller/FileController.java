package com.demojuin.demojuin.controller;

import com.demojuin.demojuin.model.File;
import com.demojuin.demojuin.service.FileServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URLConnection;

@RestController
@RequestMapping("file")
public class FileController {
    private final FileServiceInterface fileService;
      @Autowired
    public FileController(FileServiceInterface fileService) {
        this.fileService = fileService;
    }
    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
          return ResponseEntity.ok(fileService.uploadFile(file));
    }
    @GetMapping("download/{filename}")
    public ResponseEntity<?> downloadFile(@PathVariable("filename") String filename) {
          ResponseEntity<?> response = this.fileService.dowwnloadFile(filename);
          if(response.getStatusCode()== HttpStatus.OK){
              File file= (File) response.getBody();
              return ResponseEntity.ok().contentType(MediaType.parseMediaType(file.getContentType()))
                      .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\""+file.getFilename()+"\"")
                      .body(file.getData());
          }
        else{
            return new ResponseEntity("File not found", HttpStatus.NOT_FOUND);
          }
    }
    @PostMapping("uploadfolder")
    public ResponseEntity<String> uploadFolder(@RequestParam("file") MultipartFile file) {
          String savedFileName=this.fileService.saveImage(file);
          return ResponseEntity.ok("file saved with name: " + savedFileName);
    }
    @GetMapping("folder/{filename}")
    public ResponseEntity<byte[]> downloadFolder(@PathVariable("filename") String filename) {
          byte [] fileData=fileService.afficherImage(filename);
          String mimeType= URLConnection.guessContentTypeFromName(filename);
          if(mimeType==null){
              mimeType= MediaType.APPLICATION_OCTET_STREAM.toString();
          }
          return ResponseEntity.ok().contentType(MediaType.parseMediaType(mimeType)).body(fileData);

    }
}
