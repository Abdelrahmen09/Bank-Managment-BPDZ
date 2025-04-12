package com.Bank.BPDZ.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "bpdzhabi",
       indexes = {
           @Index(name = "idx_bpdzhabi_id_banque", columnList = "banque_id"),
           @Index(name = "idx_bpdzhabi_login", columnList = "login")
       })

public class BPDZHabi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Every record must be linked to a Bank
    /*This annotation defines a "many-to-one" relationship, meaning that many instances of the current entity  "Habilitation"
     *  can be associated with one instance of the BPDZDir 
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_banque", referencedColumnName = "id", nullable = false,// ON DELETE CASCADE
    // I named this foreign key for debugging because the name is generated automatically when you don't name it
                foreignKey = @ForeignKey(name = "fk_banque_habi", value = ConstraintMode.CONSTRAINT))
    private BPDZDir banque;

    @Column(length = 80, nullable = false, unique = true)
    private String login;

    @Column(name="motdepasse",length = 80, nullable = false)
    private String motDePasse;

    @Column(name="adresseip",length = 50, nullable = false)
    private String adresseIP;

    @Column(name="portreception",nullable = false)
    private Integer portReception;

    @Column(length = 50)
    private String adresseIPSecours;
    @Column(name="portreceptionsecours")
    private Integer portReceptionSecours;

    @Column(length = 10, nullable = false)
    private String role;

    @Column(columnDefinition = "TEXT")
    private String permissions;

    @PrePersist
    @PreUpdate
    private void validateRole() {
        if (!role.matches("Viewer|Modifier|Admin|User")) {
            throw new IllegalArgumentException("Role must be one of: Viewer, Modifier, Admin, User");
        }
    }
    

	public BPDZHabi() {
		super();
	}


	public BPDZHabi(BPDZDir banque, String login, String motDePasse, String adresseIP, Integer portReception,
			String adresseIPSecours, Integer portReceptionSecours, String role, String permissions) {
		super();
		this.banque = banque;
		this.login = login;
		this.motDePasse = motDePasse;
		this.adresseIP = adresseIP;
		this.portReception = portReception;
		this.adresseIPSecours = adresseIPSecours;
		this.portReceptionSecours = portReceptionSecours;
		this.role = role;
		this.permissions = permissions;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getAdresseIP() {
		return adresseIP;
	}

	public void setAdresseIP(String adresseIP) {
		this.adresseIP = adresseIP;
	}

	public Integer getPortReception() {
		return portReception;
	}

	public void setPortReception(Integer portReception) {
		this.portReception = portReception;
	}

	public String getAdresseIPSecours() {
		return adresseIPSecours;
	}

	public void setAdresseIPSecours(String adresseIPSecours) {
		this.adresseIPSecours = adresseIPSecours;
	}

	public Integer getPortReceptionSecours() {
		return portReceptionSecours;
	}

	public void setPortReceptionSecours(Integer portReceptionSecours) {
		this.portReceptionSecours = portReceptionSecours;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
    
}
