package com.blikoon.qrcodescannerlibrary;

/**
 * Created by jj on 28/10/19.
 */

public class Recycler {
    private String id;
    private String informacion;

    public Recycler(String id, String informacion) {
        this.id = id;
        this.informacion = informacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }


}
