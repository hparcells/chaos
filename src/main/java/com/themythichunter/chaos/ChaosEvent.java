package com.themythichunter.chaos;

/**
 * The interface for all Chaos Events.
 */
public abstract class ChaosEvent {
    /**
     * Called when the event is enabled.
     *
     * @param username The username of the player affected.
     * @param plugin   The plugin instance.
     */
    public abstract void onEnable(String username, Chaos plugin);

    /**
     * Called when the event is disabled.
     *
     * @param username The username of the player affected.
     * @param plugin   The plugin instance.
     */
    public void onDisable(String username, Chaos plugin) {
    }

    /**
     * Gets the name of the event.
     *
     * @return The name of the event.
     */
    public abstract String getName();
}
