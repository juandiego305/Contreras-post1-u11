package com.universidad.refactoring.domain;
import jakarta.persistence.*;
import lombok.Data;

@Entity @Data
public class Pedido {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private Long clienteId; private String clienteNombre; private double total;
    public Pedido() {}
    public Pedido(Long clienteId, String clienteNombre, double total) {
        this.clienteId = clienteId; this.clienteNombre = clienteNombre; this.total = total;
    }
}