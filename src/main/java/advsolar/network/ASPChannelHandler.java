package advsolar.network;

import cpw.mods.fml.common.network.FMLIndexedMessageToMessageCodec;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ASPChannelHandler extends FMLIndexedMessageToMessageCodec<IPacket> {
    public ASPChannelHandler() {

        for (Object o : ASPPacketHandler.packetTypes) {
            Class clazz = (Class) o;
            this.addDiscriminator(ASPPacketHandler.packetTypes.indexOf(clazz), clazz);
        }

    }

    public void encodeInto(ChannelHandlerContext ctx, IPacket msg, ByteBuf target) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            msg.write(new DataOutputStream(baos));
        } catch (Throwable var6) {
            var6.printStackTrace();
        }

        target.writeBytes(baos.toByteArray());
    }

    public void decodeInto(ChannelHandlerContext ctx, ByteBuf source, IPacket msg) {
        byte[] arr = new byte[source.readableBytes()];
        source.readBytes(arr);
        ByteArrayInputStream bais = new ByteArrayInputStream(arr);

        try {
            msg.read(new DataInputStream(bais));
        } catch (Throwable var7) {
            var7.printStackTrace();
            return;
        }

        msg.execute();
    }
}
