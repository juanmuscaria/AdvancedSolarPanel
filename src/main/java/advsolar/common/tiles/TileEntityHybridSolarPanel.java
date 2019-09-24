package advsolar.common.tiles;

import advsolar.common.AdvancedSolarPanel;

public class TileEntityHybridSolarPanel extends TileEntitySolarPanel {
    public TileEntityHybridSolarPanel() {
        super("blockHybridSolarPanel.name", 3, AdvancedSolarPanel.hGenDay, AdvancedSolarPanel.hGenNight, AdvancedSolarPanel.hOutput, AdvancedSolarPanel.hStorage);
    }

    public String getInvName() {
        return "Hyb Solar Panel";
    }
}
