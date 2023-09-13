execute as @a at @s if block ~ ~-0.1 ~ minecraft:dirt_path run tag @s add on_path
execute as @a at @s unless block ~ ~-0.1 ~ minecraft:dirt_path run tag @s remove on_path