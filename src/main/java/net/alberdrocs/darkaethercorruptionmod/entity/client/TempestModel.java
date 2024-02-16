package net.alberdrocs.darkaethercorruptionmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.alberdrocs.darkaethercorruptionmod.entity.animations.ModAnimationDefinitions;
import net.alberdrocs.darkaethercorruptionmod.entity.custom.TempestEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class TempestModel <T extends Entity> extends HierarchicalModel<T> {
    private final ModelPart tempest;
    private final ModelPart head;

    public TempestModel(ModelPart root){
        this.tempest = root.getChild("tempest");
        this.head = tempest.getChild("body").getChild("upper_body").getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition tempest = partdefinition.addOrReplaceChild("tempest", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body = tempest.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition upper_body = body.addOrReplaceChild("upper_body", CubeListBuilder.create(), PartPose.offset(0.0F, -12.0F, 0.0F));

        PartDefinition torso = upper_body.addOrReplaceChild("torso", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition pelvis = torso.addOrReplaceChild("pelvis", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -5.0F, 2.0F, 8.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(30, 31).addBox(-4.0F, -4.0F, -1.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(24, 31).addBox(4.0F, -4.0F, -1.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 1).addBox(4.0F, -3.0F, -2.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-4.0F, -3.0F, -2.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 0).addBox(-4.0F, -2.0F, -2.0F, 8.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(32, 20).addBox(-4.0F, -3.0F, -2.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(32, 19).addBox(1.0F, -3.0F, -2.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));

        PartDefinition spine = torso.addOrReplaceChild("spine", CubeListBuilder.create().texOffs(26, 18).addBox(-1.0F, -16.0F, 1.0F, 2.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));

        PartDefinition ribcage = torso.addOrReplaceChild("ribcage", CubeListBuilder.create().texOffs(0, 10).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 17).addBox(-3.0F, -8.0F, -2.0F, 6.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(29, 30).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(32, 3).addBox(1.0F, -12.0F, 1.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 31).addBox(-4.0F, -12.0F, 1.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition right_arm = upper_body.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(24, 4).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -10.0F, 0.0F));

        PartDefinition left_arm = upper_body.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(8, 22).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -10.0F, 0.0F));

        PartDefinition head = upper_body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 10).addBox(-3.0F, -8.0F, -3.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 4).addBox(2.0F, -8.0F, -3.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(32, 8).addBox(-2.0F, -8.0F, -3.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(31, 17).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-3.0F, -8.0F, -2.0F, 6.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 0.0F));

        PartDefinition right_leg = body.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 22).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

        PartDefinition left_leg = body.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(18, 17).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

        this.animate(((TempestEntity) entity).hoverAnimationState, ModAnimationDefinitions.TEMPEST_HOVER, ageInTicks, 1.0F);
    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        tempest.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return tempest;
    }
}
