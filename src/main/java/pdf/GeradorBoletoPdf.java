package pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfWriter;
import model.Boleto;

import java.io.FileOutputStream;

public class GeradorBoletoPdf {
    public void gerar(Boleto boleto, String caminhoDoArquivo) {
        try {
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(caminhoDoArquivo));
            document.open();

            document.add(new Paragraph("BOLETO BANCÁRIO"));
            document.add(new Paragraph("Beneficiário: " + boleto.getBeneficiario().getNome()));
            document.add(new Paragraph("Sacado: " + boleto.getSacado().getNome()));
            document.add(new Paragraph("Documento: " + boleto.getNumeroDocumento()));
            document.add(new Paragraph("Valor: R$ " + boleto.getValor()));
            document.add(new Paragraph("Vencimento: " + boleto.getDataVencimento()));
            document.add(new Paragraph("Linha Digitável: " + boleto.getLinhaDigitavel()));

            Barcode128 barcode = new Barcode128();
            barcode.setCode(boleto.getCodigoDeBarras());
            barcode.setCodeType(Barcode128.CODE128);
            Image codeImage = barcode.createImageWithBarcode(writer.getDirectContent(), null, null);
            codeImage.scalePercent(150);
            document.add(codeImage);

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}