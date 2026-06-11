package org.multicoder.nlti.network;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Player;
import org.jspecify.annotations.NonNull;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.commands.secure.Constants;
import org.multicoder.nlti.commands.secure.SecureCommand;
import java.net.URI;
import java.util.UUID;

public record LinkPacketS2C() implements CustomPacketPayload{
    public static final Identifier ID = Identifier.fromNamespaceAndPath(NLTI.MODID,"links2c");

    public static final StreamCodec<RegistryFriendlyByteBuf,LinkPacketS2C> CODEC = StreamCodec.unit(new LinkPacketS2C());
    public static final CustomPacketPayload.Type<LinkPacketS2C> TYPE = new CustomPacketPayload.Type<>(ID);


    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void receive(LinkPacketS2C ignored, ClientPlayNetworking.Context context) {
        try{
            Player player = context.player();
            UUID state = UUID.randomUUID();
            String URL = Constants.URL + "&state=" + state;
            SecureCommand.ServerHandler(state.toString());
            player.displayClientMessage(Component.translatable("text.nlti.link_url",URL).setStyle(Style.EMPTY.withUnderlined(true).withClickEvent(new ClickEvent.OpenUrl(URI.create(URL)))),false);
        } catch (Exception e) {
            NLTI.LOG.error("[NLTI Twitch] Failed To Send Or Open Link",e);
        }
    }
}
