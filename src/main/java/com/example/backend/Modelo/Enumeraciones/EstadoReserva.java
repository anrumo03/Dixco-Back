package com.example.backend.Modelo.Enumeraciones;

public enum EstadoReserva {

    CONFIRMADA(0), PENDIENTE(1), CANCELADA(2);

    private int estado;

    EstadoReserva(int est) {estado = est;}

    public int get(){return estado;}

    public void setEstado(int est){estado = est;}
}
