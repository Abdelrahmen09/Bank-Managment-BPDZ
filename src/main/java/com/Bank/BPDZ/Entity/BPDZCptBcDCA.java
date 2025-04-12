package com.Bank.BPDZ.Entity;





import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = " bpdzcptbcdca",
       indexes = {
           @Index(name = "idx_bpdzcptbcdca_id_banque", columnList = "id_banque"),
           @Index(name = "idx_bpdzcptbcdca_numero_compte", columnList = "numeroCompte")
       })
public class BPDZCptBcDCA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_banque", referencedColumnName = "id", nullable = false, 
                foreignKey = @ForeignKey(name = "fk_banque_cpt", value = ConstraintMode.CONSTRAINT))
    private BPDZDir id_banque;

    @Column(name = "naturecompte", length = 10, nullable = false)
    private String natureCompte;

    @Column(name = "numerocompte", length = 50, nullable = false, unique = true)
    private String numeroCompte;

    @Column(precision = 15, scale = 2, nullable = false)
    private BigDecimal solde;

    @Column(name = "datesolde", nullable = false)
    private LocalDate dateSolde;

    // Validation before persisting or updating the entity
    // this make a methode are excuted automatically during the lifecycle of an entity 
    @PrePersist
    @PreUpdate
    private void validateNatureCompte() {
        if (!natureCompte.equals("Reserve") && !natureCompte.equals("Courant")) {
            throw new IllegalArgumentException("NatureCompte must be either 'Reserve' or 'Courant'");
        }
    }
    

    public BPDZCptBcDCA() {
		super();
	}


	public BPDZCptBcDCA(BPDZDir id_banque, String natureCompte, String numeroCompte, BigDecimal solde,
			LocalDate dateSolde) {
		super();
		this.id_banque = id_banque;
		this.natureCompte = natureCompte;
		this.numeroCompte = numeroCompte;
		this.solde = solde;
		this.dateSolde = dateSolde;
	}


	// Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BPDZDir getId_banque() {
        return id_banque;
    }

    public void setId_banque(BPDZDir id_banque) {
        this.id_banque = id_banque;
    }

    public String getNatureCompte() {
        return natureCompte;
    }

    public void setNatureCompte(String natureCompte) {
        this.natureCompte = natureCompte;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public BigDecimal getSolde() {
        return solde;
    }

    public void setSolde(BigDecimal solde) {
        this.solde = solde;
    }

    public LocalDate getDateSolde() {
        return dateSolde;
    }

    public void setDateSolde(LocalDate dateSolde) {
        this.dateSolde = dateSolde;
    }
}
