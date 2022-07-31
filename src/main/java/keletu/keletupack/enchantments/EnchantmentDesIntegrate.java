package keletu.keletupack.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.EntityEquipmentSlot;

public class EnchantmentDesIntegrate extends Enchantment {
    public EnchantmentDesIntegrate(int id) {
        super(Rarity.UNCOMMON, EnumEnchantmentType.DIGGER, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
        this.setRegistryName("desentegrate");
        this.setName("desentegrate");

        EnchantmentsKP.ENCHANTNENTS.add(this);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    protected boolean canApplyTogether(Enchantment ench) {
        return ench != EnchantmentsKP.tunnel && ench != Enchantments.EFFICIENCY;
    }

    @Override
    public int getMinEnchantability(int level)
    {
        return 25;
    }

    @Override
    public int getMaxEnchantability(int level)
    {
        return 55;
    }
}