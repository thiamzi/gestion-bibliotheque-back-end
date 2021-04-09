package sn.thies.ut.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.thies.ut.modeles.Agent;
import sn.thies.ut.repository.AgentRepository;

@Service
public class AgentService {

	private final AgentRepository agentrepository;
	@Autowired
	public AgentService(AgentRepository agentrepository) {
		this.agentrepository = agentrepository;
	}
	
	public Agent addAgent(Agent agent) {
		return this.agentrepository.save(agent);
	}
	
	public List<Agent> getAllAgent(){
		return this.agentrepository.findAll();
	}
	
	public void deleteAgent(Integer id) {
		this.agentrepository.deleteById(id);
	}
	
	public Agent findOneAgent(Integer id) {
		return this.agentrepository.findById(id).get();
	}
	
	public Agent updateAgent(Agent agent) {
		return this.agentrepository.save(agent);
		
	}
}
