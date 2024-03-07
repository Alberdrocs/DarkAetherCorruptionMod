package net.alberdrocs.darkaethercorruptionmod.block;

import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
import net.alberdrocs.darkaethercorruptionmod.block.custom.AetherNeutralizerBlock;
import net.alberdrocs.darkaethercorruptionmod.block.custom.InactiveDarkAetherPortalBlock;
import net.alberdrocs.darkaethercorruptionmod.block.custom.ModFlammableRotatedPillarBlock;
import net.alberdrocs.darkaethercorruptionmod.item.ModItems;
import net.alberdrocs.darkaethercorruptionmod.worldgen.tree.CorruptedBirchTreeGrower;
import net.alberdrocs.darkaethercorruptionmod.worldgen.tree.CorruptedOakTreeGrower;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
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
    public static final RegistryObject<Block> DARK_AETHER_CRYSTAL_ORE = registerBlock
            ("dark_aether_crystal_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    //************************
    // DIRT
    //************************
    public static final RegistryObject<Block> CORRUPTED_GRASS_BLOCK = registerBlock
            ("corrupted_grass_block", () -> new GrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK)));
    public static final RegistryObject<Block> CORRUPTED_DIRT = registerBlock
            ("corrupted_dirt", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));


    //************************
    // OAK BLOCKS
    //************************
    public static final RegistryObject<Block> CORRUPTED_DARK_OAK_LOG = registerBlock
            ("corrupted_dark_oak_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> CORRUPTED_ACACIA_LOG = registerBlock
            ("corrupted_acacia_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_LOG)));
    public static final RegistryObject<Block> CORRUPTED_BIRCH_LOG = registerBlock
            ("corrupted_birch_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_LOG)));
    public static final RegistryObject<Block> CORRUPTED_CHERRY_LOG = registerBlock
            ("corrupted_cherry_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_LOG)));
    public static final RegistryObject<Block> CORRUPTED_JUNGLE_LOG = registerBlock
            ("corrupted_jungle_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_LOG)));
    public static final RegistryObject<Block> CORRUPTED_MANGROVE_LOG = registerBlock
            ("corrupted_mangrove_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_LOG)));
    public static final RegistryObject<Block> CORRUPTED_SPRUCE_LOG = registerBlock
            ("corrupted_spruce_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_LOG)));


    //************************
    // SAPLINGS
    //************************
    public static final RegistryObject<Block> CORRUPTED_OAK_SAPLING = registerBlock("corrupted_oak_sapling",
            () -> new SaplingBlock(new CorruptedOakTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> CORRUPTED_BIRCH_SAPLING = registerBlock("corrupted_birch_sapling",
            () -> new SaplingBlock(new CorruptedBirchTreeGrower(), BlockBehaviour.Properties.copy(Blocks.BIRCH_SAPLING)));


    //************************
    // STONE
    //************************
    public static final RegistryObject<Block> CORRUPTED_STONE = registerBlock
            ("corrupted_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> AETHER_STONE_BRICKS = registerBlock
            ("aether_stone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));
    public static final RegistryObject<Block> AETHER_STONE_STAIRS = registerBlock
            ("aether_stone_stairs", () -> new StairBlock(() -> ModBlocks.AETHER_STONE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));
    public static final RegistryObject<Block> AETHER_STONE_SLAB = registerBlock("aether_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> AETHER_STONE_FENCE = registerBlock("aether_stone_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> AETHER_STONE_FENCE_GATE = registerBlock("aether_stone_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST), SoundEvents.CHAIN_PLACE, SoundEvents.ANVIL_BREAK));
    public static final RegistryObject<Block> AETHER_STONE_WALL = registerBlock("aether_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));


    public static final RegistryObject<Block> AETHER_INFUSED_DOOR = registerBlock("aether_infused_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST).noOcclusion(), BlockSetType.IRON));

    public static final RegistryObject<Block> AETHER_NEUTRALIZER = registerBlock
            ("aether_neutralizer", () -> new AetherNeutralizerBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> INACTIVE_DARK_AETHER_PORTAL = registerBlock
            ("inactive_dark_aether_portal",
                    () -> new InactiveDarkAetherPortalBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_PORTAL)
                    .noLootTable()
                    .noOcclusion()));



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
