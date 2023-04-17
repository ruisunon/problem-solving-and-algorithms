package algorithms.advanced.externalsorting;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

class SplitFile implements Runnable {
    String fileName;
    int startLine, endLine;

    SplitFile(String fileName, int startLine, int endLine) {
        this.fileName = fileName;
        this.startLine = startLine;
        this.endLine = endLine;
    }

    public static void writeToFile(BufferedWriter writer, String line) {
        try {
            writer.write(line + "\r\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName));
            int totalLines = endLine + 1 - startLine;
            Stream<String> chunks =
                    Files.lines(Paths.get(ExternalSort20GB.fPath))
                            .skip(startLine - 1)
                            .limit(totalLines)
                            .sorted(Comparator.naturalOrder());

            chunks.forEach(line -> {
                writeToFile(writer, line);
            });
            System.out.println(" Done Writing " + Thread.currentThread().getName());
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
