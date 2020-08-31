package com.seynabou.repository;

import java.util.List;
/**
 * Dao de gestion des événements
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.seynabou.entities.AgentDossierEvenement;

public interface AgentDossierEventRepository extends JpaRepository<AgentDossierEvenement, Long>{
	/**
	 * @param agentId
	 * @return 
	 * la liste des événements d'un agent
	 */
	@Query("select event from AgentDossierEvenement event join event.agentDossier agent where agent.agentDossierId = :agentId")
	public List<AgentDossierEvenement> getListeAgentEvenementsByAgent(@Param("agentId") Long agentId);
}
