package advsolar.network;

import com.google.common.collect.Lists;
import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.common.network.FMLOutboundHandler.OutboundTarget;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;

import java.util.EnumMap;
import java.util.List;

public class ASPPacketHandler {
    public static List packetTypes = Lists.newArrayList();
    private static EnumMap channels;

    public static void load() {
        registerPacketType(PacketGUIPressButton.class);
        registerPacketType(PacketChangeState.class);
        channels = NetworkRegistry.INSTANCE.newChannel("AdvSolarPanels", new ASPChannelHandler());
    }

    public static void registerPacketType(Class ptype) {
        packetTypes.add(ptype);
    }

    public static void sendToAllPlayers(IPacket packet) {
        ((FMLEmbeddedChannel) channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(OutboundTarget.ALL);
        ((FMLEmbeddedChannel) channels.get(Side.SERVER)).writeOutbound(packet);
    }

    public static void sendToServer(IPacket packet) {
        ((FMLEmbeddedChannel) channels.get(Side.CLIENT)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(OutboundTarget.TOSERVER);
        ((FMLEmbeddedChannel) channels.get(Side.CLIENT)).writeOutbound(packet);
    }

    public static void sendToPlayer(EntityPlayer ep, IPacket packet) {
        ((FMLEmbeddedChannel) channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(OutboundTarget.PLAYER);
        ((FMLEmbeddedChannel) channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(ep);
        ((FMLEmbeddedChannel) channels.get(Side.SERVER)).writeOutbound(packet);
    }
}
