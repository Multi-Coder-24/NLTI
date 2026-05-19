package org.multicoder.nlti.network;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import org.multicoder.nlti.NLTI;

public record LinkResponseC2SPacket(byte[] Data) implements CustomPacketPayload {
    private static final Identifier ID = Identifier.fromNamespaceAndPath(NLTI.MODID,"LinkS2C");

    private static final StreamCodec<RegistryFriendlyByteBuf, LinkResponseC2SPacket> CODEC = StreamCodec.composite(
            ByteBufCodecs.byteArray(32), LinkResponseC2SPacket::Data,
            LinkResponseC2SPacket::new);
    private static final Type<LinkResponseC2SPacket> TYPE = new Type(ID);


    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
