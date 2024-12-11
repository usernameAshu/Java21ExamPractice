package interview_prep.io.file_systems;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _1_Path_Properties {
    public static void main(String[] args) {
        Path path = Path.of("Message.txt");
        Path abs = Path.of("C:\\Users\\002L2N744\\Documents\\Github\\Java21ExamPractice\\Message.txt");
        boolean result;
        String str;
        result = Files.isDirectory(path);
        result = Files.isExecutable(path);
        result = Files.isWritable(path);
        result = Files.isSymbolicLink(path);
        try {
            result = Files.isSameFile(path, abs);
            str = Files.probeContentType(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        long size;
        BasicFileAttributes fa;
        FileTime ft;
        try {
            FileSystems.getDefault();
            fa = Files.readAttributes(path, DosFileAttributes.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        size = fa.size();
        ft = fa.creationTime();
        ft = fa.lastModifiedTime();
        ft = fa.lastAccessTime();

        /*
        UserPrincipal user = fa.owner();
        GroupPrincipal group = fa.group();

        Set<PosixFilePermission> permissions = fa.permissions();
        */

        try {
            Files.walk(Path.of("./"), FileVisitOption.FOLLOW_LINKS)
                    .filter(p -> p.startsWith("./src"))
                    .collect(Collectors.toUnmodifiableList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //create directories, if donot exist
        Path backup = Path.of("./backup/docs");

        if (Files.notExists(backup)) {
            try {
                Files.createDirectories(backup);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            Path readme = backup.resolve("../readme.txt").normalize();
            if (Files.notExists(readme)) {
                Files.createFile(readme);
            }
            Files.writeString(readme, "Backup time: " + Instant.now());
            Files.lines(readme, Charset.defaultCharset())
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Handling temp files and directories
        try {
            Path temp = Files.createTempDirectory( Path.of("./"),"TEMP");
            Path tempFile = Files.createTempFile(temp, "TEMP", ".tmp");

            //cleanup
            Files.deleteIfExists(tempFile);
            Files.deleteIfExists(temp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
