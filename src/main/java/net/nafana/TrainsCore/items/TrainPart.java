package net.nafana.TrainsCore.items;

import net.nafana.TrainsCore.TrainsCore;

/**
 * @author Created by Nafana on 2018-07-03.
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

    /**
     * Instantiates a new Train part.
     *
     * @param trainPartName  the train part name
     * @param trainPartModel the train part model
     * @param partWeight     the part weight
     */
    public TrainPart(String trainPartName, String trainPartModel, float partWeight) {
        this.partModel = trainPartModel;
        this.partName = trainPartName;
        this.weight = partWeight;
    }

    /**
     * Gets part model.
     *
     * @return the part model
     */
    public String getPartModel() {
        return partModel;
    }

    /**
     * Gets part name.
     *
     * @return the part name
     */
    public String getPartName() {
        return partName;
    }

    /**
     * Gets weight.
     *
     * @return the weight
     */
    public float getWeight() {
        return weight;
    }

    /**
     * Gets the path to the schematic file  @return the build path for model
     */
    public String getBuildPathForModel() {
        return TrainsCore.getTrainsCore().getDataFolder().toPath() + TrainsCore.schematicsResourceFolderName()
                + "\\" + this.partModel + ".schematic";
    }
}
