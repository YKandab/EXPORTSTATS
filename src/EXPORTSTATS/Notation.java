package EXPORTSTATS;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum Notation {
    k(3), m(6), b(9), t(12), qa(15), qi(18), sx(21), sp(24), oc(27), no(30), dc(33), udc(36), 
    ddc(39), tdc(42), qadc(45), qidc(48), sxdc(51), spdc(54), odc(57), ndc(60);

    private final BigDecimal divisor;

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

        int magnitude = getExponent(abs);
        if (EXPORTSTATS.precision > magnitude || magnitude < 3) {
            return stripTrailing(number);
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
            return stripTrailing(number);
        }

        BigDecimal scaled = number.divide(chosen.divisor, EXPORTSTATS.precision, RoundingMode.HALF_UP);
        String formatted = scaled.toPlainString();
        return formatted + chosen.name();
    }

    private static String stripTrailing(BigDecimal number) {
        BigDecimal stripped = number.stripTrailingZeros();
        if (stripped.scale() < 0) {
            stripped = stripped.setScale(0);
        }
        return stripped.toPlainString();
    }

    private static int getExponent(BigDecimal number) {
        return number.precision() - number.scale() - 1;
    }
}
