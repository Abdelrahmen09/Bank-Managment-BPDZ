package com.Bank.BPDZ.Entity;

import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
@Table(name = "bpdzfraude",
       indexes = {
           @Index(name = "idx_bpdzfraude_information_interdite", columnList = "informationInterdite")
       })

public class BPDZFraude {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_mouvement", referencedColumnName = "id", nullable = false,
                foreignKey = @ForeignKey(name = "fk_fraude_mouvement", value = ConstraintMode.CONSTRAINT))
    private BPDZmt mouvement;

    @Column(name="informationinterdite",length = 50, unique = true, nullable = false)
    private String informationInterdite; // Bank Name, BIC, or Country

    @Column(length = 500)
    private String raison;

    @Column(name="dateinterdiction",nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate dateInterdiction;

    @PrePersist
    @PreUpdate
    private void validateDateInterdiction() {
        if (dateInterdiction == null) {
            dateInterdiction = LocalDate.now();  // Ensures dateInterdiction is set if not already provided
        }
    }
}
