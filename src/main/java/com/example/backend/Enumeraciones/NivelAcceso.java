package com.example.backend.Enumeraciones;

public enum NivelAcceso {
    ADMIN(0), AUX(1);

    private int nivel;

    NivelAcceso(int nivell){nivel = nivell;}

    public int get(){return nivel;}

    public void setNivel(int nivel1){nivel = nivel1;}
}
