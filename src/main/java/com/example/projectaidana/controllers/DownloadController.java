package com.example.projectaidana.controllers;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.WebResource;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//
//@Controller
//@RequestMapping("/payments")
//@RequiredArgsConstructor
public class DownloadController {
    @GetMapping("/payments/mn")
    public void downloadFile(HttpServletResponse response) throws IOException{
        File file=new File("files\\Payment.txt");
        response.setContentType("application/octet-stream");
        String headerKey="Content-Disposition";
         String headerValue="attachment; filename="+file.getName();
        response.setHeader(headerKey,headerValue);
        ServletOutputStream outputStream=response.getOutputStream();
        BufferedInputStream inputStream=new BufferedInputStream(new FileInputStream(file));
        byte[] buffer=new byte[8192];
        int byteRead=-1;
        while((byteRead=inputStream.read(buffer))!=-1){
            outputStream.write(buffer,0,byteRead);
        }
        inputStream.close();
        outputStream.close();



    }








}
