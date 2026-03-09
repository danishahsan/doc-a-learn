package com.example.fileupload.Entity;

public class FileDto {

    String fileName;
    String fileType;
    String content;

    public String getFileName() {
        return fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getContent() {
        return content;
    }
}