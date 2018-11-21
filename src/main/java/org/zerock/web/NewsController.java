package org.zerock.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.AirVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.NewsVO;

import org.zerock.persistence.NewsDAO;
/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/news/*")
public class NewsController {
	
	@Inject
	private NewsDAO NewsDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(NewsController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	
	
	
	@RequestMapping(value = "/sendNews", method = RequestMethod.GET)
	public ResponseEntity<List<NewsVO>> sendNews(){
		
		ResponseEntity<List<NewsVO>> entity = null;
		
		try {
			entity = new ResponseEntity<>(
					NewsDAO.listAll(), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	

}








