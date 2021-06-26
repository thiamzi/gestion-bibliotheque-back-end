package sn.thies.ut.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.thies.ut.modeles.Agent;
import sn.thies.ut.service.AgentService;
import sn.thies.ut.service.UserService;

@RestController
@RequestMapping("/api")
public class AgentController {

	private final AgentService agentService;
	private final UserService userService;

	public AgentController(AgentService agentService , UserService userService) {
		this.agentService = agentService;
		this.userService = userService;
	}
	
	@GetMapping("/allagents")
	public ResponseEntity<List<Agent>> getAllagents(){
		List<Agent> agents = agentService.getAllAgent();
		return new ResponseEntity<List<Agent>>(agents , HttpStatus.OK);
	}
	
	@GetMapping("/oneagent/{id}")
	public ResponseEntity<Agent> findOneaagent(@PathVariable Integer id){
		Agent agent = agentService.findOneAgent(id);
		return new ResponseEntity<Agent>(agent , HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteagent/{id}")
	public ResponseEntity<Agent> deleteagent(@PathVariable Integer id){
		agentService.deleteAgent(id);
		userService.deleteUser(id);
		return new ResponseEntity<Agent>(HttpStatus.OK);
	}
	
	@PostMapping("/addagent")
	public 	ResponseEntity<Agent> addagent(@RequestBody Agent agent){
		Agent newagent = agentService.addAgent(agent);
		return new ResponseEntity<Agent>(newagent , HttpStatus.OK);
	}

	@PutMapping("/updateagent")
	public 	ResponseEntity<Agent> updateagent(@RequestBody Agent agent){
		Agent updateagent = agentService.updateAgent(agent);
		return new ResponseEntity<Agent>(updateagent , HttpStatus.OK);
	}
}
