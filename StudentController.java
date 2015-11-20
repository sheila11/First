package hello;

import hello.models.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;



@RestController
public class StudentController {
	
private List<Student> studenti = new ArrayList<Student>();

StudentController()
 
{

	 Student s1=new Student(1,"Ion","Automatica","331");
     Student s2=new Student(2,"Adriana","Matematica","312");
     Student s3=new Student(3,"Alexandra","Medicina","331");


    studenti.add(s1);
    studenti.add(s2);
    studenti.add(s3);
  
  
 
  }


  @RequestMapping(value="/student", method = RequestMethod.GET)
   public List<Student> index() {
  return this.studenti;
}


//Metoda GET//

 @RequestMapping(value="/student/{Id}", method = RequestMethod.GET)
 public ResponseEntity show(@PathVariable("Id") int Id) {
  for(Student s : this.studenti) {
    if(s.getId() == Id) {
      return new ResponseEntity<Student>(s, new HttpHeaders(), HttpStatus.OK);
      }
	  
	  }
	  
	  return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
	  
  }
  
  @RequestMapping(value="/student/{Nume}", method = RequestMethod.GET)
  public ResponseEntity show1(@PathVariable("Nume") String Nume) {
    for(Student s : this.studenti) {
      if(s.getName().equals(Nume)) {
        return new ResponseEntity<Student>(s, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
     
  }
  
  

  @RequestMapping(value="/student/{Facultate}", method = RequestMethod.GET)
  public ResponseEntity show2(@PathVariable("Facultate") String Facultate) {
    for(Student s : this.studenti) {
      if(s.getFacultate().equals(Facultate)) {
        return new ResponseEntity<Student>(s, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
    
 }
    @RequestMapping(value="/student/{Grupa}", method = RequestMethod.GET)
    public ResponseEntity show3(@PathVariable("Grupa") String Grupa) {
      for(Student s : this.studenti) {
        if(s.getGrupa().equals(Grupa)) {
          return new ResponseEntity<Student>(s, new HttpHeaders(), HttpStatus.OK);
        }
      }
      return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
      
	  }
    
    //Metoda PUT//
    
    
      @RequestMapping(value="/student/{Id}/{Nume}/{Facultate}/{Grupa}", method = RequestMethod.PUT)
      public ResponseEntity update(@PathVariable("Id") int Id,
								  @PathVariable("Nume") String Nume,
								  @PathVariable("Facultate") String Facultate,
								  @PathVariable("Grupa") String Grupa) {
        for(Student s : this.studenti) {
          if(s.getId() == Id) {
          	s.setName(Nume);
			s.setFacultate(Facultate);
			s.setGrupa(Grupa);
          
		  
		  return new ResponseEntity<Student>(s, new HttpHeaders(), HttpStatus.OK);
		  }
            
          }
		  
		  return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
        }
          
  
  	//Metoda POST//
 
  @RequestMapping(value="/student", method = RequestMethod.POST)
  	public ResponseEntity create() {
	 Student s4=new Student(4,"Paulina","Poli","331AA");
	 studenti.add(s4);
   
       return new ResponseEntity<Student>(s4, new HttpHeaders(), HttpStatus.OK);
     }

 
 
    
   //Metoda DELETE//
      
   @RequestMapping(value="/student/{Id}", method = RequestMethod.DELETE)
   public ResponseEntity remove(@PathVariable("Id") int Id) {
     for(Student s : this.studenti) {
       if(s.getId() == Id) {
         this.studenti.remove(s);
         return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
       }
     }
     return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
   }

}   
      
      
   
 
      
   
   