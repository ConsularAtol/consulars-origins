scoreboard objectives add coffin dummy
scoreboard objectives add isBat dummy
execute as @a store result score @s coffin run clear @s consularsorigins:coffin 0
execute as @a store result score @s isBat run origin has @s origins:origin consularsorigins:bat
advancement grant @a[scores={coffin=1..,isBat=1}] only consularsorigins:used_coffin
clear @a[scores={coffin=1..,isBat=1}] consularsorigins:coffin 1