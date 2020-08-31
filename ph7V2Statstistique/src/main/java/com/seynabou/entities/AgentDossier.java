package com.seynabou.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "T_AGENT")
/** 
 * @author Seynabou Mbaye
 * 
 * Agent représenté par la classe AgentDossier
 */
public class AgentDossier implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AGENT_DOSSIER_ID")
	private Long agentDossierId;
	private String codeAgent;
	private String codeEh;
	private String matricule;
	//liste des évenements d'un agent
	@OneToMany(mappedBy = "agentDossier", fetch = FetchType.LAZY)
	private Collection<AgentDossierEvenement> listeAgentDossierEvenement;
	private LocalDate dateEntree;
	private LocalDate dateSortie;

	public AgentDossier() {
		super();
	}

	public AgentDossier(String codeAgent, String codeEh, String matricule, LocalDate dateEntree, LocalDate dateSortie) {
		super();
		this.codeAgent = codeAgent;
		this.codeEh = codeEh;
		this.matricule = matricule;
		this.dateEntree = dateEntree;
		this.dateSortie = dateSortie;
	}

	@JsonIgnore
	public Collection<AgentDossierEvenement> getListeAgentDossierEvenement() {
		return listeAgentDossierEvenement;
	}

	public void setListeAgentDossierEvenement(Collection<AgentDossierEvenement> listeAgentDossierEvenement) {
		this.listeAgentDossierEvenement = listeAgentDossierEvenement;
	}

	public Long getAgentDossierId() {
		return agentDossierId;
	}

	public void setAgentDossierId(Long agentDossierId) {
		this.agentDossierId = agentDossierId;
	}

	public String getCodeAgent() {
		return codeAgent;
	}

	public void setCodeAgent(String codeAgent) {
		this.codeAgent = codeAgent;
	}

	public String getCodeEh() {
		return codeEh;
	}

	public void setCodeEh(String codeEh) {
		this.codeEh = codeEh;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public LocalDate getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(LocalDate dateEntree) {
		this.dateEntree = dateEntree;
	}

	public LocalDate getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(LocalDate dateSortie) {
		this.dateSortie = dateSortie;
	}

}
