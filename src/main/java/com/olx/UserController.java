package com.olx;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
public class UserController {

	@PostMapping(path="/user/authenticate",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> authenticate(@RequestBody User user) {
		user.setId("48397");
		return  new ResponseEntity<String>("abcd",HttpStatus.OK);
	}
	
	@DeleteMapping(path="/user/logout",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> logout(@RequestHeader("auth-token") String authtoken) {
		if(authtoken.equalsIgnoreCase("abcd")) {
		return  new ResponseEntity<Boolean>(true,HttpStatus.OK);
		}else {
			return  new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);	
		}
	}
	
	@PostMapping(path="/user",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		user.setId("48397");
		user.setFirstName("Soma");
		return  new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@GetMapping(path="/user",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserDetails(@RequestHeader("auth-token") String authtoken) {
		User user = new User(); 
		user.setId("48397");
		user.setFirstName("Soma");
		user.setLastname("Ghosh");
		user.setPhoneNumber("9850889219");
		return  new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
}
