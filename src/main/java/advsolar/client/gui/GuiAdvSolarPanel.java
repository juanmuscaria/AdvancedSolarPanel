package advsolar.client.gui;

import advsolar.common.container.ContainerAdvSolarPanel;
import advsolar.common.tiles.TileEntitySolarPanel;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiAdvSolarPanel extends GuiContainer {
    private static ResourceLocation tex = new ResourceLocation("advancedsolarpanel", "textures/gui/GUIAdvancedSolarPanel.png");
    public TileEntitySolarPanel tileentity;

    public GuiAdvSolarPanel(InventoryPlayer inventoryplayer, TileEntitySolarPanel tileentitysolarpanel) {
        super(new ContainerAdvSolarPanel(inventoryplayer, tileentitysolarpanel));
        this.tileentity = tileentitysolarpanel;
        this.allowUserInput = false;
        this.xSize = 194;
        this.ySize = 168;
    }

    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        String formatPanelName = I18n.format(this.tileentity.panelName, new Object[0]);
        int nmPos = (this.xSize - this.fontRendererObj.getStringWidth(formatPanelName)) / 2;
        this.fontRendererObj.drawString(formatPanelName, nmPos, 7, 7718655);
        String storageString = I18n.format("gui.AdvancedSolarPanel.storage", new Object[0]) + ": ";
        String maxOutputString = I18n.format("gui.AdvancedSolarPanel.maxOutput", new Object[0]) + ": ";
        String generatingString = I18n.format("gui.AdvancedSolarPanel.generating", new Object[0]) + ": ";
        String energyPerTickString = I18n.format("gui.AdvancedSolarPanel.energyPerTick", new Object[0]);
        this.fontRendererObj.drawString(storageString + this.tileentity.storage + "/" + this.tileentity.maxStorage, 50, 22, 13487565);
        this.fontRendererObj.drawString(maxOutputString + this.tileentity.production + " " + energyPerTickString, 50, 32, 13487565);
        this.fontRendererObj.drawString(generatingString + this.tileentity.generating + " " + energyPerTickString, 50, 42, 13487565);
    }

    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(tex);
        int h = (this.width - this.xSize) / 2;
        int k = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(h, k, 0, 0, this.xSize, this.ySize);
        if (this.tileentity.storage > 0) {
            int l = this.tileentity.gaugeEnergyScaled(24);
            this.drawTexturedModalRect(h + 19, k + 24, 195, 0, l + 1, 14);
        }

        if (this.tileentity.skyIsVisible) {
            if (this.tileentity.sunIsUp) {
                this.drawTexturedModalRect(h + 24, k + 42, 195, 15, 14, 14);
            } else if (!this.tileentity.sunIsUp) {
                this.drawTexturedModalRect(h + 24, k + 42, 210, 15, 14, 14);
            }
        }

    }
}
