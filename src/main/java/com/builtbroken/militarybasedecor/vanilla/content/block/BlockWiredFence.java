package com.builtbroken.militarybasedecor.vanilla.content.block;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.managers.ConfigManager;
import com.builtbroken.militarybasedecor.vanilla.VanillaModule;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Ole on 3.11.2015.
 */
public class BlockWiredFence extends BlockPane {

    public BlockWiredFence(String texture1, String texture2, Material material, boolean bool) {
        super(texture1, texture2, material, bool);
        this.setHardness(3.0F);
        this.setResistance(10.0F);
        this.setStepSound(soundTypeMetal);
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB_1);
        this.setBlockUnbreakable();
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int int4, float float1, float float2, float float3) {

        if (world.isRemote) {
            return true;
        } else {
            ItemStack itemstack = player.inventory.getCurrentItem();

            if (itemstack == null) {
                return true;
            } else {
                if (itemstack.getItem() == VanillaModule.wireCutters)
                        {
                            world.playSoundEffect(x, y ,z, "militarybasedecor:wirecutters", 2.0F, 1.0F);
                            itemstack.damageItem(1, player);
                            world.setBlockToAir(x, y, z);
                            player.inventory.addItemStackToInventory(new ItemStack(this.getItem(world, x, y, z)));
                            player.inventoryContainer.detectAndSendChanges();
                            if (ConfigManager.WIRECUTTERS_CHAT) {
                                player.addChatMessage(new ChatComponentText(player.getDisplayName() + " cut a Wired Fence"));
                            }
                        }
                        return true;
                    }
            }
        }

    @Override
    public boolean isLadder(IBlockAccess world, int x, int y, int z, EntityLivingBase entity) {
        return true;
    }
}