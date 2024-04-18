package net.alberdrocs.darkaethercorruptionmod;

import com.mojang.logging.LogUtils;
import net.alberdrocs.darkaethercorruptionmod.block.ModBlocks;
import net.alberdrocs.darkaethercorruptionmod.incursion.EFIncursion;
import net.alberdrocs.darkaethercorruptionmod.entity.ModEntities;
import net.alberdrocs.darkaethercorruptionmod.entity.client.darkaetherzombie.DarkAetherZombieRenderer;
import net.alberdrocs.darkaethercorruptionmod.entity.client.mimic.MimicRenderer;
import net.alberdrocs.darkaethercorruptionmod.entity.client.screamer.ScreamerRenderer;
import net.alberdrocs.darkaethercorruptionmod.entity.client.tempest.TempestRenderer;
import net.alberdrocs.darkaethercorruptionmod.incursion.Incursions;
import net.alberdrocs.darkaethercorruptionmod.incursion.OverworldIncursion;
import net.alberdrocs.darkaethercorruptionmod.item.ModCreativeModTabs;
import net.alberdrocs.darkaethercorruptionmod.item.ModItems;
import net.alberdrocs.darkaethercorruptionmod.loot.ModLootModifiers;
import net.alberdrocs.darkaethercorruptionmod.sound.ModSounds;
import net.alberdrocs.darkaethercorruptionmod.worldgen.biome.surface.ModSurfaceRules;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.raid.Raids;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(DarkAetherCorruptionMod.MOD_ID)
public class DarkAetherCorruptionMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "darkaethercorruptionmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final List<EFIncursion> FACILITIES_INCURSIONS = new ArrayList<>();
    //public static final List<OverworldIncursion> OVERWORLD_INCURSIONS = new ArrayList<>();

    public static Incursions incursions;

    public DarkAetherCorruptionMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModSounds.register(modEventBus);

        ModEntities.register(modEventBus);

        ModLootModifiers.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);


    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        //SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, ModSurfaceRules.makeRules());

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.DARK_AETHER_CRYSTAL);
            event.accept(ModItems.REFINED_DARK_AETHER_CRYSTAL);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        ServerLevel level = event.getServer().getLevel(Level.OVERWORLD);
        incursions = level.getDataStorage().computeIfAbsent((p_184095_) -> {
            return Incursions.load(level, p_184095_);
        }, () -> {
            return new Incursions(level);
        }, Incursions.getFileId());
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.DARK_AETHER_ZOMBIE.get(), DarkAetherZombieRenderer::new);
            EntityRenderers.register(ModEntities.SCREAMER.get(), ScreamerRenderer::new);
            EntityRenderers.register(ModEntities.TEMPEST.get(), TempestRenderer::new);
            EntityRenderers.register(ModEntities.MIMIC.get(), MimicRenderer::new);
        }
    }
}
