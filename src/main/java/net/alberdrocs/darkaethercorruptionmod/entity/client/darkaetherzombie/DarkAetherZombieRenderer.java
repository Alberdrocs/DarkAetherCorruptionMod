package net.alberdrocs.darkaethercorruptionmod.entity.client.darkaetherzombie;

import com.mojang.blaze3d.vertex.PoseStack;
import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
import net.alberdrocs.darkaethercorruptionmod.entity.client.ModModelLayers;
import net.alberdrocs.darkaethercorruptionmod.entity.custom.DarkAetherZombieEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DarkAetherZombieRenderer extends MobRenderer<DarkAetherZombieEntity, DarkAetherZombieModel<DarkAetherZombieEntity>> {

    public DarkAetherZombieRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new DarkAetherZombieModel<>(pContext.bakeLayer(ModModelLayers.DARK_AETHER_ZOMBIE_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(DarkAetherZombieEntity pEntity) {
        return new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "textures/entity/dark_aether_zombie_texture.png");
    }

    @Override
    public void render(DarkAetherZombieEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
