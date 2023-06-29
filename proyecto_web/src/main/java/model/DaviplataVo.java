package model;

public class DaviplataVo {
    private int saldo;
    private int valorRecarga;
    private int ValorRetiro;
    private int idUsuario;

    

    public DaviplataVo() {

    }



    public DaviplataVo(int saldo, int valorRecarga, int valorRetiro, int idUsuario) {
        this.saldo = saldo;
        this.valorRecarga = valorRecarga;
        ValorRetiro = valorRetiro;
        this.idUsuario = idUsuario;
    }



    public int getSaldo() {
        return saldo;
    }



    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }



    public int getValorRecarga() {
        return valorRecarga;
    }



    public void setValorRecarga(int valorRecarga) {
        this.valorRecarga = valorRecarga;
    }



    public int getValorRetiro() {
        return ValorRetiro;
    }



    public void setValorRetiro(int valorRetiro) {
        ValorRetiro = valorRetiro;
    }



    public int getIdUsuario() {
        return idUsuario;
    }



    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    
}
