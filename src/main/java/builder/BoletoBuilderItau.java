package builder;

import model.Beneficiario;
import model.Boleto;
import model.Sacado;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoletoBuilderItau implements BoletoBuilder {
    private Boleto boleto = new Boleto();

    public void buildSacado(Sacado sacado) {
        boleto.setSacado(sacado);
    }

    public void buildBeneficiario(Beneficiario beneficiario) {
        boleto.setBeneficiario(beneficiario);
    }

    public void buildNumeroDocumento(String numero) {
        boleto.setNumeroDocumento(numero);
    }

    public void buildDataVencimento(Date data) {
        boleto.setDataVencimento(data);
    }

    public void buildValor(double valor) {
        boleto.setValor(valor);
    }

    public void buildBanco(String codigo, String agencia, String conta, String carteira) {
        boleto.setCodigoBanco(codigo);
        boleto.setAgencia(agencia);
        boleto.setConta(conta);
        boleto.setCarteira(carteira);
    }

    public void buildCodigoDeBarras() {
        String campoLivre = boleto.getAgencia() + boleto.getConta() + boleto.getCarteira() + boleto.getNumeroDocumento();
        while (campoLivre.length() < 25) campoLivre += "0";
        String valor = String.format("%010d", (int)(boleto.getValor() * 100));
        String venc = new SimpleDateFormat("yyyyMMdd").format(boleto.getDataVencimento());
        String codigo = boleto.getCodigoBanco() + "9" + venc + valor + campoLivre;
        boleto.setCodigoDeBarras(codigo.substring(0, 44));
    }

    public void buildLinhaDigitavel() {
        String cb = boleto.getCodigoDeBarras();
        boleto.setLinhaDigitavel(cb.substring(0, 5) + "." + cb.substring(5, 10) + " " +
                cb.substring(10, 15) + "." + cb.substring(15, 21) + " " +
                cb.substring(21, 26) + "." + cb.substring(26, 32) + " " +
                cb.substring(32));
    }

    public Boleto getBoleto() {
        return boleto;
    }
}