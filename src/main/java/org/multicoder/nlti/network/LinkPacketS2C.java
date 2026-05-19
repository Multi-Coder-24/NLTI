package org.multicoder.nlti.network;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import org.multicoder.nlti.NLTI;

public record LinkPacketS2C(byte[] Key) implements CustomPacketPayload {
    private static final Identifier ID = Identifier.fromNamespaceAndPath(NLTI.MODID,"LinkS2C");

    private static final StreamCodec<RegistryFriendlyByteBuf,LinkPacketS2C> CODEC = StreamCodec.composite(
            ByteBufCodecs.byteArray(32),LinkPacketS2C::Key,
            LinkPacketS2C::new);
    private static final CustomPacketPayload.Type<LinkPacketS2C> TYPE = new CustomPacketPayload.Type(ID);


    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
