package net.alberdrocs.darkaethercorruptionmod.block;

import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
import net.alberdrocs.darkaethercorruptionmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DarkAetherCorruptionMod.MOD_ID);

    //TODO: Change block properties
    public static final RegistryObject<Block> DARK_AETHER_CRYSTAL_BLOCK = registerBlock
            ("dark_aether_crystal_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)));

    public static final RegistryObject<Block> DARK_AETHER_CRYSTAL_ORE = registerBlock("dark_aether_crystal_ore",
                    () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).strength(2f)
                            .requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> CORRUPTED_GRASS_BLOCK = registerBlock
            ("corrupted_grass_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK)));

    public static final RegistryObject<Block> CORRUPTED_DIRT = registerBlock
            ("corrupted_dirt", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));

    public static final RegistryObject<Block> CORRUPTED_DARK_OAK_LOG = registerBlock
            ("corrupted_dark_oak_log", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
