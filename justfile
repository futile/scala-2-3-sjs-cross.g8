# Commands in here can be run using `just`, see https://just.systems/man/en/ for syntax etc.

# Run all commands using bash by default
set shell := ["bash", "-c"]

# allow positional arguments to commands
set positional-arguments := true

# List available recipes
_default:
    @just --list --unsorted

# Run `sbt +test` in `target/g8/`. Usually much faster than `g8Test`.
test-quick:
    cd target/g8/ && sbt "+test"
