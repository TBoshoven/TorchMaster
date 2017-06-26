package net.xalcon.torchmaster.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.lwjgl.opengl.GL11;

@Mod.EventBusSubscriber(Side.CLIENT)
public class TorchVolumeRenderHandler
{
	@SubscribeEvent
	public static void onRender(RenderWorldLastEvent event)
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		GlStateManager.pushMatrix();

		Minecraft mc = Minecraft.getMinecraft();
		EntityPlayerSP player = mc.player;

		GlStateManager.glLineWidth(2.0F);

		double xD = player.lastTickPosX + (player.posX - player.lastTickPosX) * (double)event.getPartialTicks();
		double yD = player.lastTickPosY + (player.posY - player.lastTickPosY) * (double)event.getPartialTicks();
		double zD = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * (double)event.getPartialTicks();

		GlStateManager.translate(-xD, -yD, -zD);

		GlStateManager.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_LINE);

		GlStateManager.enableAlpha();
		GlStateManager.enableBlend();
		GlStateManager.disableLighting();
		GlStateManager.disableTexture2D();
		GlStateManager.disableCull();
		BufferBuilder vbo = Tessellator.getInstance().getBuffer();
		vbo.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_COLOR);

		GlStateManager.translate(0, 7, 0);
		vbo.pos(0, 1, 0).color(1.0f, 0.0f, 0.0f, 0.6f).endVertex();
		vbo.pos(0, 1, 1).color(1.0f, 0.0f, 0.0f, 0.6f).endVertex();
		vbo.pos(1, 1, 1).color(1.0f, 0.0f, 0.0f, 0.6f).endVertex();
		vbo.pos(1, 1, 0).color(1.0f, 0.0f, 0.0f, 0.6f).endVertex();

		vbo.pos(0, 0, 0).color(1.0f, 0.0f, 0.0f, 0.6f).endVertex();
		vbo.pos(1, 0, 0).color(1.0f, 0.0f, 0.0f, 0.6f).endVertex();
		vbo.pos(1, 0, 1).color(1.0f, 0.0f, 0.0f, 0.6f).endVertex();
		vbo.pos(0, 0, 1).color(1.0f, 0.0f, 0.0f, 0.6f).endVertex();

		vbo.pos(0, 0, 1).color(1.0f, 0.0f, 0.0f, 0.6f).endVertex();
		vbo.pos(1, 0, 1).color(1.0f, 0.0f, 0.0f, 0.6f).endVertex();
		vbo.pos(1, 1, 1).color(1.0f, 0.0f, 0.0f, 0.6f).endVertex();
		vbo.pos(0, 1, 1).color(1.0f, 0.0f, 0.0f, 0.6f).endVertex();

		vbo.pos(0, 0, 0).color(1.0f, 0.0f, 0.0f, 0.6f).endVertex();
		vbo.pos(0, 1, 0).color(1.0f, 0.0f, 0.0f, 0.6f).endVertex();
		vbo.pos(1, 1, 0).color(1.0f, 0.0f, 0.0f, 0.6f).endVertex();
		vbo.pos(1, 0, 0).color(1.0f, 0.0f, 0.0f, 0.6f).endVertex();

		vbo.pos(1, 0, 0).color(1.0f, 0.0f, 0.0f, 0.6f).endVertex();
		vbo.pos(1, 1, 0).color(1.0f, 0.0f, 0.0f, 0.6f).endVertex();
		vbo.pos(1, 1, 1).color(1.0f, 0.0f, 0.0f, 0.6f).endVertex();
		vbo.pos(1, 0, 1).color(1.0f, 0.0f, 0.0f, 0.6f).endVertex();

		vbo.pos(0, 0, 0).color(1.0f, 0.0f, 0.0f, 0.6f).endVertex();
		vbo.pos(0, 0, 1).color(1.0f, 0.0f, 0.0f, 0.6f).endVertex();
		vbo.pos(0, 1, 1).color(1.0f, 0.0f, 0.0f, 0.6f).endVertex();
		vbo.pos(0, 1, 0).color(1.0f, 0.0f, 0.0f, 0.6f).endVertex();

		Tessellator.getInstance().draw();
		GlStateManager.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_FILL);
		GlStateManager.enableCull();
		GlStateManager.enableTexture2D();
		GlStateManager.popMatrix();
	}
}
