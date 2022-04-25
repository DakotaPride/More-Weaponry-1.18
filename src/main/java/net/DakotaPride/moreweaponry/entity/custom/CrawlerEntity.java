package net.DakotaPride.moreweaponry.entity.custom;

import net.DakotaPride.moreweaponry.entity.custom.abstract_cases.AbstractHostileEntity;
import net.DakotaPride.moreweaponry.sound.MoreWeaponrySoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class CrawlerEntity extends AbstractHostileEntity implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);
    public CrawlerEntity(EntityType<? extends AbstractHostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 500.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 11.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.20)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 65.0D)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 2.0f);
    }

    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0D, false));

        this.goalSelector.add(12, new RevengeGoal(this, PlayerEntity.class));
        this.goalSelector.add(13, new RevengeGoal(this, WandererEntity.class));
        this.goalSelector.add(14, new RevengeGoal(this, CracklerEntity.class));
        this.goalSelector.add(15, new RevengeGoal(this, WatcherEntity.class));
        this.goalSelector.add(19, new RevengeGoal(this, SickenedEntity.class));
        this.goalSelector.add(20, new RevengeGoal(this, SickenedHuskEntity.class));
        this.goalSelector.add(16, new RevengeGoal(this, BardEntity.class));
        this.goalSelector.add(17, new RevengeGoal(this, LurkerEntity.class));
        this.goalSelector.add(18, new RevengeGoal(this, SkeletonEntity.class));

        this.goalSelector.add(0, new ActiveTargetGoal<>(this, PlayerEntity.class, true, false));
    }


    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return MoreWeaponrySoundEvents.ENTITY_CRAWLER_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.BLOCK_DEEPSLATE_TILES_HIT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.BLOCK_DEEPSLATE_BREAK;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.BLOCK_DEEPSLATE_STEP, 0.15f, 1.0f);
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.crawler.walk", true));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.crawler.idle", true));
        return PlayState.CONTINUE;
    }
}
