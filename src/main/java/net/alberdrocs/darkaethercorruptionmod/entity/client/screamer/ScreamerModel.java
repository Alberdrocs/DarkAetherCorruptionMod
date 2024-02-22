package net.alberdrocs.darkaethercorruptionmod.entity.client.screamer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.alberdrocs.darkaethercorruptionmod.entity.animations.ModAnimationDefinitions;
import net.alberdrocs.darkaethercorruptionmod.entity.custom.ScreamerEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class ScreamerModel<T extends Entity> extends HierarchicalModel<T> {
    private final ModelPart screamer;
    private final ModelPart head;

    public ScreamerModel(ModelPart root) {
    this.screamer = root.getChild("screamer");
    this.head = screamer.getChild("body").getChild("upper_body").getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition screamer = partdefinition.addOrReplaceChild("screamer", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body = screamer.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition right_leg = body.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(16, 14).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

        PartDefinition left_leg = body.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(22, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

        PartDefinition upper_body = body.addOrReplaceChild("upper_body", CubeListBuilder.create(), PartPose.offset(0.0F, -12.0F, 0.0F));

        PartDefinition torso = upper_body.addOrReplaceChild("torso", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, 0.0F));

        PartDefinition pelvis = torso.addOrReplaceChild("pelvis", CubeListBuilder.create().texOffs(0, 28).addBox(-4.0F, -5.0F, 2.0F, 8.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(22, 26).addBox(-4.0F, -4.0F, -1.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(16, 25).addBox(4.0F, -4.0F, -1.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(2, 3).addBox(4.0F, -3.0F, -2.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 3).addBox(-4.0F, -3.0F, -2.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(-4.0F, -2.0F, -2.0F, 8.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(6, 34).addBox(-4.0F, -3.0F, -2.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(33, 29).addBox(1.0F, -3.0F, -2.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition spine = torso.addOrReplaceChild("spine", CubeListBuilder.create().texOffs(24, 16).addBox(-1.0F, -14.0F, 1.0F, 2.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition ribcage = torso.addOrReplaceChild("ribcage", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition first_rib = ribcage.addOrReplaceChild("first_rib", CubeListBuilder.create().texOffs(30, 16).addBox(-4.0F, -14.0F, 1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 32).addBox(-4.0F, -14.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(22, 31).addBox(3.0F, -14.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(30, 11).addBox(1.0F, -14.0F, 1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 14).addBox(-4.0F, -14.0F, -2.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition second_rib = ribcage.addOrReplaceChild("second_rib", CubeListBuilder.create().texOffs(30, 9).addBox(-4.0F, -14.0F, 1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 31).addBox(-4.0F, -14.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(10, 31).addBox(3.0F, -14.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(30, 7).addBox(1.0F, -14.0F, 1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(30, 5).addBox(-4.0F, -14.0F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(30, 3).addBox(1.0F, -14.0F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));

        PartDefinition third_rib = ribcage.addOrReplaceChild("third_rib", CubeListBuilder.create().texOffs(33, 32).addBox(-3.0F, -14.0F, 1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 31).addBox(-3.0F, -14.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(30, 24).addBox(2.0F, -14.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(27, 33).addBox(1.0F, -14.0F, 1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(30, 27).addBox(-3.0F, -14.0F, -2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(17, 0).addBox(1.0F, -14.0F, -2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

        PartDefinition fourth_rib = ribcage.addOrReplaceChild("fourth_rib", CubeListBuilder.create().texOffs(6, 14).addBox(-2.0F, -14.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(30, 21).addBox(-2.0F, -14.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(30, 18).addBox(1.0F, -14.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 12).addBox(1.0F, -14.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(-2.0F, -14.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(1.0F, -14.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

        PartDefinition head = upper_body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(28, 29).addBox(-1.0F, -15.0F, 1.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-3.0F, -20.0F, -3.0F, 6.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 28).addBox(-2.0F, -14.0F, -3.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 1).addBox(-2.0F, -15.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(2.0F, -15.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(1.0F, -15.0F, 1.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(3, 0).addBox(-2.0F, -15.0F, 1.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(16, 27).addBox(2.0F, -14.0F, -3.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(30, 13).addBox(-2.0F, -14.0F, -3.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(27, 0).addBox(-2.0F, -13.0F, -3.0F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition right_arm = upper_body.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(8, 14).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -10.0F, 0.0F));

        PartDefinition left_arm = upper_body.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 14).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -10.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

        this.animateWalk(ModAnimationDefinitions.SCREAMER_RUN, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(((ScreamerEntity) entity).idleAnimationState, ModAnimationDefinitions.SCREAMER_IDLE, ageInTicks, 1f);
        this.animate(((ScreamerEntity) entity).explosionAnimationState, ModAnimationDefinitions.SCREAMER_EXPLOSION, ageInTicks, 1f);
    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        screamer.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return screamer;
    }
}
