package com.Bank.BPDZ.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "bpdzser",
       indexes = {
           @Index(name = "idx_bpdzser_id_banque", columnList = "banque_id"),
           @Index(name = "idx_bpdzser_typemessage", columnList = "typeMessage")
       })

public class BPDZSer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nomservice",length = 50, nullable = false)
    private String nomService;

    @Column(name="typemessage",length = 10)
    private String typeMessage;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_banque", referencedColumnName = "id", nullable = false,
                foreignKey = @ForeignKey(name = "fk_ser_banque", value = ConstraintMode.CONSTRAINT))
    private BPDZDir banque;

    @PrePersist
    @PreUpdate
    private void validateTypeMessage() {
        if (typeMessage != null && !typeMessage.matches("Pacs\\.008|Pacs\\.009|Pacs\\.003|Pacs\\.004|camt\\.053")) {
            throw new IllegalArgumentException("TypeMessage must be one of: Pacs.008, Pacs.009, Pacs.003, Pacs.004, camt.053");
        }
    }

	public BPDZSer() {
		super();
	}

	public BPDZSer(String nomService, String typeMessage, BPDZDir banque) {
		super();
		this.nomService = nomService;
		this.typeMessage = typeMessage;
		this.banque = banque;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomService() {
		return nomService;
	}

	public void setNomService(String nomService) {
		this.nomService = nomService;
	}

	public String getTypeMessage() {
		return typeMessage;
	}

	public void setTypeMessage(String typeMessage) {
		this.typeMessage = typeMessage;
	}

	public BPDZDir getBanque() {
		return banque;
	}

	public void setBanque(BPDZDir banque) {
		this.banque = banque;
	}
    
    
}
