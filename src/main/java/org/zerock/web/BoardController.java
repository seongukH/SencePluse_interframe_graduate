package org.zerock.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.MemberVO;
import org.zerock.domain.PageMaker;
import org.zerock.domain.SearchCriteria;
import org.zerock.persistence.BoardDAO;
/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	private BoardDAO BoardDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value="/register", method= RequestMethod.GET)
	public void registerGET(BoardVO board, Model model) throws Exception{
		
		
	}
	
	@RequestMapping(value="/register", method= RequestMethod.POST)
	public String registerPOST(BoardVO board, Model model) throws Exception{
		
		BoardDAO.create(board);
		
		model.addAttribute("result", "success");
		
		//return "board/success";
		return "redirect:/board/listAll";
	}
	/*
	@RequestMapping(value="/listAll", method= RequestMethod.GET)
	public void listAll(Model model)throws Exception{
		
		model.addAttribute("list", BoardDAO.listAll());
		
		logger.info("show all list......");
	}
	*/
	
	@RequestMapping(value="/listAll", method= RequestMethod.GET)
	public void listCri( @ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception{
		//model.addAttribute("list", BoardDAO.listAll());
		
		logger.info(" "+BoardDAO.countPaging(cri));
		
		//model.addAttribute("list", BoardDAO.listCriteria(cri));
		model.addAttribute("list", BoardDAO.listSearch(cri));
		
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCriteria(cri);
		pageMaker.setTotalCount(BoardDAO.countPaging(cri));
		
		model.addAttribute("pageMaker", pageMaker);
		
	}
	
	
	
	
	
	
	
	@RequestMapping(value="/view", method= RequestMethod.GET)
	public void listAll(Model model, @RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri)throws Exception{
		model.addAttribute(BoardDAO.read(bno));
		
		logger.info("show all list......");
	}
	
	@RequestMapping(value="/remove", method= RequestMethod.POST)
	public String remove(Model model, @RequestParam("bno") int bno, Criteria cri,RedirectAttributes rttr)throws Exception{
		BoardDAO.delete(bno);
		
		logger.info("show all list......");
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/board/listAll";
	}
	
	
	@RequestMapping(value="/modify", method= RequestMethod.GET)
	public void modify(Model model, @RequestParam("bno") int bno, RedirectAttributes rttr)throws Exception{
		model.addAttribute(BoardDAO.read(bno));
		
	}
	
	@RequestMapping(value="/modify", method= RequestMethod.POST)
	public String modifyPost(Model model,BoardVO board, Criteria cri )throws Exception{
		
		logger.info(""+board);
		
		BoardDAO.update(board);		
		
		return "redirect:/board/listAll";
	}
	
	
}








