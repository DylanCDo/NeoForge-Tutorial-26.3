package net.soybeans.tutorialmod.datagen;

import net.minecraft.advancements.Advancement;
import net.minecraft.core.registries.MultiRegistryBootstrap;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import net.soybeans.tutorialmod.block.ModBlocks;
import net.soybeans.tutorialmod.item.ModItems;

import java.util.List;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(BootstrapContext<Recipe<?>> recipeOutput, BootstrapContext<Advancement> advancementOutput) {
        super(recipeOutput, advancementOutput);
    }

    public static MultiRegistryBootstrap create() {
        return RecipeProvider.asBootstrap(ModRecipeProvider::new);
    }

    @Override
    protected void buildRecipes() {
        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BISMUTH_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.BISMUTH.get())
                .unlockedBy(getHasName(ModItems.BISMUTH.get()), has(ModItems.BISMUTH))
                .group("bismuth")
                .save(output);

        shapeless(RecipeCategory.MISC, ModItems.BISMUTH.get(), 9)
                .requires(ModBlocks.BISMUTH_BLOCK)
                .unlockedBy(getHasName(ModBlocks.BISMUTH_BLOCK.get()), has(ModBlocks.BISMUTH_BLOCK))
                .group("bismuth")
                .save(output);

        List<ItemLike> BISMUTH_SMELTABLES = List.of(
                ModItems.RAW_BISMUTH,
                ModBlocks.BISMUTH_ORE,
                ModBlocks.DEEPSLATE_BISMUTH_ORE);

    }
}
