package com.Bank.BPDZ.Entity;

import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
@Table(name = " bpdzpmta",
indexes = {
    @Index(name = "idx_bpdzpmtA_id_mouvement", columnList = "mouvement_id")
})

public class BPDZPmtA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_mouvement", referencedColumnName = "id", nullable = false,
                foreignKey = @ForeignKey(name = "fk_pmta_mouvement", value = ConstraintMode.CONSTRAINT))
    private BPDZmt mouvement;

    @Column(name="fichierpacs",columnDefinition = "TEXT")
    private String fichierPACS;

    @Column(name="datearchivage",nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime dateArchivage;

    @PrePersist
    public void prePersist() {
        if (dateArchivage == null) {
            dateArchivage = LocalDateTime.now();
        }
    }
    

	public BPDZPmtA() {
		super();
	}


	public BPDZPmtA(BPDZmt mouvement, String fichierPACS, LocalDateTime dateArchivage) {
		super();
		this.mouvement = mouvement;
		this.fichierPACS = fichierPACS;
		this.dateArchivage = dateArchivage;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BPDZmt getMouvement() {
		return mouvement;
	}

	public void setMouvement(BPDZmt mouvement) {
		this.mouvement = mouvement;
	}

	public String getFichierPACS() {
		return fichierPACS;
	}

	public void setFichierPACS(String fichierPACS) {
		this.fichierPACS = fichierPACS;
	}

	public LocalDateTime getDateArchivage() {
		return dateArchivage;
	}

	public void setDateArchivage(LocalDateTime dateArchivage) {
		this.dateArchivage = dateArchivage;
	}
    
}
