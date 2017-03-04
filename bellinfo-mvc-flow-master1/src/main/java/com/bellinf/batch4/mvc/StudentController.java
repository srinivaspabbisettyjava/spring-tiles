package com.bellinf.batch4.mvc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bellinf.batch4.mvc.model.DatabaseConnection;
import com.bellinf.batch4.mvc.model.Student;

@Controller
@RequestMapping(value="/student")
public class StudentController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String getStudent(Model model){
		Student student = new Student();
		model.addAttribute("student", student);
//		model.addAttribute("course", student);
//		model.addAttribute("fee",student);
		model.addAttribute("year",student);
//		model.addAttribute("date",student);
//		
		return "student-login";
	}
	

	@RequestMapping(method=RequestMethod.POST)
	public String studentDetails(@Valid @ModelAttribute Student student, BindingResult result, HttpServletRequest model){	
		if(result.hasErrors()){
			return "student-login";
		}
		
		ArrayList<Student> info=new ArrayList<Student>();
		
	    
//		model.addAttribute("message", "Hey...welcome "+student.getName());
//		model.addAttribute("name",""+student.getName());
//		model.addAttribute("course",""+student.getCourse());
//		model.addAttribute("fee",""+student.getFee());
//		model.addAttribute("year",""+student.getYear());
//		model.addAttribute("date",""+student.getCurDate());
		
		String name1=model.getParameter("name");
		String course1 = model.getParameter("Course");
        int fee1 = Integer.parseInt(model.getParameter("Fee"));
        int year1 = Integer.parseInt(model.getParameter("Year"));
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String curDate1 = (String)dateFormat.format(date);
        
      //  if(name1.length()>3&&course1.equals(null)&&year1>2017&&fee1>100){
        
        student.setName(name1);
        student.setCourse(course1);
        student.setFee(fee1);
        student.setYear(year1);
        student.setCurDate(curDate1);
        info.add(student);
        //}
        
        DatabaseConnection dbc=new DatabaseConnection();
        dbc.getConnection();
        dbc.createTable();
        dbc.InsertUserInfoValues(info);
        
        String NameRet="",CourseRet="",CurDateRet="";
        int i=0,FreRet=0,YearRet=0;
   
         String Name1 = dbc.RetrieveUserInformationValues().get(dbc.UserRetrevialInfo.size()-1).getName();
         String Course1 = dbc.RetrieveUserInformationValues().get(dbc.UserRetrevialInfo.size()-1).getCourse();
         int Fee1 = dbc.RetrieveUserInformationValues().get(dbc.UserRetrevialInfo.size()-1).getFee();
         int Year1 = dbc.RetrieveUserInformationValues().get(dbc.UserRetrevialInfo.size()-1).getYear();
         String CurDate1 = dbc.RetrieveUserInformationValues().get(dbc.UserRetrevialInfo.size()-1).getCurDate();
         dbc.closeConnection();
         
        model.setAttribute("NameRet", Name1);
        model.setAttribute("CourseRet", Course1);
        model.setAttribute("FreRet", Fee1);
        model.setAttribute("YearRet", Year1);
        model.setAttribute("CurDateRet", CurDate1);
       

		
		
		return "success";
	}
	
}