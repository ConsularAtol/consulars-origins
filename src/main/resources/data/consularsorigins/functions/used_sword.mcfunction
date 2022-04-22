scoreboard objectives add usedWoodenSword minecraft.used:wooden_sword
scoreboard objectives add usedStoneSword minecraft.used:stone_sword
scoreboard objectives add usedIronSword minecraft.used:iron_sword
scoreboard objectives add usedGoldenSword minecraft.used:golden_sword
scoreboard objectives add usedDiamondSword minecraft.used:diamond_sword
scoreboard objectives add usedNetherSword minecraft.used:netherite_sword

advancement grant @a[scores={usedWoodenSword=1..}] only consularsorigins:used_sword
advancement grant @a[scores={usedStoneSword=1..}] only consularsorigins:used_sword
advancement grant @a[scores={usedIronSword=1..}] only consularsorigins:used_sword
advancement grant @a[scores={usedGoldenSword=1..}] only consularsorigins:used_sword
advancement grant @a[scores={usedDiamondSword=1..}] only consularsorigins:used_sword
advancement grant @a[scores={usedNetherSword=1..}] only consularsorigins:used_sword

scoreboard players set @a[scores={usedWoodenSword=1..}] usedWoodenSword 0
scoreboard players set @a[scores={usedStoneSword=1..}] usedStoneSword 0
scoreboard players set @a[scores={usedIronSword=1..}] usedIronSword 0
scoreboard players set @a[scores={usedGoldenSword=1..}] usedGoldenSword 0
scoreboard players set @a[scores={usedDiamondSword=1..}] usedDiamondSword 0
scoreboard players set @a[scores={usedNetherSword=1..}] usedNetherSword 0

advancement revoke @p only consularsorigins:used_sword