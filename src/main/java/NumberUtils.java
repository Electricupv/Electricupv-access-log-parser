/**
 * Утилитный класс для работы с числовыми значениями
 */
public class NumberUtils {
    
    /**
     * Складывает набор числовых значений и возвращает сумму в вещественной форме
     * @param numbers набор числовых значений (любые подтипы Number)
     * @return сумма всех чисел как double
     */
    public static double sumAll(Number... numbers) {
        double sum = 0.0;
        for (Number number : numbers) {
            if (number != null) {
                sum += number.doubleValue();
            }
        }
        return sum;
    }
} 