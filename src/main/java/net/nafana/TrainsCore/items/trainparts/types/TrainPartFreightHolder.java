package net.nafana.TrainsCore.items.trainparts.types;

import net.nafana.TrainsCore.items.TrainPart;

/**
 * Created by Nafana on 2018-07-03.
 */
public class TrainPartFreightHolder extends TrainPart {

    private int maxSpacePoints;

    public TrainPartFreightHolder(String trainPartName, String trainPartModel, float partWeight,int maxSpacePoints) {
        super(trainPartName, trainPartModel, partWeight);
        this.maxSpacePoints = maxSpacePoints;
    }

    public int getMaxSpacePoints() {
        return maxSpacePoints;
    }
}
