/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moroz.fled.controller;

import com.moroz.fled.fuzzy.BlackMembershipFunction;
import com.moroz.fled.fuzzy.EdgeMembershipFunctionConverter;
import com.moroz.fled.fuzzy.WhiteMembershipFunction;
import com.moroz.fled.service.FuzzyLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Oksana_Moroz
 */
@Controller
public class DefaultController {  
    
    @Autowired
    private FuzzyLogicService fuzzyLogicService;
       
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView getStartPage() {
        fuzzyLogicService.refreshMembershipFunctions();
        
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("black_start", BlackMembershipFunction.BLACK_START_GRAY);
        mav.addObject("black_end", BlackMembershipFunction.BLACK_END_GRAY);
        mav.addObject("white_start", WhiteMembershipFunction.WHITE_START_GRAY);
        mav.addObject("white_end", WhiteMembershipFunction.WHITE_END_GRAY);
        mav.addObject("edge_end", EdgeMembershipFunctionConverter.EDGE_END);
        return mav;
    }
    
    @RequestMapping(value = {"/result"}, method = RequestMethod.GET)
    public String getResultPage() {
        return "result";
    }
}
