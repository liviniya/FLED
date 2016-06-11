/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moroz.fled.controller;

import com.moroz.fled.service.FuzzyLogicService;
import com.moroz.fled.service.SobelOperatorService;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Oksana_Moroz
 */
@Controller
public class DefaultController {
    
    private BufferedImage input;
        
    @Autowired
    private FuzzyLogicService fuzzyLogicService;
    
    @Autowired
    private SobelOperatorService sobelOperatorService;
    
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String getStartPage() {
        return "index";
    }
    
    @RequestMapping(value = {"/result"}, method = RequestMethod.GET)
    public String getResultPage() {
        return "result";
    }
    
    @RequestMapping(value = "/upload", method = RequestMethod.POST)    
    public ResponseEntity upload(@RequestParam("file") MultipartFile file) 
            throws IOException, InterruptedException {
        InputStream in = new ByteArrayInputStream(file.getBytes());
        input = ImageIO.read(in);    
        return new ResponseEntity(HttpStatus.OK);
    } 
    
    @RequestMapping(value = "/fuzzy_output", method = RequestMethod.GET)
    public @ResponseBody void getOutputImage(HttpServletResponse response) 
            throws IOException {
        BufferedImage output = fuzzyLogicService.processImage(input);

        writeImageToResponse(output, response);
    }
    
    @RequestMapping(value = "/sobel_output", method = RequestMethod.GET)
    public @ResponseBody void getSobelImage(HttpServletResponse response) throws IOException {
        BufferedImage output = sobelOperatorService.processImage(input);
        
        writeImageToResponse(output, response);
    }
    
    @RequestMapping(value = "/input_image", method = RequestMethod.GET)
    public @ResponseBody void getInputImage(HttpServletResponse response) 
            throws IOException {
        writeImageToResponse(input, response);
    }
    
    @RequestMapping(value = "/change_black_white_mf", method = RequestMethod.POST)
    public ResponseEntity changeBlackWhiteMf(
            @RequestParam("black_start") Integer blackStart,
            @RequestParam("black_end") Integer blackEnd,
            @RequestParam("white_start") Integer whiteStart,
            @RequestParam("white_end") Integer whiteEnd) {
        System.out.println("black_start=" + blackStart + ", black_end=" 
                + blackEnd + ", white_start=" + whiteStart + ", white_end=" + whiteEnd);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/change_edge_mf", method = RequestMethod.POST)
    public ResponseEntity changeEdgeMf(
            @RequestParam("edge_end") Integer edgeEnd) {
        System.out.println("edge_end=" + edgeEnd);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    private void writeImageToResponse(BufferedImage image,
            HttpServletResponse response) throws IOException {
        response.setContentType("image/jpg");
        OutputStream out = response.getOutputStream();
        if (image != null) {
            ImageIO.write(image, "jpg", out);
        }
        out.close();
    }
}
