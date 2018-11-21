package org.zerock.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/image/*")




public class ImageController {	
	int i = 0;
	
	//private String uploadPath = "C:\\zzz\\upload";
	private String uploadPath = "/usr/zzz/upload";
	@Inject
	private ImageDAO imagedao;
	
	private static final Logger logger = LoggerFactory.getLogger(ImageController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value="/register", method= RequestMethod.GET)
	public String ingGet(AirVO air, Model model, HttpSession session) throws Exception{
		
		Object membervo = session.getAttribute("MemberVO");
		
		
		String s_membervo = membervo.toString();
		System.out.println(""+membervo);

		int start = s_membervo.indexOf("uhome=")+6;
		int end = s_membervo.indexOf(", ux");
		
		s_membervo = s_membervo.substring(start, end);
		
		model.addAttribute("uhome", s_membervo);
		
		model.addAttribute("MemberVO", session.getAttribute("MemberVO"));
		
		model.addAttribute("ImageVO", imagedao.read(s_membervo));


		return "img/imgGet";
	}
	
	@RequestMapping(value="/register", method= RequestMethod.POST)
	public String imgPost(MultipartFile file, MultipartFile file2, ImageVO imagevo, Model model, HttpSession session, MemberVO member) throws Exception{
		
		//logger.info("original name : "+ file.getOriginalFilename());
		
		String savedName = uploadFile(file.getOriginalFilename(), file.getBytes());
		String savedName2 = uploadFile(file2.getOriginalFilename(), file2.getBytes());

		
		String dbSavedName = savedName.replace(uploadPath, "");
		String dbSavedName2 = savedName2.replace(uploadPath, "");

		
		imagevo.setImageName("http://14.63.164.14:8080/interphone2/image/displayFile?filename="+dbSavedName);	
		imagevo.setImageArtist("http://14.63.164.14:8080/interphone2/image/displayFile?filename="+dbSavedName2);
		imagevo.setUhome(imagevo.getUhome());
		imagedao.create(imagevo);
		logger.info(imagevo.getUhome());
		
		model.addAttribute("savedName", savedName);
		model.addAttribute("savedName2", savedName2);

		
		model.addAttribute("MemberVO", session.getAttribute("MemberVO"));
		
		return "redirect:register";
		
	}
	
	
	private String uploadFile(String originalName, byte[] fileData) {
		UUID uid = UUID.randomUUID();
		
		String savedName = uid.toString() + "_" + originalName;
		
		//String savedPath = calcPath(uploadPath);
		
		File target = new File(uploadPath , savedName);
		
		try {
			FileCopyUtils.copy(fileData, target);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		logger.info(uploadPath + "/"+ savedName);
		
		return uploadPath + "/"+ savedName;
	}
	
	
	@RequestMapping(value="/imageView", method= RequestMethod.GET)
	public String imageView(String filename, Model model) throws Exception{
		
		
		
		
		model.addAttribute("filename",filename);
		
		return "img/imageView";
	
		
	}
	
	@RequestMapping(value = "/sendImage/{uhome}", method = RequestMethod.GET)
	
	public ResponseEntity<List<ImageVO>> sendAir(@PathVariable("uhome") String uhome, HttpSession session){		
		
		System.out.println(session.getAttribute("visited"));

		
		if(session.getAttribute("visited") == null) {
			session.setAttribute("visited", "0");
			System.out.println("세션 만들어짐, 0");

		}
		
		
		if(session.getAttribute("visited") == "0") {
			System.out.println(session.getAttribute("visited"));
			session.setAttribute("visited", "1");
			

		}else if(session.getAttribute("visited") == "1") {
			System.out.println(session.getAttribute("visited"));
			session.setAttribute("visited", "2");
		}else if(session.getAttribute("visited") == "2") {
			System.out.println(session.getAttribute("visited"));
			session.setAttribute("visited", "0");
		}
	      
		//System.out.println(session.getAttribute("visited"));

		
	     // session.setAttribute("visited", (visited)+"");

		
		ResponseEntity<List<ImageVO>> entity = null;
		System.out.println("uhome = "+ uhome);

		try {
			entity = new ResponseEntity<>(
					imagedao.read(uhome) , HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
@RequestMapping(value = "/sendImage2/{uhome}", method = RequestMethod.GET)
	
	public ResponseEntity<ImageVO> sendImage2(@PathVariable("uhome") String uhome, HttpSession session){		
		
		System.out.println(session.getAttribute("visited"));
		String imageType = "familyImage";
		
		if(session.getAttribute("visited") == null) {
			session.setAttribute("visited", "0");
			System.out.println("세션 만들어짐, 0");

		}
		
		
		if(session.getAttribute("visited") == "0") {
			System.out.println(session.getAttribute("visited"));
			session.setAttribute("visited", "1");
			imageType = "masterImage";

		}else if(session.getAttribute("visited") == "1") {
			System.out.println(session.getAttribute("visited"));
			session.setAttribute("visited", "2");
			imageType = "familyImage";

		}else {
			System.out.println(session.getAttribute("visited"));
			session.setAttribute("visited", "0");
			imageType = "contents";

		}
	      
		//System.out.println(session.getAttribute("visited"));

		
	     // session.setAttribute("visited", (visited)+"");

		
		ResponseEntity<ImageVO> entity = null;
		System.out.println("uhome = "+ uhome);

		try {
		
			entity = new ResponseEntity<>(
					imagedao.search(uhome, imageType) , HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@ResponseBody
	@RequestMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String filename)throws Exception{
		
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		
		HttpHeaders headers = new HttpHeaders();
		
		in = new FileInputStream(uploadPath+"/"+filename);
		
		entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, 
				HttpStatus.CREATED);
		logger.info("FILE get success");
		in.close();
		
		return entity;
	}
	
	@RequestMapping(value = "/deleteFile/{imageName}", method = RequestMethod.GET)
	public String deleteFile(@PathVariable("imageName") String imageName ) {
		System.out.println("Image Delete");
		try {
			imagedao.delete(imageName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:../../image/register";
	}
	

}








