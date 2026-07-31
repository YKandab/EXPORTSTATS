# EXPORTSTATS
A IDLE OBELISK MINER "EXPORTSTATS" json reader for Java

## What is that project
The objective is to give the Player an access to their data and everything linked to their account BY ONLY THE WAY OF THE OFFICIAL JSON.

## Current Progress
Still WIP: It is updated to 2.2.6 BUT it still requires some localization in texts/en/stats.bdeko

## How it works

### Read Json
This part is about `Export.convertJson(String json, int fileSave)`
`json` is the EXPORTSTATS given json. If it is not a json, the app crashes.
FileManage converts the bits into a String, call JsonDeko and org.json.

First, it will ensure root file last.bdeko, used as cache, is removed.

Org.json verify your entry, and JsonDeko convert it into my own file.

> [!CAUTION]
> If it crashes, the file isn't a json and the app cancel everything

> [!TIP]
> If your game or this code is outdated, the file would still work. It just would seems glitchy (if the game is outdated) or can have invalid element (if this code is outdated)

The converted file will be put in the root and named last.bdeko. 

> [!IMPORTANT]
> If you set "String exported" beforehand using `setSaveLocation(String s)`, it will be redirected in the `"/"`+`exported` directory

The new converted file will be read to check if it is indeed a `EXPORTSTATS` Valid file (contains both `"version"`, `"time"`, `"pickaxe_damage"`, `"xp_level_cap"`, `"bomb_damage"` entries). This is overshooting, but it is purely to check the integrity of the file. 

> [!WARNING]
> Modifying the file type (like, put time as a boolean) can break the file. Ensure the json stays untouched.

It will then be redirected in the `"/"`+`exported` directory as `fileSave`+`.bdeko`. The file will then be named `0.bdeko`,`1.bdeko`,`2.bdeko`,`3.bdeko`...
