package testsClasses;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class MoreDemo {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        Stream.iterate(6, i -> i + 1).limit(444).forEach(item -> list.add(item));

        Optional<Integer> opt = list.stream().findAny();
        System.out.println(opt.get());

    }
}
