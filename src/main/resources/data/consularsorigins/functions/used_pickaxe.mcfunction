scoreboard objectives add usedWoodenPick minecraft.used:wooden_pickaxe
scoreboard objectives add usedStonePick minecraft.used:stone_pickaxe
scoreboard objectives add usedIronPick minecraft.used:iron_pickaxe
scoreboard objectives add usedGoldenPick minecraft.used:golden_pickaxe
scoreboard objectives add usedDiamondPick minecraft.used:diamond_pickaxe
scoreboard objectives add usedNetherPick minecraft.used:netherite_pickaxe

advancement grant @a[scores={usedWoodenPick=1..}] only consularsorigins:used_pickaxe
advancement grant @a[scores={usedStonePick=1..}] only consularsorigins:used_pickaxe
advancement grant @a[scores={usedIronPick=1..}] only consularsorigins:used_pickaxe
advancement grant @a[scores={usedGoldenPick=1..}] only consularsorigins:used_pickaxe
advancement grant @a[scores={usedDiamondPick=1..}] only consularsorigins:used_pickaxe
advancement grant @a[scores={usedNetherPick=1..}] only consularsorigins:used_pickaxe

scoreboard players set @a[scores={usedWoodenPick=1..}] usedWoodenPick 0
scoreboard players set @a[scores={usedStonePick=1..}] usedStonePick 0
scoreboard players set @a[scores={usedIronPick=1..}] usedIronPick 0
scoreboard players set @a[scores={usedGoldenPick=1..}] usedGoldenPick 0
scoreboard players set @a[scores={usedDiamondPick=1..}] usedDiamondPick 0
scoreboard players set @a[scores={usedNetherPick=1..}] usedNetherPick 0

advancement revoke @p only consularsorigins:used_pickaxe