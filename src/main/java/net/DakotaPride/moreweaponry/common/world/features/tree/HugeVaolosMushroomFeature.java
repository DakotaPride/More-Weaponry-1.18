package net.DakotaPride.moreweaponry.common.world.features.tree;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.MushroomBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.HugeMushroomFeature;
import net.minecraft.world.gen.feature.HugeMushroomFeatureConfig;

public class HugeVaolosMushroomFeature extends HugeMushroomFeature {
    public HugeVaolosMushroomFeature(Codec<HugeMushroomFeatureConfig> codec) {
        super(codec);
    }

    @Override
    protected void generateStem(WorldAccess world, Random random, BlockPos pos, HugeMushroomFeatureConfig config, int height, BlockPos.Mutable mutablePos) {
        for (int i = 0; i < height; i++) {
            mutablePos.set(pos).move(Direction.UP, i);
            if (!world.getBlockState(mutablePos).isOpaqueFullCube(world, mutablePos)) {
                setBlockState(world, mutablePos, config.stemProvider.getBlockState(random, pos));
            }
        }
    }

    @Override
    protected int getHeight(Random random) {
        int i = random.nextInt(6) + 3;
        if (random.nextInt(12) == 0) {
            i *= 3;
        }
        return i;
    }

    @Override
    protected void generateCap(WorldAccess world, Random random, BlockPos start, int y, BlockPos.Mutable mutable, HugeMushroomFeatureConfig config) {
        int i = config.foliageRadius;
        for (int j = -i; j <= i; j++) {
            for (int k = -i; k <= i; k++) {
                boolean bl = (j == -i);
                boolean bl2 = (j == i);
                boolean bl3 = (k == -i);
                boolean bl4 = (k == i);

                boolean bl5 = (bl || bl2);
                boolean bl6 = (bl3 || bl4);
                if (!bl5 || !bl6) {



                    mutable.set(start, j, y, k);
                    if (!world.getBlockState(mutable).isOpaqueFullCube(world, mutable)) {
                        boolean bl7 = (bl || (bl6 && j == 1 - i));
                        boolean bl8 = (bl2 || (bl6 && j == i - 1));
                        boolean bl9 = (bl3 || (bl5 && k == 1 - i));
                        boolean bl10 = (bl4 || (bl5 && k == i - 1));
                        BlockState blockState = config.capProvider.getBlockState(random, start);
                        if (blockState.contains(MushroomBlock.WEST) && blockState
                                .contains(MushroomBlock.EAST) && blockState
                                .contains(MushroomBlock.NORTH) && blockState
                                .contains(MushroomBlock.SOUTH))
                        {




                            blockState = blockState.with(MushroomBlock.WEST, Boolean.valueOf(bl7)).with(MushroomBlock.EAST, Boolean.valueOf(bl8)).with(MushroomBlock.NORTH, Boolean.valueOf(bl9)).with(MushroomBlock.SOUTH, Boolean.valueOf(bl10));
                        }
                        setBlockState(world, mutable, blockState);
                    }
                }
            }
        }
    }

    @Override
    protected int getCapSize(int i, int j, int capSize, int y) {
        return (y <= 3) ? 0 : capSize;
    }
}

