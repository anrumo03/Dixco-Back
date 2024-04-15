package com.example.backend.Enumeraciones;

public enum EstadoSolicitud {

    APROBADA(0), CANCELADA(1), PENDIENTE(2);

    private int estado;

    EstadoSolicitud(int est) {estado = est;}

    public int get(){return estado;}

    public void setEstado(int est){estado = est;}
}
