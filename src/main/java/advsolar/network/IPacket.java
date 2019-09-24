package advsolar.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public abstract class IPacket {
    public abstract void read(DataInputStream var1) throws Throwable;

    public abstract void write(DataOutputStream var1) throws Throwable;

    public void execute() {
    }
}
