package com.builtbroken.militarybasedecor.modules.worldwar2;

import com.builtbroken.mc.lib.mod.loadable.AbstractLoadable;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.core.ConfigManager;
import com.builtbroken.militarybasedecor.modules.prefab.BlockPrefabStairs;
import com.builtbroken.militarybasedecor.modules.worldwar2.content.block.*;
import com.builtbroken.militarybasedecor.modules.worldwar2.content.item.ItemChocolate;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class WorldWar2Module extends AbstractLoadable {

    public static Block corrugatedGalvanisedIronBlock;
    public static Block oliveDrabTexturedBlock;
    public static Block ammunitionBox;
    public static Block equipmentCrate;
    public static Block reinforcedConcrete;
    public static Block reinforcedConcreteStairs;


    public static Item chocolate;

    @Override
    public void preInit() {
        if (ConfigManager.CHOCOLATE_ENABLED) {
            chocolate = MilitaryBaseDecor.INSTANCE.getManager().newItem("chocolate", new ItemChocolate(0, 0F, false).setPotionEffect(20, 60, 1, 1F).setUnlocalizedName("chocolate").setTextureName(MilitaryBaseDecor.DOMAIN + "chocolate").setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB_1));
        }
        ammunitionBox = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockAmmunitionBox.class, ItemBlockWorldWar2.class);
        corrugatedGalvanisedIronBlock = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockCorrugatedGalvanisedIron.class, ItemBlockCorrugatedGalvanisedIron.class);
        oliveDrabTexturedBlock = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockOliveDrabTexturedBlock.class, ItemBlockWorldWar2.class);
        equipmentCrate = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockEquipmentCrate.class, ItemBlockWorldWar2.class);
        reinforcedConcrete = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedConcrete.class, ItemBlockWorldWar2.class);
        reinforcedConcreteStairs = MilitaryBaseDecor.INSTANCE.getManager().newBlock("reinforced_concrete_stairs", new BlockPrefabStairs(reinforcedConcrete, 1).setBlockName("reinforced_concrete_stairs").setResistance(150).setHardness(15).setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB_1).setStepSound(Block.soundTypeStone), ItemBlockWorldWar2.class);
        MilitaryBaseDecor.CREATIVE_TAB_1.itemStack = new ItemStack(ammunitionBox);
    }

    @Override
    public void postInit() {

        WW2Recipes.initItemRecipes();
        WW2Recipes.initBlockRecipes();
    }
}