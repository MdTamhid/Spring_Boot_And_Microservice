package com.tm.ms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tm.cliecnt.IPLTeamServiceMSClient;
import com.tm.entity.IPLPlayer;
import com.tm.entity.IPLTeam;
import com.tm.service.IPLPlayerMgmtService;

@RestController
@RequestMapping("/player-api")
public class IPLPlayerOperationConroller {
	
	@Autowired
	private IPLPlayerMgmtService iplService;
	
	@Autowired
	private IPLTeamServiceMSClient client;
	
	@PostMapping("/save")
    public ResponseEntity<String> registerPlayer(@RequestBody IPLPlayer player){
		// get players team id
		int tid = player.getTeam().getTeamId();
		// get IPL Team object from target MS (IPL Team MS)
		IPLTeam team=client.getTeamById(tid); // (MicroService Intra communication)
		// set team object to player object
		player.setTeam(team);
		// use service to save player and his team information
		String msg= iplService.registerPlayer(player);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<IPLPlayer>> showAllPlayer(){
		
		List<IPLPlayer> list = iplService.findAllPlayers();
		return new ResponseEntity<List<IPLPlayer>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<IPLPlayer> showPlayerById(@PathVariable int id){
		
		// use service
		IPLPlayer playerById = iplService.findPlayerById(id);
		return new ResponseEntity<IPLPlayer>(playerById,HttpStatus.OK);
	}// method
	
}





