package myjava.util;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

public final class Strings {
    public static final String EMPTY_STRING = "";
    public static final Comparator<String> STRING_COMPARATOR = ((String a, String b) -> Strings.compare(a, b));
    public static final Comparator<String> STRING_COMPARATOR_IGNORE_CASE = ((String a, String b) -> Strings.compareIgnoreCase(a, b));

    private Strings() {
        throw new AssertionError("No myjava.util.Strings instances for you!");
    }

    public static boolean equals(String a, String b) {
        return (a == b) || (a != null && a.equals(b));
    }

    public static boolean equalsIgnoreCase(String a, String b) {
        return (a == b) || (a != null && a.equalsIgnoreCase(b));
    }

    public static String strip(String str) {
        return (str != null) ? str.strip() : null;
    }

    public static int compare(String a, String b) {
        if(a == b) {
            return 0;
        }

        if(a == null) {
            return -1;
        }

        if(b == null) {
            return 1;
        }

        return a.compareTo(b);
    }

    public static int compareIgnoreCase(String a, String b) {
        if(a == b) {
            return 0;
        }

        if(a == null) {
            return -1;
        }

        if(b == null) {
            return 1;
        }

        return a.compareToIgnoreCase(b);
    }

    public static boolean isNull(String str) {
        return (str == null);
    }

    public static boolean isNullOrEmpty(String str) {
        return (str == null || str.isEmpty());
    }

    public static boolean isNullOrWhitespace(String str) {
        return (str == null || str.strip().isEmpty());
    }

    public static boolean nonNull(String str) {
        return (str != null);
    }

    public static boolean nonNullNorEmpty(String str) {
        return (str != null && !str.isEmpty());
    }

    public static boolean nonNullNorWhitespace(String str) {
        return (str != null && !str.strip().isEmpty());
    }

    public static String requireNonNull(String str) throws Throwable {
        str = Strings.requireNonNullPrivate(str, StringExceptionsRecord.createByDefault());
        return str;
    }

    public static String requireNonNullNorEmpty(String str) throws Throwable {
        str = Strings.requireNonNullNorEmptyPrivate(str, StringExceptionsRecord.createByDefault());
        return str;
    }

    public static String requireNonNullNorWhitespace(String str) throws Throwable {
        str = Strings.requireNonNullNorWhitespacePrivate(str, StringExceptionsRecord.createByDefault());
        return str;
    }

    public static String requireNonNull(String str, String nullStringMessage) throws Throwable {
        str = Strings.requireNonNullPrivate(str, StringExceptionsRecord.createFromMessages(nullStringMessage, null, null));
        return str;
    }

    public static String requireNonNullNorEmpty(String str, String nullStringMessage, String emptyStringMessage) throws Throwable {
        str = Strings.requireNonNullNorEmptyPrivate(str, StringExceptionsRecord.createFromMessages(nullStringMessage, emptyStringMessage, null));
        return str;
    }

    public static String requireNonNullNorWhitespace(String str, String nullStringMessage, String emptyStringMessage, String whitespaceStringMessage) throws Throwable {
        str = Strings.requireNonNullNorWhitespacePrivate(str, StringExceptionsRecord.createFromMessages(nullStringMessage, emptyStringMessage, whitespaceStringMessage));
        return str;
    }

    public static String requireNonNull(String str, Supplier<String> nullStringMessageSupplier) throws Throwable {
        str = Strings.requireNonNullPrivate(str, StringExceptionsRecord.createFromMessageSuppliers(nullStringMessageSupplier, null, null));
        return str;
    }

    public static String requireNonNullNorEmpty(String str, Supplier<String> nullStringMessageSupplier, Supplier<String> emptyStringMessageSupplier) throws Throwable {
        str = Strings.requireNonNullNorEmptyPrivate(str, StringExceptionsRecord.createFromMessageSuppliers(nullStringMessageSupplier, emptyStringMessageSupplier, null));
        return str;
    }

    public static String requireNonNullNorWhitespace(String str, Supplier<String> nullStringMessageSupplier, Supplier<String> emptyStringMessageSupplier, Supplier<String> whitespaceStringMessageSupplier) throws Throwable {
        str = Strings.requireNonNullNorWhitespacePrivate(str, StringExceptionsRecord.createFromMessageSuppliers(nullStringMessageSupplier, emptyStringMessageSupplier, whitespaceStringMessageSupplier));
        return str;
    }

    public static String requireNonNullElseThrow(String str, Supplier<Throwable> nullStringThrowableSupplier) throws Throwable {
        str = Strings.requireNonNullPrivate(str, StringExceptionsRecord.createFromThrowableSuppliers(nullStringThrowableSupplier, null, null));
        return str;
    }

    public static String requireNonNullNorEmptyElseThrow(String str, Supplier<Throwable> nullStringThrowableSupplier, Supplier<Throwable> emptyStringThrowableSupplier) throws Throwable {
        str = Strings.requireNonNullNorEmptyPrivate(str, StringExceptionsRecord.createFromThrowableSuppliers(nullStringThrowableSupplier, emptyStringThrowableSupplier, null));
        return str;
    }

    public static String requireNonNullNorWhitespaceElseThrow(String str, Supplier<Throwable> nullStringThrowableSupplier, Supplier<Throwable> emptyStringThrowableSupplier, Supplier<Throwable> whitespaceStringThrowableSupplier) throws Throwable {
        str = Strings.requireNonNullNorWhitespacePrivate(str, StringExceptionsRecord.createFromThrowableSuppliers(nullStringThrowableSupplier, emptyStringThrowableSupplier, whitespaceStringThrowableSupplier));
        return str;
    }

    public static String requireNonNullElse(String str, String defaultStr) throws Throwable {
        return (str != null) ? str :
                requireNonNull(defaultStr, "defaultStr");
    }

    public static String requireNonNullNorEmptyElse(String str, String defaultStr) throws Throwable {
        return (str != null && !str.isEmpty()) ? str :
                requireNonNullNorEmpty(defaultStr, "defaultStr", "defaultStr");
    }

    public static String requireNonNullNorWhitespaceElse(String str, String defaultStr) throws Throwable {
        str = strip(str);
        return (str != null && !str.isEmpty()) ? str :
                requireNonNullNorWhitespace(defaultStr, "defaultStr", "defaultStr", "defaultStr");
    }

    public static String requireNonNullElseGet(String str, Supplier<String> supplier) throws Throwable {
        return (str != null) ? str :
                requireNonNull(Objects.requireNonNull(supplier, "supplier").get(), "supplier.get()");
    }

    public static String requireNonNullNorEmptyElseGet(String str, Supplier<String> supplier) throws Throwable {
        return (str != null && !str.isEmpty()) ? str :
                requireNonNullNorEmpty(Objects.requireNonNull(supplier, "supplier").get(), "supplier.get()", "supplier.get()");
    }

    public static String requireNonNullNorWhitespaceElseGet(String str, Supplier<String> supplier) throws Throwable {
        str = strip(str);
        return (str != null && !str.isEmpty()) ? str :
                requireNonNullNorWhitespace(Objects.requireNonNull(supplier, "supplier").get(), "supplier.get()", "supplier.get()", "supplier.get()");
    }

    private static String requireNonNullPrivate(String str, StringExceptionsRecord stringExceptionsRecord) throws Throwable {
        if (str == null) {
            throw Objects.requireNonNull(stringExceptionsRecord, "stringExceptionsRecord").nullStringThrowableSupplier.get();
        }
        return str;
    }

    private static String requireNonNullNorEmptyPrivate(String str, StringExceptionsRecord stringExceptionsRecord) throws Throwable {
        if (str == null) {
            throw Objects.requireNonNull(stringExceptionsRecord, "stringExceptionsRecord").nullStringThrowableSupplier.get();
        }
        if (str.isEmpty()) {
            throw Objects.requireNonNull(stringExceptionsRecord, "stringExceptionsRecord").emptyStringThrowableSupplier.get();
        }
        return str;
    }

    private static String requireNonNullNorWhitespacePrivate(String str, StringExceptionsRecord stringExceptionsRecord) throws Throwable {
        if (str == null) {
            throw Objects.requireNonNull(stringExceptionsRecord, "stringExceptionsRecord").nullStringThrowableSupplier.get();
        }
        if (str.isEmpty()) {
            throw Objects.requireNonNull(stringExceptionsRecord, "stringExceptionsRecord").emptyStringThrowableSupplier.get();
        }

        str = str.strip();

        if (str.isEmpty()) {
            throw Objects.requireNonNull(stringExceptionsRecord, "stringExceptionsRecord").whitespaceStringThrowableSupplier.get();
        }
        return str;
    }

    private final record StringExceptionsRecord(Supplier<Throwable> nullStringThrowableSupplier, Supplier<Throwable> emptyStringThrowableSupplier, Supplier<Throwable> whitespaceStringThrowableSupplier) {
        //LAMBDAS DEFAULT
        private static final Supplier<Throwable> LAMBDA_DEFAULT_NULL = () -> new NullPointerException();
        private static final Supplier<Throwable> LAMBDA_DEFAULT_EMPTY = () -> new IllegalArgumentException();
        private static final Supplier<Throwable> LAMBDA_DEFAULT_WHITESPACE = () -> new IllegalArgumentException();

        //LAMBDAS DEFAULT WITH MESSAGE
        private static final Function<String, Supplier<Throwable>> LAMBDA_DEFAULT_WITH_MESSAGE_NULL = (String nullStringMessage) -> {
            return () -> new NullPointerException(Objects.requireNonNull(nullStringMessage, "nullStringMessage"));
        };
        private static final Function<String, Supplier<Throwable>> LAMBDA_DEFAULT_WITH_MESSAGE_EMPTY = (String emptyStringMessage) -> {
            return () -> new IllegalArgumentException(Objects.requireNonNull(emptyStringMessage, "emptyStringMessage"));
        };
        private static final Function<String, Supplier<Throwable>> LAMBDA_DEFAULT_WITH_MESSAGE_WHITESPACE = (String whitespaceStringMessage) -> {
            return () -> new IllegalArgumentException(Objects.requireNonNull(whitespaceStringMessage, "whitespaceStringMessage"));
        };

        //LAMBDAS DEFAULT WITH MESSAGE SUPPLIER
        private static final Function<Supplier<String>, Supplier<Throwable>> LAMBDA_DEFAULT_WITH_MESSAGE_SUPPLIER_NULL = (Supplier<String> nullStringMessageSupplier) -> {
            return () -> {
                Objects.requireNonNull(nullStringMessageSupplier, "nullStringMessageSupplier");
                return new NullPointerException(Objects.requireNonNull(nullStringMessageSupplier.get(), "nullStringMessageSupplier.get()"));
            };
        };
        private static final Function<Supplier<String>, Supplier<Throwable>> LAMBDA_DEFAULT_WITH_MESSAGE_SUPPLIER_EMPTY = (Supplier<String> emptyStringMessageSupplier) -> {
            return () -> {
                Objects.requireNonNull(emptyStringMessageSupplier, "emptyStringMessageSupplier");
                return new IllegalArgumentException(Objects.requireNonNull(emptyStringMessageSupplier.get(), "emptyStringMessageSupplier.get()"));
            };
        };
        private static final Function<Supplier<String>, Supplier<Throwable>> LAMBDA_DEFAULT_WITH_MESSAGE_SUPPLIER_WHITESPACE = (Supplier<String> whitespaceStringMessageSupplier) -> {
            return () -> {
                Objects.requireNonNull(whitespaceStringMessageSupplier, "whitespaceStringMessageSupplier");
                return new IllegalArgumentException(Objects.requireNonNull(whitespaceStringMessageSupplier.get(), "whitespaceStringMessageSupplier.get()"));
            };
        };

        //LAMBDAS CUSTOM THROWABLE SUPPLIER
        private static final Function<Supplier<Throwable>, Supplier<Throwable>> LAMBDA_CUSTOM_NULL = (Supplier<Throwable> nullStringThrowableSupplier) -> {
            return () -> {
                Objects.requireNonNull(nullStringThrowableSupplier, "nullStringThrowableSupplier");
                return Objects.requireNonNull(nullStringThrowableSupplier.get(), "nullStringThrowableSupplier.get()");
            };
        };
        private static final Function<Supplier<Throwable>, Supplier<Throwable>> LAMBDA_CUSTOM_EMPTY = (Supplier<Throwable> emptyStringThrowableSupplier) -> {
            return () -> {
                Objects.requireNonNull(emptyStringThrowableSupplier, "emptyStringThrowableSupplier");
                return Objects.requireNonNull(emptyStringThrowableSupplier.get(), "emptyStringThrowableSupplier.get()");
            };
        };
        private static final Function<Supplier<Throwable>, Supplier<Throwable>> LAMBDA_CUSTOM_WHITESPACE = (Supplier<Throwable> whitespaceStringThrowableSupplier) -> {
            return () -> {
                Objects.requireNonNull(whitespaceStringThrowableSupplier, "whitespaceStringThrowableSupplier");
                return Objects.requireNonNull(whitespaceStringThrowableSupplier.get(), "whitespaceStringThrowableSupplier.get()");
            };
        };

        public static StringExceptionsRecord createByDefault() {
            return new StringExceptionsRecord(
                    LAMBDA_DEFAULT_NULL,
                    LAMBDA_DEFAULT_EMPTY,
                    LAMBDA_DEFAULT_WHITESPACE);
        }

        public static StringExceptionsRecord createFromMessages(String nullStringMessage, String emptyStringMessage, String whitespaceStringMessage) {
            return new StringExceptionsRecord(
                    LAMBDA_DEFAULT_WITH_MESSAGE_NULL.apply(nullStringMessage),
                    LAMBDA_DEFAULT_WITH_MESSAGE_EMPTY.apply(emptyStringMessage),
                    LAMBDA_DEFAULT_WITH_MESSAGE_WHITESPACE.apply(whitespaceStringMessage));
        }

        public static StringExceptionsRecord createFromMessageSuppliers(Supplier<String> nullStringMessageSupplier, Supplier<String> emptyStringMessageSupplier, Supplier<String> whitespaceStringMessageSupplier) {
            return new StringExceptionsRecord(
                    LAMBDA_DEFAULT_WITH_MESSAGE_SUPPLIER_NULL.apply(nullStringMessageSupplier),
                    LAMBDA_DEFAULT_WITH_MESSAGE_SUPPLIER_EMPTY.apply(emptyStringMessageSupplier),
                    LAMBDA_DEFAULT_WITH_MESSAGE_SUPPLIER_WHITESPACE.apply(whitespaceStringMessageSupplier));
        }

        public static StringExceptionsRecord createFromThrowableSuppliers(Supplier<Throwable> nullStringThrowableSupplier, Supplier<Throwable> emptyStringThrowableSupplier, Supplier<Throwable> whitespaceStringThrowableSupplier) {
            return new StringExceptionsRecord(
                    LAMBDA_CUSTOM_NULL.apply(nullStringThrowableSupplier),
                    LAMBDA_CUSTOM_EMPTY.apply(emptyStringThrowableSupplier),
                    LAMBDA_CUSTOM_WHITESPACE.apply(whitespaceStringThrowableSupplier));
        }

        private StringExceptionsRecord(Supplier<Throwable> nullStringThrowableSupplier, Supplier<Throwable> emptyStringThrowableSupplier, Supplier<Throwable> whitespaceStringThrowableSupplier) {
            this.nullStringThrowableSupplier = nullStringThrowableSupplier;
            this.emptyStringThrowableSupplier = emptyStringThrowableSupplier;
            this.whitespaceStringThrowableSupplier = whitespaceStringThrowableSupplier;
        }
    }
}
