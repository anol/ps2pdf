import org.ghost4j.converter.PDFConverter;
import org.ghost4j.document.PSDocument;
import org.ghost4j.document.PaperSize;

import java.io.File;
import java.io.FileOutputStream;

import static org.ghost4j.converter.PDFConverter.OPTION_AUTOROTATEPAGES_ALL;

public class Main {

    public static void main(String[] args) throws Throwable {
        if (1 < args.length) {
            String inputFileName = args[0];
            String outputFileName = args[1];
            System.out.println("ps2pdf input=\"" + inputFileName + " output=\"" + outputFileName + "\"");
            //load PostScript document
            PSDocument document = new PSDocument();
            document.load(new File(inputFileName));
            //create OutputStream
            FileOutputStream fos = new FileOutputStream(new File(outputFileName));
            //create converter
            PDFConverter converter = new PDFConverter();
            //set options
            converter.setPDFSettings(PDFConverter.OPTION_PDFSETTINGS_DEFAULT);
            converter.setPaperSize(PaperSize.A0);
            converter.setAutoRotatePages(OPTION_AUTOROTATEPAGES_ALL);
            //convert
            converter.convert(document, fos);
        } else {
            System.out.println("Usage: ps2pdf <input file name> <output file name>");
        }
    }

}
