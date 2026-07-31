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
> If it crashes, the entry isn't a json and the app cancels everything

> [!TIP]
> If your game or this code is outdated, the file would still work. It just would seems glitchy (if the game is outdated) or can have invalid element (if this code is outdated)

The converted file will be put in the root and named last.bdeko. 

> [!IMPORTANT]
> If you set "String exported" beforehand using `setSaveLocation(String s)`, it will be redirected in the `"/"`+`exported` directory

The new converted file will be read to check if it is indeed a `EXPORTSTATS` Valid file (contains both `"version"`, `"time"`, `"pickaxe_damage"`, `"xp_level_cap"`, `"bomb_damage"` entries). This is overshooting, but it is purely to check the integrity of the file. 

> [!WARNING]
> Modifying the file type (like, put time as a boolean) can break the file. Ensure the json stays untouched.

It will then be redirected in the `"/"`+`exported` directory as `fileSave`+`.bdeko`. The file will then be named `0.bdeko`,`1.bdeko`,`2.bdeko`,`3.bdeko`...

### Use EXPORTSTATS Structure

`List<Stats> getTag(TagList tg)`: Send all element based on the TagList. For example, `TagList.Pickaxe` sends `[pickaxe_damage, pickaxe_super_crit_damage, pickaxe_omega_crit_chance, pickaxe_ultra_crit_damage, pickaxe_attack_speed_per_second, pickaxe_omega_crit_damage, pickaxe_crit_chance, pickaxe_ultra_crit_chance, pickaxe_crit_damage, pickaxe_radius_percent, pickaxe_super_crit_chance]`. This method can be used to categorize individually every element.

### Set a bdeko file

`List<String> getAllData()`: Find all data in `/exported` directory. Check every bdeko file, if the file is EXPORTSTATS compatible, then it would had its `name+extension` in the given list. Can be used to list every single save before loading one.

`void load(int x)`: As saves are int based, the loader will just look for "`exported`/`x`.bdeko". If you saved your file as save `12`, just `load(12)` will load it.

`boolean checkSave(int x)`: Check if save exists.

### Read a bdeko file

> [WARNING]
> Set a bdeko file before this step

EXPORTSTATS simplify. You won't need to read the file anymore by yourself. You can use `EXPORTSTATS.TagList` to locate the tab (Drones, Pickaxe...) and `EXPORTSTATS.Stats` to find the entry you want.

> [!TIP]
> If you are looking for a peculiar element, try looking in texts/en/stats.bdeko to find the corresponding element

You can use EXPORTSTATS.EXPORTSTATS for locating or sending the result (as of iom v2.2.6 and EXPORTSTATS v2.2.6-3):

`List<String> getSimilarName(String s)`: Send the element based on an extract of its name. For example `"bomb_crit"` sends `[bomb_crit_damage, bomb_crit_chance]`, if it is empty, no result were found. If there is only one, it's more likely what the user was looking for. REQUIRE A RESTORE TO BE SET

`String getString(Stats st)`: This method calls a value of a Stats into a Stringified text. `precision` can change the Stringified text.

`String getRaw(Stats st)`: Sends the Stringified version of the json. It will remove the information of the statues (if it is platined, gilded, base) and keep the number (0.0,1.0,2.0,3.0)

### Parameters

`void setExportLocation(String s)` Choose from where will be the exported bdeko. Base value is in `/EXPORTDATA`.
`void setPrecision(int x)`: Choose the number of precision, between -1 (unlimited) and +inf. Avoid big number and pick -1, as the biggest the number is, the more complex the BigNumber conversion become
`void showScience(boolean set)`: Decide if Scientific Notation is active or not on = `6.89e26`, off = `689.49sp`

### Set up localisation

> [!NOTE]
> Localisation module is heavy. Some syntax, like `<>`, `//N` and `[[]]` can be misinterpreted.

> [!TIP]
> You are not forced to use this to use the EXPORTSTATS jar, as it is a lot more complex.

`void EXPORTSTATS.setLanguageManage(String path, String language)`: Refers to the next two line.

`void LanguageManage.setPath(String path)`: Set a language path. This file should sends to the designated `texts` path, so including a `main.bdeko` in its name.
`void LanguageManage.setLanguage(String language)`: (Do it AFTER setPath) Set a language based from `main.bdeko` entry `main`, or entry `other`. The said language name should be a directory in the `path` (`en` language is in `texts/en` next to `texts/main.bdeko`)

### Use localisations

> [!NOTE]
> Localisation module is for now limited. Adding entry will be forced to use the `Texts` module.

`String getText(Stats st)`: if LanguageManage is set correctly, will check for `st.name()` in the `stats.bdeko` file of the selected language. Base one are the same as the codename.
`String getTextDesc(Stats st)`: if LanguageManage is set correctly, will check for `st.name()`+`_desc` in the `stats.bdeko` file of the selected language. Sends the description. Base one are taken from the Wiki.

> [!NOTE]
> Localisation module is for now limited. Adding entry is for now limited

## Usage Example
You can have a demo app created with that jar in releases (Android 12+)
