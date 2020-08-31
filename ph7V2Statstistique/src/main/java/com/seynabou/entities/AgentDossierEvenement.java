package com.seynabou.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="T_EVENEMENT")
/** 
 * @author Seynabou Mbaye
 * 
 * AgentDossierEvenement représentant un événement
 */
public class AgentDossierEvenement implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAgentDosEvt;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private String nature;
	private String type;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="AGENT_DOSSIER_ID")
	private AgentDossier agentDossier;


	public Long getIdAgentDosEvt() {
		return idAgentDosEvt;
	}
	public void setIdAgentDosEvt(Long idAgentDosEvt) {
		this.idAgentDosEvt = idAgentDosEvt;
	}
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	public LocalDate getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	public String getNature() {
		return nature;
	}
	public void setNature(String nature) {
		this.nature = nature;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public AgentDossier getAgentDossier() {
		return agentDossier;
	}
	public void setAgentDossier(AgentDossier agentDossier) {
		this.agentDossier = agentDossier;
	}
	public AgentDossierEvenement(LocalDate dateDebut, LocalDate dateFin, LocalDate horodatagePriseEnCompte,
			LocalDate horodatageReception, String nature, String type) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.nature = nature;
		this.type = type;
	}
	public AgentDossierEvenement() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
