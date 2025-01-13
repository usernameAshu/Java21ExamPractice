package streams;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _1 {

  void main() {
    List<Character> chars = List.of('a', 'b', ' ', 'c');

    String result =
    chars.stream()
        .filter(c -> !Character.isWhitespace(c))
        .map(Character::toUpperCase)
        .collect(StringBuilder::new,(sb,ch) -> sb.append(ch),
            (sb1, sb2) -> sb1.append(sb2))
        .toString();

    System.out.println("Combined chars: "+ result);


    //Same functionality with reduce operation
    String result2 =
    chars.stream()
        .filter(c -> !Character.isWhitespace(c))
        .map(Character::toUpperCase)
        .reduce(new StringBuilder(), (stringBuilder, character) -> stringBuilder.append(character),
            (stringBuilder, stringBuilder2) -> stringBuilder.append(stringBuilder2))
        .toString();

    System.out.println(result2);

    //flatmap
    //you generate a stream from another stream

    List<String> indList =
    Stream.of(1, 2, 3, 4)
        .flatMap(i -> Stream.of("Index:"+i))
        .toList();

    System.out.println(indList);

    Optional<String> optStr = Optional.ofNullable(null);
    optStr.ifPresentOrElse(str -> System.out.println("Result present: "+ str),
        () -> System.out.println("No such element present"));


  }

}
