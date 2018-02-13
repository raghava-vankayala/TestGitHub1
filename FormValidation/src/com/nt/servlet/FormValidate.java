package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class FormValidate extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,pwd=null,ppage=null;
		int age=0;
		
		//set content type
		res.setContentType("text/html");
		//get printwriter
		pw=res.getWriter();
		
		//read the data from the form
		name=req.getParameter("uname");
		pwd=req.getParameter("upwd");
		ppage=req.getParameter("page");
		
		//perform server side validations
		if(name.equals("")|| name==null || name.length()==0){
			pw.println("in server side");
			pw.println("person name is mandatory");
			return;
		}
		if(pwd.equals("")||pwd==null||pwd.length()==0){
			pw.println("in server side");
			pw.println("password mandatory");
			return;
		}
		else if(pwd.length()<8){
			pw.println("in server side");
			pw.println("password must be above 8 charcters");
			return;
		}
		if(ppage.equals("")||ppage==null||ppage.length()==0){
			pw.println("in server side ");
			pw.println("person age mandatory");
			return;
		}
		//else block for checking the age is number or not
		else{
			try{
			age=Integer.parseInt(ppage);
			}
			catch(NumberFormatException nfe){
				pw.println("age must be in number format");
				return;
			}
		}//else
		age=Integer.parseInt(ppage);
		//write the business logic
		if(age>18 && age<120){
			pw.println(name+ " u r eligible to marriage");
		}
		else if(age>=120){
			pw.println("age must be int <b> 1 </b> to <120>");
		}
		else{
			pw.println("you are not eligible for marriage");
		}
		pw.println("<a href='index.html'><img src='home_link_img.jpg'></img></a>");
		//close the streams
		pw.close();
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
