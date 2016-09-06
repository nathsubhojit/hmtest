package com.hm.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hm.domain.RandomNumber;
import com.hm.services.number.generator.RandomNumberService;

@Controller
public class RandomNumberController {

	private RandomNumberService randomNumberService;

    @Autowired
    public void setRandomNumberService(RandomNumberService randomNumberService) {
        this.randomNumberService = randomNumberService;
    }

    @RequestMapping("randomnumber/new")
    public String newRandomNumber(Model model, HttpServletRequest request){
    	RandomNumber randonNumber = randomNumberService.generateRandomNumbers(2);
    	HttpSession session = request.getSession();
    	List<RandomNumber> randomNumbers = (ArrayList)session.getAttribute("randomnumberhistory");
    	randomNumbers.add(randonNumber);
    	session.setAttribute("randomnumberhistory", randomNumbers);
    	model.addAttribute("randomnumberhistory", randomNumbers);
        return "randomnumberhistory";
    }
    
    @RequestMapping(value = "/randomnumberhistory", method = RequestMethod.GET)
    public String list(Model model, HttpServletRequest request){
    	HttpSession session = request.getSession();
    	List<RandomNumber> randomNumbers = null;
    	
        if(session.getAttribute("randomnumberhistory") == null) {
        	randomNumbers = randomNumberService.listRandomNumbers();
            session.setAttribute("randomnumberhistory", randomNumbers);
        } else {
        	randomNumbers = (ArrayList)session.getAttribute("randomnumberhistory");
        }
        model.addAttribute("randomnumberhistory", randomNumbers);
        return "randomnumberhistory";
    }
    
}
