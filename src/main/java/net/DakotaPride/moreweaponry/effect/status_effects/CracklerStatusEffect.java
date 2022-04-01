package net.DakotaPride.moreweaponry.effect.status_effects;

import net.DakotaPride.moreweaponry.effect.status_effects.base.CelestialEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class CracklerStatusEffect extends CelestialEffect {
    public CracklerStatusEffect(StatusEffectCategory statusEffectCategory, int i) {
        super(statusEffectCategory, i);
    }

    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier) {
        return true;
    }

}
