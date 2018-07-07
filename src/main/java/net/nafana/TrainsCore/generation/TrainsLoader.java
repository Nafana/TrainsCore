package net.nafana.TrainsCore.generation;

import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.extent.Extent;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormat;
import com.sk89q.worldedit.function.mask.ExistingBlockMask;
import com.sk89q.worldedit.function.operation.ForwardExtentCopy;
import com.sk89q.worldedit.function.operation.Operations;
import com.sk89q.worldedit.math.transform.AffineTransform;
import com.sk89q.worldedit.world.registry.WorldData;
import net.nafana.TrainsCore.TrainsCore;
import net.nafana.TrainsCore.items.TrainPart;
import org.bukkit.Location;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nafana on 2018-07-03.
 */
public final class TrainsLoader {

    private List<TrainPart> cachedTrainPartsList = new ArrayList<>();

    public TrainsLoader() {}

    /** Adds a train part to the cached list **/
    public void addTrainPart(TrainPart trainPart) {
        this.cachedTrainPartsList.add(trainPart);
    }

    /** Removes a train from the cached storage by name**/
    public void removeTrainPart(String trainPartName) {
        for (TrainPart part: cachedTrainPartsList) {
            if (part.getPartName().equals(trainPartName)) {
                this.cachedTrainPartsList.remove(part);
            }
        }
    }

    /** Removes a train from the cached storage by object**/
    public void removeTrainPart(TrainPart trainPart) {
        if (this.cachedTrainPartsList.contains(trainPart)) {
            this.cachedTrainPartsList.remove(trainPart);
        }
    }

    public TrainPart getTrainPartFromName(String trainPartName) {
        for (TrainPart part: cachedTrainPartsList) {
            if (part.getPartName().equals(trainPartName)) {
                return part;
            }
        }
        return null;
    }

    /** Spawns a TrainPart object from it's name into the given location. **/
    public void spawnTrainPart(String trainPartName, Location location, boolean ignoreAirBlocks) {
        TrainPart part = getTrainPartFromName(trainPartName);
        if (part == null) { return; }
        spawnTrainPart(part, location, ignoreAirBlocks);
    }

    /** Spawns a TrainPart object into the given location. **/
    public void spawnTrainPart(TrainPart trainPart, Location location, boolean ignoreAirBlocks) {
        File trainPartSchematic = new File(trainPart.getBuildPathForModel());
        if (!trainPartSchematic.exists()) { return; }

        com.sk89q.worldedit.Vector spawnPosition = new com.sk89q.worldedit.Vector(location.getX(), location.getY(), location.getZ());

        com.sk89q.worldedit.world.World weWorld = new BukkitWorld(TrainsCore.getTrainsCore().getServer().getWorld("world"));
        WorldData worldData = weWorld.getWorldData();
        Clipboard clipboard = null;

        try {
            clipboard = ClipboardFormat.SCHEMATIC.getReader(new FileInputStream(trainPartSchematic)).read(worldData);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (clipboard == null) {return;}

        Extent extent = WorldEdit.getInstance().getEditSessionFactory().getEditSession(weWorld, -1);
        AffineTransform transform = new AffineTransform();

        ForwardExtentCopy copy = new ForwardExtentCopy(extent, clipboard.getRegion(), clipboard.getOrigin(), extent, spawnPosition);
        if (!transform.isIdentity()) copy.setTransform(transform);
        if (ignoreAirBlocks) {
            copy.setSourceMask(new ExistingBlockMask(clipboard));
        }
        try {
            Operations.completeLegacy(copy);
        } catch (MaxChangedBlocksException e) {
            e.printStackTrace();
        }
    }


}
