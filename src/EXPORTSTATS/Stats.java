package EXPORTSTATS;

public enum Stats {
    contract_double_points_chance(TagList.Contracts),craft_100x_chance(TagList.Crafting),fishing_super_shiny_multi(TagList.Fishing),drone_count(TagList.Drones),
    super_star_triple_chance(TagList.Stars),drone_damage_percent(TagList.Drones),bomb_omega_crit_damage(TagList.Bombs),rainbow_floor_multi(TagList.Ore),

    statue_0_set1(TagList.Statues),statue_1_set1(TagList.Statues),statue_2_set1(TagList.Statues),
    statue_3_set1(TagList.Statues),statue_4_set1(TagList.Statues),statue_5_set1(TagList.Statues),
    statue_6_set1(TagList.Statues),statue_7_set1(TagList.Statues),statue_8_set1(TagList.Statues),
    statue_0_set2(TagList.Statues),statue_1_set2(TagList.Statues),statue_2_set2(TagList.Statues),
    statue_3_set2(TagList.Statues),statue_4_set2(TagList.Statues),statue_5_set2(TagList.Statues),
    statue_6_set2(TagList.Statues),statue_7_set2(TagList.Statues),statue_8_set2(TagList.Statues),
    statue_0_set3(TagList.Statues),statue_1_set3(TagList.Statues),statue_2_set3(TagList.Statues),
    statue_3_set3(TagList.Statues),statue_4_set3(TagList.Statues),statue_5_set3(TagList.Statues),
    statue_6_set3(TagList.Statues),statue_7_set3(TagList.Statues),statue_8_set3(TagList.Statues),

    bomb_additional_multiplier(TagList.Bombs),bomb_damage(TagList.Bombs),bomb_transmuter_multi(TagList.Bombs),bomb_trans_apply_bop_chance(TagList.Bombs),
    coal_capacity_multi(TagList.Drones), xp_level_cap(TagList.Prestige), fishing_drone_power(TagList.Fishing),candy_eaten(TagList.Stars),prismatic_floor_multi(TagList.Ore),
    star_supernova_chance(TagList.Stars),chest_double_chance(TagList.Chests),lootfrog_golden_chance(TagList.Lootfrogs),obelisk_timer_add(TagList.Obelisk),
    lootfrog_triple_spawn_chance(TagList.Lootfrogs),super_star_radiant_chance(TagList.Stars),star_auto_catch_chance(TagList.Stars),drone_radius_percent(TagList.Drones),
    pickaxe_damage(TagList.Pickaxe),bomb_of_plenty_make_gold_chance(TagList.Bombs),prismatic_floor_chance(TagList.Ore),galactic_floor_chance(TagList.Ore),
    drone_rapid_fire_chance(TagList.Drones),chest_meter_multi(TagList.Chests),lootfrog_loot_multi(TagList.Lootfrogs),super_star_spawn_multi(TagList.Stars),
    game_speed_multi(TagList.Misc),bomb_battery_cap_increases(TagList.Bombs),all_floor_multipliers(TagList.Ore), fishing_5x_tick_chance(TagList.Fishing),
    super_star_10x_chance(TagList.Stars),golden_ore_multi(TagList.Ore),fishing_tier2_dock_multi(TagList.Fishing),pickaxe_super_crit_damage(TagList.Pickaxe),
    void_portal_base_multi(TagList.Drones),super_stonks_multi(TagList.Chests),fishing_notice_requirement(TagList.Fishing),bomb_omega_crit_chance(TagList.Bombs),    
    fishing_shiny_multi(TagList.Fishing),golden_floor_multi(TagList.Ore),coal_generation_seconds(TagList.Drones),super_star_supergiant_multi(TagList.Stars),
    super_star_supernova_multi(TagList.Stars),lootbug_bank_cap(TagList.Lootbugs),freebie_gems_bonus(TagList.Chests),rainbow_vein_multi(TagList.Veins),
    floor_clear_requirement_multi(TagList.Prestige),vein_income_multi(TagList.Veins),star_supergiant_chance(TagList.Stars),gleaming_vein_chance(TagList.Veins),
    golden_lootfrogs_caught(TagList.Lootfrogs),free_craft_chance(TagList.Crafting),fishing_drone_multiplier(TagList.Fishing),fishing_token_multi(TagList.Fishing),
    craft_5x_chance(TagList.Crafting),lootbug_triple_chance(TagList.Lootbugs),fishing_shiny_chance(TagList.Fishing),lootfrog_golden_multi(TagList.Lootfrogs),
    rainbow_void_portal_chance(TagList.Drones),rainbow_vein_chance(TagList.Veins),artifact_tier4_cap_increase(TagList.Prestige),golden_vein_chance(TagList.Veins),
    super_star_radiant_multi(TagList.Stars),pickaxe_omega_crit_chance(TagList.Pickaxe),pet_levelup_chance_multi(TagList.Misc),drone_movespeed_percent(TagList.Drones),
    contract_points_rewarded(TagList.Contracts),pickaxe_ultra_crit_damage(TagList.Pickaxe),star_double_spawn_chance(TagList.Stars),pickaxe_attack_speed_per_second(TagList.Pickaxe),
    golden_ore_chance(TagList.Ore),bomb_super_crit_damage(TagList.Bombs),obelisk_cooldown_multi(TagList.Obelisk),fishing_drone_capacity(TagList.Fishing),
    stonks_multi(TagList.Chests),bomb_cherry3x_chance(TagList.Bombs),contract_cost_reduction(TagList.Contracts),contract_cap_increase(TagList.Contracts),
    contract_10x_points_chance(TagList.Contracts),chest_items_bonus(TagList.Chests),bomb_free_chance(TagList.Bombs),all_star_multi(TagList.Stars),ore_income_multi(TagList.Ore),
    galactic_floor_multi(TagList.Ore),bomb_crit_chance(TagList.Bombs),freebie_5x_chance(TagList.Chests),pizzas_eaten(TagList.Ore),craft_20x_chance(TagList.Crafting),
    super_stonks_chance(TagList.Chests),golden_void_portal_multi(TagList.Drones),lootbug_golden_chance(TagList.Lootbugs),elixir_crit_chance(TagList.Drones),
    ultra_stonks_multi(TagList.Chests),fishing_triple_tick_chance(TagList.Fishing),rainbow_void_portal_multi(TagList.Drones),pickaxe_omega_crit_damage(TagList.Pickaxe),
    craft_10x_chance(TagList.Crafting),super_star_supergiant_chance(TagList.Stars),elixir_crit_multi(TagList.Drones),fishing_super_shiny_chance(TagList.Fishing),
    pickaxe_crit_chance(TagList.Pickaxe),time(TagList.Others),fishing_tick_reduction_seconds(TagList.Fishing),prestige_point_multi(TagList.Prestige),fishing_rod_power(TagList.Fishing),
    gleaming_vein_multi(TagList.Veins),bomb_ultra_crit_chance(TagList.Bombs),bomb_cap_multiplier(TagList.Bombs),stonks_chance(TagList.Chests),gem_upgrade_cap_increase(TagList.Misc),
    lootfrog_lanterns_used(TagList.Lootbugs),lootbug_loot_multi(TagList.Lootbugs),artifact_cap_increase(TagList.Prestige),lootbug_spawn_rate(TagList.Lootbugs),
    pickaxe_ultra_crit_chance(TagList.Pickaxe),rainbow_floor_chance(TagList.Ore),bar_upgrade_cost_reduction(TagList.Ore),steak_eaten(TagList.Ore),star_spawn_rate(TagList.Stars),
    freebie_bank_cap(TagList.Chests),coal_drone_exp_multi(TagList.Drones),drone_attack_speed_percent(TagList.Drones),coal_fuel_save_chance(TagList.Drones),
    bomb_capacity(TagList.Bombs),drone_triple_damage_chance(TagList.Drones),star_triple_spawn_chance(TagList.Stars),lootfrog_capacity(TagList.Lootfrogs),
    fishing_tick_speed(TagList.Fishing),coal_fuel_duration_multi(TagList.Drones),fishing_income_multi(TagList.Fishing),pickaxe_crit_damage(TagList.Pickaxe),
    lootfrog_10x_spawn_chance(TagList.Lootfrogs),contract_triple_points_chance(TagList.Contracts),bomb_workshop_cap_increase(TagList.Bombs),pickaxe_radius_percent(TagList.Pickaxe),
    ore_sell_price_multi(TagList.Ore),bar_output_multi(TagList.Ore),void_portal_chance(TagList.Drones),bomb_of_plenty_multi(TagList.Bombs),drone_suit_cap(TagList.Drones),
    bomb_ultra_crit_damage(TagList.Bombs),lootbug_gem_cost_reduction(TagList.Lootbugs),star_supernova_multi(TagList.Stars),star_supergiant_multi(TagList.Stars),
    obelisk_armor_reduction(TagList.Obelisk),star_radiant_chance(TagList.Stars),experience_multi(TagList.Prestige),multi_rock_chance(TagList.Ore),bomb_crit_damage(TagList.Bombs),
    ultra_stonks_chance(TagList.Chests),star_radiant_multi(TagList.Stars),contract_5x_points_chance(TagList.Contracts),golden_floor_chance(TagList.Ore),
    item_duration_multi(TagList.Misc),contract_upgrade_cost_reduction(TagList.Contracts),bomb_recharge_speed(TagList.Bombs),fishing_tiny_notice_chance(TagList.Fishing),
    lootfrog_big_chance(TagList.Lootfrogs),bar_craft_cost_multi(TagList.Ore),freebie_cooldown_seconds(TagList.Chests),super_star_supernova_chance(TagList.Stars),
    freebie_refresh_chance(TagList.Chests),lootfrog_big_multi(TagList.Lootfrogs),golden_vein_multi(TagList.Veins),double_craft_chance(TagList.Crafting),version(TagList.Others),
    lootfrogs_caught(TagList.Lootfrogs),vein_spawn_rate_multi(TagList.Veins),pickaxe_super_crit_chance(TagList.Pickaxe),novagiant_combo_multi(TagList.Stars),
    fishing_double_tick_chance(TagList.Fishing),triple_craft_chance(TagList.Crafting),golden_void_portal_chance(TagList.Drones),bomb_super_crit_chance(TagList.Bombs),
    all_void_portal_multi(TagList.Drones),
    
    //2.2.5

    ores_per_screen(TagList.Ore),is_drone_elixir_equipped_and_fueled(TagList.Drone_Unlock),is_drone_bear_equipped(TagList.Drone_Unlock),
    veinseeker_fuel_grade(TagList.Drone_Unlock),is_drone_elixir_equipped(TagList.Drone_Unlock),
    is_drone_frogger_equipped(TagList.Drone_Unlock),minotaur_fuel_grade(TagList.Drone_Unlock),
    galactic_void_portal_multi(TagList.Drones),starburst_fuel_grade(TagList.Drone_Unlock),
    is_drone_prism_equipped_and_fueled(TagList.Drone_Unlock),is_drone_starburst_equipped_and_fueled(TagList.Drone_Unlock),
    is_drone_bear_equipped_and_fueled(TagList.Drone_Unlock),is_drone_minotaur_equipped_and_fueled(TagList.Drone_Unlock),midas_fuel_grade(TagList.Drone_Unlock),
    is_drone_chain_equipped_and_fueled(TagList.Drone_Unlock),is_drone_veinseeker_equipped_and_fueled(TagList.Drone_Unlock),galactic_void_portal_chance(TagList.Drones),
    is_drone_minotaur_equipped(TagList.Drone_Unlock),lootfrog_massive_multi(TagList.Lootfrogs),is_drone_frogger_equipped_and_fueled(TagList.Drone_Unlock),void_portal_multi(TagList.Drones),
    lootfrog_massive_chance(TagList.Lootfrogs),angler_fuel_grade(TagList.Drone_Unlock),is_drone_chain_equipped(TagList.Drone_Unlock),is_drone_midas_equipped(TagList.Drone_Unlock),
    is_drone_prism_equipped(TagList.Drone_Unlock),is_drone_void_equipped(TagList.Drone_Unlock),is_drone_midas_equipped_and_fueled(TagList.Drone_Unlock),bear_fuel_grade(TagList.Drone_Unlock),
    infernal_card_multi(TagList.Misc),frogger_fuel_grade(TagList.Drone_Unlock),is_drone_starburst_equipped(TagList.Drone_Unlock),is_drone_void_equipped_and_fueled(TagList.Drone_Unlock),
    prism_fuel_grade(TagList.Drone_Unlock),void_fuel_grade(TagList.Drone_Unlock),chain_fuel_grade(TagList.Drone_Unlock),is_drone_basic_equipped(TagList.Drone_Unlock),
    is_drone_angler_equipped(TagList.Drone_Unlock),
    elixir_fuel_grade(TagList.Drone_Unlock),is_drone_veinseeker_equipped(TagList.Drone_Unlock),is_drone_angler_equipped_and_fueled(TagList.Drone_Unlock);

    //...

    
    TagList tag;

    Stats(TagList tg){
        tag = tg;
    }

    
}
