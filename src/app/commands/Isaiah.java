package app.commands;

import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Isaiah {
    public Isaiah(MessageReceivedEvent event) {
        MessageChannel channel = event.getChannel();
        channel.sendMessage("<@596693413651546114>")
        .queue();
    }
}