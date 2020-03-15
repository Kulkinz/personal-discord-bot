package app.commands;

import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Connor {
    public Connor(MessageReceivedEvent event) {
        MessageChannel channel = event.getChannel();
        channel.sendMessage("<@393804816419389440>")
        .delay(10, TimeUnit.MILLISECONDS)
        .flatMap(Message::delete)
        .queue();
    }
}