package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseUtils {

    /**
     * Получить из строки вида "Сохранили объявление - UUID" UUID
     * @param input строка вида "Сохранили объявление - UUID"
     * @return UUID из переданной строки
     */
    public static String extractUuidString(String input) {

        final Pattern UUID_PATTERN = Pattern.compile(
                "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}"
        );

        if (input == null) return null;
        Matcher matcher = UUID_PATTERN.matcher(input);
        return matcher.find() ? matcher.group() : null;
    }
}
