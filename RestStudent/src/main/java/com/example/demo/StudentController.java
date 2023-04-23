package com.example.demo;

import java.util.HashMap;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class StudentController {
	
	private static Map<String,Student>
	studentRepo=new HashMap<String,Student>();
	static {
		Student aditya=new Student("1","Aditya");
		studentRepo.put(aditya.getId(),aditya);
		
		Student aishu=new Student("2","Aishu");
		studentRepo.put(aishu.getId(),aishu);
		
		Student vishu=new Student("3","Vishu");
		studentRepo.put(vishu.getId(),vishu);
		
		Student nisha=new Student("2","Nisha");
		studentRepo.put(nisha.getId(),nisha);
		
		Student shubh=new Student("2","Shubh");
		studentRepo.put(shubh.getId(),shubh);
		
	}
	
	@RequestMapping("student")
	public ResponseEntity<Object>showll()
	{
		return new ResponseEntity<Object>(studentRepo.values(),HttpStatus.OK);
		
	}
	
	@RequestMapping(value="student/{id}",method=RequestMethod.GET)
	public ResponseEntity<Object>showll1(@PathVariable("id")String id)
{
		return new ResponseEntity<Object>(studentRepo.get(id),HttpStatus.OK);
	
}
	
	
	
	@RequestMapping(value="/student/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Object>delstud(@PathVariable("id")String id)
{
		studentRepo.remove(id);
		return new ResponseEntity<Object>("Student Deleted..",HttpStatus.OK);
	
}
	
	@RequestMapping(value="/student/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Object>updateStud(@PathVariable("id")String id,@RequestBody Student p)
{
		studentRepo.remove(id);
		p.setId(id);
		studentRepo.put(id, p);
		return new ResponseEntity<Object>("Student Updated...",HttpStatus.OK);
	
}
	
	@RequestMapping(value="/student",method=RequestMethod.POST)
	public ResponseEntity<Object>addstud(@RequestBody Student p)
{
		studentRepo.put(p.getId(),p);
		return new ResponseEntity<Object>("Student Added...",HttpStatus.CREATED);
	
}
	
	
	


}

