package com.builtbroken.militarybasedecor.worldwar1.content.block;

import java.util.Random;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BlockConcertinaWire extends Block {
	
	public BlockConcertinaWire()
    {
        super(Material.iron);
        this.setHardness(3.0F);
        this.setResistance(10.0F);
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB);
        this.setBlockName("concertina_wire");
        this.setBlockTextureName(MilitaryBaseDecor.DOMAIN + ":" + "concertina_wire");
    }

    public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
    {
        entity.setInWeb();
        entity.attackEntityFrom(DamageSource.cactus, 1.0F);
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        return null;
    }

    public int getRenderType()
    {
        return 1;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }
}