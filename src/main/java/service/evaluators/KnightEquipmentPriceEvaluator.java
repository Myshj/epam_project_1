package service.evaluators;

import models.Knight;
import models.equipment.wearable.Wearable;

import java.util.function.ToLongFunction;

public class KnightEquipmentPriceEvaluator implements ToLongFunction<Knight> {
    @Override
    public long applyAsLong(Knight value) {
        return value.equipment().stream().mapToLong(Wearable::getPrice).sum();
    }
}
