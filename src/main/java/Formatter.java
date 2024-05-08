public class Formatter {
    public static String formatRubles(double amount) {
        String formatSum = String.format("%.0f", amount);
        String result = String.format("%.2f", amount);
        if (
                formatSum.endsWith("0") ||
                formatSum.endsWith("5") ||
                formatSum.endsWith("6") ||
                formatSum.endsWith("7") ||
                formatSum.endsWith("8") ||
                formatSum.endsWith("9")) {
            return result + " рублей";
        } else if (formatSum.endsWith("1")) {
            return result + " рубль";
        } else if (
                formatSum.endsWith("2") ||
                formatSum.endsWith("3") ||
                formatSum.endsWith("4")
        ) {
            return result + " рубля";
        } else return "Ошибка инициализации результата";
    }
}
