package com.example.backend.Modelo.Enumeraciones;

public enum TipoServicio {
    CUMPLEAÑOS(0), ANIVERSARIO(1), TEMATICO(2), NINGUNO(3), LICORES_ILIMIATDOS(4), ACCESO_DIRECTO(5), SESION_FOTOS(6),
    CONDUCTOR_ELEGIDO(7);

    private int estado;

    TipoServicio(int est) {estado = est;}

    public int get(){return estado;}

    public void setEstado(int est){estado = est;}

}
