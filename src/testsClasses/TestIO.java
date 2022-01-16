package testsClasses;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestIO {
    public static void main(String[] args) throws IOException {

        final Path path = Path.of("src", "codewars", "PigLatin.java");
        final boolean exists = Files.exists(path);

        if (exists) {
            String s = Files.readString(path);
            String pigLatinRefactor = s.replaceAll("public ", "private ");
            Path to = Path.of("src", "testsClasses", "PigLatin.java");
            Files.writeString(to, pigLatinRefactor);
        }
    }
}
