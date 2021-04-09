package sn.thies.ut.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import email.EmailModel;
import email.EmailService;
import sn.thies.ut.modeles.UserDTO;
import sn.thies.ut.modeles.UserModel;
import sn.thies.ut.service.UserService;
import sn.thies.ut.springSecurity.AuthenticationRequest;
import sn.thies.ut.springSecurity.AuthenticationResponse;
import sn.thies.ut.springSecurity.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;



@RestController
@RequestMapping("/api")
public class UserController {

	private final UserService userService;
	
	private final EmailService emailService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	public UserController(UserService userService , EmailService emailService) {
		super();
		this.userService = userService;
		this.emailService = emailService;
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getEmail(), authenticationRequest.getPassword()));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		}
		catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		
		UserDetails userdetails = userService.loadUserByUsername(authenticationRequest.getEmail());
		String token = jwtUtil.generateToken(userdetails);
		return ResponseEntity.ok(new AuthenticationResponse(token));
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
		return ResponseEntity.ok(userService.save(user));
	}

	@GetMapping("/allusers")
	public ResponseEntity<List<UserModel>> getAllrvs(){
		List<UserModel> etudiants = userService.getAllUser();
		return new ResponseEntity<List<UserModel>>(etudiants , HttpStatus.OK);
	}
	
		
	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<UserModel> deleteuser(@PathVariable Integer id){
		userService.deleteUser(id);
		return new ResponseEntity<UserModel>(HttpStatus.OK);
	}
	@PutMapping("/updateuser")
	public 	ResponseEntity<UserModel> updateuser(@RequestBody UserModel userModel){
		UserModel updateuser = userService.updateUser(userModel);
		return new ResponseEntity<UserModel>(updateuser , HttpStatus.OK);
	}
	
	@GetMapping("/oneuser/{email}")
	public ResponseEntity<UserModel> deleteuser(@PathVariable String email){
		UserModel updateuser = userService.findOneUser(email);
		return new ResponseEntity<UserModel>(updateuser ,HttpStatus.OK);
	}
	
	@PutMapping("/updatepassword")
	public 	ResponseEntity<UserModel> updatepassword(@RequestBody UserModel userModel){
		UserModel updateuser = userService.updatePasswod(userModel);
		return new ResponseEntity<UserModel>(updateuser , HttpStatus.OK);
	}
	
	@PostMapping("/emailetudiant")
	public ResponseEntity<EmailModel> sendMailEtudiant(@RequestBody EmailModel user) throws MessagingException{
				this.emailService.sendEmailEtudiant(user);
				return new ResponseEntity<EmailModel>(user , HttpStatus.OK);
	}
	
	@PostMapping("/emailagent")
	public ResponseEntity<EmailModel> sendMailAgent(@RequestBody EmailModel user) throws MessagingException{
				this.emailService.sendEmailAgent(user);
				return new ResponseEntity<EmailModel>(user , HttpStatus.OK);
	}
	
	@PostMapping("/emaillivre")
	public ResponseEntity<EmailModel> sendMailForLivre(@RequestBody EmailModel user) throws MessagingException{
				this.emailService.sendEmailForLivre(user);
				return new ResponseEntity<EmailModel>(user , HttpStatus.OK);
	}
	
}


