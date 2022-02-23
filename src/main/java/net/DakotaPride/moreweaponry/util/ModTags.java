package net.DakotaPride.moreweaponry.util;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        private static Tag.Identified<Block> createTag(String name) {
            return TagFactory.BLOCK.create(new Identifier(MoreWeaponry.MOD_ID, name));
        }

        private static Tag.Identified<Block> createCommonTag(String name) {
            return TagFactory.BLOCK.create(new Identifier("c", name));
        }
    }

    public static class Items {
        public static final Tag.Identified<Item> BATTLEAXES = createCommonTag("battleaxes");
        public static final Tag.Identified<Item> ESSENCE = createCommonTag("essence");
        public static final Tag.Identified<Item> HANDLES = createCommonTag("handles");
        public static final Tag.Identified<Item> RAPIERS = createCommonTag("rapiers");
        public static final Tag.Identified<Item> SHIELDS = createCommonTag("shields");
        public static final Tag.Identified<Item> BLUESTONE = createCommonTag("bluestone");
        public static final Tag.Identified<Item> COBBLED_BLUESTONE = createCommonTag("cobbled_bluestone");


        private static Tag.Identified<Item> createTag(String name) {
            return TagFactory.ITEM.create(new Identifier(MoreWeaponry.MOD_ID, name));
        }

        private static Tag.Identified<Item> createCommonTag(String name) {
            return TagFactory.ITEM.create(new Identifier("c", name));
        }
    }

}