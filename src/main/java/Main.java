// ========== Main.java ==========
import builder.*;
import model.Beneficiario;
import model.Boleto;
import model.Sacado;
import pdf.GeradorBoletoPdf;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Sacado sacado = new Sacado("João da Silva", "123.456.789-00", "Rua X, 123");
        Beneficiario beneficiario = new Beneficiario("Empresa SA", "00.000.000/0001-00", "Av. Central, 1000");
        DiretorBoleto diretor = new DiretorBoleto();
        GeradorBoletoPdf gerador = new GeradorBoletoPdf();

        // Banco do Brasil (001)
        BoletoBuilder bbBuilder = new BoletoBuilderBancoDoBrasil();
        diretor.construirBoleto(bbBuilder, sacado, beneficiario, "1234567890", new Date(), 250.75,
                "001", "1234", "56789", "18");
        gerador.gerar(bbBuilder.getBoleto(), "boleto_bb.pdf");

        // Banco Itaú (341)
        BoletoBuilder itauBuilder = new BoletoBuilderItau();
        diretor.construirBoleto(itauBuilder, sacado, beneficiario, "2345678901", new Date(), 350.00,
                "341", "4321", "98765", "109");
        gerador.gerar(itauBuilder.getBoleto(), "boleto_itau.pdf");

        // Banco Bradesco (237)
        BoletoBuilder bradescoBuilder = new BoletoBuilderBradesco();
        diretor.construirBoleto(bradescoBuilder, sacado, beneficiario, "3456789012", new Date(), 480.90,
                "237", "1111", "22222", "09");
        gerador.gerar(bradescoBuilder.getBoleto(), "boleto_bradesco.pdf");

        System.out.println("Boletos gerados com sucesso!");
    }
}