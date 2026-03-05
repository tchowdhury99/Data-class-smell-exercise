package uncc.datasmells;

public class Validation {

    public static void notBlank(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new ValidationException(field + " must not be blank");
        }
    }

    public static void notNull(Object value, String field) {
        if (value == null) {
            throw new ValidationException(field + " must not be null");
        }
    }

    public static void nonNegative(double value, String field) {
        if (value < 0.0) {
            throw new ValidationException(field + " must be >= 0");
        }
    }

    public static void inRange(double value, double min, double max, String field) {
        if (value < min || value > max) {
            throw new ValidationException(field + " must be in [" + min + ", " + max + "]");
        }
    }
}