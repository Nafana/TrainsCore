package net.nafana.TrainsCore.items;

import net.nafana.TrainsCore.TrainsCore;

/**
 * Created by Nafana on 2018-07-03.
 */
public enum TrainModel {

    /** The TrainModel enum is responsible for linking
     *  the schematic file to the type of train.
     * **/
    TIER_1_STEAM("tier_1_steam"),
    TIER_2_STEAM("tier_2_steam"),
    TIER_1_ELECTRIC("tier_1_electric"),
    TIER_2_ELECTRIC("tier_2_electric");

    /** The name of the schematic file which contains the model, as well as the file extensions. **/
    private final String schemName;
    private final String schematicFileExtention = ".schematic";
    private final String fileSeparator = "\\";

    TrainModel (String schematicFileName) {
        this.schemName = schematicFileName;
    }

    /** Gets the path to the schematic file **/
    public String getBuildPathForModel() {
        return TrainsCore.getTrainsCore().getDataFolder().toPath() + TrainsCore.schematicsResourceFolderName()
                + fileSeparator + schemName + schematicFileExtention;
    }

    public String getSchemName () {
        return this.schemName;
    }



}
