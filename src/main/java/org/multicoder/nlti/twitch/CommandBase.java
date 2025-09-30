package org.multicoder.nlti.twitch;

import net.minecraft.server.MinecraftServer;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class CommandBase
{
    public int COOLDOWN;
    public String TRIGGER;
    public LocalDateTime COOLDOWN_COUNTER;

    abstract public boolean Trigger(MinecraftServer server,String Username);

    @Override
    public int hashCode() {
        return Objects.hash(this.COOLDOWN, this.TRIGGER, this.COOLDOWN_COUNTER);
    }

    @Override
    public String toString()
    {
        return "CommandBase$" + hashCode();
    }
}
