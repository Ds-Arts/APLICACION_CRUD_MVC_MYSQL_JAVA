package model;

public class NequiVo {



    private int saldo=0;
    private int valorRecarga;
    private int ValorRetiro;
    private int IdUsuario;



//metodo constructor    
    
//metodos accesores


    public NequiVo() {

    }







    public NequiVo(int saldo, int valorRecarga, int valorRetiro, int idUsuario) {
        this.saldo = saldo;
        this.valorRecarga = valorRecarga;
        ValorRetiro = valorRetiro;
        IdUsuario = idUsuario;
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
        return IdUsuario;
    }







    public void setIdUsuario(int idUsuario) {
        IdUsuario = idUsuario;
    }




}
