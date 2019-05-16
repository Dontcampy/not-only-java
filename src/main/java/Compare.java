import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sirius
 * @since 2019/05/16
 */
public class Compare {
    public static void main(String[] args) {
        Set<BigDecimal> set = new HashSet<>();
        BigDecimal bd1 = new BigDecimal("1.0");
        BigDecimal bd2 = new BigDecimal("1.00");

        set.add(bd1);
        set.add(bd2);

        System.out.println(set.size());
    }
}
