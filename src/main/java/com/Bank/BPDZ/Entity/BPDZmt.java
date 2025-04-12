package com.Bank.BPDZ.Entity;

import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "bpdzmt",
       indexes = {
           @Index(name = "idx_bpdzmt_id_banque", columnList = "banque_id"),
           @Index(name = "idx_bpdzmt_typemessage", columnList = "typeMessage"),
           @Index(name = "idx_bpdzmt_modetransmission", columnList = "modeTransmission")
       })

public class BPDZmt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="transmisrecu",length = 1, nullable = false)
    private String transmisRecu;

    @Column(name="statutmouvement",length = 100, nullable = false)
    private String statutMouvement;

    @Column(name="naturemouvement",length = 100, nullable = false)
    private String natureMouvement;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_banque", referencedColumnName = "id", nullable = false,
                foreignKey = @ForeignKey(name = "fk_banque_mt", value = ConstraintMode.CONSTRAINT))
    private BPDZDir banque;

    @Column(name="typemessage",length = 10, nullable = false)
    private String typeMessage;

    @Column(name="informationsmessage",columnDefinition = "TEXT")
    private String informationsMessage;

    @Column(name="modetransmission",length = 10)
    private String modeTransmission;

    @Column(name="xmlfile",columnDefinition = "TEXT")
    private String xmlFile;
    @Column(name="datesend")
    private LocalDateTime dateSend;
    @Column(name="datereceived")
    private LocalDateTime dateReceived;

    @PrePersist
    @PreUpdate
    private void validateFields() {
        if (!transmisRecu.matches("S|R")) {
            throw new IllegalArgumentException("TransmisRecu must be 'S' or 'R'");
        }
        if (!typeMessage.matches("Pacs\\.008|Pacs\\.009|Pacs\\.003|Pacs\\.004|camt\\.053")) {
            throw new IllegalArgumentException("TypeMessage must be one of: Pacs.008, Pacs.009, Pacs.003, Pacs.004, camt.053");
        }
        if (modeTransmission != null && !modeTransmission.matches("RTGS|CLRG|DNS")) {
            throw new IllegalArgumentException("ModeTransmission must be 'RTGS', 'CLRG', or 'DNS'");
        }
    }
    

	public BPDZmt() {
		super();
	}


	public BPDZmt(String transmisRecu, String statutMouvement, String natureMouvement, BPDZDir banque,
			String typeMessage, String informationsMessage, String modeTransmission, String xmlFile,
			LocalDateTime dateSend, LocalDateTime dateReceived) {
		super();
		this.transmisRecu = transmisRecu;
		this.statutMouvement = statutMouvement;
		this.natureMouvement = natureMouvement;
		this.banque = banque;
		this.typeMessage = typeMessage;
		this.informationsMessage = informationsMessage;
		this.modeTransmission = modeTransmission;
		this.xmlFile = xmlFile;
		this.dateSend = dateSend;
		this.dateReceived = dateReceived;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTransmisRecu() {
		return transmisRecu;
	}

	public void setTransmisRecu(String transmisRecu) {
		this.transmisRecu = transmisRecu;
	}

	public String getStatutMouvement() {
		return statutMouvement;
	}

	public void setStatutMouvement(String statutMouvement) {
		this.statutMouvement = statutMouvement;
	}

	public String getNatureMouvement() {
		return natureMouvement;
	}

	public void setNatureMouvement(String natureMouvement) {
		this.natureMouvement = natureMouvement;
	}

	public BPDZDir getBanque() {
		return banque;
	}

	public void setBanque(BPDZDir banque) {
		this.banque = banque;
	}

	public String getTypeMessage() {
		return typeMessage;
	}

	public void setTypeMessage(String typeMessage) {
		this.typeMessage = typeMessage;
	}

	public String getInformationsMessage() {
		return informationsMessage;
	}

	public void setInformationsMessage(String informationsMessage) {
		this.informationsMessage = informationsMessage;
	}

	public String getModeTransmission() {
		return modeTransmission;
	}

	public void setModeTransmission(String modeTransmission) {
		this.modeTransmission = modeTransmission;
	}

	public String getXmlFile() {
		return xmlFile;
	}

	public void setXmlFile(String xmlFile) {
		this.xmlFile = xmlFile;
	}

	public LocalDateTime getDateSend() {
		return dateSend;
	}

	public void setDateSend(LocalDateTime dateSend) {
		this.dateSend = dateSend;
	}

	public LocalDateTime getDateReceived() {
		return dateReceived;
	}

	public void setDateReceived(LocalDateTime dateReceived) {
		this.dateReceived = dateReceived;
	}
    
}

