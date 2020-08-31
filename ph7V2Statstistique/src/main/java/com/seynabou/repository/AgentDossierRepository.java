package com.seynabou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.seynabou.entities.AgentDossier;

/**
 * DAO de gestion des agentDossiers 
 */
public interface AgentDossierRepository extends JpaRepository<AgentDossier, Long>{
/**
 * 
 * @return le nombre d'agent de l'établissement hospitalier 
 */
	@Query("SELECT COUNT(agent.agentDossierId) FROM AgentDossier agent" )	
	public int nbAgentDossier();
}
