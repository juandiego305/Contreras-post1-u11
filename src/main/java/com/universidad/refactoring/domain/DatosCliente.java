package com.universidad.refactoring.domain;
import lombok.Getter;

@Getter
public class DatosCliente {
    private final Long id;
    private final String nombre;
    private final String email;
    private final String telefono;
    private final Direccion direccion;

    public DatosCliente(Long id, String nombre, String email, String telefono, Direccion direccion) {
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("Nombre requerido");
        if (email == null || !email.contains("@")) throw new IllegalArgumentException("Email inválido");
        this.id = id; this.nombre = nombre; this.email = email; this.telefono = telefono; this.direccion = direccion;
    }
}