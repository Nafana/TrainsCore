package net.nafana.TrainsCore.data.configurations;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.nafana.TrainsCore.TrainsCore;
import net.nafana.TrainsCore.data.Configuration;
import net.nafana.TrainsCore.data.format.RuntimeTypeAdapterFactory;
import net.nafana.TrainsCore.items.TrainPart;
import net.nafana.TrainsCore.items.trainparts.types.TrainPartCaboose;
import net.nafana.TrainsCore.items.trainparts.types.TrainPartFreightHolder;
import net.nafana.TrainsCore.items.trainparts.types.TrainPartPilot;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nafana on 2018-07-03.
 */
public class TrainPartsConfiguration extends Configuration {

    private static final String trainPartsFileName = "trainparts.json";
    private static final String trainPartsConfigName = "trainparts";

    private RuntimeTypeAdapterFactory<TrainPart> trainAdaptorFactory;

    public TrainPartsConfiguration() {
        super(trainPartsFileName, trainPartsConfigName);
        trainAdaptorFactory = RuntimeTypeAdapterFactory.of(TrainPart.class, "partType")
            .registerSubtype(TrainPartCaboose.class, TrainPartCaboose.class.getName())
            .registerSubtype(TrainPartFreightHolder.class, TrainPartFreightHolder.class.getName())
            .registerSubtype(TrainPartPilot.class, TrainPartPilot.class.getName());
    }

    //** Adds a train part to the configuration file, uses a custom adapter factory
    //   to serialize classes that extend TrainPart.class // **/
    public void addTrainPartEntry(TrainPart trainPart) {
        Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapterFactory(trainAdaptorFactory).create();
        try {
            // First get the existing train parts in the JSON file.
            FileReader fileReader = new FileReader(this.getConfigurationPath());
            List<TrainPart> trainParts = gson.fromJson(fileReader, new TypeToken<List<TrainPart>>(){}.getType());
            fileReader.close();
            if (trainParts == null)
                trainParts = new ArrayList<>();
            // Next add the train part, and write to the file.
            trainParts.add(trainPart);
            Writer fileWriter = new FileWriter(this.getConfigurationPath());
            gson.toJson(trainParts, fileWriter);
            fileWriter.close();
            // Update the Trains Loader class
            TrainsCore.getTrainsLoader().addTrainPart(trainPart);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //** Gets a list of all train parts that were found in the file, uses the custom adapter factory. **//
    public List<TrainPart> getTrainParts() {
        Gson gson = new GsonBuilder().registerTypeAdapterFactory(trainAdaptorFactory).create();
        try {
            FileReader fileReader = new FileReader(this.getConfigurationPath());
            List<TrainPart> trainParts = gson.fromJson(fileReader, new TypeToken<List<TrainPart>>(){}.getType());
            fileReader.close();
            return trainParts;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
