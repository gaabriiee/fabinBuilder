package builder;

import model.Beneficiario;
import model.Sacado;

import java.util.Date;

public class DiretorBoleto {
    public void construirBoleto(BoletoBuilder builder, Sacado sacado, Beneficiario beneficiario,
                                String numeroDocumento, Date dataVencimento, double valor,
                                String banco, String agencia, String conta, String carteira) {
        builder.buildSacado(sacado);
        builder.buildBeneficiario(beneficiario);
        builder.buildNumeroDocumento(numeroDocumento);
        builder.buildDataVencimento(dataVencimento);
        builder.buildValor(valor);
        builder.buildBanco(banco, agencia, conta, carteira);
        builder.buildCodigoDeBarras();
        builder.buildLinhaDigitavel();
    }
}