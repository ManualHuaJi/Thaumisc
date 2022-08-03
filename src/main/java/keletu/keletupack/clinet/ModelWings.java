package keletu.keletupack.clinet;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import org.jetbrains.annotations.NotNull;

public class ModelWings extends ModelBiped {

    ModelRenderer Wing1;
    ModelRenderer Wing2;

    public ModelWings() {
        super(1F);
        textureWidth = 64;
        textureHeight = 32;

        Wing1 = new ModelRenderer(this, 16, -12);
        Wing1.addBox(0F, 0F, 0F, 0, 7, 12);
        Wing1.setRotationPoint(-2F, 1F, 2F);
        setRotation(Wing1, 0F, -0.6108652F, 0F);
        bipedBody.addChild(Wing1);

        Wing2 = new ModelRenderer(this, 16, -12);
        Wing2.addBox(0.1F, 0F, 0F, 0, 7, 12);
        Wing2.setRotationPoint(2F, 1F, 2F);
        setRotation(Wing2, 0F, 0.4468043F, 0F);
        bipedBody.addChild(Wing2);
    }

    @Override
    public void render(@NotNull Entity entity, float v1, float v2, float v3, float v4, float v5, float v6) {
        setRotationAngles(v1, v2, v3, v4, v5, v6, entity);

        bipedHead.showModel = false;
        bipedHeadwear.showModel = false;
        bipedLeftLeg.showModel = false;
        bipedRightLeg.showModel = false;

        super.render(entity, v1, v2, v3, v4, v5, v6);
    }

    @Override
    public void setRotationAngles(float v1, float v2, float v3, float v4, float v5, float v6, Entity entity) {
        EntityLivingBase living = (EntityLivingBase) entity;
        isSneak = living != null && living.isSneaking();
        if (living != null && living instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) living;

            if (player.capabilities.isFlying) {
                Wing1.rotateAngleY = (float) ((Math.sin(entity.ticksExisted) + 1) * (Math.PI / 180F) * 15 - 0.6108652F);
                Wing2.rotateAngleY = -Wing1.rotateAngleY;
            }
        }

        super.setRotationAngles(v1, v2, v3, v4, v5, v6, entity);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

}