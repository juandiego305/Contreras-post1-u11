package com.universidad.refactoring.domain;
import lombok.Getter;

@Getter
public class Direccion {
    private final String calle, ciudad, codigoPostal;
    public Direccion(String calle, String ciudad, String codigoPostal) {
        this.calle = calle; this.ciudad = ciudad; this.codigoPostal = codigoPostal;
    }
}