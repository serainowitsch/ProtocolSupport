package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_14r1_14r2_15;

import protocolsupport.protocol.ConnectionImpl;
import protocolsupport.protocol.packet.PacketType;
import protocolsupport.protocol.packet.middle.clientbound.play.MiddleBlockAction;
import protocolsupport.protocol.packet.middleimpl.ClientBoundPacketData;
import protocolsupport.protocol.serializer.PositionSerializer;
import protocolsupport.protocol.serializer.VarNumberSerializer;
import protocolsupport.protocol.typeremapper.block.BlockRemappingHelper;
import protocolsupport.protocol.typeremapper.block.FlatteningBlockData;
import protocolsupport.protocol.typeremapper.block.FlatteningBlockData.FlatteningBlockDataTable;
import protocolsupport.protocol.typeremapper.block.LegacyBlockData;
import protocolsupport.protocol.typeremapper.utils.RemappingTable.ArrayBasedIdRemappingTable;

public class BlockAction extends MiddleBlockAction {

	protected final ArrayBasedIdRemappingTable blockDataRemappingTable = LegacyBlockData.REGISTRY.getTable(version);
	protected final FlatteningBlockDataTable flatteningBlockDataTable = FlatteningBlockData.REGISTRY.getTable(version);

	public BlockAction(ConnectionImpl connection) {
		super(connection);
	}

	@Override
	public void writeToClient() {
		ClientBoundPacketData blockaction = ClientBoundPacketData.create(PacketType.CLIENTBOUND_PLAY_BLOCK_ACTION);
		PositionSerializer.writePosition(blockaction, position);
		blockaction.writeByte(actionId);
		blockaction.writeByte(actionParam);
		VarNumberSerializer.writeVarInt(blockaction, BlockRemappingHelper.remapFlatteningBlockId(blockDataRemappingTable, flatteningBlockDataTable, blockId));
		codec.write(blockaction);
	}

}
