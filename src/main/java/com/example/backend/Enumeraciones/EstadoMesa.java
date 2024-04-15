package com.example.backend.Enumeraciones;

public enum EstadoMesa {

    RESERVADA(0), LIBRE(1), FUERASERVICIO(2);

    private int estado;

    EstadoMesa(int est) {estado = est;}

    public int get(){return estado;}

    public void setEstado(int est){estado = est;}
}
