# Chaos
> Fun with random Minecraft events.

![](https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png)


## Usage
- `/chaos [add|remove] [username]` will add or remove players from the list of players that will be affected
by the outcome of the chaos events. Note: this does reset whenever the plugin is reloaded.
- `/chaos [start|stop]` will start or stop the game.
- `/chaos players` will list the players that will be affected by the outcome of the chaos events.
- `/chaos spoilers` will toggle spoilers for the game. The default is OFF. Spoilers announce in chat the current
 event in the chat.
 
**Config File**

A config will be generated in a `plugins/Chaos` folder. Two values will be provided, a minimum and a maximum value
for how long events should last.

## Disclaimer
This plugin has the possibility to cause permanent damage in your world, or make you *very very* sad. Please do not
use this plugin on a world you *really* care about.

## Inspiration
The inspiration for this plugin really came from the plugins for the games Portal 1 and
[Portal 2](https://github.com/NeKzor/chaoshttps://github.com/NeKzor/chaos) also named chaos, where it ran random
commands from the console, for some crazy effects. This plugin tries to replicate that but with the creativity of
Minecraft.

## Contributing
Contributing made simple. If you know any Bukkit programming, it is really simple to add your own events. Create a
new class in the events folder that extends the ChaosEvent class, and fill in the methods. Add an event instance to
the array in the ChaosThread class. View the other events for examples.

## License
This work is licensed under a [Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License](http://creativecommons.org/licenses/by-nc-sa/4.0/).
