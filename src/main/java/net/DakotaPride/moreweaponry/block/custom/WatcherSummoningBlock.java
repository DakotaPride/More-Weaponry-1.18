package net.DakotaPride.moreweaponry.block.custom;

import com.google.common.collect.Maps;
import net.DakotaPride.moreweaponry.entity.MoreWeaponryEntities;
import net.DakotaPride.moreweaponry.entity.custom.WatcherEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import java.util.Map;

public class WatcherSummoningBlock
        extends Block {
    private final Block regularBlock;
    private static final Map<Block, Block> REGULAR_TO_INFESTED_BLOCK = Maps.newIdentityHashMap();

    /**
     * Creates an infested block
     *
     * @param regularBlock the block this infested block should mimic
     * @param settings block settings
     */
    public WatcherSummoningBlock(Block regularBlock, Settings settings) {
        super(settings);
        this.regularBlock = regularBlock;
        REGULAR_TO_INFESTED_BLOCK.put(regularBlock, this);
    }

    public WatcherSummoningBlock(Settings settings, Block regularBlock) {
        super(settings);
        this.regularBlock = regularBlock;
    }

    public Block getRegularBlock() {
        return this.regularBlock;
    }

    public static boolean isInfestable(BlockState block) {
        return REGULAR_TO_INFESTED_BLOCK.containsKey(block.getBlock());
    }

    private void spawnWatcher(ServerWorld world, BlockPos pos) {
        WatcherEntity watcherEntity = MoreWeaponryEntities.WATCHER.create(world);
        assert watcherEntity != null;
        watcherEntity.refreshPositionAndAngles((double)pos.getX() + 0.5, pos.getY(), (double)pos.getZ() + 0.5, 0.0f, 0.0f);
        world.spawnEntity(watcherEntity);
        watcherEntity.playSpawnEffects();
    }

    @Override
    public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack stack) {
        super.onStacksDropped(state, world, pos, stack);
        if (world.getGameRules().getBoolean(GameRules.DO_TILE_DROPS) && EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, stack) == 0) {
            this.spawnWatcher(world, pos);
        }
    }

    @Override
    public void onDestroyedByExplosion(World world, BlockPos pos, Explosion explosion) {
        if (world instanceof ServerWorld) {
            this.spawnWatcher((ServerWorld)world, pos);
        }
    }


}

