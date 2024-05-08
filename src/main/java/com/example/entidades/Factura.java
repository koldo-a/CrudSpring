package com.example.entidades;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "facturas")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fechaEmision;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto productos;
    
    private int cantidad;
    
}
