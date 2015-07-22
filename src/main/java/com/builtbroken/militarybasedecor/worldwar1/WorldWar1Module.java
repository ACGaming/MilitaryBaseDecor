package com.builtbroken.militarybasedecor.worldwar1;

import com.builtbroken.mc.lib.mod.loadable.AbstractLoadable;
import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.vanilla.VanillaModule;
import com.builtbroken.militarybasedecor.worldwar1.content.block.BlockBarbedWireFence;
import com.builtbroken.militarybasedecor.worldwar1.content.block.BlockConcertinaWire;
import com.builtbroken.militarybasedecor.worldwar1.content.block.ItemBlockWorldWar1;
import com.builtbroken.militarybasedecor.worldwar1.content.block.TileAdvancedSandbag;
import com.builtbroken.militarybasedecor.worldwar1.content.item.ItemBarbedBundledWire;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class WorldWar1Module extends AbstractLoadable {

    public static Block advancedSandBag;
    public static Block barbedWireFence;
    public static Block concertinaWire;

    public static Item barbedBundledWire;

    @Override
    public void preInit() {
        barbedWireFence = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockBarbedWireFence.class, ItemBlockWorldWar1.class).setBlockUnbreakable();
        concertinaWire = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockConcertinaWire.class, ItemBlockWorldWar1.class);
        advancedSandBag = MilitaryBaseDecor.INSTANCE.getManager().newBlock(TileAdvancedSandbag.class);

        barbedBundledWire = MilitaryBaseDecor.INSTANCE.getManager().newItem(ItemBarbedBundledWire.class).setUnlocalizedName("barbed_bundled_wire");

        MilitaryBaseDecor.CREATIVE_TAB.itemStack = new ItemStack(barbedWireFence);
    }

    @Override
    public void postInit() {
        // Blocks
        // Advanced Sandbag
        GameRegistry.addShapedRecipe(new ItemStack(advancedSandBag, 1, 0), new Object[]{"WWW", "WSW", "WWW", 'W', Blocks.wool, 'S', VanillaModule.sandBag});
        // Barbed Wire Fence
        GameRegistry.addShapedRecipe(new ItemStack(barbedWireFence, 8, 0), "FFF", "FWF", "FFF", 'F', Items.flint, 'W', VanillaModule.wiredFence);

        // Items

    }

}
