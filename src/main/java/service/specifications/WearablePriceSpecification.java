package service.specifications;

import models.equipment.wearable.Wearable;

import java.util.function.Predicate;

public class WearablePriceSpecification<T extends Wearable> implements Predicate<T> {
    private final long minPrice;
    private final long maxPrice;

    public WearablePriceSpecification(
            long minPrice,
            long maxPrice
    ) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    @Override
    public boolean test(T wearable) {
        long price = wearable.getPrice();
        return price >= minPrice && price < maxPrice;
    }
}
