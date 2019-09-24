package advsolar.utils;

import advsolar.api.IMTRecipeManager;
import advsolar.common.AdvancedSolarPanel;
import com.google.common.collect.Lists;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry.UniqueIdentifier;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MTRecipeManager implements IMTRecipeManager {
    public static List transformerRecipes = Lists.newArrayList();
    public static MTRecipeManager instance = new MTRecipeManager();
    public static ArrayList defaultRecipeList = new ArrayList();
    public static boolean rawReflectionDone = false;
    private static Method getUniqueName_Item;
    private static Method getUniqueName_Block;

    private static void lazyReflectionInit() {
        if (!rawReflectionDone) {
            try {
                getUniqueName_Item = GameData.class.getDeclaredMethod("getUniqueName", Item.class);
                getUniqueName_Block = GameData.class.getDeclaredMethod("getUniqueName", Block.class);
                getUniqueName_Item.setAccessible(true);
                getUniqueName_Block.setAccessible(true);
            } catch (Exception var1) {
                AdvancedSolarPanel.addLog("Reflection failed. This is a fatal error and not recoverable");
                throw new RuntimeException(var1);
            }

            rawReflectionDone = true;
        }

    }

    public static MTRecipeManager.RawItemData getItemData(ItemStack is) {
        lazyReflectionInit();

        try {
            Item i = is.getItem();
            if (i instanceof ItemBlock) {
                Block b = Block.getBlockFromItem(i);
                UniqueIdentifier ui = (UniqueIdentifier) getUniqueName_Block.invoke((Object) null, b);
                return new MTRecipeManager.RawItemData(ui.modId, ui.name);
            } else {
                UniqueIdentifier ui = (UniqueIdentifier) getUniqueName_Item.invoke((Object) null, i);
                return new MTRecipeManager.RawItemData(ui.modId, ui.name);
            }
        } catch (Throwable var4) {
            AdvancedSolarPanel.addLog("Reflection failed. Weird error, report it.");
            var4.printStackTrace();
            return null;
        }
    }

    public void addMTOreDict(String name, String output, int energy) {
        List inputs = OreDictionary.getOres(name);
        List outputs = OreDictionary.getOres(output);
        if (outputs.size() != 0) {
            if (inputs.size() != 0) {

                for (Object input : inputs) {
                    ItemStack inputIS = (ItemStack) input;

                    for (Object o : outputs) {
                        ItemStack outputIS = (ItemStack) o;
                        this.addMTRecipe(inputIS.copy(), outputIS.copy(), energy);
                    }
                }

            }
        }
    }

    public void addMTOreDict(String input, ItemStack output, int energy) {
        List inputs = OreDictionary.getOres(input);

        for (Object o : inputs) {
            ItemStack inputIS = (ItemStack) o;
            this.addMTRecipe(inputIS.copy(), output.copy(), energy);
        }

    }

    public void addMTOreDict(ItemStack input, String output, int energy) {
        List outputs = OreDictionary.getOres(output);
        if (outputs.size() != 0) {

            for (Object o : outputs) {
                ItemStack outputIS = (ItemStack) o;
                this.addMTRecipe(input.copy(), outputIS.copy(), energy);
            }

        }
    }

    public void initRecipes() {
        transformerRecipes.clear();
        String configFilePath = AdvancedSolarPanel.configFileName.substring(0, AdvancedSolarPanel.configFileName.lastIndexOf(File.separatorChar) + 1);
        String tmpFileName = AdvancedSolarPanel.configFileName.substring(AdvancedSolarPanel.configFileName.lastIndexOf(File.separatorChar) + 1);
        String recipesFileName = tmpFileName.substring(0, tmpFileName.lastIndexOf("."));
        String recipesFileExt = tmpFileName.substring(tmpFileName.lastIndexOf("."));
        recipesFileName = recipesFileName + "_MTRecipes" + recipesFileExt;
        File file = new File(configFilePath, recipesFileName);
        transformerRecipes.clear();
        transformerRecipes.addAll(MTRecipeConfig.parse(file));
    }

    public void addMTRecipe(ItemStack inputItem, ItemStack outputItem, int energyPerOperation) {
        MTRecipeRecord recipeToAdd = new MTRecipeRecord();
        recipeToAdd.inputStack = inputItem.copy();
        recipeToAdd.outputStack = outputItem.copy();
        recipeToAdd.energyPerOperation = energyPerOperation;
        transformerRecipes.add(recipeToAdd);
    }

    public static class RawItemData {
        public final String modId;
        public final String itemName;

        public RawItemData(String id, String name) {
            this.modId = id;
            this.itemName = name;
        }
    }
}
