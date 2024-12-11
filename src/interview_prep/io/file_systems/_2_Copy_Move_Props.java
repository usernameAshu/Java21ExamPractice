package interview_prep.io.file_systems;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class _2_Copy_Move_Props {
    public static void main(String[] args) {
        Path source = Path.of("C:\\Users\\002L2N744\\Documents\\Github\\Java21ExamPractice\\source");
        Path backup = source.resolve("backup");
        Path user = source.resolve("user");

        System.out.println("------------------Backup walk----------------");
        walkPath(backup);
        System.out.println("------------------User walk----------------");
        walkPath(user);

        /*
        System.out.println("------------------Root walk----------------");
        listPath(Path.of("/"));
        System.out.println("------------------Username folder walk----------------");
        listPath(Path.of("/Users/002L2N744"));
        */

        System.out.println("------------------Copy start----------------");
        System.out.println("backup: "+ backup);
        try {
            Files.list(user)
                    .forEach(file -> {
                        try {
                            Path dest = backup.resolve(file);
                            System.out.println("file: "+ file);
                            System.out.println("dest: " +dest);
                            Files.copy(file, dest,
                                    StandardCopyOption.COPY_ATTRIBUTES,
                                    StandardCopyOption.REPLACE_EXISTING);

                        } catch (IOException e) {
                            throw new RuntimeException("Error while copying");
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException("Error while Iterating");
        }


        System.out.println("------------------After copying----------------");
        walkPath(backup);


    }

    private static void walkPath(Path path) {
        try {
            Files.walk(path).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void listPath(Path path) {
        try {
            Files.list(path).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
