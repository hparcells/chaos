# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [1.2.0] - 2023-01-14

### Added

- Updated to 1.19.3
- Added a sound when a new event starts.

### Fixed

- Fixed an issue allowing non-privileged player to issue Chaos commands.

## [1.1.0] - 2020-08-08

### Added

- More Events
    - **Diamond**: Gives you a diamond.
    - **Hard**: Sets the difficulty to Hard temporarily.
    - **Nice XP**: Sets your XP to 69 levels.
    - **Zero XP**: Sets your XP to 0 levels.
    - **Sky Lava**: Sets lava at Y=255.
    - **Tree**: Creates a tree at your location.
    - **Fire Trail**
    - **Explosive Beds**: Boom!
    - **Slippery Buckets**: Dumps bucket contents at your feet.
    - **Full Heal**: Sets your HP to max.
    - **Full Hunger**: Sets your hunger and saturation to max.
    - **Zero Hunger**: Removes all your hunger and saturation.
    - **Food Poisoning**: All food items will give you food poisoning.
- Effect Events
    - Speed
    - Jump Boost
    - Blindness
    - Mining Fatigue
    - Haste
- Event list in the `EVENTS.md` file in the GitHub repository.

### Fixed

- Fixed an issue involving effects not being removed. (#1)

## [1.0.1] - 2020-08-02

### Fixed

- Fixed duplication glitch involving the armor and off hand item with the trip event.

### Known Bugs

- Events including effects have been temporarily disabled, until a fix is found (#1).

## [1.0.0] - 2020-08-02

### Added

- Initial plugin.

### Known Bugs

- Events including effects have been temporarily disabled, until a fix is found (#1).
- Items in the armor slots and the off hand will be kept in the inventory, and duplicated on the ground when the trip
  event occurs.
