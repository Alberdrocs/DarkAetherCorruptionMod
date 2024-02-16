package net.alberdrocs.darkaethercorruptionmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
import net.alberdrocs.darkaethercorruptionmod.entity.custom.TempestEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TempestRenderer extends MobRenderer<TempestEntity, TempestModel<TempestEntity>> {
    public TempestRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new TempestModel<>(pContext.bakeLayer(ModModelLayers.TEMPEST_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(TempestEntity pEntity) {
        return new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "textures/entity/tempest_texture.png");
    }

    @Override
    public void render(TempestEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}