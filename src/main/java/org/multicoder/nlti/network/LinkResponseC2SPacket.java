package org.multicoder.nlti.network;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.commands.secure.SecureCommand;

@SuppressWarnings("all")
public record LinkResponseC2SPacket(String Data) implements CustomPacketPayload{
    public static final Identifier ID = Identifier.fromNamespaceAndPath(NLTI.MODID,"linkc2s");

    public static final StreamCodec<RegistryFriendlyByteBuf, LinkResponseC2SPacket> CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, LinkResponseC2SPacket::Data,
            LinkResponseC2SPacket::new);
    public static final Type<LinkResponseC2SPacket> TYPE = new Type<>(ID);


    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void receive(LinkResponseC2SPacket payload, ServerPlayNetworking.Context context) {
        SecureCommand.HandleReply(payload.Data());
        context.server().sendSystemMessage(Component.translatable("text.nlti.linked"));
    }
}
