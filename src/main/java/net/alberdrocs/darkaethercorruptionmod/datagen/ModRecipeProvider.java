package net.alberdrocs.darkaethercorruptionmod.datagen;

import net.alberdrocs.darkaethercorruptionmod.block.ModBlocks;
import net.alberdrocs.darkaethercorruptionmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.DARK_AETHER_CRYSTAL_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.REFINED_DARK_AETHER_CRYSTAL.get())
                .unlockedBy(getHasName(ModItems.REFINED_DARK_AETHER_CRYSTAL.get()), has(ModItems.REFINED_DARK_AETHER_CRYSTAL.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.REFINED_DARK_AETHER_CRYSTAL.get(), 9)
                .requires(ModBlocks.DARK_AETHER_CRYSTAL_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.DARK_AETHER_CRYSTAL_BLOCK.get()), has(ModBlocks.DARK_AETHER_CRYSTAL_BLOCK.get()))
                .save(pWriter);

        /*ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.REFINED_DARK_AETHER_CRYSTAL.get())
                .requires(ModItems.DARK_AETHER_CRYSTAL.get())
                .requires(Items.DIAMOND)
                .unlockedBy(getHasName(ModBlocks.DARK_AETHER_CRYSTAL_BLOCK.get()), has(ModBlocks.DARK_AETHER_CRYSTAL_BLOCK.get()))
                .save(pWriter);*/
    }
}
