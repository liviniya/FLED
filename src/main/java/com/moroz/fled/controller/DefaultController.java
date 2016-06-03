/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moroz.fled.controller;

import com.moroz.fled.classic.SobelOperatorEdgeDetector;
import com.moroz.fled.fuzzy.FuzzyLogicEdgeDetector;
import com.moroz.fled.util.ImageTransformer;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Oksana_Moroz
 */
@Controller
public class DefaultController {
    
    private BufferedImage input;
        
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index() {
        return "index";
    }
    
    @RequestMapping(value = "/upload", method = RequestMethod.POST)    
    public ResponseEntity upload(@RequestParam("file") MultipartFile file) 
            throws IOException, InterruptedException {
        System.out.println("In upload");
        InputStream in = new ByteArrayInputStream(file.getBytes());
        input = ImageIO.read(in);    
        System.out.println("input in upload = " + input);
        return new ResponseEntity(HttpStatus.OK);
    } 
    
    @RequestMapping(value = "/output_image", method = RequestMethod.GET)
    public @ResponseBody void getOutputImage(HttpServletResponse response) 
            throws IOException {
        BufferedImage output = processImage(input);

        writeImageToResponse(output, response);
    }
    
    @RequestMapping(value = "/sobel_image", method = RequestMethod.GET)
    public @ResponseBody void getSobelImage(HttpServletResponse response) throws IOException {
        BufferedImage output = operateSobel(input);
        writeImageToResponse(output, response);
    }
    
    @RequestMapping(value = "/input_image", method = RequestMethod.GET)
    public @ResponseBody void getInputImage(HttpServletResponse response) 
            throws IOException {
        System.out.println("input=" + input);
        writeImageToResponse(input, response);
    }
    
    private void writeImageToResponse(BufferedImage image,
            HttpServletResponse response) throws IOException {
        response.setContentType("image/jpg");
        OutputStream out;
        out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        out.close();
    }
    
    private BufferedImage operateSobel(BufferedImage input) {
        ImageTransformer imageTransformer = new ImageTransformer();
        BufferedImage grayscaleImage = imageTransformer.toGrayscaleImage(input);
        
        SobelOperatorEdgeDetector edgeDetector = new SobelOperatorEdgeDetector();
        BufferedImage output = edgeDetector.detectEdges(grayscaleImage);
        
        return output;
    }
    
    private BufferedImage processImage(BufferedImage input) {
        ImageTransformer imageTransformer = new ImageTransformer();
        BufferedImage grayscaleImage = imageTransformer.toGrayscaleImage(input);

        FuzzyLogicEdgeDetector edgeDetector = new FuzzyLogicEdgeDetector();
        BufferedImage output = edgeDetector.detectEdges(grayscaleImage);     
        
        return output;
    }    
}
