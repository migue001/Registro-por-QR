package com.blikoon.qrcodescanner;

/**
 * Created by jj on 20/10/19.
 */

public class Basededatos  {
    private String laboratorio,fecha,horaentrada,horasalida,informacion,profesor;
    private int id;

    public Basededatos(String laboratorio, String fecha, String horaentrada, String horasalida, String informacion, String profesor, int id) {
        this.laboratorio = laboratorio;
        this.fecha = fecha;
        this.horaentrada = horaentrada;
        this.horasalida = horasalida;
        this.informacion = informacion;
        this.profesor = profesor;
        this.id = id;

    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraentrada() {
        return horaentrada;
    }

    public void setHoraentrada(String horaentrada) {
        this.horaentrada = horaentrada;
    }

    public String getHorasalida() {
        return horasalida;
    }

    public void setHorasalida(String horasalida) {
        this.horasalida = horasalida;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
