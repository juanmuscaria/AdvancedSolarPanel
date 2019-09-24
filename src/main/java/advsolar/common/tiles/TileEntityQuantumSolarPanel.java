package advsolar.common.tiles;

import advsolar.common.AdvancedSolarPanel;

public class TileEntityQuantumSolarPanel extends TileEntitySolarPanel {
    public TileEntityQuantumSolarPanel() {
        super("blockQuantumSolarPanel.name", 4, AdvancedSolarPanel.qpGenDay, AdvancedSolarPanel.qpGenNight, AdvancedSolarPanel.qpOutput, AdvancedSolarPanel.qpStorage);
    }

    public String getInvName() {
        return "Quantum Solar Panel";
    }
}
