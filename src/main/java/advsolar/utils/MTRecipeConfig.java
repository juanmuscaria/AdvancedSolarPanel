package advsolar.utils;

import advsolar.common.AdvancedSolarPanel;
import com.google.common.collect.Lists;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MTRecipeConfig {
    public static final String SEPARATOR = "; ";
    public static final String NEW_LINE = System.getProperty("line.separator");
    public static List<String> defaultLines = Lists.newArrayList();
    public static boolean filled = false;
    public static String configVersion = "1.0";

    public static void populateDefaults() {
        if (!filled) {
            defaultLines.add("minecraft:skull-1:1; minecraft:nether_star:1; 250000000");
            defaultLines.add("minecraft:iron_ingot:1; IC2:itemOreIridium:1; 9000000");
            defaultLines.add("minecraft:netherrack:1; minecraft:gunpowder:2; 70000");
            defaultLines.add("minecraft:sand:1; minecraft:gravel:1; 50000");
            defaultLines.add("minecraft:dirt:1; minecraft:clay:1; 50000");
            defaultLines.add("minecraft:coal-1:1; minecraft:coal-0:1; 60000");
            defaultLines.add("minecraft:glowstone_dust:1; AdvancedSolarPanel:asp_crafting_items-9:1; 1000000");
            defaultLines.add("minecraft:glowstone:1; AdvancedSolarPanel:asp_crafting_items-0:1; 9000000");
            defaultLines.add("minecraft:wool-4:1; minecraft:glowstone:1; 500000");
            defaultLines.add("minecraft:wool-11:1; minecraft:lapis_block:1; 500000");
            defaultLines.add("minecraft:wool-14:1; minecraft:redstone_block:1; 500000");
            defaultLines.add("minecraft:dye-4:1; oredict:gemSapphire; 5000000");
            defaultLines.add("minecraft:redstone:1; oredict:gemRuby:1; 5000000");
            defaultLines.add("minecraft:coal:1; IC2:itemPartIndustrialDiamond:1; 9000000");
            defaultLines.add("IC2:itemPartIndustrialDiamond:1; minecraft:diamond:1; 1000000");
            defaultLines.add("oredict:dustTitanium:1; oredict:dustChrome:1; 500000");
            defaultLines.add("oredict:ingotTitanium:1; oredict:ingotChrome:1; 500000");
            defaultLines.add("oredict:gemNetherQuartz:1; oredict:gemCertusQuartz:1; 500000");
            defaultLines.add("oredict:ingotCopper:1; oredict:ingotNickel:1; 300000");
            defaultLines.add("oredict:ingotTin:1; oredict:ingotSilver:1; 500000");
            defaultLines.add("oredict:ingotSilver:1; oredict:ingotGold:1; 500000");
            defaultLines.add("oredict:ingotGold:1; oredict:ingotPlatinum:1; 9000000");
            filled = true;
        }

    }

    public static String formatItemData(MTRecipeManager.RawItemData rawItemData) {
        return String.format("%s:%s", rawItemData.modId, rawItemData.itemName);
    }

    public static void addDefaultRecipe(Object input, int inputStackSize, Object output, int outputStackSize, int energy) {
        String result = "";
        result = result + "# ";
        result = result + (input instanceof ItemStack ? ((ItemStack) input).getDisplayName() : (String) input);
        result = result + " -> ";
        result = result + (output instanceof ItemStack ? ((ItemStack) output).getDisplayName() : (String) output);
        result = result + String.format(" [%d EU]", energy);
        defaultLines.add(result);
        result = "";
        if (input instanceof String) {
            result = result + "oredict:" + (String) input + "; ";
        } else {
            if (!(input instanceof ItemStack)) {
                throw new RuntimeException("addDefaultRecipe(): input unsupported type: " + input.getClass().getCanonicalName());
            }

            result = result + formatItemData(MTRecipeManager.getItemData((ItemStack) input)) + "-" + ((ItemStack) input).getItemDamage() + ":" + ((ItemStack) input).stackSize + "; ";
        }

        if (output instanceof String) {
            result = result + "oredict:" + (String) output + "; ";
        } else {
            if (!(output instanceof ItemStack)) {
                throw new RuntimeException("addDefaultRecipe(): output unsupported type: " + output.getClass().getCanonicalName());
            }

            result = result + formatItemData(MTRecipeManager.getItemData((ItemStack) output)) + "-" + ((ItemStack) output).getItemDamage() + ":" + ((ItemStack) output).stackSize + "; ";
        }

        result = result + energy;
        defaultLines.add(result);
    }

    public static void doDebug() {
    }

    public static void writeGuide(BufferedWriter bw) {
        try {
            bw.write("##################################################################################################" + NEW_LINE);
            bw.write("#                        AdvancedSolarPanels Molecular Transformer Recipes                       #" + NEW_LINE);
            bw.write("##################################################################################################" + NEW_LINE);
            bw.write("# Format of recipe: \"inputItem:stackSize;outputItem:outputStackSize;energy\"                      #" + NEW_LINE);
            bw.write("# InputItem (outputItem) format:                                                                 #" + NEW_LINE);
            bw.write("# \"oredict:forgeOreDictName\" or \"minecraft:item_name-meta\" or \"modID:item_name-meta\"             #" + NEW_LINE);
            bw.write("# New line = new recipe.                                                                         #" + NEW_LINE);
            bw.write("# Add \"#\" before line to skip parsing recipe                                                     #" + NEW_LINE);
            bw.write("##################################################################################################" + NEW_LINE);
            bw.write("version=" + configVersion + NEW_LINE);
            bw.write("##################################################################################################" + NEW_LINE);
        } catch (Throwable var2) {
            var2.printStackTrace();
        }

    }

    public static void fillWithInitials(BufferedWriter bw) {
        populateDefaults();
        writeGuide(bw);
        System.out.println(defaultLines.size());
        Iterator i$ = defaultLines.iterator();

        while (i$.hasNext()) {
            String s = (String) i$.next();

            try {
                bw.append(s + "\r\n");
            } catch (Throwable var4) {
                var4.printStackTrace();
            }
        }

    }

    public static List parse(File f) {
        ArrayList list = Lists.newArrayList();

        try {
            if (!f.exists()) {
                AdvancedSolarPanel.addLog("MT recipes config file not found. Create default recipes.");
                f.createNewFile();
                FileOutputStream fos = new FileOutputStream(f);
                OutputStreamWriter osw = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(osw);
                fillWithInitials(bw);
                bw.close();
                fos.close();
            }

            AdvancedSolarPanel.addLog("* * * * * * Start parsing MT recipes * * * * * * ");
            FileInputStream fis = new FileInputStream(f);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line = "";
            int lineNumber = 0;

            while (true) {
                while (true) {
                    do {
                        if ((line = br.readLine()) == null) {
                            br.close();
                            fis.close();
                            AdvancedSolarPanel.addLog("* * * * * * Finished parsing MT recipes * * * * * * ");
                            AdvancedSolarPanel.addLog(String.format("Config loading completed, %d recipes parsed.", list.size()));
                            AdvancedSolarPanel.addLog("* * * * * * Loaded recipes list * * * * * * ");
                            Iterator i$ = list.iterator();

                            while (i$.hasNext()) {
                                MTRecipeRecord record = (MTRecipeRecord) i$.next();
                                Object input = record.inputStack;
                                Object output = record.outputStack;
                                int energy = record.energyPerOperation;
                                String result = "";
                                result = result + (input instanceof ItemStack ? ((ItemStack) input).getDisplayName() : (String) input);
                                result = result + " -> ";
                                result = result + (output instanceof ItemStack ? ((ItemStack) output).getDisplayName() : (String) output);
                                result = result + String.format(" [%d EU]", energy);
                                AdvancedSolarPanel.addLog(result);
                            }

                            AdvancedSolarPanel.addLog("* * * * * * * * * * * * * * * * * * * * *");
                            return list;
                        }

                        ++lineNumber;
                        line = line.replace("\r", "").replace("\n", "");
                    } while (line.trim().startsWith("#"));

                    if (line.indexOf("#") != 0 && line.indexOf("version") != 0) {
                        if (line.indexOf("#") > 0) {
                            line = line.substring(0, line.indexOf("#"));
                            line = line.trim();
                        }
                    } else if (line.indexOf("version") == 0) {
                        if (line.indexOf("#") > 0) {
                            line = line.substring(0, line.indexOf("#"));
                            line = line.trim();
                        }

                        String tmpString = line.substring(line.indexOf("=") + 1);
                        if (tmpString != "") {
                            configVersion = tmpString;
                        }
                        continue;
                    }

                    String[] spaceSplit = line.trim().split("; ".trim());
                    if (spaceSplit.length != 3) {
                        AdvancedSolarPanel.addLog(String.format("Ignoring line %d, incorrect format.", lineNumber));
                    } else {
                        String input = spaceSplit[0].trim();
                        String output = spaceSplit[1].trim();
                        boolean var9 = true;

                        int energy;
                        try {
                            energy = Integer.parseInt(spaceSplit[2].trim());
                        } catch (Exception var16) {
                            AdvancedSolarPanel.addLog(String.format("Ignoring line %d, energy number is incorrect.", lineNumber));
                            continue;
                        }

                        List inputStacks = wrap(input);
                        if (inputStacks == null) {
                            AdvancedSolarPanel.addLog(String.format("Ignoring line %d, failed to parse input.", lineNumber));
                        } else {
                            List outputStacks = wrap(output);
                            if (outputStacks == null) {
                                AdvancedSolarPanel.addLog(String.format("Ignoring line %d, failed to parse output.", lineNumber));
                            } else {
                                ItemStack outputStack = (ItemStack) outputStacks.get(0);
                                Iterator i$ = inputStacks.iterator();

                                while (i$.hasNext()) {
                                    ItemStack is = (ItemStack) i$.next();
                                    MTRecipeRecord recipeToAdd = new MTRecipeRecord();
                                    recipeToAdd.inputStack = is.copy();
                                    recipeToAdd.outputStack = outputStack.copy();
                                    recipeToAdd.energyPerOperation = energy;
                                    list.add(recipeToAdd);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable var17) {
            AdvancedSolarPanel.addLog("Fatal error occurred parsing MT recipes config. (" + var17.toString() + ")");
            return list;
        }
    }

    public static List wrap(String s) {
        List list = Lists.newArrayList();
        String[] split = s.split(":");
        String namespace = split[0];
        int stackSize = 1;
        if (namespace.equalsIgnoreCase("oredict")) {
            if (split.length == 2 || split.length == 3) {
                if (split.length == 3) {
                    stackSize = Integer.parseInt(split[2]);
                }

                List retrOreDict = OreDictionary.getOres(split[1]);
                if (retrOreDict.size() > 0) {
                    for (int i = 0; i < retrOreDict.size(); ++i) {
                        ItemStack tmpItemStack = ((ItemStack) retrOreDict.get(i)).copy();
                        list.add(new ItemStack(tmpItemStack.getItem(), stackSize, tmpItemStack.getItemDamage()));
                    }
                }
            }
        } else if ((namespace.equalsIgnoreCase("minecraft") || Loader.isModLoaded(namespace)) && split.length == 3) {
            String modId = split[0];
            String itemName = split[1];
            stackSize = Integer.parseInt(split[2]);
            if (stackSize <= 0) {
                stackSize = 1;
            }

            int meta = 0;
            String[] itemArray = null;
            if (itemName.indexOf("-") > 0) {
                itemArray = itemName.split("-");
                itemName = itemArray[0];
                meta = Integer.parseInt(itemArray[1]);
            }

            ItemStack is = GameRegistry.findItemStack(modId, itemName, 1);
            if (is != null) {
                is.setItemDamage(meta);
                is.stackSize = stackSize;
                list.add(is);
            }
        }

        return list.size() != 0 ? list : null;
    }
}
