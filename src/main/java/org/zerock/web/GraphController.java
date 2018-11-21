package org.zerock.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.AirVO;
import org.zerock.domain.MemberVO;
import org.zerock.persistence.AirDAO;
import org.apache.commons.io.IOUtils;

import com.github.rcaller.rStuff.RCaller;
import com.github.rcaller.rStuff.RCode;

/**
 * Handles requests for the application home page.
 */


@Controller
@RequestMapping("/graph/*")


public class GraphController {
	
	@Inject
	private AirDAO airdao;

	private static final Logger logger = LoggerFactory.getLogger(GraphController.class);

	File file;

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/caller/{uhome}", method = RequestMethod.GET)
	public String home2(Locale locale, Model model, @PathVariable("uhome") String uhome, HttpSession session, AirVO air,
			MemberVO member) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Object membervo = session.getAttribute("MemberVO");

		String s_membervo = membervo.toString();
		System.out.println("" + membervo);

		int start = s_membervo.indexOf("uhome=") + 6;
		int end = s_membervo.indexOf(", ux");

		s_membervo = s_membervo.substring(start, end);

		model.addAttribute("uhome", s_membervo);
		model.addAttribute("MemberVO", session.getAttribute("MemberVO"));
		
		try {
			model.addAttribute("AirVO", airdao.read(s_membervo));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		try {

			RCaller caller = new RCaller();
			caller.setRscriptExecutable("C:\\Program Files\\R\\R-3.5.0\\bin\\x64\\Rscript.exe");
			RCode code = new RCode();
			code.clear();

			file = code.startPlot();
			System.out.println(file);
			model.addAttribute("ploturl", file);

			code.addRCode("\n" + "library(RMySQL)\n" + "library(readxl)\n" + "library(dplyr)\n" + "library(ggplot2)\n"
					+ "#library(RMySQL)\n" + "\n" + "\n" + "con <- dbConnect(MySQL(), \n"
					+ "                 user=\"gk0610\",\n" + "                 password=\"tjddnr1121\",\n"
					+ "                  dbname=\"air\",\n" + "                 host = \"127.0.0.1\"\n"
					+ "                 )\n" + "\n" + "con\n" + "\n"
					+ "air2 = dbGetQuery(con, \"select * from air where uhome = " + uhome + "\");\n" + "\n" + "air2\n"
					+ "#air2<-read.csv(\"air.csv\")\n" + "\n" + "ggplot(data=air2,aes(x=time,y=humid,group=1))+\n"
					+ "  geom_line(color=\"black\",linetype=1)+geom_point(color=\"navy\",size=5)+\n"
					+ "  ggtitle(\"Monthly temperature graph\")+\n"
					+ "  theme(plot.title=element_text(face=\"bold\",size=25,color=\"navy\"))+\n"
					+ "  theme(axis.title.x=element_text(size=12,color=\"navy\"))+\n"
					+ "  theme(axis.title.y=element_text(size=12,color=\"navy\"))+\n"
					+ "  xlab(\"Date\")+ylab(\"Temperature\n" + "\")");
			// code.addRCode("plot(x)");
			code.endPlot();

			caller.setRCode(code);
			caller.runOnly();
			// code.showPlot(file);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception!");

		}

		return "air/caller";
	}

	@ResponseBody
	@RequestMapping("/displayFile/{uhome}")
	public ResponseEntity<byte[]> displayFile(String filename, @PathVariable("uhome") String uhome) throws Exception {
		File file = null;

		try {

			RCaller caller = new RCaller();
			caller.setRscriptExecutable("/usr/bin/Rscript");
			RCode code = new RCode();
			code.clear();

			file = code.startPlot();
			System.out.println(file);

			code.addRCode("\n" + "library(RMySQL)\n" + "library(readxl)\n" + "library(dplyr)\n" + "library(ggplot2)\n"
					+ "#library(RMySQL)\n" + "\n" + "\n" + "con <- dbConnect(MySQL(), \n"
					+ "                 user=\"gk0610\",\n" + "                 password=\"tjddnr1121\",\n"
					+ "                  dbname=\"air\",\n" + "                 host = \"127.0.0.1\"\n"
					+ "                 )\n" + "\n" + "con\n" + "\n"
					+ "air2 = dbGetQuery(con, \"select * from air where uhome = " + uhome + "\");\n" + "\n" + "air2\n"
					+ "#air2<-read.csv(\"air.csv\")\n" + "\n" + "ggplot(data=air2,aes(x=time,y=humid,group=1))+\n"
					+ "  geom_line(color=\"black\",linetype=1)+geom_point(color=\"navy\",size=5)+\n"
					+ "  ggtitle(\"Daily temperature graph\")+\n"
					+ "  theme(plot.title=element_text(face=\"bold\",size=25,color=\"navy\"))+\n"
					+ "  theme(axis.title.x=element_text(size=12,color=\"navy\"))+\n"
					+ "  theme(axis.title.y=element_text(size=12,color=\"navy\"))+\n"
					+ "  xlab(\"Time\")+ylab(\"Temperature\")");
			// code.addRCode("plot(x)");
			code.endPlot();

			caller.setRCode(code);
			caller.runOnly();
			// code.showPlot(file);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception!");

		}

		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		logger.info("FILE NAME : " + filename);

		HttpHeaders headers = new HttpHeaders();

		in = new FileInputStream(file);

		entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);

		return entity;
	}

}
