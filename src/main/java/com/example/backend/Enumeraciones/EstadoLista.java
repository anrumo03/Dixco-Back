package com.example.backend.Enumeraciones;

public enum EstadoLista {

    PENDIENTE(0), RESUELTA(1), CANCELADA(2);

    private int estado;

    EstadoLista(int est) {estado = est;}

    public int get(){return estado;}

    public void setEstado(int est){estado = est;}
}
