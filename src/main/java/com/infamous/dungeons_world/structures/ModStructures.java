package com.infamous.dungeons_world.structures;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.infamous.dungeons_world.DungeonsWorld;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;

public class ModStructures {

    /**
     * We are using the Deferred Registry system to register our structure as this is the preferred way on Forge.
     * This will handle registering the base structure for us at the correct time so we don't have to handle it ourselves.
     * <p>
     * HOWEVER, do note that Deferred Registries only work for anything that is a Forge Registry. This means that
     * configured structures and configured features need to be registered directly to WorldGenRegistries as there
     * is no Deferred Registry system for them.
     */
    public static final DeferredRegister<Structure<?>> STRUCTURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, DungeonsWorld.MODID);

    /**
     * Registers the structure itself and sets what its path is. In this case, the
     * structure will have the resourcelocation of structure_tutorial:run_down_house.
     * <p>
     * It is always a good idea to register your Structures so that other mods and datapacks can
     * use them too directly from the registries. It great for mod/datapacks compatibility.
     * <p>
     * IMPORTANT: Once you have set the name for your structure below and distributed your mod,
     * changing the structure's registry name or removing the structure may cause log spam.
     * This log spam won't break your worlds as forge already fixed the Mojang bug of removed structures wrecking worlds.
     * https://github.com/MinecraftForge/MinecraftForge/commit/56e538e8a9f1b8e6ff847b9d2385484c48849b8d
     * <p>
     * However, users might not know that and think you are to blame for issues that doesn't exist.
     * So it is best to keep your structure names the same as long as you can instead of changing them frequently.
     */
    public static final RegistryObject<Structure<NoFeatureConfig>> CW_RUINED_TOWER = STRUCTURES.register("cw_ruined_tower", () -> (new CreeperWoodsRuinedTower(NoFeatureConfig.CODEC)));
    public static final RegistryObject<Structure<NoFeatureConfig>> CW_ANCIENT_TRUNK = STRUCTURES.register("cw_ancient_trunk", () -> (new CreeperWoodsAncientTrunk(NoFeatureConfig.CODEC)));
    public static final RegistryObject<Structure<NoFeatureConfig>> CW_CREEPER_HEAD = STRUCTURES.register("cw_creeper_head", () -> (new CreeperWoodsCreeperHead(NoFeatureConfig.CODEC)));
    public static final RegistryObject<Structure<NoFeatureConfig>> CW_ENDERMAN_HEAD = STRUCTURES.register("cw_enderman_head", () -> (new CreeperWoodsEndermanHead(NoFeatureConfig.CODEC)));
    public static final RegistryObject<Structure<NoFeatureConfig>> ILLAGER_CARAVAN = STRUCTURES.register("illager_caravan", () -> (new IllagerCaravan(NoFeatureConfig.CODEC)));
    public static final RegistryObject<Structure<NoFeatureConfig>> CREEPY_CRYPT = STRUCTURES.register("creepy_crypt", () -> (new CreepyCrypt(NoFeatureConfig.CODEC)));
    public static final RegistryObject<Structure<NoFeatureConfig>> DUNGEONS_BLACKSMITH = STRUCTURES.register("dungeons_blacksmith", () -> (new DungeonsBlacksmith(NoFeatureConfig.CODEC)));


    /**
     * This is where we set the rarity of your structures and determine if land conforms to it.
     * See the comments in below for more details.
     */
    public static void setupStructures() {
        setupMapSpacingAndLand(
                CW_RUINED_TOWER.get(), /* The instance of the structure */
                new StructureSeparationSettings(12 /* average distance apart in chunks between spawn attempts */,
                        6 /* minimum distance apart in chunks between spawn attempts. MUST BE LESS THAN ABOVE VALUE*/,
                        37198423 /* this modifies the seed of the structure so no two structures always spawn over each-other. Make this large and unique. */),
                true);
        setupMapSpacingAndLand(
                CW_ANCIENT_TRUNK.get(), /* The instance of the structure */
                new StructureSeparationSettings(10 /* average distance apart in chunks between spawn attempts */,
                        5 /* minimum distance apart in chunks between spawn attempts. MUST BE LESS THAN ABOVE VALUE*/,
                        8726314 /* this modifies the seed of the structure so no two structures always spawn over each-other. Make this large and unique. */),
                true);
        setupMapSpacingAndLand(
                CW_CREEPER_HEAD.get(), /* The instance of the structure */
                new StructureSeparationSettings(11 /* average distance apart in chunks between spawn attempts */,
                        6 /* minimum distance apart in chunks between spawn attempts. MUST BE LESS THAN ABOVE VALUE*/,
                        9371452 /* this modifies the seed of the structure so no two structures always spawn over each-other. Make this large and unique. */),
                true);
        setupMapSpacingAndLand(
                CW_ENDERMAN_HEAD.get(), /* The instance of the structure */
                new StructureSeparationSettings(30 /* average distance apart in chunks between spawn attempts */,
                        20 /* minimum distance apart in chunks between spawn attempts. MUST BE LESS THAN ABOVE VALUE*/,
                        9371457 /* this modifies the seed of the structure so no two structures always spawn over each-other. Make this large and unique. */),
                true);
        setupMapSpacingAndLand(
                ILLAGER_CARAVAN.get(), /* The instance of the structure */
                new StructureSeparationSettings(25 /* average distance apart in chunks between spawn attempts */,
                        15 /* minimum distance apart in chunks between spawn attempts. MUST BE LESS THAN ABOVE VALUE*/,
                        5341413 /* this modifies the seed of the structure so no two structures always spawn over each-other. Make this large and unique. */),
                true);
        setupMapSpacingAndLand(
                CREEPY_CRYPT.get(), /* The instance of the structure */
                new StructureSeparationSettings(30 /* average distance apart in chunks between spawn attempts */,
                        20 /* minimum distance apart in chunks between spawn attempts. MUST BE LESS THAN ABOVE VALUE*/,
                        4867104 /* this modifies the seed of the structure so no two structures always spawn over each-other. Make this large and unique. */),
                false);
        setupMapSpacingAndLand(
                DUNGEONS_BLACKSMITH.get(), /* The instance of the structure */
                new StructureSeparationSettings(10 /* average distance apart in chunks between spawn attempts */,
                        5 /* minimum distance apart in chunks between spawn attempts. MUST BE LESS THAN ABOVE VALUE*/,
                        32841468 /* this modifies the seed of the structure so no two structures always spawn over each-other. Make this large and unique. */),
                true);
        // Add more structures here and so on
    }

    /**
     * Adds the provided structure to the registry, and adds the separation settings.
     * The rarity of the structure is determined based on the values passed into
     * this method in the structureSeparationSettings argument.
     * This method is called by setupStructures above.
     */
    public static <F extends Structure<?>> void setupMapSpacingAndLand(
            F structure,
            StructureSeparationSettings structureSeparationSettings,
            boolean transformSurroundingLand) {
        /*
         * We need to add our structures into the map in Structure class
         * alongside vanilla structures or else it will cause errors.
         *
         * If the registration is setup properly for the structure,
         * getRegistryName() should never return null.
         */
        Structure.STRUCTURES_REGISTRY.put(structure.getRegistryName().toString(), structure);

        /*
         * Whether surrounding land will be modified automatically to conform to the bottom of the structure.
         * Basically, it adds land at the base of the structure like it does for Villages and Outposts.
         * Doesn't work well on structure that have pieces stacked vertically or change in heights.
         *
         * Note: The air space this method will create will be filled with water if the structure is below sealevel.
         * This means this is best for structure above sealevel so keep that in mind.
         *
         * NOISE_AFFECTING_FEATURES requires AccessTransformer  (See resources/META-INF/accesstransformer.cfg)
         */
        if (transformSurroundingLand) {
            Structure.NOISE_AFFECTING_FEATURES =
                    ImmutableList.<Structure<?>>builder()
                            .addAll(Structure.NOISE_AFFECTING_FEATURES)
                            .add(structure)
                            .build();
        }

        /*
         * This is the map that holds the default spacing of all structures.
         * Always add your structure to here so that other mods can utilize it if needed.
         *
         * However, while it does propagate the spacing to some correct dimensions from this map,
         * it seems it doesn't always work for code made dimensions as they read from this list beforehand.
         *
         * Instead, we will use the WorldEvent.Load event in StructureTutorialMain to add the structure
         * spacing from this list into that dimension or to do dimension blacklisting properly.
         * We also use our entry in DimensionStructuresSettings.DEFAULTS in WorldEvent.Load as well.
         *
         * DEFAULTS requires AccessTransformer  (See resources/META-INF/accesstransformer.cfg)
         */
        DimensionStructuresSettings.DEFAULTS =
                ImmutableMap.<Structure<?>, StructureSeparationSettings>builder()
                        .putAll(DimensionStructuresSettings.DEFAULTS)
                        .put(structure, structureSeparationSettings)
                        .build();


        /*
         * There are very few mods that relies on seeing your structure in the noise settings registry before the world is made.
         *
         * You may see some mods add their spacings to DimensionSettings.BUILTIN_OVERWORLD instead of the NOISE_GENERATOR_SETTINGS loop below but
         * that field only applies for the default overworld and won't add to other worldtypes or dimensions (like amplified or Nether).
         * So yeah, don't do DimensionSettings.BUILTIN_OVERWORLD. Use the NOISE_GENERATOR_SETTINGS loop below instead if you must.
         */
        WorldGenRegistries.NOISE_GENERATOR_SETTINGS.entrySet().forEach(settings -> {
            Map<Structure<?>, StructureSeparationSettings> structureMap = settings.getValue().structureSettings().structureConfig();

            /*
             * Pre-caution in case a mod makes the structure map immutable like datapacks do.
             * I take no chances myself. You never know what another mods does...
             *
             * structureConfig requires AccessTransformer  (See resources/META-INF/accesstransformer.cfg)
             */
            if (structureMap instanceof ImmutableMap) {
                Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(structureMap);
                tempMap.put(structure, structureSeparationSettings);
                settings.getValue().structureSettings().structureConfig = tempMap;
            } else {
                structureMap.put(structure, structureSeparationSettings);
            }
        });
    }
}