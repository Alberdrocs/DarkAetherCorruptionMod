package net.alberdrocs.darkaethercorruptionmod.entity.client.screamer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
import net.alberdrocs.darkaethercorruptionmod.entity.client.ModModelLayers;
import net.alberdrocs.darkaethercorruptionmod.entity.custom.ScreamerEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ScreamerRenderer extends MobRenderer<ScreamerEntity, ScreamerModel<ScreamerEntity>> {
    public ScreamerRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ScreamerModel<>(pContext.bakeLayer(ModModelLayers.SCREAMER_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(ScreamerEntity pEntity) {
        return new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "textures/entity/screamer_texture.png");
    }

    @Override
    public void render(ScreamerEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
