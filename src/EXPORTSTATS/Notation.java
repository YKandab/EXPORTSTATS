package EXPORTSTATS;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum Notation {
    k(3), m(6), b(9), t(12), qa(15), qi(18), sx(21), sp(24), oc(27), no(30), dc(33), udc(36), 
    ddc(39), tdc(42), qadc(45), qidc(48), sxdc(51), spdc(54), odc(57), ndc(60);

    private final BigDecimal divisor;
    public static boolean scientificNotation = false;

    private Notation(int exponent) {
        this.divisor = BigDecimal.TEN.pow(exponent);
    }

    public static String getBestNotation(BigDecimal number) {
        if (number == null) return "";
        if (EXPORTSTATS.precision == -1) {
            return number.toBigInteger().toString();
        }

        BigDecimal abs = number.abs();
        if (abs.compareTo(BigDecimal.ZERO) == 0) {
            return "0";
        }

        if (scientificNotation) {
            return toScientific(number);
        }

        BigDecimal minThreshold = BigDecimal.valueOf(100000);
        BigDecimal threshold = BigDecimal.TEN.pow(EXPORTSTATS.precision + 3);
        if (threshold.compareTo(minThreshold) < 0) {
            threshold = minThreshold;
        }
        if (abs.compareTo(threshold) < 0) {
            return roundToPrecision(number);
        }

        Notation chosen = null;
        for (Notation notation : values()) {
            if (abs.compareTo(notation.divisor) >= 0) {
                chosen = notation;
            } else {
                break;
            }
        }

        if (chosen == null) {
            return roundToPrecision(number);
        }

        BigDecimal scaled = number.divide(chosen.divisor, EXPORTSTATS.precision, RoundingMode.HALF_UP);
        String formatted = scaled.toPlainString();
        return formatted + chosen.name();
    }

    private static String toScientific(BigDecimal number) {
        BigDecimal abs = number.abs();
        int exponent = getExponent(abs);
        BigDecimal mantissa = number.movePointLeft(exponent).setScale(EXPORTSTATS.precision, RoundingMode.HALF_UP);
        String formatted = stripTrailing(mantissa);
        return formatted + "e" + exponent;
    }

    private static String roundToPrecision(BigDecimal number) {
        BigDecimal scaled = number.setScale(EXPORTSTATS.precision, RoundingMode.HALF_UP);
        return stripTrailing(scaled);
    }

    private static String stripTrailing(BigDecimal number) {
        BigDecimal stripped = number.stripTrailingZeros();
        if (stripped.scale() < 0) {
            stripped = stripped.setScale(0);
        }
        return stripped.toPlainString();
    }

    private static int getExponent(BigDecimal number) {
        BigDecimal stripped = number.stripTrailingZeros();
        return stripped.precision() - stripped.scale() - 1;
    }
}
