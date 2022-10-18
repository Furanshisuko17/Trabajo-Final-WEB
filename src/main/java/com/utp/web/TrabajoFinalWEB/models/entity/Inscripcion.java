package com.utp.web.TrabajoFinalWEB.models.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "inscripcion")
public class Inscripcion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInscripcion;
    
    @NotNull
    @OneToOne
    @JoinColumn(nullable = false, unique = true, name = "idPlan", referencedColumnName = "idPlan")
    private Plan plan;
    
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, unique = true, name = "idCliente", referencedColumnName = "idCliente")
    private Cliente cliente;
    
    @NotNull
    @OneToOne
    @JoinColumn(nullable = false, unique = true, name = "idSede", referencedColumnName = "idSede")
    private Sede sede;
    
    @NotNull
    @Column(nullable = false, columnDefinition = "string default 'Activo'")
    private String estado;
    
    @NotNull
    @Column(nullable = false, insertable = false, updatable = false)
    @CreationTimestamp
    private Timestamp fechaInscripcion;
    
    
}
