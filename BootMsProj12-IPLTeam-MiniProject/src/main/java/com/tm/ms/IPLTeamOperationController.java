package com.tm.ms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tm.entity.IPLTeam;
import com.tm.service.IPLTeamMgmtService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/team-api")
@Slf4j
public class IPLTeamOperationController {

	@Autowired
	private IPLTeamMgmtService iplService;
	
	// save ipl team operation
	@PostMapping("/register")
	public ResponseEntity<String> gegisterTeam(@RequestBody IPLTeam team){

			// use service
			String saveTeam = iplService.registerIPLTeam(team);
			return new ResponseEntity<String>(saveTeam,HttpStatus.CREATED);
	}
	
	// get all ipl team operation
	@GetMapping("/all")
	public ResponseEntity<List<IPLTeam>> getAllIplTeam(){
			// use service
			List<IPLTeam> allTemas = iplService.getAllTemas();
			log.error("showAllTeams() method controller");
		    return new ResponseEntity<List<IPLTeam>>(allTemas,HttpStatus.OK);
	}
	
	// get ipl team by id
	@GetMapping("/find/{id}")
	public ResponseEntity<IPLTeam> showTeamById(@PathVariable("id") int id){
		
	    // use service
		IPLTeam teamById = iplService.getTeamById(id);
		log.error("showTeamById() method controller");
		return new ResponseEntity<IPLTeam>(teamById,HttpStatus.OK);
	}
}




