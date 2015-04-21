package com.builtbroken.militarybasedecor.vanilla.content.block.reinforced;

import java.util.List;

import com.builtbroken.mc.lib.helper.BlockUtility;
import com.builtbroken.militarybasedecor.MilitaryBaseDecor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;

public class BlockReinforcedMetal extends BlockReinforced{

	public static float RESISTANCE_SCALE = 7;
	
    public BlockReinforcedMetal()
    {
        super(Material.iron, "reinforcedMetal");
        this.setStepSound(soundTypeMetal);
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "reinforced_metal");
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB);
    }

    /**
     * TODO Once we get the textures we need to specify them here!
     */
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
		return blockIcon;
        
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconRegister)
    {}

    @Override
    public float getBlockHardness(int meta)
    {
        if (meta < ReinforcedMetalMeta.values().length)
        {
            return ReinforcedMetalMeta.values()[meta].hardness;
        }
        return this.blockHardness;
    }

    @Override
    public float getBlockResistance(int meta)
    {
        if (meta < ReinforcedMetalMeta.values().length)
        {
            return ReinforcedMetalMeta.values()[meta].base_resistance * RESISTANCE_SCALE;
        }
        return 35;
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
        for (ReinforcedMetalMeta type : ReinforcedMetalMeta.values())
        {
            list.add(new ItemStack(item, 1, type.ordinal()));
        }
    }

    /**
     * Sub types for this block
     */
    public static enum ReinforcedMetalMeta
    {
        IRON(Blocks.iron_block),
        GOLD(Blocks.gold_block);

        public final float hardness;
        public final float base_resistance;

        private ReinforcedMetalMeta(Block block)
        {
            hardness = BlockUtility.getBlockHardness(block);
            base_resistance = BlockUtility.getBlockResistance(block);
        }

        private ReinforcedMetalMeta(float hardness, float base_resistance)
        {
            this.hardness = hardness;
            this.base_resistance = base_resistance;
        }
    }
}