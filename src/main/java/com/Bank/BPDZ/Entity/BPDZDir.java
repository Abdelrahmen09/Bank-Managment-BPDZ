package com.Bank.BPDZ.Entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.*;


@Entity
@Table(name = "bpdzdir", 
       indexes = {
           @Index(name = "idx_bpdzdir_codebanque", columnList = "codeBanque"),
           @Index(name = "idx_bpdzdir_bic", columnList = "bic"),
           @Index(name = "idx_bpdzdir_nombanque", columnList = "nomBanque")
       })
@Component
public class BPDZDir {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombanque", length = 50, nullable = false)
    private String nomBanque;

    @Column(name = "codebanque", length = 50, nullable = false, unique = true)
    private String codeBanque;

    @Column(name = "bic", length = 50, nullable = false, unique = true)
    private String bic;

    @Column(columnDefinition = "TEXT")
    private String adresse;

    @Column(nullable = false)
    private Boolean participante = true;

    @Column(name = "iso20022integration", length = 1, nullable = false)
    private String iso20022Integration = "N";

    @Column(length = 2, nullable = false)
    private String abonnement;

    @PrePersist
    @PreUpdate
    private void validate() {
        if (!iso20022Integration.equals("O") && !iso20022Integration.equals("N")) {
            throw new IllegalArgumentException("ISO20022integration must be 'O' or 'N'");
        }
        if (!abonnement.matches("P[1-4]")) {
            throw new IllegalArgumentException("Abonnement must be one of: P1, P2, P3, P4");
        }
    }

	public BPDZDir() {
		super();
	}

	public BPDZDir(String nomBanque, String codeBanque, String bic, String adresse, Boolean participante,
			String iso20022Integration, String abonnement) {
		super();
		this.nomBanque = nomBanque;
		this.codeBanque = codeBanque;
		this.bic = bic;
		this.adresse = adresse;
		this.participante = participante;
		this.iso20022Integration = iso20022Integration;
		this.abonnement = abonnement;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomBanque() {
		return nomBanque;
	}

	public void setNomBanque(String nomBanque) {
		this.nomBanque = nomBanque;
	}

	public String getCodeBanque() {
		return codeBanque;
	}

	public void setCodeBanque(String codeBanque) {
		this.codeBanque = codeBanque;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Boolean getParticipante() {
		return participante;
	}

	public void setParticipante(Boolean participante) {
		this.participante = participante;
	}

	public String getIso20022Integration() {
		return iso20022Integration;
	}

	public void setIso20022Integration(String iso20022Integration) {
		this.iso20022Integration = iso20022Integration;
	}

	public String getAbonnement() {
		return abonnement;
	}

	public void setAbonnement(String abonnement) {
		this.abonnement = abonnement;
	}
    
}
