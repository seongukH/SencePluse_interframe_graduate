package org.zerock.web;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.AirVO;
import org.zerock.domain.NewsVO;

import com.github.rcaller.rStuff.RCaller;
import com.github.rcaller.rStuff.RCode;

@Controller
public class RcallerController {
	File file;

	@RequestMapping(value = "/caller", method = RequestMethod.GET)
	//@Scheduled(fixedDelay=1000)
	public void caller(Locale locale, Model model) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		 try {
	         
	         RCaller caller = new RCaller();
	        // caller.setRscriptExecutable("C:\\Program Files\\R\\R-3.5.0\\bin\\x64\\Rscript.exe");
	         caller.setRscriptExecutable("/usr/bin/Rscript");

	         
	         
	         RCode code = new RCode();
	         code.clear();
	         
	         code.addRCode("x = c(1,2,3,4,5)"+
	        		 		"x");
	        
	         
	         code.clear();
	         
	         
	         file = code.startPlot();
	         System.out.println(file);
	 		model.addAttribute("ploturl", file);

	       
	 		code.addRCode("t = Sys.time()\r\n" + 
	 				"\r\n" + 
	 				"t\r\n" + 
	 				"text = (\"ø¿¥√¿« ¥∫Ω∫ // \")\r\n" + 
	 				"\r\n" + 
	 				"out = paste(text, t)\r\n" + 
	 				"\r\n" + 
	 				"#write(out, \"C:/zzz/text/new.txt\")\r\n" + 
	 				"\r\n" + 
	 				"write(out, \"/usr/zzz/text/new.txt\")\r\n" + 
	 				"\r\n" + 
	 				"");
	 		code.endPlot();
	 		
	         caller.setRCode(code);
	         caller.runOnly();
	         
	       
	        // code.showPlot(file);
	         
	      } catch (Exception e) {
	         // TODO: handle exception
		         System.out.println("exception!");

	      }
		 
		 
	}
	
	
	@ResponseBody
	@RequestMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String filename)throws Exception{
		
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		System.out.println("FILE get success");
		
		HttpHeaders headers = new HttpHeaders();
		
		in = new FileInputStream(file);
		
		entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, 
				HttpStatus.CREATED);
		
		return entity;
	}
	/*
	@ResponseBody
	@RequestMapping("/displayTextFile")
	public ResponseEntity<byte[]> displayTextFile(String filename)throws Exception{
		
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		System.out.println("FILE get success");
		
		HttpHeaders headers = new HttpHeaders();
		
		file = new File( "C:\\zzz\\text\\new.txt");
		//file = new File( "/usr/zzz/text/new.txt");
		in = new FileInputStream(file);
		
		entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, 
				HttpStatus.CREATED);
		
		//entity = entity.toString();
		return entity;
	}
	*/
	
	@RequestMapping("/displayTextFile")
	public String displayTextFile(Model model)throws Exception{
		
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		String str = null;
		System.out.println("FILE get success");
		
		HttpHeaders headers = new HttpHeaders();
		
		//file = new File( "C:\\zzz\\text\\new.txt");
		file = new File( "/usr/zzz/text/new.txt");
		in = new FileInputStream(file);
		
		str = IOUtils.toString(in);
		
		
		System.out.println(str);
		//entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, 
		//		HttpStatus.CREATED);
		
		//entity = entity.toString();
		
		model.addAttribute("news",str);
		
		return "news";
	}
	
	@RequestMapping(value = "/displayTextFile2",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String displayTextFile2(Model model)throws Exception{
		
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		String str = null;
		System.out.println("FILE get success");
		
		HttpHeaders headers = new HttpHeaders();
		
		//file = new File( "C:\\zzz\\text\\new.txt");
		file = new File( "/usr/zzz/text/new.txt");
		in = new FileInputStream(file);
		
		str = IOUtils.toString(in);
		
		//ResponseEntity<String> news = in.toString();
		
		
		System.out.println(str);
		
		byte[] b = str.getBytes("UTF-8");
		
		//entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, 
		//		HttpStatus.CREATED);
		
		//entity = entity.toString();
		
		model.addAttribute("news",str);
		
		
		
		return str;
	}
	
	@RequestMapping(value = "/so", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String so() {
	    return "This is a String";
	}
	
	
	@RequestMapping(value = "/sendNews", produces="application/json;charset=UTF-8")
	public ResponseEntity<String> sendNews(){
		
		ResponseEntity<String> entity = null;
		
		InputStream in = null;
		
		//file = new File( "C:\\zzz\\text\\new.txt");
		file = new File( "/usr/zzz/text/new.txt");
		
		try {
			in = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//entity = IOUtils.toString(in);
		
		
		try {
			entity = new ResponseEntity<String>(IOUtils.toString(in, "UTF-8"), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	
}
