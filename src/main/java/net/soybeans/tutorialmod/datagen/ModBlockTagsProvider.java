package net.soybeans.tutorialmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.soybeans.tutorialmod.TutorialMod;
import net.soybeans.tutorialmod.block.ModBlocks;

import java.util.concurrent.CompletableFuture;


public class ModBlockTagsProvider extends BlockTagsProvider{

    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, TutorialMod.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.getRK(ModBlocks.BISMUTH_BLOCK.get()))
                .add(ModBlocks.getRK(ModBlocks.BISMUTH_ORE.get()))
                .add(ModBlocks.getRK(ModBlocks.DEEPSLATE_BISMUTH_ORE.get()));

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BISMUTH_BLOCK.unwrapKey().orElseThrow())
                .add(ModBlocks.getRK(ModBlocks.BISMUTH_BLOCK.get()))
                .add(ModBlocks.getRK(ModBlocks.BISMUTH_ORE.get()))
                .add(ModBlocks.getRK(ModBlocks.DEEPSLATE_BISMUTH_ORE.get()));

    }


}