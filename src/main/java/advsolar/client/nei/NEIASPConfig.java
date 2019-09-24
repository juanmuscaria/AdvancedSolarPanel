package advsolar.client.nei;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

public class NEIASPConfig implements IConfigureNEI {
    public void loadConfig() {
        System.out.println("[Advanced Solar Panels]: Loading NEI compatibility...");
        API.registerUsageHandler(new MTRecipeHandler());
        API.registerRecipeHandler(new MTRecipeHandler());
    }

    public String getName() {
        return "Advanced Solar Panels";
    }

    public String getVersion() {
        return "v1.0";
    }
}
