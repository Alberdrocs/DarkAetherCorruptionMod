package net.alberdrocs.darkaethercorruptionmod.entity.client.mimic;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
import net.alberdrocs.darkaethercorruptionmod.entity.client.ModModelLayers;
import net.alberdrocs.darkaethercorruptionmod.entity.custom.MimicEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MimicRenderer extends MobRenderer<MimicEntity, EntityModel<MimicEntity>> {
    private final EntityModel<MimicEntity> normal;
    private final EntityModel<MimicEntity> hiding;

    public MimicRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new MimicModel<>(pContext.bakeLayer(ModModelLayers.MIMIC_LAYER)), 0.5f);
        this.normal = new MimicModel<>(pContext.bakeLayer(ModModelLayers.MIMIC_LAYER));
        this.hiding = new MimicHidingModel<>(pContext.bakeLayer(ModModelLayers.MIMIC_HIDING_LAYER));
    }

    @Override
    public ResourceLocation getTextureLocation(MimicEntity pEntity) {
        return new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "textures/entity/mimic_texture.png");
    }

    @Override
    public void render(MimicEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isHiding()){
            this.model = this.hiding;
        } else {
            this.model = this.normal;
        }
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }


}
