package kvbdev;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int threshold;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();

        for (Integer el : source) {
            if (el < threshold) {
                logger.log("Элемент \"" + el + "\" не подходит");
                continue;
            }
            logger.log("Элемент \"" + el + "\" подходит");
            result.add(el);
        }
        logger.log("Прошло фильтр " + result.size() + " элемента из " + source.size());
        return result;
    }
}
