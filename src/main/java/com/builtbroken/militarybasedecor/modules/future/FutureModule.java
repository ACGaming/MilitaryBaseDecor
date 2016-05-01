package com.builtbroken.militarybasedecor.modules.future;

import com.builtbroken.mc.lib.mod.loadable.AbstractLoadable;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.modules.future.content.block.*;
import com.builtbroken.militarybasedecor.core.ConfigManager;
import net.minecraft.block.Block;

/**
 * A module set in the future, this module allows for a lot more imagination than the other modules.
 * Created by Ole on 4/27/2015.
 */
public class FutureModule extends AbstractLoadable {

    public static Block meshedFloorPanel;
    public static Block glassFloorPanel;
    public static Block reinforcedGlassPanel;
    public static Block metalMeshBlock;

    @Override
    public void preInit() {

        meshedFloorPanel = MilitaryBaseDecor.INSTANCE.getManager().newBlock("meshed_floor_panel", new TileMeshedFloorPanel()).setBlockName("meshed_floor_panel");
        glassFloorPanel = MilitaryBaseDecor.INSTANCE.getManager().newBlock("glass_floor_panel", new TileGlassFloorPanel()).setBlockName("glass_floor_panel");
        metalMeshBlock = MilitaryBaseDecor.INSTANCE.getManager().newBlock("metal_mesh_block", new BlockMetalMeshBlock().setBlockName("metal_mesh_block"), ItemBlockFuture.class);

        if (ConfigManager.VANILLA_ENABLED) {
            reinforcedGlassPanel = MilitaryBaseDecor.INSTANCE.getManager().newBlock("reinforced_glass_floor_panel", new TileReinforcedGlassFloorPanel()).setBlockName("reinforced_glass_floor_panel");
        }
    }

    @Override
    public void postInit() {
        FutureRecipes.initItemRecipes();
        FutureRecipes.initBlockRecipes();
    }
}