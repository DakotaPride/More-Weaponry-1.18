package net.DakotaPride.moreweaponry.entity;

import com.google.common.collect.ImmutableSet;
import net.minecraft.entity.*;
import net.minecraft.util.registry.Registry;

public class ModEntityType extends EntityType {
    public ModEntityType(EntityFactory<Entity> factory, SpawnGroup spawnGroup, boolean saveable, boolean summonable, boolean fireImmune, boolean spawnableFarFromPlayer, ImmutableSet<net.minecraft.block.Block> canSpawnInside, EntityDimensions dimensions, int maxTrackDistance, int trackTickInterval) {
        super(factory, spawnGroup, saveable, summonable, fireImmune, spawnableFarFromPlayer, canSpawnInside, dimensions, maxTrackDistance, trackTickInterval);
    }

    private static EntityFactory<SuppressedExplosiveEntity> SuppressedExplosiveEntity;
    public static final EntityType<SuppressedExplosiveEntity> SUPPRESSED_EXPLOSIVE = ModEntityType.modregister
            ("suppressed_explosive", Builder.create(SuppressedExplosiveEntity, SpawnGroup.MISC)
                    .makeFireImmune().setDimensions(0.98f, 0.98f).maxTrackingRange(10).trackingTickInterval(10));

    private static <T extends Entity> EntityType<T> modregister(String id, Builder<T> type) {
        return Registry.register(Registry.ENTITY_TYPE, id, type.build(id));
    }

    public static void setSuppressedExplosiveEntity(EntityFactory<SuppressedExplosiveEntity> suppressedExplosiveEntity) {
        SuppressedExplosiveEntity = suppressedExplosiveEntity;
    }
}