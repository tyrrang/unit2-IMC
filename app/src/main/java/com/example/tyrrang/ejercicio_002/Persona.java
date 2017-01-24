package com.example.tyrrang.ejercicio_002;

/**
 * Created by tyrrang on 18/01/17.
 */

public class Persona {
    private String  nombre;
    private double peso;
    private double estatura;
    private char sexo;
    private byte ejercicio;
    private double imc;
    private String estatus;

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public byte getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(byte ejercicio) {
        this.ejercicio = ejercicio;
    }

    public void calcularImc() {
        imc=peso/(estatura*estatura);
    }

    public double resultado(){
        imc=peso/(estatura*estatura);

        return imc;
    }
    public double definirEstatus(){
        imc=peso/(estatura*estatura);
        if(imc<20){
            estatus="Bajo Peso";
        }else if(imc>=20 && imc<=25){
            estatus="Peso Normal";
        }else if(imc>25){
            estatus="SobrePeso";
        }
        return estatura;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", peso=" + peso +
                ", estatura=" + estatura +
                ", sexo=" + sexo +
                ", ejercicio=" + ejercicio +
                ", imc=" + imc +
                ", estatus='" + estatus + '\'' +
                '}';
    }
}
