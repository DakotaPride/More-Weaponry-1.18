package net.DakotaPride.moreweaponry.item.custom.elder_scale_items;

import net.DakotaPride.moreweaponry.item.custom.mod_tools.ModKnifeItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;

public class ElderScaleKnife extends ModKnifeItem {
    public ElderScaleKnife(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 200, 2), attacker);
        return super.postHit(stack, target, attacker);
    }
}