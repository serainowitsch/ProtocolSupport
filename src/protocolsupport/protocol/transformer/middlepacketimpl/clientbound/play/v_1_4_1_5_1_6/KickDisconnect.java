package protocolsupport.protocol.transformer.middlepacketimpl.clientbound.play.v_1_4_1_5_1_6;

import java.io.IOException;

import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;

import protocolsupport.api.ProtocolVersion;
import protocolsupport.protocol.ClientBoundPacket;
import protocolsupport.protocol.PacketDataSerializer;
import protocolsupport.protocol.transformer.middlepacket.clientbound.play.MiddleKickDisconnect;
import protocolsupport.protocol.transformer.middlepacketimpl.PacketData;
import protocolsupport.protocol.transformer.utils.LegacyUtils;
import protocolsupport.utils.recyclable.RecyclableCollection;
import protocolsupport.utils.recyclable.RecyclableSingletonList;

public class KickDisconnect extends MiddleKickDisconnect<RecyclableCollection<PacketData>> {

	@Override
	public RecyclableCollection<PacketData> toData(ProtocolVersion version) throws IOException {
		PacketDataSerializer serializer = PacketDataSerializer.createNew(version);
		serializer.writeString(LegacyUtils.toText(ChatSerializer.a(messageJson)));
		return RecyclableSingletonList.<PacketData>create(PacketData.create(ClientBoundPacket.PLAY_KICK_DISCONNECT_ID, serializer));
	}

}