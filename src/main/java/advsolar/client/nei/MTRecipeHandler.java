package advsolar.client.nei;

import advsolar.client.gui.GuiMolecularTransformer;
import advsolar.utils.ItemStackUtil;
import advsolar.utils.MTRecipeManager;
import advsolar.utils.MTRecipeRecord;
import codechicken.lib.gui.GuiDraw;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import codechicken.nei.recipe.TemplateRecipeHandler.CachedRecipe;
import codechicken.nei.recipe.TemplateRecipeHandler.RecipeTransferRect;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.Iterator;

public class MTRecipeHandler extends TemplateRecipeHandler {
    public int ticks;

    public void onUpdate() {
        super.onUpdate();
        ++this.ticks;
    }

    public void drawBackground(int i) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GuiDraw.changeTexture(this.getGuiTexture());
        GuiDraw.drawTexturedModalRect(0, 0, 5, 11, 167, 67);
    }

    public void loadTransferRects() {
        this.transferRects.add(new RecipeTransferRect(new Rectangle(17, 35, 12, 12), this.getRecipeId(), new Object[0]));
    }

    public String getRecipeName() {
        return "Molecular Transformer";
    }

    public String getRecipeId() {
        return "Molecular Transformer";
    }

    public void drawExtras(int r) {
        float f = this.ticks >= 20 ? (float) ((this.ticks - 20) % 20) / 20.0F : 0.0F;
        this.drawProgressBar(15, 29, 177, 3, 10, 9, f, 1);
        MTRecipeHandler.CachedMTRecipe recipe = (MTRecipeHandler.CachedMTRecipe) this.arecipes.get(r);
        FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
        ItemStack inputStack = recipe.input;
        ItemStack outputStack = recipe.output;
        int energy = recipe.energy;
        String formatedEnergy = GuiMolecularTransformer.parsingNumber(String.valueOf(energy));
        fontRenderer.drawString("Input: " + inputStack.getDisplayName(), 46, 18, 16777215);
        fontRenderer.drawString("Output: " + outputStack.getDisplayName(), 46, 28, 16777215);
        fontRenderer.drawString("Energy: " + formatedEnergy, 46, 38, 16777215);
    }

    public String getGuiTexture() {
        return "advancedsolarpanel:textures/gui/guiMolecularTransformer_nei.png";
    }

    public void loadUsageRecipes(ItemStack ingredient) {
        Iterator i$ = MTRecipeManager.transformerRecipes.iterator();

        while (i$.hasNext()) {
            MTRecipeRecord record = (MTRecipeRecord) i$.next();
            if (ItemStackUtil.areStacksEqual(record.inputStack, ingredient)) {
                this.arecipes.add(new MTRecipeHandler.CachedMTRecipe(record.inputStack, record.outputStack, record.energyPerOperation));
            }
        }

    }

    public void loadCraftingRecipes(String outputId, Object... results) {
        if (outputId.equals(this.getRecipeId())) {
            Iterator i$ = MTRecipeManager.transformerRecipes.iterator();

            while (i$.hasNext()) {
                MTRecipeRecord record = (MTRecipeRecord) i$.next();
                this.arecipes.add(new MTRecipeHandler.CachedMTRecipe(record.inputStack, record.outputStack, record.energyPerOperation));
            }
        } else {
            super.loadCraftingRecipes(outputId, results);
        }

    }

    public void loadCraftingRecipes(ItemStack ingredient) {
        Iterator i$ = MTRecipeManager.transformerRecipes.iterator();

        while (i$.hasNext()) {
            MTRecipeRecord record = (MTRecipeRecord) i$.next();
            if (ItemStackUtil.areStacksEqual(record.outputStack, ingredient)) {
                this.arecipes.add(new MTRecipeHandler.CachedMTRecipe(record.inputStack, record.outputStack, record.energyPerOperation));
            }
        }

    }

    public int recipiesPerPage() {
        return 2;
    }

    public Class getGuiClass() {
        return GuiMolecularTransformer.class;
    }

    public class CachedMTRecipe extends CachedRecipe {
        public ItemStack input;
        public ItemStack output;
        public int energy;

        public CachedMTRecipe(ItemStack input, ItemStack output, int energy) {
            this.input = input;
            this.output = output;
            this.energy = energy;
        }

        public PositionedStack getIngredient() {
            return new PositionedStack(this.input, 12, 8);
        }

        public PositionedStack getResult() {
            return new PositionedStack(this.output, 12, 43);
        }
    }
}
