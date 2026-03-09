package com.example.fileupload.Controller;

import com.example.fileupload.Entity.FileDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Base64;


@RestController
@RequestMapping("/api/v1/files")
public class FileController {


    @PostMapping("/uploads")
    public ResponseEntity<String> saveFiles(@RequestPart MultipartFile file) throws IOException {

        byte[] content = file.getBytes();
//        Path path= Paths.get("C:\\Users\\Ahsan\\Desktop\\cloud\\");

        File directory = new File("uploaded");

        if(!directory.exists()){
            directory.mkdirs();
        }
//        Path path = Paths.get(directory + file.getOriginalFilename());

        System.out.println("Original File Name "+ file.getOriginalFilename());

        Path path = Paths.get(directory + "/" + file.getOriginalFilename());

        if(content.length >50001){
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("length  should be less than 40KB");
        }

        /*Path filePath = null;
        try {
            filePath = Files.createDirectory(path);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage()+" directory alraedy exists");
        }

        Path resolvePath = filePath.resolve(filePath.getFileName() + "." + file.getContentType());
        */

//            out.write(content);
        Files.write(path, content);

        return ResponseEntity.status(HttpStatus.OK).body("File saved to path "+ directory.toString());
    }

    @PostMapping("/uploads/text")
    public ResponseEntity<String> saveFile(@RequestBody FileDto file) {

//        String str= new String(Base64.getDecoder().decode(file.getContent()));
//        StringBuilder s = new StringBuilder(str);

        Path filePath;
//        CREATE DIRECTORY
//        Path path= Paths.get("C:\\Users\\Ahsan\\Desktop\\cloud\\"+file.getFileName()+"."+file.getFileType());
        Path path= Paths.get("C:\\Users\\Ahsan\\Desktop\\cloud\\", file.getFileName());
        Path newPath;
        try {
            newPath = Files.createDirectory(path);

        }
        catch (IOException e) {
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage()+" directory already exist");
        }

        filePath = newPath.resolve(file.getFileName()+"." + file.getFileType());
        byte[] bytes = Base64.getDecoder().decode(file.getContent());

//      Save File
        try (OutputStream out = Files.newOutputStream(filePath)){
//            Path write = Files.write(filePath,bytes,
//                    StandardOpenOption.CREATE_NEW);

            out.write(bytes);

        }
        catch (IOException e) {
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage()+" while writing");

        }

//        appendation(s);
        return ResponseEntity.status(HttpStatus.OK).body("File saved to "+ filePath.toString());
    }

    @PostMapping("/uploads/image")
    public ResponseEntity<String> saveImage(@RequestBody FileDto file)  {

        byte[] image = Base64.getDecoder().decode(file.getContent());

        Path path = Paths.get("C:\\Users\\Ahsan\\Desktop\\cloud\\", file.getFileName());

        if(image.length >50001){
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("length  should be less than 40KB");
        }
        Path filePath = null;
        try {
            filePath = Files.createDirectory(path);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage()+" directory alraedy exists");
        }

        Path resolvePath = filePath.resolve(filePath.getFileName() + "." + file.getFileType());
        try (OutputStream out = Files.newOutputStream(resolvePath,
                StandardOpenOption.CREATE)){

            out.write(image);
        }
        catch (IOException e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body("File saved to path "+filePath.toString());
    }

    private void appendation(StringBuilder s) {

        for (int i = 0; i < 4; i++) {
            s.append("\n Round "+ i +"\n");
        }
    }

}