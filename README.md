# Chaos
> Fun with random Minecraft events.

## About
Chaos is Minecraft plugin that runs random events (good or bad) periodically through out. The default is set to a
random time between 30 and 40 seconds. Read more about the events in the EVENTS.md file in the GitHub repository.

## Usage
- `/chaos [add|remove] [username]` will add or remove players from the list of players that will be affected
by the outcome of the chaos events. Note: this does reset whenever the plugin is reloaded.
- `/chaos [start|stop]` will start or stop the game.
- `/chaos players` will list the players that will be affected by the outcome of the chaos events.
- `/chaos spoilers` will toggle spoilers for the game. The default is OFF. Spoilers announce in chat the current
 event in the chat.

**Permissions**

- `chaos.use`: Use the plugin's commands.

**Config File**

A config will be generated in a `plugins/Chaos` folder. Two values will be provided, a minimum and a maximum value
for how long events should last.

## Demo Video
[https://www.youtube.com/watch?v=mSM8qk2JbMU](https://www.youtube.com/watch?v=mSM8qk2JbMU)

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
This work is licensed under the GNU General Public License v3.
