package org.zerock.web;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.Date;

import javax.inject.Inject;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.zerock.persistence.AlarmDAO;

import com.github.rcaller.rStuff.RCaller;
import com.github.rcaller.rStuff.RCode;




@Service
public class NewsScheduler {
	File file;
	
	
	
	@Inject
	private AlarmDAO AlarmDAO;
	
	/*
	@Scheduled(fixedDelay=1000*1)
    public void TestScheduler123(){
		System.out.println("second");
		
	}
	*/
	
	@Scheduled(fixedDelay=1000*60*2)	
	public void TestScheduler() {
		
		String rcode = 	"getwd()\n" + 
				"\n" + 
				"#install.packages(\"rvest\")\n" + 
				"#install.packages(\"xml2\")\n" + 
				"#install.packages(\"R6\")\n" + 
				"#install.packages(\"rJava\")\n" + 
				"library(\"xml2\")\n" + 
				"library(\"rJava\")\n" + 
				"library(\"memoise\")\n" + 
				"library(\"KoNLP\")\n" + 
				"library(\"dplyr\")\n" + 
				"library(\"rvest\")\n" + 
				"library(\"R6\")\n" + 
				"library(\"stringr\")\n" + 
				"\n" + 
				"#library(rvest)\n" + 
				"\n" + 
				"\n" + 
				"all.reviews<-c()\n" + 
				"\n" + 
				"\n" + 
				"exurl <- \"http://www.yonhapnews.co.kr/\"\n" + 
				"yhmain<- read_html(exurl)\n" + 
				"\n" + 
				"exnewsurl <- html_nodes(yhmain, css='.tit-news')\n" + 
				"newsLink = exnewsurl;\n" + 
				"#headImage = exnewsurl[1];\n" + 
				"#sumNews = exnewsurl[1];\n" + 
				"#headline = exnewsurl[1];\n" + 
				"\n" + 
				"newsLink\n" + 
				"\n" + 
				"newsLink = gsub(\".*HTTP\", \"http\", newsLink)\n" + 
				"newsLink = gsub(\"\\\".*\", \"\", newsLink)\n" + 
				"\n" + 
				"newsLink\n" + 
				"\n" + 
				"\n" + 
				"headImageFunc = function(newsLink){\n" + 
				"  \n" + 
				"  headImage = read_html(newsLink)\n" + 
				"  headImage = gsub(\".*http://img.yonhapnews.co.kr/photo/\", \n" + 
				"                   \"http://img.yonhapnews.co.kr/photo/\", headImage)\n" + 
				"  \n" + 
				"  headImage = gsub(\".*http://img.yonhapnews.co.kr/etc/\", \n" + 
				"                   \"http://img.yonhapnews.co.kr/etc/\", headImage)\n" + 
				"  \n" + 
				"  \n" + 
				"  headImage = gsub(\"jpg.*\", \"jpg\", headImage)\n" + 
				"  headImage = gsub(\"jpeg.*\", \"jpeg\", headImage)\n" + 
				"  \n" + 
				"  return(headImage)\n" + 
				"}\n" + 
				"\n" + 
				"headlinkFunk = function(newsLink){\n" + 
				"  \n" + 
				"  headline = read_html(newsLink)\n" + 
				"  \n" + 
				"  headline = html_nodes(headline, css='.tit-article')\n" + 
				"  headline = gsub(\"<h1 class=\\\"tit-article\\\">\", \"\",headline)\n" + 
				"  headline = gsub(\"</h1>\", \"\",headline)\n" + 
				"  headline = gsub(\"\\\"\", \"\",headline)\n" + 
				"  \n" + 
				"  \n" + 
				"  return (headline)\n" + 
				"  \n" + 
				"  headline.length\n" + 
				"  \n" + 
				"  \n" + 
				"}\n" + 
				"\n" + 
				"sumNewsFunc <- function(newsLink) {\n" + 
				"  \n" + 
				"  \n" + 
				"  sumNews = read_html(newsLink)\n" + 
				"  sumNews = html_node(sumNews, css='.stit')\n" + 
				"  sumNews = gsub(\"<strong>\\r\\n<b>\", \"\", sumNews)\n" + 
				"  sumNews = gsub(\"<div class=\\\"stit\\\">\\r\\n\", \"\", sumNews)\n" + 
				"  \n" + 
				"  sumNews = gsub(\"</b>*\", \" \", sumNews)\n" + 
				"  sumNews = gsub(\"<b>*\", \" \", sumNews)\n" + 
				"  sumNews = gsub(\"</br>\", \"\", sumNews)\n" + 
				"  sumNews = gsub(\"<br>\", \"\", sumNews)\n" + 
				"  sumNews = gsub(\"</strong>*\", \"\", sumNews)\n" + 
				"  sumNews = gsub(\"</div>*\", \"\", sumNews)\n" + 
				"  sumNews = gsub(\"r>*\", \"\", sumNews)\n" + 
				"  sumNews = gsub(\"\\r*\", \"\", sumNews)\n" + 
				"  sumNews = gsub(\"\\n*\", \"\", sumNews)\n" + 
				"  sumNews = gsub(\"\\\"\", \"\", sumNews)\n" + 
				"  \n" + 
				"  \n" + 
				"  return(sumNews)\n" + 
				"}\n" + 
				"\n" + 
				"\n" + 
				"crollArticleFunc = function(newsLink){\n" + 
				"  article = read_html(newsLink)\n" + 
				" # article = html_node(article, css=\".article\")\n" + 
				"  \n" + 
				"  article<-article %>% html_nodes(\".article\") %>% html_text()\n" + 
				"  \n" + 
				"  article=gsub(\"\\\\.\",\"\\\\.\\n\",article)\n" + 
				"  \n" + 
				"  article<-str_replace_all(article,\"\\r\",\"\")\n" + 
				"  article<-str_replace_all(article,\"\\t\",\"\")\n" + 
				"  article<-str_replace_all(article,\"\\t\\t\",\"\")\n" + 
				"  article<-str_replace_all(article,\"\\t\\t\\t\",\"\")\n" + 
				"  article<-str_replace_all(article,\"\\n\\n\\n\\n\",\"\\n\")\n" + 
				"  article<-str_replace_all(article,\"\\n\\n\\n\",\"\\n\")\n" + 
				"  article<-str_replace_all(article,\"\\n\\n\",\"\\n\")\n" + 
				"  \n" + 
				"  article<-str_replace_all(article,\"<div class=\\\"article\\\">\",\"\\n\")\n" + 
				"  article<-str_replace_all(article,\"</p>\",\"\")\n" + 
				"  article<-str_replace_all(article,\"<p>\",\"\")\n" + 
				"  article<-str_replace_all(article,\"div class=\\\"article-img\\\">*\",\"\")\n" + 
				"  article<-str_replace_all(article,\"<p>\",\"\")\n" + 
				"  article = gsub(\"\\\"\", \"\",article)\n" + 
				"  \n" + 
				"  article\n" + 
				"  \n" + 
				"  return(article)\n" + 
				"}\n" + 
				"crollArticleFunc(newsLink[1])\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"sumNewsFunc2 = function(article){\n" + 
				"  \n" + 
				"  write.table(article,'news2222.txt')\n" + 
				"  news<-readLines(\"news2222.txt\")\n" + 
				"  \n" + 
				"  nouns<-extractNoun(news)\n" + 
				"  \n" + 
				"  wordcount<-table(unlist(nouns))\n" + 
				"  df_word<-as.data.frame(wordcount,stringsAsFactors = F)\n" + 
				"  df_word<-rename(df_word,word=Var1,freq=Freq)\n" + 
				"  \n" + 
				"  df_word<-filter(df_word,nchar(word)>=2)\n" + 
				"  top_20<-df_word%>% arrange(desc(freq))%>%head(20)\n" + 
				"  \n" + 
				"  many2<-head(top_20,10)\n" + 
				"  \n" + 
				"  temp3<-as.data.frame(0)\n" + 
				"  temp=0\n" + 
				"  temp4=0\n" + 
				"  temp4[1]=0\n" + 
				"  temp4[2]=0\n" + 
				"  \n" + 
				"  check_past <- function(news){\n" + 
				"    check<-1:17\n" + 
				"    check[1]<-gregexpr(\"°¬\", news)\n" + 
				"    check[2]<-gregexpr(\"°å\", news)\n" + 
				"    check[3]<-gregexpr(\"³µ\", news)\n" + 
				"    check[4]<-gregexpr(\"µÆ\", news)\n" + 
				"    check[5]<-gregexpr(\"·È\", news)\n" + 
				"    check[6]<-gregexpr(\"¼¹\", news)\n" + 
				"    check[7]<-gregexpr(\"½è\", news)\n" + 
				"    check[8]<-gregexpr(\"½Õ\", news)\n" + 
				"    check[9]<-gregexpr(\"½ú\", news)\n" + 
				"    check[10]<-gregexpr(\"¾Ò\", news)\n" + 
				"    check[11]<-gregexpr(\"¾ú\", news)\n" + 
				"    check[12]<-gregexpr(\"¿´\", news)\n" + 
				"    check[13]<-gregexpr(\"¿ü\", news)\n" + 
				"    check[14]<-gregexpr(\"¿Ô\", news)\n" + 
				"    check[15]<-gregexpr(\"Àä\", news)\n" + 
				"    check[16]<-gregexpr(\"Áá\", news)\n" + 
				"    check[17]<-gregexpr(\"Çß\", news)\n" + 
				"    past=0\n" + 
				"    for(i in 1:17){\n" + 
				"      if(check[[i]][1]!=-1){\n" + 
				"        past=1\n" + 
				"        break\n" + 
				"      }\n" + 
				"    }\n" + 
				"    return(past)\n" + 
				"  }\n" + 
				"  \n" + 
				"  \n" + 
				"  for(i in 1:length(news)){\n" + 
				"    for(j in 1:10){\n" + 
				"      find<-gregexpr(many2[j,1], news[i])\n" + 
				"      temp3<-as.data.frame(find[[1]][1])\n" + 
				"      if(temp3[1,1] != -1){\n" + 
				"        temp=temp+many2[j,2]\n" + 
				"      }\n" + 
				"      \n" + 
				"    }\n" + 
				"    ok<-check_past(news[i])\n" + 
				"    if(ok==1){\n" + 
				"      temp=temp+5\n" + 
				"    }\n" + 
				"    print(temp)\n" + 
				"    temp4[i]=temp\n" + 
				"    temp=0\n" + 
				"  }\n" + 
				"  \n" + 
				"  temp5<-as.data.frame(temp4)\n" + 
				"  temp5 %>% arrange(desc(temp4))\n" + 
				"  temp6 <-temp5 %>% arrange(desc(temp4))\n" + 
				"  temp7=0\n" + 
				"  \n" + 
				"  result = \"\"\n" + 
				"  \n" + 
				"  for(i in 1:length(temp4)){\n" + 
				"    for(j in 1:5){\n" + 
				"      if(temp6[j,1]==temp4[i]){\n" + 
				"        print(news[i])\n" + 
				"        result = paste(result,\" \" , news[i])\n" + 
				"        break\n" + 
				"      }\n" + 
				"    }\n" + 
				"  }\n" + 
				"  \n" + 
				"  result\n" + 
				"  return(result)\n" + 
				"}#func\n" + 
				"crollArticleFunc(newsLink[1])\n" + 
				"sumNewsFunc2(crollArticleFunc(newsLink[1]))\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"sumNewsFunc(newsLink[2])\n" + 
				"headImageFunc(newsLink[1])\n" + 
				"headlinkFunk(newsLink[1])\n" + 
				"\n" + 
				"\n" + 
				"out = paste(\"[{\\\"newsLink\\\":\",\"\\\"\", newsLink[1], \"\\\",\", \n" + 
				"            \"\\\"headImage\\\" : \",\"\\\"\", headImageFunc(newsLink[1]),\"\\\",\", \n" + 
				"            \"\\\"headLine\\\" : \",\"\\\"\", headlinkFunk(newsLink[1]), \"\\\",\",\n" + 
				"            \"\\\"sumNews\\\" : \",\"\\\"\", sumNewsFunc2(crollArticleFunc(newsLink[1]))\n" + 
				", \"\\\"},\",\n" + 
				"            \n" + 
				"            \"{\\\"newsLink\\\" : \",\"\\\"\", newsLink[2], \"\\\",\", \n" + 
				"            \"\\\"headImage\\\" : \",\"\\\"\", headImageFunc(newsLink[2]),\"\\\",\", \n" + 
				"            \"\\\"headLine\\\" : \",\"\\\"\", headlinkFunk(newsLink[2]), \"\\\",\",\n" + 
				"            \"\\\"sumNews\\\" : \",\"\\\"\", sumNewsFunc2(crollArticleFunc(newsLink[2]))\n" + 
				", \"\\\"},\",\n" + 
				"            \n" + 
				"            \"{\\\"newsLink\\\" : \",\"\\\"\", newsLink[3], \"\\\",\", \n" + 
				"            \"\\\"headImage\\\" : \",\"\\\"\", headImageFunc(newsLink[3]),\"\\\",\", \n" + 
				"            \"\\\"headLine\\\" : \",\"\\\"\", headlinkFunk(newsLink[3]), \"\\\",\",\n" + 
				"            \"\\\"sumNews\\\" : \",\"\\\"\", sumNewsFunc2(crollArticleFunc(newsLink[3]))\n" + 
				", \"\\\"},\",\n" + 
				"            \n" + 
				"            \"{\\\"newsLink\\\" : \",\"\\\"\", newsLink[4], \"\\\",\", \n" + 
				"            \"\\\"headImage\\\" : \",\"\\\"\", headImageFunc(newsLink[4]),\"\\\",\", \n" + 
				"            \"\\\"headLine\\\" : \",\"\\\"\", headlinkFunk(newsLink[4]), \"\\\",\",\n" + 
				"            \"\\\"sumNews\\\" : \",\"\\\"\", sumNewsFunc2(crollArticleFunc(newsLink[4]))\n" + 
				", \"\\\"},\",\n" + 
				"            \n" + 
				"            \"{\\\"newsLink\\\" : \",\"\\\"\", newsLink[5], \"\\\",\", \n" + 
				"            \"\\\"headImage\\\" : \",\"\\\"\", headImageFunc(newsLink[5]),\"\\\",\", \n" + 
				"            \"\\\"headLine\\\" : \",\"\\\"\", headlinkFunk(newsLink[5]), \"\\\",\",\n" + 
				"            \"\\\"sumNews\\\" : \",\"\\\"\", sumNewsFunc2(crollArticleFunc(newsLink[5]))\n" + 
				", \"\\\"}\",\n" + 
				"            \n" + 
				"            \"]\")\n" + 
				"#write(out, \"C:/zzz/text/new.txt\" )\n" + 
				"write(out, \"/usr/zzz/text/new.txt\")\n" + 
				"out\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"";
		
		


		
		 try {
			 
	         
	         RCaller caller = new RCaller();
	        // caller.setRscriptExecutable("C:\\Program Files\\R\\R-3.5.0\\bin\\x64\\Rscript.exe");
	         caller.setRscriptExecutable("/usr/bin/Rscript");

	         
	         
	         RCode code = new RCode();
	         code.clear();
	         
	 
	         code.addRCode(""+rcode);
	         
	         
	 		code.endPlot();
	 		
	         caller.setRCode(code);
	         System.out.println();  
	         caller.runOnly();
	         
	       
	        // code.showPlot(file);
	         
	      } catch (Exception e) {
	         // TODO: handle exception
		         System.out.println("exception!");

	      }
		 
		 
    }
    
    
	
	@Scheduled(fixedDelay=1000*10)
    public void AlarmScheduler(){
		Date date = new Date();

		
		System.out.println(date.getHours() +" : "+date.getMinutes());
		
		int hour = date.getHours();
		int minute = date.getMinutes();
				
		String shour = String.valueOf(hour);
		String sminute = String.valueOf(minute);
		
		try {
			AlarmDAO.updateStartAlarm(shour, sminute);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			AlarmDAO.updateEndAlarm(shour, sminute);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
