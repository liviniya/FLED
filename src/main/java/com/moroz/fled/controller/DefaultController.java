/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moroz.fled.controller;

import com.moroz.fled.fuzzy.FuzzyLogicEdgeDetector;
import com.moroz.fled.util.FileImageProcessor;
import com.moroz.fled.util.ImageTransformer;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Oksana_Moroz
 */
@Controller
public class DefaultController {
    
    @Value("${inputPath}")
    private String inputPath;
    
    @Value("${outputPath}")
    private String outputPath;
    
    private static final String JPG_FORMAT = "jpg";
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap map) {
        map.put("msg", "Hello Spring 4 Web MVC!");
        return "index";
    }
    
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file, ModelMap map) throws IOException, InterruptedException {
        InputStream in = new ByteArrayInputStream(file.getBytes());
        BufferedImage input = ImageIO.read(in);
        BufferedImage output = processImage(input);
                
        saveImages(input, output);       
        
        Thread.currentThread().sleep(1000);
        
        return "redirect:/result";
        //return new ModelAndView("result");
    }
    
    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public ModelAndView result() throws IOException {
                        
        //return "redirect:/";
        return new ModelAndView("result");
    }
    
    private BufferedImage processImage(BufferedImage input) throws IOException {
        ImageTransformer imageTransformer = new ImageTransformer();
        BufferedImage grayscaleImage = imageTransformer.toGrayscaleImage(input);

        FuzzyLogicEdgeDetector edgeDetector = new FuzzyLogicEdgeDetector();
        BufferedImage output = edgeDetector.detectEdges(grayscaleImage);     
        
        return output;
    }
    
    private void saveImages(BufferedImage input, BufferedImage output) throws IOException {
        FileImageProcessor imageProcessor = new FileImageProcessor();
        imageProcessor.writeImageToFile(input, inputPath, "input", JPG_FORMAT);
        imageProcessor.writeImageToFile(output, outputPath, "output", JPG_FORMAT);
    }
}
