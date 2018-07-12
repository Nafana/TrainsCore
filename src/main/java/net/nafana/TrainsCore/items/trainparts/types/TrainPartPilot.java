package net.nafana.TrainsCore.items.trainparts.types;

import net.nafana.TrainsCore.items.TrainPart;

/**
 * @author Created by Nafana on 2018-07-03.
 */
public class TrainPartPilot extends TrainPart {

    private float maxSpeed;
    private float maxTowWeight;

    /**
     * Instantiates a new Train part pilot.
     *
     * @param trainPartName  the train part name
     * @param trainPartModel the train part model
     * @param partWeight     the part weight
     */
    public TrainPartPilot(String trainPartName, String trainPartModel, float partWeight) {
        super(trainPartName, trainPartModel, partWeight);
    }

    /**
     * Gets max speed.
     *
     * @return the max speed
     */
    public float getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Gets max tow weight.
     *
     * @return the max tow weight
     */
    public float getMaxTowWeight() {
        return maxTowWeight;
    }
}
