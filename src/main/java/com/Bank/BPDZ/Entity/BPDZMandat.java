package com.Bank.BPDZ.Entity;

import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
@Table(name = "bpdzmandat",
       indexes = {
           @Index(name = "idx_bpdzmandat_id_banque", columnList = "banque_id"),
           @Index(name = "idx_bpdzmandat_id_compte", columnList = "compte_id"),
           @Index(name = "idx_bpdzmandat_id_mouvement", columnList = "mouvement_id")
       })

public class BPDZMandat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_banque", referencedColumnName = "id", nullable = false,
                foreignKey = @ForeignKey(name = "fk_mandat_banque", value = ConstraintMode.CONSTRAINT))
    private BPDZDir banque;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idcompte", referencedColumnName = "id", nullable = false,
                foreignKey = @ForeignKey(name = "fk_mandat_compte", value = ConstraintMode.CONSTRAINT))
    private BPDZCptBcDCA compte;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_mouvement", referencedColumnName = "id", nullable = false,
                foreignKey = @ForeignKey(name = "fk_mandat_mouvement", value = ConstraintMode.CONSTRAINT))
    private BPDZmt mouvement;

    @Column(name="datemandat",nullable = false)
    private LocalDate dateMandat;
    

	public BPDZMandat() {
		super();
	}

	public BPDZMandat(BPDZDir banque, BPDZCptBcDCA compte, BPDZmt mouvement, LocalDate dateMandat) {
		super();
		this.banque = banque;
		this.compte = compte;
		this.mouvement = mouvement;
		this.dateMandat = dateMandat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BPDZDir getBanque() {
		return banque;
	}

	public void setBanque(BPDZDir banque) {
		this.banque = banque;
	}

	public BPDZCptBcDCA getCompte() {
		return compte;
	}

	public void setCompte(BPDZCptBcDCA compte) {
		this.compte = compte;
	}

	public BPDZmt getMouvement() {
		return mouvement;
	}

	public void setMouvement(BPDZmt mouvement) {
		this.mouvement = mouvement;
	}

	public LocalDate getDateMandat() {
		return dateMandat;
	}

	public void setDateMandat(LocalDate dateMandat) {
		this.dateMandat = dateMandat;
	}
    
}
