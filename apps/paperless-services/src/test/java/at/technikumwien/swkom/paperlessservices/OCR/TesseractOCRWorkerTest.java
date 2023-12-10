package at.technikumwien.swkom.paperlessservices.OCR;

import at.technikumwien.swkom.paperlessservices.services.impl.MinIOService;
import at.technikumwien.swkom.paperlessservices.services.impl.TesseractOCRWorker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class TesseractOCRWorkerTest {
    @Mock
    private TesseractOCRWorker tesseractOCRWorker;
    @Test
    public void testProcessFile() throws Exception {

        tesseractOCRWorker = new TesseractOCRWorker("/usr/share/tesseract-ocr/4.00/tessdata");

        String filename = "Test.pdf";
        String expectedOcrResult = "Paperless Test PDF\n";
        InputStream inputStream = new FileInputStream("./src/test/java/at/technikumwien/swkom/paperlessservices/OCR/Test.pdf");

        String result = tesseractOCRWorker.processFile(filename, inputStream);

        assertEquals(result, expectedOcrResult);
    }
}
