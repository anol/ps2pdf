import org.ghost4j.converter.MyPDFConverter;
import org.ghost4j.converter.PDFConverter;
import org.ghost4j.document.PSDocument;
import org.ghost4j.document.PaperSize;
import org.ghost4j.modifier.SafeAppenderModifier;

import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import static org.ghost4j.converter.PDFConverter.OPTION_AUTOROTATEPAGES_ALL;
import static org.ghost4j.converter.PDFConverter.OPTION_AUTOROTATEPAGES_OFF;

public class Main {

    public static void main(String[] args) throws Throwable {
        if (1 < args.length) {
            String inputFileName = args[0];
            String outputFileName = args[1];
            System.out.println("ps2pdf input=\"" + inputFileName + "\" output=\"" + outputFileName + "\"");
            //load PostScript document
            PSDocument document = new PSDocument();
            // Load postscript
            document.load(new File(inputFileName));
            //create OutputStream
            FileOutputStream fos = new FileOutputStream(new File(outputFileName));
            //create converter
            MyPDFConverter converter = new MyPDFConverter();
            //set options
            converter.setPDFSettings(PDFConverter.OPTION_PDFSETTINGS_DEFAULT);
            converter.setPaperSize(PaperSize.A4);
            converter.setAutoRotatePages(OPTION_AUTOROTATEPAGES_OFF);
            //convert
            converter.convert(document, fos);
        } else {
            System.out.println("Usage: ps2pdf <input file name> <output file name>");
        }
    }

}
