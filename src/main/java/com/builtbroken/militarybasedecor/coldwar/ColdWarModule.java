package com.builtbroken.militarybasedecor.coldwar;

import com.builtbroken.mc.lib.mod.loadable.ILoadable;
import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.coldwar.content.BlockAsphalt;
import com.builtbroken.militarybasedecor.coldwar.content.BlockBarbedWire;
import com.builtbroken.militarybasedecor.coldwar.content.BlockConcrete;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

/** Content themed after cold ware military bunkers and bases
 * Created by robert on 12/7/2014.
 */
public class ColdWarModule implements ILoadable
{

    public static Block concrete;
    public static Block reinforcedGlass;
    public static Block reinforcedRails;
    public static Block spikes;
    public static Block barbedWire;
    public static Block asphalt;

    @Override
    public void preInit()
    {
        concrete = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockConcrete.class);
        asphalt = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockAsphalt.class);
        // barbedWire = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockBarbedWire.class);
        MilitaryBaseDecor.CREATIVE_TAB.itemStack = new ItemStack(concrete);
    }

    @Override
    public void init()
    {

    }

    @Override
    public void postInit()
    {

    }
}
