package protocolsupport.protocol.transformer.middlepacketimpl.clientbound.play.v_1_4_1_5_1_6_1_7;

import java.io.IOException;

import protocolsupport.api.ProtocolVersion;
import protocolsupport.protocol.ClientBoundPacket;
import protocolsupport.protocol.PacketDataSerializer;
import protocolsupport.protocol.transformer.middlepacket.clientbound.play.MiddleInventoryClose;
import protocolsupport.protocol.transformer.middlepacketimpl.PacketData;
import protocolsupport.utils.recyclable.RecyclableCollection;
import protocolsupport.utils.recyclable.RecyclableSingletonList;

public class InventoryClose extends MiddleInventoryClose<RecyclableCollection<PacketData>> {

	@Override
	public RecyclableCollection<PacketData> toData(ProtocolVersion version) throws IOException {
		PacketDataSerializer serializer = PacketDataSerializer.createNew(version);
		serializer.writeByte(windowId);
		return RecyclableSingletonList.<PacketData>create(PacketData.create(ClientBoundPacket.PLAY_WINDOW_CLOSE_ID, serializer));
	}

}