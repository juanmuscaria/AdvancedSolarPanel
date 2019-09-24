package advsolar.common.tiles;

import advsolar.common.AdvancedSolarPanel;

public class TileEntityAdvancedSolarPanel extends TileEntitySolarPanel {
    public TileEntityAdvancedSolarPanel() {
        super("blockAdvancedSolarPanel.name", 2, AdvancedSolarPanel.advGenDay, AdvancedSolarPanel.advGenNight, AdvancedSolarPanel.advOutput, AdvancedSolarPanel.advStorage);
    }

    public String getInvName() {
        return "Adv Solar Panel";
    }
}
