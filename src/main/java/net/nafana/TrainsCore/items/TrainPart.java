package net.nafana.TrainsCore.items;

/**
 * Created by Nafana on 2018-07-03.
 */
public abstract class TrainPart {

    /** The definition of a Train on the server.
     *      This is the class that all further trains parts should extend from.
     *
     *  partModel - the schematic for the model of the part
     *  partName - the name of the particular
     *  weight - the weight of the part
     *
     * **/
    private TrainModel partModel;
    private String partName;

    private float weight;

    public TrainPart(String trainPartName, TrainModel trainPartModel, float partWeight) {
        this.partModel = trainPartModel;
        this.partName = trainPartName;
        this.weight = partWeight;
    }

    public TrainModel getPartModel() {
        return partModel;
    }

    public String getPartName() {
        return partName;
    }

    public float getWeight() {
        return weight;
    }
}
