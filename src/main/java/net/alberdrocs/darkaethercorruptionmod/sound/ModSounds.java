package net.alberdrocs.darkaethercorruptionmod.sound;

import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DarkAetherCorruptionMod.MOD_ID);

    public static final RegistryObject<SoundEvent> DARK_AETHER_ZOMBIE_AMBIENT = registerSoundEvents("dark_aether_zombie_ambient");
    public static final RegistryObject<SoundEvent> DARK_AETHER_ZOMBIE_ATTACK = registerSoundEvents("dark_aether_zombie_attack");

    public static final RegistryObject<SoundEvent> SCREAMER_CHASE = registerSoundEvents("screamer_chase");
    public static final RegistryObject<SoundEvent> SCREAMER_EXPLOSION = registerSoundEvents("screamer_explosion");

    public static final RegistryObject<SoundEvent> TEMPEST_AMBIENT = registerSoundEvents("tempest_ambient");
    public static final RegistryObject<SoundEvent> TEMPEST_TELEPORT = registerSoundEvents("tempest_teleport");
    public static final RegistryObject<SoundEvent> TEMPEST_DEATH = registerSoundEvents("tempest_death");

    public static final RegistryObject<SoundEvent> MIMIC_ATTACK = registerSoundEvents("mimic_attack");
    public static final RegistryObject<SoundEvent> MIMIC_DEATH = registerSoundEvents("mimic_death");
    public static final RegistryObject<SoundEvent> MIMIC_SPAWN = registerSoundEvents("mimic_spawn");


    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name,
                () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
