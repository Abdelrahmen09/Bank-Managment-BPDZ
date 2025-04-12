package com.Bank.BPDZ.Entity;

import jakarta.persistence.*;


import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "bpdzpret",
       indexes = {
           @Index(name = "idx_bpdzpret_id_banque", columnList = "banque_id"),
           @Index(name = "idx_bpdzpret_id_agent", columnList = "agent_id")
       })

public class BPDZPret {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pret")
    private Long idPret;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_banque", referencedColumnName = "id", nullable = false,
                foreignKey = @ForeignKey(name = "fk_banque_pret", value = ConstraintMode.CONSTRAINT))
    private BPDZDir banque;

    @Column(name = "montantpret",precision = 15, scale = 2, nullable = false)
    private BigDecimal montantPret;

    @Column(name = "datepret",nullable = false)
    private LocalDate datePret;

    @Column(name = "datepriseencharge",nullable = false)
    private LocalDate datePriseEnCharge;

    @ManyToOne
    @JoinColumn(name = "id_agent", referencedColumnName = "id",//ther is no an "ON DELETE SET NULL" in Spring Boot ,so the best practice like that
                foreignKey = @ForeignKey(name = "fk_agent_pret", value = ConstraintMode.CONSTRAINT))
    private BPDZHabi agent;  // Can be null, so no `optional = false`

    
	public BPDZPret() {
		super();
	}

	public BPDZPret(BPDZDir banque, BigDecimal montantPret, LocalDate datePret, LocalDate datePriseEnCharge,
			BPDZHabi agent) {
		super();
		this.banque = banque;
		this.montantPret = montantPret;
		this.datePret = datePret;
		this.datePriseEnCharge = datePriseEnCharge;
		this.agent = agent;
	}

	public Long getIdPret() {
		return idPret;
	}

	public void setIdPret(Long idPret) {
		this.idPret = idPret;
	}

	public BPDZDir getBanque() {
		return banque;
	}

	public void setBanque(BPDZDir banque) {
		this.banque = banque;
	}

	public BigDecimal getMontantPret() {
		return montantPret;
	}

	public void setMontantPret(BigDecimal montantPret) {
		this.montantPret = montantPret;
	}

	public LocalDate getDatePret() {
		return datePret;
	}

	public void setDatePret(LocalDate datePret) {
		this.datePret = datePret;
	}

	public LocalDate getDatePriseEnCharge() {
		return datePriseEnCharge;
	}

	public void setDatePriseEnCharge(LocalDate datePriseEnCharge) {
		this.datePriseEnCharge = datePriseEnCharge;
	}

	public BPDZHabi getAgent() {
		return agent;
	}

	public void setAgent(BPDZHabi agent) {
		this.agent = agent;
	}
    
}

