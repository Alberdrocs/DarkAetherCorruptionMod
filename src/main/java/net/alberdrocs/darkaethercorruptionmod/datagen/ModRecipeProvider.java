package net.alberdrocs.darkaethercorruptionmod.datagen;

import net.alberdrocs.darkaethercorruptionmod.block.ModBlocks;
import net.alberdrocs.darkaethercorruptionmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.REFINED_DARK_AETHER_CRYSTAL.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.DARK_AETHER_CRYSTAL.get())
                .unlockedBy(getHasName(ModItems.DARK_AETHER_CRYSTAL.get()), has(ModItems.DARK_AETHER_CRYSTAL.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.DARK_AETHER_CRYSTAL_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.REFINED_DARK_AETHER_CRYSTAL.get())
                .unlockedBy(getHasName(ModItems.REFINED_DARK_AETHER_CRYSTAL.get()), has(ModItems.REFINED_DARK_AETHER_CRYSTAL.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.AETHER_NEUTRALIZER.get())
                .pattern(" X ")
                .pattern("XSX")
                .pattern(" X ")
                .define('S', ModBlocks.DARK_AETHER_CRYSTAL_BLOCK.get())
                .define('X', Blocks.IRON_BLOCK)
                .unlockedBy(getHasName(ModItems.REFINED_DARK_AETHER_CRYSTAL.get()), has(ModItems.REFINED_DARK_AETHER_CRYSTAL.get()))
                .save(pWriter);


        //Armor and tools
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.AETHERIUM_HELMET.get())
                .pattern("   ")
                .pattern("SSS")
                .pattern("S S")
                .define('S', ModItems.REFINED_DARK_AETHER_CRYSTAL.get())
                .unlockedBy(getHasName(ModItems.REFINED_DARK_AETHER_CRYSTAL.get()), has(ModItems.REFINED_DARK_AETHER_CRYSTAL.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.AETHERIUM_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.REFINED_DARK_AETHER_CRYSTAL.get())
                .unlockedBy(getHasName(ModItems.REFINED_DARK_AETHER_CRYSTAL.get()), has(ModItems.REFINED_DARK_AETHER_CRYSTAL.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.AETHERIUM_LEGGINS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', ModItems.REFINED_DARK_AETHER_CRYSTAL.get())
                .unlockedBy(getHasName(ModItems.REFINED_DARK_AETHER_CRYSTAL.get()), has(ModItems.REFINED_DARK_AETHER_CRYSTAL.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.AETHERIUM_BOOTS.get())
                .pattern("   ")
                .pattern("S S")
                .pattern("S S")
                .define('S', ModItems.REFINED_DARK_AETHER_CRYSTAL.get())
                .unlockedBy(getHasName(ModItems.REFINED_DARK_AETHER_CRYSTAL.get()), has(ModItems.REFINED_DARK_AETHER_CRYSTAL.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.AETHERIUM_SWORD.get())
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" # ")
                .define('S', ModItems.REFINED_DARK_AETHER_CRYSTAL.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.REFINED_DARK_AETHER_CRYSTAL.get()), has(ModItems.REFINED_DARK_AETHER_CRYSTAL.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.AETHERIUM_PICKAXE.get())
                .pattern("SSS")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', ModItems.REFINED_DARK_AETHER_CRYSTAL.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.REFINED_DARK_AETHER_CRYSTAL.get()), has(ModItems.REFINED_DARK_AETHER_CRYSTAL.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.AETHERIUM_AXE.get())
                .pattern("SS ")
                .pattern("S# ")
                .pattern(" # ")
                .define('S', ModItems.REFINED_DARK_AETHER_CRYSTAL.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.REFINED_DARK_AETHER_CRYSTAL.get()), has(ModItems.REFINED_DARK_AETHER_CRYSTAL.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.AETHERIUM_SHOVEL.get())
                .pattern(" S ")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', ModItems.REFINED_DARK_AETHER_CRYSTAL.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.REFINED_DARK_AETHER_CRYSTAL.get()), has(ModItems.REFINED_DARK_AETHER_CRYSTAL.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.AETHERIUM_HOE.get())
                .pattern("SS ")
                .pattern(" # ")
                .pattern(" # ")
                .define('S', ModItems.REFINED_DARK_AETHER_CRYSTAL.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.REFINED_DARK_AETHER_CRYSTAL.get()), has(ModItems.REFINED_DARK_AETHER_CRYSTAL.get()))
                .save(pWriter);

        /*ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.REFINED_DARK_AETHER_CRYSTAL.get())
                .requires(ModItems.DARK_AETHER_CRYSTAL.get())
                .requires(Items.DIAMOND)
                .unlockedBy(getHasName(ModBlocks.DARK_AETHER_CRYSTAL_BLOCK.get()), has(ModBlocks.DARK_AETHER_CRYSTAL_BLOCK.get()))
                .save(pWriter);*/
    }
}
