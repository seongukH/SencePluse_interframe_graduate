package org.zerock.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.domain.AirVO;
import org.zerock.domain.ImageVO;
import org.zerock.domain.MemberVO;
import org.zerock.persistence.AirDAO;
import org.zerock.persistence.ImageDAO;
/**
 * Handles requests for the application home page.
 */


@Controller
@RequestMapping("/indivisual/*")




public class ViewController {	
	
	
	//private String uploadPath = "C:\\zzz\\upload";
	private String uploadPath = "/usr/zzz/upload";
	@Inject
	private ImageDAO imagedao;
	
	@Inject
	private AirDAO airdao;
	
	private static final Logger logger = LoggerFactory.getLogger(ViewController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	
	
	@RequestMapping(value="/viewAll", method= RequestMethod.GET)
	public ModelAndView viewAll(String filename,ImageVO imagevo, AirVO airvo,
			ModelAndView mav, HttpSession session) throws Exception{
		
		mav.setViewName("viewAll");
		
		Object membervo = session.getAttribute("MemberVO");
		
		
		String s_membervo = membervo.toString();
		System.out.println(""+membervo);

		int start = s_membervo.indexOf("uhome=")+6;
		int end = s_membervo.indexOf(", ux");
		
		s_membervo = s_membervo.substring(start, end);
		
		System.out.println(s_membervo);		
		
		//imagedao.read(s_membervo);		
		//airdao.listAll ();
		
		mav.addObject("ImageVO", imagedao.read(s_membervo));
		mav.addObject("AirVO", airdao.read(s_membervo));
		
		return mav;
	
		
	}
	
	
	

}








