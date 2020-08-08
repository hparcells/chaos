# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## Unreleased
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
- Effect Events
  - Speed
  - Jump Boost
  - Blindness
  - Mining Fatigue
  - Haste

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
