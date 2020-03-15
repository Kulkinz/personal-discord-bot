package app;

import java.util.Calendar;

import app.commands.Isaiah;
import app.commands.Ping;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandSelector {
    public CommandSelector(MessageReceivedEvent event, String message) {
        message = message.substring(1);
        System.out.println(event.getAuthor() + " just tried to run " + message + " at " + Calendar.getInstance().getTime());

        if (message.equals("ping")) {
            new Ping(event);
        }
        switch (message) {
            case "ping":
                new Ping(event);
                break;
            case "isaiah":
                new Isaiah(event);
                break;
        }
    }
}