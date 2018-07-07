package net.nafana.TrainsCore.items.trainparts.types;

import net.nafana.TrainsCore.items.TrainPart;

/**
 * Created by Nafana on 2018-07-03.
 */
public class TrainPartPilot extends TrainPart {

    private float maxSpeed;
    private float maxTowWeight;

    public TrainPartPilot(String trainPartName, String trainPartModel, float partWeight) {
        super(trainPartName, trainPartModel, partWeight);
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public float getMaxTowWeight() {
        return maxTowWeight;
    }
}
