package net.nafana.TrainsCore.items.trainparts.types;

import net.nafana.TrainsCore.items.TrainPart;

/**
 * @author Created by Nafana on 2018-07-03.
 */
public class TrainPartFreightHolder extends TrainPart {

    private int maxSpacePoints;

    /**
     * Instantiates a new Train part freight holder.
     *
     * @param trainPartName  the train part name
     * @param trainPartModel the train part model
     * @param partWeight     the part weight
     * @param maxSpacePoints the max space points
     */
    public TrainPartFreightHolder(String trainPartName, String trainPartModel, float partWeight, int maxSpacePoints) {
        super(trainPartName, trainPartModel, partWeight);
        this.maxSpacePoints = maxSpacePoints;
    }

    /**
     * Gets max space points.
     *
     * @return the max space points
     */
    public int getMaxSpacePoints() {
        return maxSpacePoints;
    }
}
