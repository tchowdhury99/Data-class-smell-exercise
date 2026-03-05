package uncc.datasmells;

public class Validation {

    public static void requireNonBlank(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new ValidationException(fieldName + " must not be blank");
        }
    }

    public static void requireNonNull(Object value, String fieldName) {
        if (value == null) {
            throw new ValidationException(fieldName + " must not be null");
        }
    }

    public static void requireNonNegative(double value, String fieldName) {
        if (value < 0.0) {
            throw new ValidationException(fieldName + " must be >= 0");
        }
    }

    public static void requireRange(double value, double min, double max, String fieldName) {
        if (value < min || value > max) {
            throw new ValidationException(fieldName + " must be in [" + min + ", " + max + "]");
        }
    }
}