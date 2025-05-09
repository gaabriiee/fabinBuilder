package builder;

import model.Boleto;
import model.Beneficiario;
import model.Sacado;

import java.util.Date;

public interface BoletoBuilder {
    void buildSacado(Sacado sacado);
    void buildBeneficiario(Beneficiario beneficiario);
    void buildNumeroDocumento(String numero);
    void buildDataVencimento(Date data);
    void buildValor(double valor);
    void buildBanco(String codigo, String agencia, String conta, String carteira);
    void buildCodigoDeBarras();
    void buildLinhaDigitavel();
    Boleto getBoleto();
}
