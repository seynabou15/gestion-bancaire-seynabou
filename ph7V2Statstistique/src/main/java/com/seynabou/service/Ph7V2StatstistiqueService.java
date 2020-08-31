package com.seynabou.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.seynabou.entities.AgentDossier;
import com.seynabou.entities.AgentDossierEvenement;
import com.seynabou.repository.AgentDossierEventRepository;
import com.seynabou.repository.AgentDossierRepository;

@RestController
public class Ph7V2StatstistiqueService {
	@Autowired
	private AgentDossierRepository agentRepository ;
	
	@Autowired
	private AgentDossierEventRepository eventRepository ;
	
	@RequestMapping(value="/agentDossiers",method = RequestMethod.GET)
	public List<AgentDossier> getListeAgents(){
		return agentRepository.findAll();
	}
	
	@RequestMapping(value="/nbAgentDossiers",method = RequestMethod.GET)
	public int nbAgentDossier(){
		return agentRepository.nbAgentDossier();
	}
	
	@RequestMapping(value="/saveAgent",method = RequestMethod.POST) 
	public AgentDossier saveAgentDossier(@RequestBody AgentDossier agent){ 
		 return agentRepository.save(agent);
 
	}
	@RequestMapping(value="/agentDossiers/{id}",method = RequestMethod.GET) 
	public AgentDossier getAgentDossierById(@PathVariable("id")Long agentDossierId){ 
	
		 return agentRepository.findOne(agentDossierId) ; 
	}

	@RequestMapping(value="/agentDossiers/{id}",method = RequestMethod.PUT ) 
	public AgentDossier updateAgentDossier(AgentDossier agent,@PathVariable("id")Long agentDossierId){
		
		agent.setAgentDossierId(agentDossierId);
	
		 return agentRepository.saveAndFlush(agent) ; 
	}
	
	@RequestMapping(value="/agentDossiers/{id}",method = RequestMethod.DELETE ) 
	public void deleteAgentDossier(@PathVariable("id")Long agentDossierId){
		
	 agentRepository.delete(agentDossierId); 
	}
	
	@RequestMapping(value="/agentEvenements",method = RequestMethod.GET)
	public List<AgentDossierEvenement> getListeAgentEvenements(){
		return eventRepository.findAll();
	}
	@RequestMapping(value="/agentEvenements/{id}",method = RequestMethod.GET)
	public List<AgentDossierEvenement> getListeAgentEvenementsByAgent(@PathVariable("id") Long agentDossierId){
		return eventRepository.getListeAgentEvenementsByAgent(agentDossierId);
	}
	@RequestMapping(value="/saveEvent",method = RequestMethod.POST) 
	public AgentDossierEvenement saveAgentEvenement(@RequestBody AgentDossierEvenement evenement){ 
			
		return eventRepository.save(evenement);

	}

	@RequestMapping(value="/nbreMoisByEvent/{id}",method = RequestMethod.GET)
	public long getNbreMoisRetroActifByEvent(@PathVariable("id") Long eventId ){
		AgentDossierEvenement event = eventRepository.findOne(eventId);
		long nbreMoisRetro = getNbreMonths(event.getDateDebut(), event.getDateFin());
		return nbreMoisRetro;
	}
	@RequestMapping(value="/nbreMoisByAgent/{id}",method = RequestMethod.GET)
	public long getNbreMoisRetroActifByAgent(@PathVariable("id") Long agentId ){
		long nbreMoisByAgent =0;
		AgentDossier agent = agentRepository.findOne(agentId);
		Collection<AgentDossierEvenement> listeEvenements = agent.getListeAgentDossierEvenement();
		for(AgentDossierEvenement evenement :listeEvenements) {
			long nbMoisByEvent =this.getNbreMoisRetroActifByEvent(evenement.getIdAgentDosEvt());
			nbreMoisByAgent += nbMoisByEvent;
		}
		return nbreMoisByAgent;
	}
	
	@RequestMapping(value="/nbreMoisTotal",method = RequestMethod.GET)
	public long getNbreMoisRetroActifTotalEH(){
		long nbreMoisTotalEH =0;
		List<AgentDossier> listeTotalAgent= agentRepository.findAll();
		for(AgentDossier agent :listeTotalAgent) {
			long nbreMoisByAgent =this.getNbreMoisRetroActifByAgent(agent.getAgentDossierId());
			nbreMoisTotalEH += nbreMoisByAgent;
		}
		return nbreMoisTotalEH;
	}
	@RequestMapping(value="/nbreTotalAgent",method = RequestMethod.GET)
	public int getNbreAgentTotalEH(){

		return agentRepository.nbAgentDossier();
	}
	
	@RequestMapping(value="/moyenneMois",method = RequestMethod.GET)
	public long getMoyenneMoisRetroActifEH(){
		long nbreMoisTotalEH =this.getNbreMoisRetroActifTotalEH();
		int nbreAgentTotal = this.getNbreAgentTotalEH();
		long moyenneMoisRetroActivite = nbreMoisTotalEH/nbreAgentTotal;
		return moyenneMoisRetroActivite;
	}
	@SuppressWarnings("unused")
	private static long getNbreMonths(LocalDate dDebut,LocalDate dFin) {
		
		long diffMounths = ChronoUnit.MONTHS.between(dDebut, dFin);
		return diffMounths;
//		Period didd = Period.between(dDebut, dFin);
//
//		return didd.getMonths();
		
	}
////TODO à supprimer
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/categories")
	@RequestMapping(value="/categories",method = RequestMethod.GET)
	public List<AgentDossierEvenement> getListeCat(){
		return eventRepository.findAll();
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/produits")
	@RequestMapping(value="/produits/{id}",method = RequestMethod.GET)
	public List<AgentDossierEvenement> getListeProduitsByCAt(@PathVariable("id") Long idAgentDosEvt){
		return eventRepository.getListeAgentEvenementsByAgent(idAgentDosEvt);
	}
}
