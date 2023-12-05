package at.technikumwien.swkom.paperlessservices.services.impl;

import at.technikumwien.swkom.paperlessservices.services.IOCRWorker;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class TesseractOCRWorker implements IOCRWorker {
    private final String tessData;

    TesseractOCRWorker(@Value("${tesseract.data}") String tessData) {
        this.tessData = tessData;
    }

    @Override
    public String processFile(String fileName, InputStream fileInputStream) {
        try {
            File tempFile = createTempFile(fileName, fileInputStream);
            return this.doOCR(tempFile);
        } catch (TesseractException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String doOCR(File tempFile) throws TesseractException {
        var tesseract = new Tesseract();
        tesseract.setDatapath(tessData);
        return tesseract.doOCR(tempFile);
    }

    private static File createTempFile(String storagePath, InputStream is) throws IOException {
        File tempFile = File.createTempFile(StringUtils.getFilename(storagePath), "." + StringUtils.getFilenameExtension(storagePath));
        tempFile.deleteOnExit();
        try (FileOutputStream out = new FileOutputStream(tempFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);  //copy it to file system
            }
        }
        return tempFile;
    }
}
