package net.alberdrocs.darkaethercorruptionmod.entity.client.mimic;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.alberdrocs.darkaethercorruptionmod.entity.animations.ModAnimationDefinitions;
import net.alberdrocs.darkaethercorruptionmod.entity.custom.MimicEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class MimicModel<T extends Entity> extends HierarchicalModel<T> {
    private final ModelPart mimic;
    private final ModelPart head;

    public MimicModel(ModelPart root) {
        this.mimic = root.getChild("mimic");
        this.head = mimic.getChild("body").getChild("upper_body").getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition mimic = partdefinition.addOrReplaceChild("mimic", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body = mimic.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition right_leg = body.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(14, 43).addBox(-2.0F, 1.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -16.0F, 0.0F));

        PartDefinition right_knee = right_leg.addOrReplaceChild("right_knee", CubeListBuilder.create().texOffs(50, 14).addBox(-2.1F, 0.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.1F, 8.0F, 0.0F));

        PartDefinition right_below_knee = right_knee.addOrReplaceChild("right_below_knee", CubeListBuilder.create().texOffs(0, 51).addBox(-2.1F, 4.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));

        PartDefinition right_foot = right_below_knee.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(48, 42).addBox(-2.1F, 2.0F, -4.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 0.0F));

        PartDefinition left_leg = body.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(14, 43).addBox(-2.0F, 1.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -16.0F, 0.0F));

        PartDefinition left_knee = left_leg.addOrReplaceChild("left_knee", CubeListBuilder.create().texOffs(50, 14).addBox(-2.1F, 0.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.1F, 8.0F, 0.0F));

        PartDefinition left_below_knee = left_knee.addOrReplaceChild("left_below_knee", CubeListBuilder.create().texOffs(50, 49).addBox(-2.1F, 4.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));

        PartDefinition left_foot = left_below_knee.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(30, 48).addBox(-2.1F, 2.0F, -4.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 0.0F));

        PartDefinition upper_body = body.addOrReplaceChild("upper_body", CubeListBuilder.create(), PartPose.offset(0.0F, -15.0F, 0.0F));

        PartDefinition torso = upper_body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(25, 25).addBox(-7.0F, -3.0F, -2.0F, 14.0F, 2.0F, 4.0F, new CubeDeformation(0.5F))
                .texOffs(36, 38).addBox(-3.0F, -9.0F, -1.0F, 6.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(30, 31).addBox(-6.0F, -12.0F, -2.0F, 12.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-7.0F, -18.0F, -3.0F, 14.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));

        PartDefinition tentacles = torso.addOrReplaceChild("tentacles", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition right_tentacle = tentacles.addOrReplaceChild("right_tentacle", CubeListBuilder.create().texOffs(24, 55).addBox(-1.0F, -8.0F, 1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.offset(-5.5F, -17.0F, 1.0F));

        PartDefinition right_upper_tentacle = right_tentacle.addOrReplaceChild("right_upper_tentacle", CubeListBuilder.create().texOffs(40, 55).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 2.0F));

        PartDefinition left_tentacles = tentacles.addOrReplaceChild("left_tentacles", CubeListBuilder.create().texOffs(16, 55).addBox(-1.0F, -8.0F, 1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.offset(5.5F, -17.0F, 1.0F));

        PartDefinition left_upper_tentacle = left_tentacles.addOrReplaceChild("left_upper_tentacle", CubeListBuilder.create().texOffs(32, 55).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 2.0F));

        PartDefinition right_arm = upper_body.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(38, 0).addBox(-4.0F, -2.0F, -3.0F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.25F)), PartPose.offset(-7.0F, -15.0F, 0.0F));

        PartDefinition right_forearm = right_arm.addOrReplaceChild("right_forearm", CubeListBuilder.create().texOffs(0, 32).addBox(-2.0F, -1.0F, -3.0F, 4.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 7.0F, 0.0F));

        PartDefinition left_arm = upper_body.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(38, 0).addBox(-4.0F, -2.0F, -3.0F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.25F)), PartPose.offset(11.0F, -15.0F, 0.0F));

        PartDefinition left_forearm = left_arm.addOrReplaceChild("left_forearm", CubeListBuilder.create().texOffs(0, 32).addBox(-2.0F, -1.0F, -3.0F, 4.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 7.0F, 0.0F));

        PartDefinition head = upper_body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 11).addBox(-4.0F, -2.0F, -5.0F, 8.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(0, 22).addBox(-4.0F, -6.0F, -5.0F, 8.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(58, 22).addBox(-4.0F, -5.0F, -5.0F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(58, 23).addBox(-4.0F, -3.0F, -5.0F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-4.0F, -3.0F, -5.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, -1).addBox(-4.0F, -5.0F, -5.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 2).addBox(4.0F, -3.0F, -5.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 1).addBox(4.0F, -5.0F, -5.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(26, 14).addBox(-4.0F, -9.0F, -4.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(18, 32).addBox(-4.0F, -5.0F, -4.0F, 1.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(18, 32).addBox(3.0F, -5.0F, -4.0F, 1.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(25, 11).addBox(-3.0F, -5.0F, 4.0F, 6.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -17.0F, -1.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

        this.animateWalk(ModAnimationDefinitions.MIMIC_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(((MimicEntity) entity).idleAnimationState, ModAnimationDefinitions.MIMIC_IDLE, ageInTicks, 1F);
        this.animate(((MimicEntity) entity).attackAnimationState, ModAnimationDefinitions.MIMIC_MELEE_ATTACK, ageInTicks, 1F);
        this.animate(((MimicEntity) entity).shootingAnimationState, ModAnimationDefinitions.MIMIC_RANGED_ATTACK, ageInTicks, 1F);
    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        mimic.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return mimic;
    }
}