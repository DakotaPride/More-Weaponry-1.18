package net.DakotaPride.moreweaponry.world.features;

import net.DakotaPride.moreweaponry.block.ModBlocks;
import net.DakotaPride.moreweaponry.tag.ModBlockTags;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.tag.BlockTags;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModOreConfiguredFeatures extends OreConfiguredFeatures {

    public static final RuleTest SAND_REPLACEABLE_OVERWORLD = new TagMatchRuleTest(ModBlockTags.SAND_REPLACEABLE_OVERWORLD);
    public static final RuleTest DRIPSTONE_REPLACEABLE_OVERWORLD = new TagMatchRuleTest(ModBlockTags.DRIPSTONE_REPLACEABLE_OVERWORLD);




}