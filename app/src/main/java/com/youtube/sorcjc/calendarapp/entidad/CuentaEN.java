package com.youtube.sorcjc.calendarapp.entidad;

/**
 * Created by Juarez on 11/12/2016.
 */
import java.io.Serializable;

public class CuentaEN implements Serializable{
    private Integer idCuenta;
    private String year;
    private Double payment;
    private Double amount;
    private Double debe;
    private Integer idUsuario;
    private UsuarioEN usuario;

    public CuentaEN() {
        this.setIdCuenta(0);
        this.setYear("");
        this.setPayment(0.0);
        this.setAmount(0.0);
        this.setIdUsuario(0);
        this.setUsuario(null);
    }

    public CuentaEN(Integer idCuenta, String year, Double payment, Double amount, Integer idUsuario, UsuarioEN usuario) {
        this.setIdCuenta(idCuenta);
        this.setYear(year);
        this.setPayment(payment);
        this.setAmount(amount);
        this.setIdUsuario(idUsuario);
        this.setUsuario(usuario);
    }


    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public UsuarioEN getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEN usuario) {
        this.usuario = usuario;
    }

    public Double getDebe() {
        return debe;
    }

    public void setDebe(Double debe) {
        this.debe = debe;
    }
}
