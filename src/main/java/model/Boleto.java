package model;

import java.util.Date;

public class Boleto {
    private Sacado sacado;
    private Beneficiario beneficiario;
    private String numeroDocumento;
    private Date dataVencimento;
    private double valor;
    private String codigoBanco;
    private String agencia;
    private String conta;
    private String carteira;
    private String codigoDeBarras;
    private String linhaDigitavel;

    // Getters e Setters
    public Sacado getSacado() { return sacado; }
    public void setSacado(Sacado sacado) { this.sacado = sacado; }

    public Beneficiario getBeneficiario() { return beneficiario; }
    public void setBeneficiario(Beneficiario beneficiario) { this.beneficiario = beneficiario; }

    public String getNumeroDocumento() { return numeroDocumento; }
    public void setNumeroDocumento(String numeroDocumento) { this.numeroDocumento = numeroDocumento; }

    public Date getDataVencimento() { return dataVencimento; }
    public void setDataVencimento(Date dataVencimento) { this.dataVencimento = dataVencimento; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public String getCodigoBanco() { return codigoBanco; }
    public void setCodigoBanco(String codigoBanco) { this.codigoBanco = codigoBanco; }

    public String getAgencia() { return agencia; }
    public void setAgencia(String agencia) { this.agencia = agencia; }

    public String getConta() { return conta; }
    public void setConta(String conta) { this.conta = conta; }

    public String getCarteira() { return carteira; }
    public void setCarteira(String carteira) { this.carteira = carteira; }

    public String getCodigoDeBarras() { return codigoDeBarras; }
    public void setCodigoDeBarras(String codigoDeBarras) { this.codigoDeBarras = codigoDeBarras; }

    public String getLinhaDigitavel() { return linhaDigitavel; }
    public void setLinhaDigitavel(String linhaDigitavel) { this.linhaDigitavel = linhaDigitavel; }
}