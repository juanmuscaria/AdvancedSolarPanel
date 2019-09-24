package advsolar.client.gui;

import advsolar.common.AdvancedSolarPanel;
import advsolar.common.container.ContainerQGenerator;
import advsolar.common.tiles.TileEntityQGenerator;
import advsolar.network.PacketGUIPressButton;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GuiQGenerator extends GuiContainer implements KeyListener {
    private static ResourceLocation tex = new ResourceLocation("advancedsolarpanel", "textures/gui/GUIQuantumGenerator.png");
    public Minecraft mc;
    public TileEntityQGenerator tileentity;
    private GuiTextField maxPacketSizeEdit;
    private GuiTextField productonEdit;

    public GuiQGenerator(InventoryPlayer inventoryplayer, TileEntityQGenerator tileentityqgenerator) {
        super(new ContainerQGenerator(inventoryplayer, tileentityqgenerator));
        this.tileentity = tileentityqgenerator;
        this.xSize = 176;
        this.ySize = 149;
        this.mc = Minecraft.getMinecraft();
    }

    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        String formatDeviceName = I18n.format("blockQuantumGenerator.name", new Object[0]);
        int nmPos = (this.xSize - this.fontRendererObj.getStringWidth(formatDeviceName)) / 2;
        this.fontRendererObj.drawString(formatDeviceName, nmPos, 6, 16777215);
        String gen = Integer.toString(this.tileentity.production);
        String outputString = I18n.format("gui.QuantumGenerator.power", new Object[0]) + ":";
        this.fontRendererObj.drawString(outputString, 54, 24, 16777215);
        this.fontRendererObj.drawString(gen, 140 - this.fontRendererObj.getStringWidth(gen), 25, 16777215);
    }

    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        if (tex == null) {
            tex = new ResourceLocation("advancedsolarpanel", "textures/gui/GUIQuantumGenerator.png");
            AdvancedSolarPanel.addLog("Quantum Generator GUI texture is null? How could that happen?!");
        }

        this.mc.renderEngine.bindTexture(tex);
        int h = (this.width - this.xSize) / 2;
        int k = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(h, k, 0, 0, this.xSize, this.ySize);
        if (!this.tileentity.active) {
            this.drawTexturedModalRect(h + 145, k + 21, 176, 3, 14, 14);
        }

    }

    protected void actionPerformed(GuiButton button) {
        try {
            if (Keyboard.getEventKey() == 42 && Keyboard.getEventKeyState()) {
                PacketGUIPressButton.issue(this.tileentity, button.id + 100);
            } else {
                PacketGUIPressButton.issue(this.tileentity, button.id);
            }
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        super.actionPerformed(button);
    }

    public void initGui() {
        super.initGui();
        int xGuiPos = (this.width - this.xSize) / 2;
        int yGuiPos = (this.height - this.ySize) / 2;
        this.buttonList.add(new GuiButton(1, xGuiPos + 6, yGuiPos + 40, 32, 20, "-100"));
        this.buttonList.add(new GuiButton(2, xGuiPos + 39, yGuiPos + 40, 26, 20, "-10"));
        this.buttonList.add(new GuiButton(3, xGuiPos + 66, yGuiPos + 40, 20, 20, "-1"));
        this.buttonList.add(new GuiButton(4, xGuiPos + 89, yGuiPos + 40, 20, 20, "+1"));
        this.buttonList.add(new GuiButton(5, xGuiPos + 110, yGuiPos + 40, 26, 20, "+10"));
        this.buttonList.add(new GuiButton(6, xGuiPos + 137, yGuiPos + 40, 32, 20, "+100"));
    }

    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }
}
