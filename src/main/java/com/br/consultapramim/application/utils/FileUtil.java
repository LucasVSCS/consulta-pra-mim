package com.br.consultapramim.application.utils;

import com.br.consultapramim.application.services.exceptions.InternalServerErrorException;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {

    private FileUtil() {
    }

    public static void saveCarhunterLogo(String path, String base64) {
        byte[] imageByte = Base64.decodeBase64(base64);

        try (FileOutputStream file = new FileOutputStream(path)) {
            file.write(imageByte);
        } catch (IOException e) {
            throw new InternalServerErrorException("Erro ao salvar a logo do consultor");
        }
    }

    public static void deleteCarHunterLogo(String path) {
        File file = new File(path);

        if (file.exists()) {
            file.delete();
        }
    }

    public static String getBase64FromFile(String path) throws IOException {
        try {
            byte[] imageBytes = Files.readAllBytes(Paths.get(path));
            String mimeType = Files.probeContentType(Paths.get(path));
            String base64 = Base64.encodeBase64String(imageBytes);
            return "data:" + mimeType + ";base64," + base64;
        } catch (IOException e) {
            throw new IOException("Erro ao ler a logo do consultor");
        }
    }
}
