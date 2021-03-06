package net.nafana.TrainsCore.items;

import net.nafana.TrainsCore.TrainsCore;

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
    private String partModel;
    private String partName;

    private float weight;

    public TrainPart(String trainPartName, String trainPartModel, float partWeight) {
        this.partModel = trainPartModel;
        this.partName = trainPartName;
        this.weight = partWeight;
    }

    public String getPartModel() {
        return partModel;
    }

    public String getPartName() {
        return partName;
    }

    public float getWeight() {
        return weight;
    }

    /** Gets the path to the schematic file **/
    public String getBuildPathForModel() {
        return TrainsCore.getTrainsCore().getDataFolder().toPath() + TrainsCore.schematicsResourceFolderName()
                + "\\" + this.partModel + ".schematic";
    }
}
