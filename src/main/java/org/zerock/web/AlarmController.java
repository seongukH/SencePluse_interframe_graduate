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
import org.zerock.domain.AlarmVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.MemberVO;
import org.zerock.domain.PageMaker;
import org.zerock.domain.SearchCriteria;
import org.zerock.persistence.AlarmDAO;
import org.zerock.persistence.AirDAO;
/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/alarm/*")
public class AlarmController {
	
	@Inject
	private AlarmDAO AlarmDAO;
	private AirDAO AirDAO;

	
	private static final Logger logger = LoggerFactory.getLogger(AlarmController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value="/register", method= RequestMethod.GET)
	public String airGet(AlarmVO alarm, Model model,  HttpSession session) throws Exception{
		
		Object membervo = session.getAttribute("MemberVO");
		
		
		String s_membervo = membervo.toString();
		System.out.println(""+membervo);

		int start = s_membervo.indexOf("uhome=")+6;
		int end = s_membervo.indexOf(", ux");
		
		s_membervo = s_membervo.substring(start, end);
		
		model.addAttribute("uhome", s_membervo);
		model.addAttribute("MemberVO", session.getAttribute("MemberVO"));

		model.addAttribute("AlarmVO", AlarmDAO.read(s_membervo));

		return "alarm/alarmGet";
	}
	
	@RequestMapping(value="/register", method= RequestMethod.POST)
	public String airPost(AlarmVO alarm, Model model, HttpSession session, MemberVO member) throws Exception{
		
		int hour = alarm.getHour_10()*10 + alarm.getHour_1();
		int minute = alarm.getMinute_10()*10 + alarm.getMinute_1();
		
		alarm.setHour(hour);
		alarm.setMinute(minute);

		AlarmDAO.create(alarm);
		
		model.addAttribute("MemberVO", session.getAttribute("MemberVO"));
		
		return "redirect:register";
		
	}
		
	
	
	@RequestMapping(value = "/sendAlarm/{uhome}", method = RequestMethod.GET)
	public ResponseEntity<List<AlarmVO>> sendAir(@PathVariable("uhome") String uhome){
		
		ResponseEntity<List<AlarmVO>> entity = null;
		
		try {
			entity = new ResponseEntity<>(
					AlarmDAO.read(uhome) , HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value = "/deleteAlarm/{sno}", method = RequestMethod.GET)
	public String deleteAlarm(@PathVariable("sno") String sno){
		
		try {
			AlarmDAO.delete(sno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:../../alarm/register";

	}
	
}








