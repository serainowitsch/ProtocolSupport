package protocolsupport.protocol.packet.middle.clientbound.play;

import protocolsupport.protocol.packet.middle.ClientBoundMiddlePacket;
import protocolsupport.protocol.serializer.PacketDataSerializer;

public abstract class MiddleSetHealth<T> extends ClientBoundMiddlePacket<T> {

	protected float health;
	protected int food;
	protected float saturation;

	@Override
	public void readFromServerData(PacketDataSerializer serializer) {
		health = serializer.readFloat();
		food = serializer.readVarInt();
		saturation = serializer.readFloat();
	}

}