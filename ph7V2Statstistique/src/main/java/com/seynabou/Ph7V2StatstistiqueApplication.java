//package com.seynabou;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
//
//import com.seynabou.entities.AgentDossier;
//import com.seynabou.entities.AgentDossierEvenement;
//import com.seynabou.repository.AgentDossierEventRepository;
//import com.seynabou.repository.AgentDossierRepository;
//
//@SpringBootApplication
//public class Ph7V2StatstistiqueApplication {
//
//	public static void main(String[] args) {
//		AgentDossier agent1 = new AgentDossier();
//		agent1.setCodeAgent("C2563654AG2");
//		agent1.setCodeEh("EMBS");
//		agent1.setDateEntree(LocalDate.parse("2002-06-11"));
//		agent1.setMatricule("EMBS01");
//		
//		AgentDossier agent2 = new AgentDossier();
//		agent2.setCodeAgent("C802356B25");
//		agent2.setCodeEh("EMBS");
//		agent2.setDateEntree(LocalDate.parse("2011-01-02"));
//		agent2.setMatricule("EMBS02");
//		
//		AgentDossier agent3 = new AgentDossier();
//		agent3.setCodeAgent("C0236999FI2");
//		agent3.setCodeEh("EMBS");
//		agent3.setDateEntree(LocalDate.parse("2015-03-11"));
//		agent3.setMatricule("EMBS03");
//		
//		AgentDossierEvenement evenement1 = new AgentDossierEvenement();
//		evenement1.setNature("EVP");
//		evenement1.setType("INS");
//		evenement1.setDateDebut(LocalDate.parse("2016-03-13"));
//		evenement1.setDateFin(LocalDate.parse("2016-05-23"));
//		evenement1.setAgentDossier(agent1);
//		evenement1.setAgentDossier(agent2);
//		
//		AgentDossierEvenement evenement2 = new AgentDossierEvenement();
//		evenement2.setNature("EVP");
//		evenement2.setType("INS");
//		evenement2.setDateDebut(LocalDate.parse("2017-07-08"));
//		evenement2.setDateFin(LocalDate.parse("2017-11-11"));
//		evenement2.setAgentDossier(agent1);
//		evenement2.setAgentDossier(agent3);
//		ApplicationContext context = SpringApplication.run(Ph7V2StatstistiqueApplication.class, args);
//		AgentDossierRepository agentRepository = context.getBean(AgentDossierRepository.class);
//		AgentDossierEventRepository eventRepository = context.getBean(AgentDossierEventRepository.class);
//
//		agentRepository.save(agent1);
//		agentRepository.save(agent2);
//		agentRepository.save(agent3);
//		List<AgentDossier> listeAgents = agentRepository.findAll();
//		for(AgentDossier agent:listeAgents) {
//			System.out.println(agent.getCodeAgent());
//		}
//		eventRepository.save(evenement1);
//		eventRepository.save(evenement2);
//		List<AgentDossierEvenement> listeEvents = eventRepository.findAll();
//		for(AgentDossierEvenement event:listeEvents) {
//			System.out.println(event.getNature());
//		}	
//	}
//}
